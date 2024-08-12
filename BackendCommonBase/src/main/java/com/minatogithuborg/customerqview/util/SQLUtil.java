package com.minatogithuborg.customerqview.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import com.vs.rappit.base.appconfiguration.AppConfigurationCache;
import org.hibernate.cfg.Environment;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.vs.rappit.base.tasks.Task;
import com.vs.rappit.base.tasks.model.TaskProgress;
import com.vs.rappit.base.attachment.logic.EvaAttachment;
import com.vs.rappit.exposedapi.base.model.RappitExposedAPIClients;
import com.vs.rappit.base.model.Changelog;
import com.minatogithuborg.customerqview.model.COrder;
import com.minatogithuborg.customerqview.model.ApplicationUser;
import com.minatogithuborg.customerqview.model.CProduct;
import com.minatogithuborg.customerqview.model.Customer;
import com.vs.rappit.exposedapi.base.model.RappitExposedAPIClients;
import com.vs.rappit.base.appconfiguration.AppConfigurationCache;
import com.vs.rappit.base.factory.StorageFactory;
import com.vs.rappit.base.storage.providers.IStorage;
import com.vs.rappit.base.storage.providers.Options;
import com.vs.rappit.base.storage.providers.StorageOptions;
import com.vs.rappit.gcs.CloudStorageOptions;
import com.vs.rappit.storage.files.FileOptions;
import com.vs.rappit.base.listener.BaseApplicationConfiguration;
import com.vs.rappit.base.util.JsonUtil;
import com.vs.rappit.sql.connection.properties.DBConnectionProperties;
import com.vs.rappit.sql.connection.properties.DBConnectionPropertiesFactory;
import com.vs.rappit.sql.connection.properties.SQLDataBaseOptions;
import com.vs.rappit.sql.utils.JPAConstants;
import com.vs.rappit.sql.namingstrategy.QuotingPhysicalNamingStrategy;
import com.vs.rappit.base.logger.Logger;
import com.vs.rappit.base.logger.LoggerFactory;

@Component
public class SQLUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(SQLUtil.class);
	private static final String NEWLINE = "\r\n";
	@Autowired
	BaseApplicationConfiguration baseApplicationConfiguration;
	@Autowired
	private AppConfigurationCache appConfigurationCache;
	@Autowired
	private StorageFactory storageFactory;

	public ResponseEntity generateSQLScript() {
		generateSQLFile();
		return generateAlterStatements();
	}

	private ResponseEntity generateAlterStatements() {
		String alterStatementsForMySQL = "ALTER TABLE `COrder` ADD CONSTRAINT `SIDUnique` UNIQUE (`sid`);"
 + NEWLINE + "ALTER TABLE `ApplicationUser` ADD CONSTRAINT `SIDUnique` UNIQUE (`sid`);"
 + NEWLINE + "ALTER TABLE `CProduct` ADD CONSTRAINT `SIDUnique` UNIQUE (`sid`);"
 + NEWLINE + "ALTER TABLE `Customer` ADD CONSTRAINT `SIDUnique` UNIQUE (`sid`);"
 + NEWLINE + "ALTER TABLE `COrder` ADD CONSTRAINT `Customer_COrder_ref1` FOREIGN KEY (`customerNo`) REFERENCES `Customer` (`customerNo`);" + NEWLINE + "ALTER TABLE `COrder` ADD CONSTRAINT `CProduct_COrder_ref1` FOREIGN KEY (`productId`) REFERENCES `CProduct` (`productId`);";
		String alterStatementsForPostgres = null;
		File f1 = new File("db_init.sql");
		if (f1.exists()) {

				FileWriter fileWriter;
				BufferedWriter bw = null;
				try {
					fileWriter = new FileWriter(f1.getName(), true);
					bw = new BufferedWriter(fileWriter);
					if(baseApplicationConfiguration.getRdbmsName().equals("GOOGLE_CLOUD_SQL_POSTGRESQL")) {
						if(StringUtils.isNotBlank(alterStatementsForPostgres)){
							bw.write(alterStatementsForPostgres);
						}
					}
					else {
						if(StringUtils.isNotBlank(alterStatementsForMySQL)){
						bw.write(alterStatementsForMySQL);
					}

				}
				} catch (IOException e) {
					LOGGER.info("Error in writing Alter Statements {}", e);
				} finally {
					try {
						if (bw != null) bw.close();
					} catch (IOException e) {
						LOGGER.info("Error occurred while closing Buffered Writer {}", e);
					}
				}

			FileInputStream fis = null;
			try {
				// Open the file
				fis = new FileInputStream("db_init.sql");
				// Get the input stream
				InputStream input = fis;
				uploadSqlFileToGCS(fis);
				return ResponseEntity.ok().build();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (fis != null) {
					try {
						fis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return ResponseEntity.noContent().build();
	}

	private void generateSQLFile() {
        Map<String, String> settings = getDBSettings();
        MetadataSources metadataSources = new MetadataSources(
                    new StandardServiceRegistryBuilder()    
                    .applySettings(settings)
                            .build());
        if(baseApplicationConfiguration.getRdbmsName().equals("GOOGLE_CLOUD_SQL_POSTGRESQL")) {
            metadataSources = new MetadataSources(
                    new StandardServiceRegistryBuilder()    
                    .applySettings(settings)
                    .applySetting(Environment.PHYSICAL_NAMING_STRATEGY, new QuotingPhysicalNamingStrategy())
                    .build());
        }
        metadataSources.addAnnotatedClass(Task.class);
		metadataSources.addAnnotatedClass(TaskProgress.class);
		metadataSources.addAnnotatedClass(EvaAttachment.class);
		metadataSources.addAnnotatedClass(RappitExposedAPIClients.class);
		metadataSources.addAnnotatedClass(Changelog.class);
		metadataSources.addAnnotatedClass(COrder.class);
		metadataSources.addAnnotatedClass(ApplicationUser.class);
		metadataSources.addAnnotatedClass(CProduct.class);
		metadataSources.addAnnotatedClass(Customer.class);
		metadataSources.addAnnotatedClass(RappitExposedAPIClients.class);
        Metadata metadata = metadataSources.buildMetadata();
        SchemaExport schemaExport = new SchemaExport();
        schemaExport.setFormat(true);
        schemaExport.setOverrideOutputFileContent();
        schemaExport.setOutputFile("db_init.sql");
        schemaExport.createOnly(EnumSet.of(TargetType.SCRIPT), metadata);
    }
	
	private Map<String, String> getDBSettings() {
		Map<String, String> settings = new HashMap<>();
		SQLDataBaseOptions databaseOptions = SQLDataBaseOptions.valueOf(baseApplicationConfiguration.getRdbmsName());
		DBConnectionPropertiesFactory dBConnectionPropertiesFactory = new DBConnectionPropertiesFactory();
		DBConnectionProperties dbConnection = dBConnectionPropertiesFactory.getConnectionProperties(databaseOptions);
		String  dbConfig = (String) appConfigurationCache.get("db_connection_info");
		Map<String, Object> dbInfo= JsonUtil.toMap(dbConfig);
		settings.put("connection.driver_class", dbConnection.getDriver());
		settings.put("hibernate.dialect", dbConnection.getDialect());
		settings.put("hibernate.connection.url", dbInfo.get(JPAConstants.DB_URL).toString());
		settings.put("hibernate.connection.username", dbInfo.get(JPAConstants.DB_USER).toString());
		settings.put("hibernate.connection.password", dbInfo.get(JPAConstants.DB_PASSWORD).toString());
		settings.put("hibernate.hbm2ddl.auto", "create");
		settings.put("show_sql", "true");
		return settings;
	}
	
	private void uploadSqlFileToGCS(InputStream inputStream) throws IOException {
		String fileName = "db_init-" + getDateTimeFormatForFile(Instant.now().toEpochMilli()) + "-UTC.sql";
		Map<Options, Object> meta = new HashMap<>();
		meta.put(FileOptions.FILE_NAME,fileName);
		meta.put(FileOptions.GUID,"sqlDB_Schema" + File.separator + fileName);
		meta.put(FileOptions.CONTENT_TYPE, "application/sql");
		meta.put(FileOptions.REFERENCE_ID, fileName);
		meta.put(FileOptions.DESCRIPTION,"SQL script for tables creation");
		meta.put(FileOptions.BUCKET_NAME, baseApplicationConfiguration.getConfigLocation());
		meta.put(FileOptions.PROJECT_ID, baseApplicationConfiguration.getProjectId());
		StorageOptions options = new CloudStorageOptions(fileName, meta);
		IStorage storage = storageFactory.getProvider();
		storage.upload(inputStream, options);
	}

	private static String getDateTimeFormatForFile(Long timeInMillis) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
		LocalDateTime dateTime = Instant.ofEpochMilli(timeInMillis)
				.atZone(ZoneId.of("UTC"))
				.toLocalDateTime();
		return dateTime.format(formatter);
	}
}

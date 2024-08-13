package com.minatogithuborg.customerqview.base.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.vs.rappit.base.logger.Logger;
import com.vs.rappit.base.logger.LoggerFactory;

import com.vs.rappit.base.dal.providers.PersistenceType;
import com.vs.rappit.base.acl.AllowedFields;
import com.vs.rappit.base.authentication.logic.AppUserPrivilegeCache;
import com.vs.rappit.base.acl.IPerimeterManager;
import com.vs.rappit.base.exception.InternalException;
import com.vs.rappit.base.util.CollectionUtils;
import com.vs.rappit.base.util.ErrorCode;
import com.minatogithuborg.customerqview.model.Roles;
import com.minatogithuborg.customerqview.base.model.COPViewBase;
import com.minatogithuborg.customerqview.base.model.ApplicationUserBase;
import com.minatogithuborg.customerqview.base.model.constants.COPViewConstantBase;
import org.springframework.stereotype.Component;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collections;
import com.vs.rappit.base.acl.IJPAViewPerimeterManager;


@Component
public abstract class COPViewPerimeterBaseImpl<T extends COPViewBase> implements IJPAViewPerimeterManager<T>, COPViewConstantBase {
	
	private Logger LOGGER = LoggerFactory.getLogger(COPViewPerimeterBaseImpl.class);
	
	@Autowired
	private AppUserPrivilegeCache<ApplicationUserBase> userCache;
	
	@Override
	public boolean canCreate(T model) {
		LOGGER.info("Entering canCreate");
		try {
			ApplicationUserBase userBase = (ApplicationUserBase) userCache.getCurrentUser();
			if (userBase != null && CollectionUtils.isNotEmpty(userBase.getUserRoles())) {
				return userBase.getUserRoles()
				        .stream()
				        .map(Roles::getRoleNameEnum)
				        .filter(Objects::nonNull)
				        .anyMatch(roleName -> Roles.APP_ADMIN.equals(roleName));
			} else {
				LOGGER.error("Application user is not available to verify the perimeter create access ");
				throw new InternalException("Application user is not available to verify the perimeter create access ");
			}
		} catch (Exception e) {
			LOGGER.error("Excepton while reading the perimeter create action {0}",e);
			throw new InternalException(ErrorCode.SAVE_NOT_ALLOWED,e);
		} finally {
			LOGGER.info("Exiting canCreate");
		}
	}

	@Override
	public boolean canUpdate(T model) {
		LOGGER.info("Entering canUpdate");
		try {
			ApplicationUserBase userBase = (ApplicationUserBase) userCache.getCurrentUser();
			if (userBase != null && CollectionUtils.isNotEmpty(userBase.getUserRoles())) {
				return userBase.getUserRoles()
				        .stream()
				        .map(Roles::getRoleNameEnum)
				        .filter(Objects::nonNull)
				        .anyMatch(roleName -> Roles.APP_ADMIN.equals(roleName));
			} else {
				LOGGER.error("Application user is not available to verify the perimeter update access ");
				throw new InternalException("Application user is not available to verify the perimeter update access ");
			}
		} catch (Exception e) {
			LOGGER.error("Excepton while updating the perimeter update action {0}",e);
			throw new InternalException(ErrorCode.UPDATE_NOT_ALLOWED,e);
		} finally {
			LOGGER.info("Exiting canUpdate");
		}
	}

	@Override
	public boolean canDelete(T model) {
		LOGGER.info("Entering canDelete");
		try {
			ApplicationUserBase userBase = (ApplicationUserBase) userCache.getCurrentUser();
			if (userBase != null && CollectionUtils.isNotEmpty(userBase.getUserRoles())) {
				return userBase.getUserRoles()
				        .stream()
				        .map(Roles::getRoleNameEnum)
				        .filter(Objects::nonNull)
				        .anyMatch(roleName -> Roles.APP_ADMIN.equals(roleName));
			} else {
				LOGGER.error("Application user is not available to verify the perimeter delete access ");
				throw new InternalException("Application user is not available to verify the perimeter delete access ");
			}
		} catch (Exception e) {
			LOGGER.error("Excepton while deleting the perimeter action {0}",e);
			throw new InternalException(ErrorCode.DELETE_NOT_ALLOWED,e);
		} finally {
			LOGGER.info("Exiting canDelete");
		}
	}

	@Override
	public boolean canRead(T model) {
		LOGGER.info("Entering canRead");
		try {
			ApplicationUserBase userBase = (ApplicationUserBase) userCache.getCurrentUser();
			if (userBase != null && CollectionUtils.isNotEmpty(userBase.getUserRoles())) {
				return userBase.getUserRoles()
				        .stream()
				        .map(Roles::getRoleNameEnum)
				        .filter(Objects::nonNull)
				        .anyMatch(roleName -> Roles.APP_ADMIN.equals(roleName));
			} else {
				LOGGER.error("Application user is not available to verify the perimeter read access ");
				throw new InternalException("Application user is not available to verify perimeter read access ");
			}
		} catch (Exception e) {
			LOGGER.error("Excepton while reading the perimeter action {0}",e);
			throw new InternalException(ErrorCode.READ_NOT_ALLOWED,e);
		} finally {
			LOGGER.info("Exiting canRead");
		}
	}

	@Override
	public String getAccessQuery(PersistenceType type) {
		return null;
	}

	@Override
	public AllowedFields getSelectFields(PersistenceType type) {
		AllowedFields allowedFields = new AllowedFields();
		ApplicationUserBase userBase = (ApplicationUserBase) userCache.getCurrentUser();
		setReadFields(userBase, allowedFields);
		setWriteFields(userBase, allowedFields);
		return allowedFields;
	}
	
	protected void setReadFields(ApplicationUserBase userBase, AllowedFields allowedFields) {
		Set<String> allowedAccessFields = new HashSet<>();
		if(userBase == null) {
			List<String> allowedAccessFieldList = new ArrayList<>(allowedAccessFields);
			allowedFields.setAllowedReadFields(allowedAccessFieldList);
			return;
		}
					if (BooleanUtils.isTrue(userBase.isAppAdmin())) {
			String[] readFields = new String[] {ORDERNO, CUSTOMERNO, PRODUCTID};
			allowedAccessFields.addAll(Arrays.asList(readFields));
		}

		List<String> allowedAccessFieldList = new ArrayList<>(allowedAccessFields);
		allowedFields.setAllowedReadFields(allowedAccessFieldList);
	}
	protected void setWriteFields(ApplicationUserBase userBase, AllowedFields allowedFields) {
		Set<String> allowedAccessFields = new HashSet<>();
		if(userBase == null) {
			List<String> allowedAccessFieldList = new ArrayList<>(allowedAccessFields);
			allowedFields.setAllowedWriteFields(allowedAccessFieldList);
			return;
		}
					if (BooleanUtils.isTrue(userBase.isAppAdmin())) {
			String[] readFields = new String[] {ORDERNO, CUSTOMERNO, PRODUCTID};
			allowedAccessFields.addAll(Arrays.asList(readFields));
		}

		List<String> allowedAccessFieldList = new ArrayList<>(allowedAccessFields);
		allowedFields.setAllowedWriteFields(allowedAccessFieldList);
	}
}

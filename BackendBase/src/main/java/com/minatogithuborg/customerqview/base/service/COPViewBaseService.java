package com.minatogithuborg.customerqview.base.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.minatogithuborg.customerqview.base.model.COPViewBase;
import com.vs.rappit.base.acl.IJPAViewPerimeterManager;
import com.vs.rappit.base.logger.Logger;
import com.vs.rappit.base.logger.LoggerFactory;
import com.vs.rappit.base.logic.BaseJPAViewBusinessLogic;
import com.vs.rappit.base.dal.Filter;
import com.vs.rappit.base.dal.SimpleFilter;
import com.vs.rappit.base.exception.InternalException;
import java.util.ArrayList;
import com.vs.rappit.base.util.FieldUtils;
import org.springframework.util.MultiValueMap;
import java.util.Map;
import com.vs.rappit.base.exception.ValidationError;
import java.util.List;
import com.vs.rappit.base.rest.APIConstants;
import org.apache.commons.lang3.StringUtils;
public class COPViewBaseService<T extends COPViewBase> extends BaseJPAViewBusinessLogic<T>
		implements ICOPViewBaseService<T> {

	private static final Logger LOGGER = LoggerFactory.getLogger(COPViewBaseService.class.getName());

	@Autowired
	private  COPViewPerimeterBaseImpl copviewPerimeterBaseImpl;
	
	public COPViewBaseService(Class<T> modelClass) {
		super(modelClass);
	}

	protected IJPAViewPerimeterManager<T> getPerimeterManager() {
		return copviewPerimeterBaseImpl;
	}
	
		@Override
	public List<Filter> getInputFilters(Map<String, Object> params) {
		List<Filter> filters = new ArrayList<>();
		List<ValidationError> validationErrors = new ArrayList<>();
		List<String> missingMandatoryRequestParams = new ArrayList<>();
			// Mandatory filters
		if (params.get("orderno") != null && !APIConstants.UNDEFINED.equals(params.get("orderno"))) {
			filters.add(new SimpleFilter("orderno", FieldUtils.getValue(params.get("orderno").toString(), String.class, "Orderno", validationErrors, false, "", "", "")));
		} else {
			missingMandatoryRequestParams.add("orderno");
		}

			// Mandatory filters
		if (params.get("customerno") != null && !APIConstants.UNDEFINED.equals(params.get("customerno"))) {
			filters.add(new SimpleFilter("customerno", FieldUtils.getValue(params.get("customerno").toString(), String.class, "Customerno", validationErrors, false, "", "", "")));
		} else {
			missingMandatoryRequestParams.add("customerno");
		}

			// Mandatory filters
		if (params.get("productid") != null && !APIConstants.UNDEFINED.equals(params.get("productid"))) {
			filters.add(new SimpleFilter("productid", FieldUtils.getValue(params.get("productid").toString(), String.class, "Productid", validationErrors, false, "", "", "")));
		} else {
			missingMandatoryRequestParams.add("productid");
		}

		if (filters.size() != 3) {
	String paramsMissing = StringUtils.join(missingMandatoryRequestParams, ", ");
	throw new InternalException("Mandatory input filter " + paramsMissing + "is missing in the request");
}

		
		return filters;
	}    


}
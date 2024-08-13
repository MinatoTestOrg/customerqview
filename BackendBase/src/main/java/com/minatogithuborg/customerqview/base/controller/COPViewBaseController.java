package com.minatogithuborg.customerqview.base.controller;


import java.util.List;
import com.vs.rappit.base.dal.Filter;
import com.vs.rappit.base.dal.SimpleFilter;
import com.vs.rappit.base.exception.ValidationException;
import org.apache.commons.lang.StringUtils;
import java.util.Set;	
import java.util.HashSet;
import com.vs.rappit.base.util.Constants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.minatogithuborg.customerqview.base.model.COPViewBase;
import com.minatogithuborg.customerqview.base.service.ICOPViewBaseService;
import com.vs.rappit.base.model.PaginationRequest;
import com.vs.rappit.base.model.PaginationResponse;
import com.vs.rappit.base.model.QueryViewRequest;
import com.vs.rappit.jersey.base.webservice.BaseViewWebService;
import com.vs.rappit.jersey.webservice.mapper.DatatableJson;
import com.vs.rappit.jersey.webservice.mapper.QueryViewJson;
import jakarta.servlet.http.HttpServletResponse;

public abstract class COPViewBaseController<SERVICE extends ICOPViewBaseService<M>, M extends COPViewBase>
		extends BaseViewWebService<SERVICE, M> {

	public COPViewBaseController(SERVICE logic) {
		super(logic);
	}

	@PostMapping
	public M create(@RequestBody M modelObj) {
		return super.create(modelObj);
	}
	
	@PutMapping
	public M update(@RequestBody M modelObj) {
		return super.update(modelObj);
	}

	@DeleteMapping
	public ResponseEntity delete(@RequestBody List<M> modelObj) {
		return super.delete(modelObj);
	}

	@PostMapping("/getresults")
	public PaginationResponse getQueryResultsByPage(@RequestBody DatatableJson datatableJson) {
		PaginationRequest dataTable = convertToPaginationRequest(datatableJson);
		return logic.getQueryResultsByPage(dataTable);
	}
	
	@Override
	public void validateMandatoryFilters(List<Filter> filterList) {
		Set<String> mandatoryFilters = new HashSet<>(Set.of("orderno","customerno","productid"));
		for (Filter filter : filterList) {
			SimpleFilter simpleFilter = (SimpleFilter) filter;
			if (mandatoryFilters.contains(simpleFilter.getField()) && simpleFilter.getValue() != null) {
				mandatoryFilters.remove(simpleFilter.getField());
			}
		}
		if (mandatoryFilters.isEmpty()) { return; }
		throw new ValidationException("MANDATORY_FILTER_MISSING", StringUtils.join(mandatoryFilters, Constants.COMMA));
	}
}

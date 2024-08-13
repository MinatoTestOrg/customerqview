package com.minatogithuborg.customerqview.base.controller;

import org.apache.commons.lang3.StringUtils;

import com.vs.rappit.base.rest.APIConstants;
import com.vs.rappit.base.dal.providers.PersistenceType;
import com.vs.rappit.jersey.base.webservice.BaseWebService;
import com.minatogithuborg.customerqview.base.service.ICOrderBaseService;
import com.minatogithuborg.customerqview.base.model.COrderBase;
import java.util.Date;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.vs.rappit.base.util.FieldUtils;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;

import com.vs.rappit.base.model.PaginationRequest;

import com.vs.rappit.jersey.webservice.mapper.DatatableJson;

import com.vs.rappit.base.model.PaginationResponse;

import org.springframework.web.bind.annotation.PathVariable;

import com.vs.rappit.base.model.Primary;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;

import com.vs.rappit.base.dal.Filter;

import org.springframework.util.MultiValueMap;

import java.util.Map;

public abstract class COrderBaseController<SERVICE extends ICOrderBaseService<M>, M extends COrderBase>
		extends BaseWebService<SERVICE, M> {
	
	
	public COrderBaseController(SERVICE logic) {
		super(logic);
	}
	
	
	@GetMapping(path = "/autosuggest", produces = "application/json")
	public List<Object> autoSuggestService(@RequestParam("query") String searchText,@RequestParam(name = "sortColumn", required = false) String sortColumn,@RequestParam(name = "sortOrder", required = false) String sortOrder,@RequestParam("pgNo") int pgNo,@RequestParam("pgLen") int length) {
		return logic.autosuggest(searchText,sortColumn,sortOrder,pgNo,length);
	}


	@PostMapping
	public M create(@RequestBody M modelObj) {
		return super.save(modelObj);
	}


	@PostMapping("/datatable")
	public PaginationResponse getDatatableData(@RequestBody DatatableJson datatableJson)
	{
		PaginationRequest dataTable = convertToPaginationRequest(datatableJson);
	 	return logic.getAllByPage(PersistenceType.SEARCH, dataTable);
	}
	


	@GetMapping(path = "/{sid}", produces = "application/json")
	public M getById(@PathVariable("sid") Primary sid) {
		M model = super.getById(sid);
		if (model == null) {
			RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
			if (requestAttributes instanceof ServletRequestAttributes) {
				HttpServletResponse response = ((ServletRequestAttributes) requestAttributes).getResponse();
				if (response != null) {
					response.setStatus(HttpServletResponse.SC_NO_CONTENT);
				}
			}
		}
		return model;
	}


	@DeleteMapping("/{ids}")
	public ResponseEntity deleteRecords(@PathVariable("ids") String ids) {
		boolean isDeleted = super.delete(ids);
		if (isDeleted)
			return ResponseEntity.ok().build();
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}


	@GetMapping(path = "/lookup/corderlookup1", produces = "application/json")
	public List<Object> lookupCOrderLookup1(@RequestParam MultiValueMap<String, Object> queryParams) {
		Map<String, Object> params = queryParams.toSingleValueMap();
		List<Filter> filters = new ArrayList<>();
		filters = logic.getCorderLookup1InputFilters(params);
		return logic.getCorderLookup1MappedResponse(super.autosuggest(filters, params));

	}



	@PutMapping
	public M update(@RequestBody M modelObj) {
		return super.update(modelObj);
	}




	
}

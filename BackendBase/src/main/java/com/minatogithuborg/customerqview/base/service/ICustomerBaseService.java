package com.minatogithuborg.customerqview.base.service;

import com.vs.rappit.base.logic.ICRUDOperation;
import com.minatogithuborg.customerqview.base.model.CustomerBase;
import java.util.List;
import java.util.Map;
import com.vs.rappit.base.dal.Filter;


public interface ICustomerBaseService<T extends CustomerBase> extends ICRUDOperation<T>{
	
	
	public List<Object> getCustomerLookup1MappedResponse(List<Object> listToBeTransformed);
	public List<Filter> getCustomerLookup1InputFilters(Map<String, Object> params);
}
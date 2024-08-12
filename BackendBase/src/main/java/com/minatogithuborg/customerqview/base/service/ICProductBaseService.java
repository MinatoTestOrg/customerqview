package com.minatogithuborg.customerqview.base.service;

import com.vs.rappit.base.logic.ICRUDOperation;
import com.minatogithuborg.customerqview.base.model.CProductBase;
import java.util.List;
import java.util.Map;
import com.vs.rappit.base.dal.Filter;


public interface ICProductBaseService<T extends CProductBase> extends ICRUDOperation<T>{
	
	
	public List<Object> getCproductLookup1MappedResponse(List<Object> listToBeTransformed);
	public List<Filter> getCproductLookup1InputFilters(Map<String, Object> params);
}
package com.minatogithuborg.customerqview.base.service;

import com.vs.rappit.base.logic.ICRUDOperation;
import com.minatogithuborg.customerqview.base.model.COrderBase;
import java.util.List;
import java.util.Map;
import com.vs.rappit.base.dal.Filter;


public interface ICOrderBaseService<T extends COrderBase> extends ICRUDOperation<T>{
	
	
	public List<Object> getCorderLookup1MappedResponse(List<Object> listToBeTransformed);
	public List<Filter> getCorderLookup1InputFilters(Map<String, Object> params);
}
package com.minatogithuborg.customerqview.base.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.minatogithuborg.customerqview.base.model.COPViewBase;
import com.vs.rappit.base.acl.IJPAViewPerimeterManager;
import com.vs.rappit.base.logger.Logger;
import com.vs.rappit.base.logger.LoggerFactory;
import com.vs.rappit.base.logic.BaseJPAViewBusinessLogic;

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
	
	

}
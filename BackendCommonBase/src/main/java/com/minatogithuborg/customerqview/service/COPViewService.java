package com.minatogithuborg.customerqview.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minatogithuborg.customerqview.base.service.COPViewBaseService;
import com.minatogithuborg.customerqview.model.COPView;

@Service("COPView")
public class COPViewService extends COPViewBaseService<COPView>
		implements ICOPViewService<COPView> {
	@Autowired
	private COPViewPerimeterImpl copviewPerimeterImpl;

	public COPViewService() {
		super(COPView.class);
	}
}

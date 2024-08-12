package com.minatogithuborg.customerqview.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import com.vs.rappit.base.logger.Logger;
import com.vs.rappit.base.logger.LoggerFactory;
import org.springframework.http.ResponseEntity;
import com.vs.rappit.base.factory.InstanceFactory;
import com.minatogithuborg.customerqview.base.controller.COPViewBaseController;
import com.minatogithuborg.customerqview.service.ICOPViewService;
import com.minatogithuborg.customerqview.service.COPViewService;
import com.minatogithuborg.customerqview.model.COPView;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "rest/copviews/", produces = "application/json")
public class COPViewController extends COPViewBaseController<ICOPViewService<COPView>, COPView> {
	private static final Logger LOGGER = LoggerFactory.getLogger(COPViewController.class.getName());
	public COPViewController(COPViewService copviewService) {
		super(copviewService);
	}
}

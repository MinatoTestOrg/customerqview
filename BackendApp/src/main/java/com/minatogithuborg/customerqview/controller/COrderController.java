package com.minatogithuborg.customerqview.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import com.vs.rappit.base.logger.Logger;
import com.vs.rappit.base.logger.LoggerFactory;
import org.springframework.http.ResponseEntity;
import com.vs.rappit.base.factory.InstanceFactory;
import com.minatogithuborg.customerqview.base.controller.COrderBaseController;
import com.minatogithuborg.customerqview.service.ICOrderService;
import com.minatogithuborg.customerqview.service.COrderService;
import com.minatogithuborg.customerqview.model.COrder;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "rest/corders/", produces = "application/json")
public class COrderController extends COrderBaseController<ICOrderService<COrder>, COrder> {
	private static final Logger LOGGER = LoggerFactory.getLogger(COrderController.class.getName());
	public COrderController(COrderService corderService) {
		super(corderService);
	}
}

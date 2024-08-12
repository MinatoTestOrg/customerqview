package com.minatogithuborg.customerqview.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import com.vs.rappit.base.logger.Logger;
import com.vs.rappit.base.logger.LoggerFactory;
import org.springframework.http.ResponseEntity;
import com.vs.rappit.base.factory.InstanceFactory;
import com.minatogithuborg.customerqview.base.controller.CProductBaseController;
import com.minatogithuborg.customerqview.service.ICProductService;
import com.minatogithuborg.customerqview.service.CProductService;
import com.minatogithuborg.customerqview.model.CProduct;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "rest/cproducts/", produces = "application/json")
public class CProductController extends CProductBaseController<ICProductService<CProduct>, CProduct> {
	private static final Logger LOGGER = LoggerFactory.getLogger(CProductController.class.getName());
	public CProductController(CProductService cproductService) {
		super(cproductService);
	}
}

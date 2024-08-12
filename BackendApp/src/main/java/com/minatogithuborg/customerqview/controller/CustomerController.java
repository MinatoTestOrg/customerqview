package com.minatogithuborg.customerqview.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import com.vs.rappit.base.logger.Logger;
import com.vs.rappit.base.logger.LoggerFactory;
import org.springframework.http.ResponseEntity;
import com.vs.rappit.base.factory.InstanceFactory;
import com.minatogithuborg.customerqview.base.controller.CustomerBaseController;
import com.minatogithuborg.customerqview.service.ICustomerService;
import com.minatogithuborg.customerqview.service.CustomerService;
import com.minatogithuborg.customerqview.model.Customer;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "rest/customers/", produces = "application/json")
public class CustomerController extends CustomerBaseController<ICustomerService<Customer>, Customer> {
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class.getName());
	public CustomerController(CustomerService customerService) {
		super(customerService);
	}
}

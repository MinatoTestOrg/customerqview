package com.minatogithuborg.customerqview.service;

import com.vs.rappit.base.acl.IPerimeterManager;
import com.minatogithuborg.customerqview.base.service.CustomerBaseService;
import com.minatogithuborg.customerqview.model.Customer;
import com.minatogithuborg.customerqview.service.CustomerPerimeterImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service("Customer")
public class CustomerService extends CustomerBaseService<Customer> implements ICustomerService<Customer>{

		@Autowired
		private  CustomerPerimeterImpl  customerPerimeterImpl;

		public CustomerService(ChangelogService changelogService) {
		super(Customer.class);	
		setChangelogService(changelogService); 
		
	}
	
}
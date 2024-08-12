package com.minatogithuborg.customerqview.service;

import com.vs.rappit.base.acl.IPerimeterManager;
import com.minatogithuborg.customerqview.base.service.CProductBaseService;
import com.minatogithuborg.customerqview.model.CProduct;
import com.minatogithuborg.customerqview.service.CProductPerimeterImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service("CProduct")
public class CProductService extends CProductBaseService<CProduct> implements ICProductService<CProduct>{

		@Autowired
		private  CProductPerimeterImpl  cproductPerimeterImpl;

		public CProductService(ChangelogService changelogService) {
		super(CProduct.class);	
		setChangelogService(changelogService); 
		
	}
	
}
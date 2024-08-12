package com.minatogithuborg.customerqview.service;

import com.vs.rappit.base.acl.IPerimeterManager;
import com.minatogithuborg.customerqview.base.service.COrderBaseService;
import com.minatogithuborg.customerqview.model.COrder;
import com.minatogithuborg.customerqview.service.COrderPerimeterImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service("COrder")
public class COrderService extends COrderBaseService<COrder> implements ICOrderService<COrder>{

		@Autowired
		private  COrderPerimeterImpl  corderPerimeterImpl;

		public COrderService(ChangelogService changelogService) {
		super(COrder.class);	
		setChangelogService(changelogService); 
		
	}
	
}
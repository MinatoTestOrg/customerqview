package com.minatogithuborg.customerqview.base.model;

import com.vs.rappit.base.annotations.QueryView;
import com.vs.rappit.base.model.BaseJPAViewModel;
import jakarta.persistence.MappedSuperclass;


@QueryView(name = "query_for_queryviewtable_copview", keys = { "orderno","customerno","productid" })
@MappedSuperclass
public class COPViewBase extends BaseJPAViewModel {
    	private String orderno;
	private String customerno;
	private String productid;

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public String getOrderno() {
		return orderno;
	}

	public void setCustomerno(String customerno) {
		this.customerno = customerno;
	}

	public String getCustomerno() {
		return customerno;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getProductid() {
		return productid;
	}


}
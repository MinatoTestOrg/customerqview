package com.minatogithuborg.customerqview.base.model;
import com.vs.rappit.base.model.BaseJPAModel;
import com.vs.rappit.base.annotations.Table;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Id;
import com.vs.rappit.base.annotations.Searchable;
import com.vs.rappit.base.annotations.NotBlank;
import com.vs.rappit.base.util.ValidationErrorConstants;
import jakarta.persistence.UniqueConstraint;


@Table(name="CProduct", keys={"sid"})
@MappedSuperclass
@jakarta.persistence.Table(name = "CProduct",
				uniqueConstraints = {
			@UniqueConstraint(name = "SIDUnique", columnNames = {"sid"} )})
public class CProductBase extends BaseJPAModel {

	@Id
	@NotBlank(message = ValidationErrorConstants.BLANK_VALUE)
	@Searchable(index = true)
	private String productId;
	@Searchable(index = false)
	private String productName;

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductName() {
		return productName;
	}



}
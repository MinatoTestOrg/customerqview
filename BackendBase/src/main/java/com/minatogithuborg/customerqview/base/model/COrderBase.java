package com.minatogithuborg.customerqview.base.model;
import com.vs.rappit.base.model.BaseJPAModel;
import com.vs.rappit.base.annotations.Table;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Id;
import com.vs.rappit.base.annotations.Searchable;
import com.vs.rappit.base.annotations.NotBlank;
import com.vs.rappit.base.util.ValidationErrorConstants;
import jakarta.persistence.UniqueConstraint;


@Table(name="COrder", keys={"sid"})
@MappedSuperclass
@jakarta.persistence.Table(name = "COrder",
				uniqueConstraints = {
			@UniqueConstraint(name = "SIDUnique", columnNames = {"sid"} )})
public class COrderBase extends BaseJPAModel {

	@Id
	@NotBlank(message = ValidationErrorConstants.BLANK_VALUE)
	@Searchable(index = true)
	private String orderNo;
	@Searchable(index = false)
	private String customerNo;
	@Searchable(index = false)
	private String productId;
	@Searchable(index = false)
	private Long quantity;
	@Searchable(index = false)
	private Double price;

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	public String getCustomerNo() {
		return customerNo;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductId() {
		return productId;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getPrice() {
		return price;
	}



}
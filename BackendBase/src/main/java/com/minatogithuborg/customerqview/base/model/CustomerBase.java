package com.minatogithuborg.customerqview.base.model;
import com.vs.rappit.base.model.BaseJPAModel;
import com.vs.rappit.base.annotations.Table;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Id;
import com.vs.rappit.base.annotations.Searchable;
import com.vs.rappit.base.annotations.NotBlank;
import com.vs.rappit.base.util.ValidationErrorConstants;
import jakarta.persistence.UniqueConstraint;


@Table(name="Customer", keys={"sid"})
@MappedSuperclass
@jakarta.persistence.Table(name = "Customer",
				uniqueConstraints = {
			@UniqueConstraint(name = "SIDUnique", columnNames = {"sid"} )})
public class CustomerBase extends BaseJPAModel {

	@Id
	@NotBlank(message = ValidationErrorConstants.BLANK_VALUE)
	@Searchable(index = true)
	private String customerNo;
	@Searchable(index = false)
	private String customerName;
	@Searchable(index = false)
	private String customerAddress;
	@Searchable(index = false)
	private String customerContact;

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}

	public String getCustomerContact() {
		return customerContact;
	}



}
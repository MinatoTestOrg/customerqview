import { Component, OnInit,inject } from '@angular/core';
import { CustomerDetailBaseComponent } from '@baseapp/customer/customer/customer-detail/customer-detail.base.component';
import { CustomerService } from '@baseapp/customer/customer/customer.service';


@Component({
  selector: 'app-customer-detail',
  templateUrl: '../../../../../base/app/customer/customer/customer-detail/customer-detail.component.html',
  styleUrls: ['./customer-detail.scss']
})
export class CustomerDetailComponent extends CustomerDetailBaseComponent implements OnInit {
 
	
  ngAfterViewInit(): void {
    this.onAfterViewInit()
  }

  ngOnInit(): void {
    super.onInit();
  }

  ngOnChanges(changes:any){
    super.onChanges(changes);
  }
 
}
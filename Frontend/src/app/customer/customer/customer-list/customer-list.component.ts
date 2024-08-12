import { Component, OnInit,inject } from '@angular/core';
import { CustomerListBaseComponent } from '@baseapp/customer/customer/customer-list/customer-list.base.component';
import { CustomerService } from '@baseapp/customer/customer/customer.service';


@Component({
  selector: 'app-customer-list',
  templateUrl: '../../../../../base/app/customer/customer/customer-list/customer-list.component.html',
  styleUrls: ['./customer-list.scss']
})
export class CustomerListComponent extends CustomerListBaseComponent implements OnInit {
 
	
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
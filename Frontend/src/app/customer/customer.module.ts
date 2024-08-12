import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CustomerRoutingModule } from './customer-routing.module';
import { CustomerBaseModule } from '@baseapp/customer/customer.base.module';
@NgModule({
  declarations: [
  ],
  imports: [
    CommonModule,
    CustomerBaseModule,
    CustomerRoutingModule
    
  ],
  exports: [
      CustomerBaseModule,
  ]

})
export class CustomerModule  { }
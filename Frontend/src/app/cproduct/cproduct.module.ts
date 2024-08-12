import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CproductRoutingModule } from './cproduct-routing.module';
import { CproductBaseModule } from '@baseapp/cproduct/cproduct.base.module';
@NgModule({
  declarations: [
  ],
  imports: [
    CommonModule,
    CproductBaseModule,
    CproductRoutingModule
    
  ],
  exports: [
      CproductBaseModule,
  ]

})
export class CproductModule  { }
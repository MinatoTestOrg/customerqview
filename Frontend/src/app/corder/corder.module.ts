import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CorderRoutingModule } from './corder-routing.module';
import { CorderBaseModule } from '@baseapp/corder/corder.base.module';
@NgModule({
  declarations: [
  ],
  imports: [
    CommonModule,
    CorderBaseModule,
    CorderRoutingModule
    
  ],
  exports: [
      CorderBaseModule,
  ]

})
export class CorderModule  { }
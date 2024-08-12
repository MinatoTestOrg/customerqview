import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CopviewRoutingModule } from './copview-routing.module';
import { CopviewBaseModule } from '@baseapp/copview/copview.base.module';
@NgModule({
  declarations: [
  ],
  imports: [
    CommonModule,
    CopviewBaseModule,
    CopviewRoutingModule
    
  ],
  exports: [
      CopviewBaseModule,
  ]

})
export class CopviewModule  { }
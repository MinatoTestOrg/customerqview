import { NgModule } from '@angular/core';
import { SharedModule } from '@app/shared/shared.module';
import { WidgetsBaseModule } from '@libbase/widgets.base.module';
import { CustomerListComponent } from '@app/customer/customer/customer-list/customer-list.component';
import { CustomerDetailComponent } from '@app/customer/customer/customer-detail/customer-detail.component';
import { CanDeactivateGuard } from '@baseapp/auth.can-deactivate-guard.service';
import { DynamicDialogConfig, DynamicDialogRef } from 'primeng/dynamicdialog';

@NgModule({
  declarations: [
    CustomerListComponent,
    CustomerDetailComponent
  ],
  imports: [
    SharedModule,
    WidgetsBaseModule,
  ],
  exports: [
    SharedModule,
	WidgetsBaseModule,
    CustomerListComponent,
    CustomerDetailComponent
  ],
  providers: [
  DynamicDialogConfig,
  DynamicDialogRef,
	CanDeactivateGuard
  ],
  
})
export class CustomerBaseModule { }
import { NgModule } from '@angular/core';
import { SharedModule } from '@app/shared/shared.module';
import { WidgetsBaseModule } from '@libbase/widgets.base.module';
import { CproductListComponent } from '@app/cproduct/cproduct/cproduct-list/cproduct-list.component';
import { CproductDetailComponent } from '@app/cproduct/cproduct/cproduct-detail/cproduct-detail.component';
import { CanDeactivateGuard } from '@baseapp/auth.can-deactivate-guard.service';
import { DynamicDialogConfig, DynamicDialogRef } from 'primeng/dynamicdialog';

@NgModule({
  declarations: [
    CproductListComponent,
    CproductDetailComponent
  ],
  imports: [
    SharedModule,
    WidgetsBaseModule,
  ],
  exports: [
    SharedModule,
	WidgetsBaseModule,
    CproductListComponent,
    CproductDetailComponent
  ],
  providers: [
  DynamicDialogConfig,
  DynamicDialogRef,
	CanDeactivateGuard
  ],
  
})
export class CproductBaseModule { }
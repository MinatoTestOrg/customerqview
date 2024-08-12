import { NgModule } from '@angular/core';
import { SharedModule } from '@app/shared/shared.module';
import { WidgetsBaseModule } from '@libbase/widgets.base.module';
import { CorderListComponent } from '@app/corder/corder/corder-list/corder-list.component';
import { CorderDetailComponent } from '@app/corder/corder/corder-detail/corder-detail.component';
import { CanDeactivateGuard } from '@baseapp/auth.can-deactivate-guard.service';
import { DynamicDialogConfig, DynamicDialogRef } from 'primeng/dynamicdialog';

@NgModule({
  declarations: [
    CorderListComponent,
    CorderDetailComponent
  ],
  imports: [
    SharedModule,
    WidgetsBaseModule,
  ],
  exports: [
    SharedModule,
	WidgetsBaseModule,
    CorderListComponent,
    CorderDetailComponent
  ],
  providers: [
  DynamicDialogConfig,
  DynamicDialogRef,
	CanDeactivateGuard
  ],
  
})
export class CorderBaseModule { }
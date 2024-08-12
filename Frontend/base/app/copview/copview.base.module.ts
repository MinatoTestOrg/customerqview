import { NgModule } from '@angular/core';
import { SharedModule } from '@app/shared/shared.module';
import { WidgetsBaseModule } from '@libbase/widgets.base.module';
import { CopviewListComponent } from '@app/copview/copview/copview-list/copview-list.component';
import { CopviewDetailComponent } from '@app/copview/copview/copview-detail/copview-detail.component';
import { CanDeactivateGuard } from '@baseapp/auth.can-deactivate-guard.service';
import { DynamicDialogConfig, DynamicDialogRef } from 'primeng/dynamicdialog';

@NgModule({
  declarations: [
    CopviewListComponent,
    CopviewDetailComponent
  ],
  imports: [
    SharedModule,
    WidgetsBaseModule,
  ],
  exports: [
    SharedModule,
	WidgetsBaseModule,
    CopviewListComponent,
    CopviewDetailComponent
  ],
  providers: [
  DynamicDialogConfig,
  DynamicDialogRef,
	CanDeactivateGuard
  ],
  
})
export class CopviewBaseModule { }
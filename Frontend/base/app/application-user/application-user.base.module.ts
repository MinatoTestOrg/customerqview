import { NgModule } from '@angular/core';
import { SharedModule } from '@app/shared/shared.module';
import { WidgetsBaseModule } from '@libbase/widgets.base.module';
import { ApplicationUserDetailComponent } from '@app/application-user/application-user/application-user-detail/application-user-detail.component';
import { ApplicationUserListComponent } from '@app/application-user/application-user/application-user-list/application-user-list.component';
import { CanDeactivateGuard } from '@baseapp/auth.can-deactivate-guard.service';
import { DynamicDialogConfig, DynamicDialogRef } from 'primeng/dynamicdialog';

@NgModule({
  declarations: [
    ApplicationUserDetailComponent,
    ApplicationUserListComponent
  ],
  imports: [
    SharedModule,
    WidgetsBaseModule,
  ],
  exports: [
    SharedModule,
	WidgetsBaseModule,
    ApplicationUserDetailComponent,
    ApplicationUserListComponent
  ],
  providers: [
  DynamicDialogConfig,
  DynamicDialogRef,
	CanDeactivateGuard
  ],
  
})
export class ApplicationUserBaseModule { }
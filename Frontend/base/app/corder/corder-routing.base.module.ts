import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CanDeactivateGuard } from '@baseapp/auth.can-deactivate-guard.service';

import { CorderListComponent } from '@app/corder/corder/corder-list/corder-list.component';
import { CorderDetailComponent } from '@app/corder/corder/corder-detail/corder-detail.component';

export const routes: Routes = [

{
     path: 'corderlist',
     component: CorderListComponent,
     canDeactivate: [ CanDeactivateGuard ],
     data: {
     	label: "CORDER_LIST",
        breadcrumb: "CORDER_LIST",
        roles : [					"all"
				]
     }
},
{
     path: 'corderdetail',
     component: CorderDetailComponent,
     canDeactivate: [ CanDeactivateGuard ],
     data: {
     	label: "CORDER_DETAIL",
        breadcrumb: "CORDER_DETAIL",
        roles : [					"all"
				]
     }
}
];

@NgModule({
  imports: [ RouterModule.forChild(routes) ],
  exports: [ RouterModule ]
})
export class CorderBaseRoutingModule
{
}

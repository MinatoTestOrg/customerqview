import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CanDeactivateGuard } from '@baseapp/auth.can-deactivate-guard.service';

import { CopviewListComponent } from '@app/copview/copview/copview-list/copview-list.component';
import { CopviewDetailComponent } from '@app/copview/copview/copview-detail/copview-detail.component';

export const routes: Routes = [

{
     path: 'copviewlist',
     component: CopviewListComponent,
     canDeactivate: [ CanDeactivateGuard ],
     data: {
     	label: "COPVIEW_LIST",
        breadcrumb: "COPVIEW_LIST",
        roles : [					"all"
				]
     }
},
{
     path: 'copviewdetail',
     component: CopviewDetailComponent,
     canDeactivate: [ CanDeactivateGuard ],
     data: {
     	label: "COPVIEW_DETAIL",
        breadcrumb: "COPVIEW_DETAIL",
        roles : [					"all"
				]
     }
}
];

@NgModule({
  imports: [ RouterModule.forChild(routes) ],
  exports: [ RouterModule ]
})
export class CopviewBaseRoutingModule
{
}

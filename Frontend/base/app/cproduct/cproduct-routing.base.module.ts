import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CanDeactivateGuard } from '@baseapp/auth.can-deactivate-guard.service';

import { CproductListComponent } from '@app/cproduct/cproduct/cproduct-list/cproduct-list.component';
import { CproductDetailComponent } from '@app/cproduct/cproduct/cproduct-detail/cproduct-detail.component';

export const routes: Routes = [

{
     path: 'cproductlist',
     component: CproductListComponent,
     canDeactivate: [ CanDeactivateGuard ],
     data: {
     	label: "CPRODUCT_LIST",
        breadcrumb: "CPRODUCT_LIST",
        roles : [					"all"
				]
     }
},
{
     path: 'cproductdetail',
     component: CproductDetailComponent,
     canDeactivate: [ CanDeactivateGuard ],
     data: {
     	label: "CPRODUCT_DETAIL",
        breadcrumb: "CPRODUCT_DETAIL",
        roles : [					"all"
				]
     }
}
];

@NgModule({
  imports: [ RouterModule.forChild(routes) ],
  exports: [ RouterModule ]
})
export class CproductBaseRoutingModule
{
}

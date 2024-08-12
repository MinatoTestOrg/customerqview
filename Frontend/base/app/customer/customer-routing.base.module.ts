import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CanDeactivateGuard } from '@baseapp/auth.can-deactivate-guard.service';

import { CustomerListComponent } from '@app/customer/customer/customer-list/customer-list.component';
import { CustomerDetailComponent } from '@app/customer/customer/customer-detail/customer-detail.component';

export const routes: Routes = [

{
     path: 'customerlist',
     component: CustomerListComponent,
     canDeactivate: [ CanDeactivateGuard ],
     data: {
     	label: "CUSTOMER_LIST",
        breadcrumb: "CUSTOMER_LIST",
        roles : [					"all"
				]
     }
},
{
     path: 'customerdetail',
     component: CustomerDetailComponent,
     canDeactivate: [ CanDeactivateGuard ],
     data: {
     	label: "CUSTOMER_DETAIL",
        breadcrumb: "CUSTOMER_DETAIL",
        roles : [					"all"
				]
     }
}
];

@NgModule({
  imports: [ RouterModule.forChild(routes) ],
  exports: [ RouterModule ]
})
export class CustomerBaseRoutingModule
{
}

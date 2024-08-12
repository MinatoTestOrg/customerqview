import {Routes } from '@angular/router';
import { AppLayoutComponent } from '@app/app-layout/app-layout.component';
import { AppHomePageComponent } from '@app/app-home-page/app-home-page.component';
import { AuthenticationResolver } from '@app/auth/authentication.resolver';
import { LoginDetailComponent } from '@app/auth/login/login.component';

export const routes: Routes = [ 
  {
     path: '',
     redirectTo: "/home",
     pathMatch: 'full'
  }, 

    {
    path: '',
    component: AppLayoutComponent,
    resolve:{authResolver:AuthenticationResolver},
    children: [
    {
    path: 'home',
    component: AppHomePageComponent,
    },
      {
        path: 'corder',
        loadChildren: () => import('@app/corder/corder.module').then(m => m.CorderModule)
      },
      {
        path: 'applicationuser',
        loadChildren: () => import('@app/application-user/application-user.module').then(m => m.ApplicationUserModule)
      },
      {
        path: 'cproduct',
        loadChildren: () => import('@app/cproduct/cproduct.module').then(m => m.CproductModule)
      },
      {
        path: 'customer',
        loadChildren: () => import('@app/customer/customer.module').then(m => m.CustomerModule)
      },
      {
        path: 'copview',
        loadChildren: () => import('@app/copview/copview.module').then(m => m.CopviewModule)
      }
   	]
  }
];
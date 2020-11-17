import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';
import { CustomerLoginComponent } from './auth/components/customer-login/customer-login.component';
import { CustomerRegisterComponent } from './auth/components/customer-register/customer-register.component';

const routes: Routes = [
  // {
  //   path: 'home',
  //   loadChildren: () => import('./home/home.module').then( m => m.HomePageModule)
  // },
  // {
  //   path: '',
  //   redirectTo: 'home',
  //   pathMatch: 'full'
  // },

  // {
  //   path: 'customer/login',
  //   component: CustomerLoginComponent
  // },
  // {
  //   path: 'customer/register',
  //   component: CustomerRegisterComponent
  // },
  {
    path: 'products',
    loadChildren: () => import('./product/product.module').then(m => m.ProductPageModule)
  },
  {
    path: 'products-categoris',
    loadChildren: () => import('./product-categories/product-categories.module').then(m => m.ProductCategoriesPageModule)
  },
  {
    path: "",
    redirectTo: '/products-categoris',
    pathMatch: "full"
  },
  {
    path: 'product',
    loadChildren: () => import('./product/product.module').then(m => m.ProductPageModule)
  },
  {
    path: 'product-categories',
    loadChildren: () => import('./product-categories/product-categories.module').then(m => m.ProductCategoriesPageModule)
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }

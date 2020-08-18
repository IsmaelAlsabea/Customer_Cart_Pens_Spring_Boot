import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginPageComponent} from '../app/components/login-page/login-page.component'
import {ShopPageComponent} from '../app/components/shop-page/shop-page.component'
import {CartPageComponent} from '../app/components/cart-page/cart-page.component'
import {TestHttpReqForOrderAndCartComponent} from '../app/components/test-http-req-for-order-and-cart/test-http-req-for-order-and-cart.component'

const routes: Routes = [
  {path:"login", component : LoginPageComponent},
  {path: "shop",component: ShopPageComponent},
  {path: "cart",component: CartPageComponent},
  {path:"test-http-cart-order",component:TestHttpReqForOrderAndCartComponent},
  {path: "**", component:LoginPageComponent} // put the wild card path last
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

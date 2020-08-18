import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatCardModule} from '@angular/material/card';
import { MatSliderModule } from '@angular/material/slider';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatDialogModule} from '@angular/material/dialog';



import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginPageComponent } from '../app/components/login-page/login-page.component';
import { ShopPageComponent } from '../app/components/shop-page/shop-page.component';
import { CartPageComponent } from '../app/components/cart-page/cart-page.component';
import { PenService } from 'src/app/services/pen.service';
import { PenDialogComponent } from './components/pen-dialog/pen-dialog.component';
import { TestHttpReqForOrderAndCartComponent } from './components/test-http-req-for-order-and-cart/test-http-req-for-order-and-cart.component';

import { DatePipe } from '@angular/common';

@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
    ShopPageComponent,
    CartPageComponent,
    PenDialogComponent,
    TestHttpReqForOrderAndCartComponent,
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatSliderModule,
    MatInputModule,
    MatGridListModule,
    MatDialogModule
  ],
  providers: [ PenService , DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }

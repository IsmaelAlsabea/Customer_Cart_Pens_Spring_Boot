import { Component, OnInit } from '@angular/core';
import {CartService} from '../../services/cart.service';
import {OrderService} from '../../services/order.service';
import {Cart} from '../../models/Cart';
import {Order} from '../../models/Order';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-test-http-req-for-order-and-cart',
  templateUrl: './test-http-req-for-order-and-cart.component.html',
  styleUrls: ['./test-http-req-for-order-and-cart.component.css']
})
export class TestHttpReqForOrderAndCartComponent implements OnInit {

  constructor(private cs:CartService, private os: OrderService, private datePipe: DatePipe) { }

  ngOnInit(): void {
  }

  //Cart Service

  async createCarts ():Promise<void> {
    let cartArray:Array<Cart> = new Array<Cart>();

    cartArray.push(new Cart(5,2,3,20), new Cart(5,2,4,33), new Cart(5,2,1,17));
    const returnedCarts: Array<Cart> = await this.cs.createAllCartItems(cartArray);

    console.log (returnedCarts) ;
  }

  async getAllCartItemsByCartId(): Promise<void>{
    let cartId=1;
    const returnedCarts: Array<Cart> = await this.cs.getAllCartsByCartId(cartId);
    console.log(returnedCarts);
  }

  async getLastElementId(): Promise<void>{
    const returnedId: number = await this.cs.getLastElementId();
    console.log(returnedId);
  }

  //Order Service

  async createOrder(): Promise<void>{

    let date: string = this.datePipe.transform(new Date(), 'yyyy-MM-dd hh-mm-ss');

    const returnedOrder: Order = await this.os.createOrder(new Order(0, 5,2, date));
    console.log(returnedOrder);
  }

  async getOrderById(): Promise<void>{
    const orderReturned: Order = await this.os.getOrderById(1);
    console.log(orderReturned);
  }

  async getCustomerOrders(): Promise<void>{
    const customerOrdersReturned: Array<Order> = await this.os.getAllOrdersByCustomerId(1);
    console.log(customerOrdersReturned);
  }


}

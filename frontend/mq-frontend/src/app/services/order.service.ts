import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import {Order} from '../models/Order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http:HttpClient) { }

  async createOrder (order: Order): Promise<Order>{

    const orderReturned:Order = await this.http.post<Order>(`http://localhost:8080/orders`, order).toPromise();
    return orderReturned;
  }

  async getOrderById (orderId: number): Promise<Order>{

    const orderReturned:Order = await this.http.get<Order>
      (`http://localhost:8080/orders/${orderId}`).toPromise();
    return orderReturned;
  }

  async getAllOrdersByCustomerId (customerId: number): Promise<Array<Order>>{

    const ordersReturned:Array<Order> = await this.http.get<Array<Order>>
      (`http://localhost:8080//customers/${customerId}/orders`).toPromise();
    return ordersReturned;
  }


}

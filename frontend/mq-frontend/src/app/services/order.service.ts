import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import {Order} from '../models/Order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  
  constructor(private http:HttpClient) { }

  //x : string = "localhost"
  x : string = "ec2-18-223-112-137.us-east-2.compute.amazonaws.com:9090";

  
  
  async createOrder (order: Order): Promise<Order>{
    const orderReturned:Order = await this.http.post<Order>(`http://${this.x}/orders`, order).toPromise();
    return orderReturned;
  }
  
  async getOrderById (orderId: number): Promise<Order>{
    
    const orderReturned:Order = await this.http.get<Order>
    (`http://${this.x}/orders/${orderId}`).toPromise();
    return orderReturned;
  }
  
  async getAllOrdersByCustomerId (customerId: number): Promise<Array<Order>>{
    
    const ordersReturned:Array<Order> = await this.http.get<Array<Order>>
    (`http://${this.x}//customers/${customerId}/orders`).toPromise();
    return ordersReturned;
  }
  
}

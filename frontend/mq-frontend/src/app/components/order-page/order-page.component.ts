import { Component, OnInit } from '@angular/core';
import {Order} from '../../models/Order';
import {OrderService} from '../../services/order.service';
import { Customer } from 'src/app/models/customer';
import { PersistentCustomerInfoService } from 'src/app/services/persistent-customer-info.service';

@Component({
  selector: 'app-order-page',
  templateUrl: './order-page.component.html',
  styleUrls: ['./order-page.component.css']
})
export class OrderPageComponent implements OnInit {
  
  constructor(private os: OrderService, private pcis: PersistentCustomerInfoService) { }
  
  curCustomer:Customer;
  orders:Array<Order>;
  
  ngOnInit(): void {
    
    this.curCustomer = this.pcis.getCustomer();
    this.getCustomerOrders(this.curCustomer.cId);
  }
  
  
  async getCustomerOrders(cust:number): Promise<void>{
    this.orders  = await this.os.getAllOrdersByCustomerId(cust);
  }
  
}

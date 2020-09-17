import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from "@angular/material/dialog";
import { CartService } from 'src/app/services/cart.service';
import { DatePipe } from '@angular/common';
import { Order } from 'src/app/models/Order';
import { OrderService } from 'src/app/services/order.service';
import { ShopToCartService } from 'src/app/services/shop-to-cart.service';
import { Cart } from 'src/app/models/cart';
import { PersistentCustomerInfoService } from 'src/app/services/persistent-customer-info.service';
import { CustomerService } from 'src/app/services/customer.service';
import { Customer } from 'src/app/models/customer';


@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  constructor(
    public dialogRef:MatDialogRef<OrderComponent>,
    private datePipe: DatePipe,
    private orderService:OrderService,
    private stc:ShopToCartService,
    private cartService:CartService,
    private pcis:PersistentCustomerInfoService,
    private cs: CustomerService,
    @Inject(MAT_DIALOG_DATA) public data:any ) { }

  ngOnInit(): void {
  }


  
  async placeOrder() {
    let date: string = this.datePipe.transform(new Date(), 'yyyy-MM-dd hh-mm-ss');
    let cartID = await this.cartService.getLastElementId() + 1;
    let custID = this.data.custId;
    let orderTotal = this.data.cost;


    const courierCarts:Map<number, Cart> = this.stc.getCourier();
    console.log(courierCarts);

    if(courierCarts.size === 0) {
        alert("You have no items in your cart!");
      } else if(this.pcis.getCustomer().points < this.data.cost) {
        alert("You do not have sufficient points to purchase these pens!");
      } else {
        let cartsToPersist: Array<Cart> = Array.from(courierCarts.values());
        const carts:Array<Cart> = await this.cartService.createAllCartItems(cartsToPersist);
        console.log(carts);
    
        this.stc.clear();
        const returnedOrder:Order = await this.orderService.createOrder(new Order(0, cartID, custID, date, orderTotal));
        console.log(returnedOrder);
        let cust: Customer= this.pcis.getCustomer();
        cust.points-=returnedOrder.orderTotal;
        this.pcis.setCustomer(cust);   
        this.cs.updateCustomer(this.pcis.getCustomer());
        
      }

      
  }
}

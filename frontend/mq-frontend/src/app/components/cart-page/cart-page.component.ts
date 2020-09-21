import { Component, OnInit } from '@angular/core';
import { Cart } from 'src/app/models/cart'
import { CartService } from 'src/app/services/cart.service'
import { PenService } from '../../services/pen.service';
import { Pen } from '../../models/pen'
import { Router } from '@angular/router';
import { PersistentCustomerInfoService } from 'src/app/services/persistent-customer-info.service';
import { ShopToCartService } from 'src/app/services/shop-to-cart.service';
import { DatePipe } from '@angular/common';
import { OrderService } from 'src/app/services/order.service';
import { Order } from 'src/app/models/Order';
import { Customer } from 'src/app/models/customer';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-cart-page',
  templateUrl: './cart-page.component.html',
  styleUrls: ['./cart-page.component.scss']
})
export class CartPageComponent implements OnInit {
  
  
  constructor(private cartService:CartService, 
    private penService:PenService,
    private router:Router,
    private pcis:PersistentCustomerInfoService,
    private stc:ShopToCartService,
    private datePipe: DatePipe,
    private orderService: OrderService,
    private cs: CustomerService,) { }
    
    ngOnInit(): void {
      this.initalizeCartsField();
      this.calcTotalCost();
    }
    
    showConfPopUp: boolean= false;
    showNoItemInCartPopUp: boolean =false ;
    showInsuffecientPointsPopUp: boolean =false;
    
    carts: CartDTO[]=[];
    totalCost:number;
    
    popUpBool: boolean=false;
    
    async initalizeCartsField(): Promise<void> {
      let cartsOrig: Cart[]= Array.from(this.stc.getCourier().values());
      for (let c of cartsOrig){
        this.carts.push(new CartDTO(c.cartId, c.cId, await this.penService.getPenById(c.pId), c.quantity));
      }
      
    }
    
    async calcTotalCost(): Promise<void>{
      const selectedCartItems: Array<Cart> = Array.from(this.stc.getCourier().values());
      console.log(selectedCartItems);
      let cost:number = 0;
      for(let i = 0; i < selectedCartItems.length; i++) {
        
        cost+= await this.stc.getCost(selectedCartItems[i].pId);
        
      }
      this.totalCost = cost;
    }
    
    
    async clearCart(){
      this.carts=null;
      this.stc.clear();
      await this.calcTotalCost();
      this.router.navigateByUrl("/cart");
    }
    
    async openDialog() {
      this.popUpBool=true;
    }
    
    
    
    async placeOrder() {
      const courierCarts:Map<number, Cart> = this.stc.getCourier();
      if(courierCarts.size === 0) {
        this.closeAllAlerts();
        this.closeDialog();
        this.showNoItemInCartPopUp=true;
      } else if(this.pcis.getCustomer().points < this.totalCost) {
        this.closeAllAlerts();
        this.closeDialog();
        this.showInsuffecientPointsPopUp=true;
      } else {
        this.processPlacingTheOrder(Array.from(courierCarts.values()));
      }
    }
    
    private async processPlacingTheOrder(cartsToPersist: Array<Cart>) : Promise<void>{
      let date: string = this.datePipe.transform(new Date(), 'yyyy-MM-dd hh-mm-ss');
      let cartID = await this.cartService.getLastElementId() + 1;
      
      const carts:Array<Cart> = await this.cartService.createAllCartItems(cartsToPersist);
      console.log(carts);
      
      const returnedOrder:Order = await this.orderService.createOrder(new Order(0, cartID, this.pcis.getCustomer().cId, date, this.totalCost));
      console.log(returnedOrder);
      
      this.updateCustInfoAfterPurchase();
      this.closeDialog();
      this.clearCart();
      
      this.closeAllAlerts();
      this.showConfPopUp=true;
    }
    
    
    
    
    private updateCustInfoAfterPurchase(): void{
      let cust: Customer= this.pcis.getCustomer();
      //update cust points
      cust.points-=this.totalCost;
      //update cust in the service
      this.pcis.setCustomer(cust);
      //update cust in the database   
      this.cs.updateCustomer(this.pcis.getCustomer());
    }
    
    closeDialog(): void {
      this.popUpBool=false;
    }
    
    closeConfPopUp(){
      this.showConfPopUp=false;
    }
    
    closeNoItemPopUp(){
      this.showNoItemInCartPopUp=false;
    }
    
    closeInsufficientPopUp(){
      this.showInsuffecientPointsPopUp=false;
    }
    
    closeAllAlerts(){
      
      this.showConfPopUp= false;
      this.showNoItemInCartPopUp=false ;
      this.showInsuffecientPointsPopUp =false;
    }
    
  }
  
  
  export class CartDTO{
    
    cartId:number;
    cId : number;
    pen : Pen;
    quantity: number;
    
    constructor(cartId: number, cId: number, pen:Pen, quantity: number){
      this.cartId = cartId;
      this.cId =  cId;
      this.pen = pen;
      this.quantity=quantity;
    }
  }
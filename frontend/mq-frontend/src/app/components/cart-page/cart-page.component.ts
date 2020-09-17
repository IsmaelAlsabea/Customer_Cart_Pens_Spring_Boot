import { Component, OnInit } from '@angular/core';
import { Cart } from 'src/app/models/cart'
import { CartService } from 'src/app/services/cart.service'
import { PenService } from '../../services/pen.service';
import { Pen } from '../../models/pen'
import { Router } from '@angular/router';
import { PersistentCustomerInfoService } from 'src/app/services/persistent-customer-info.service';
import { OrderComponent } from 'src/app/components/order/order.component';
import { MatDialogConfig, MatDialog } from '@angular/material/dialog';
import { ShopToCartService } from 'src/app/services/shop-to-cart.service';

@Component({
  selector: 'app-cart-page',
  templateUrl: './cart-page.component.html',
  styleUrls: ['./cart-page.component.css']
})
export class CartPageComponent implements OnInit {
  
  constructor(private cartService:CartService, 
    private penService:PenService,
    private router:Router,
    private pcis:PersistentCustomerInfoService,
    private stc:ShopToCartService,
    private matDialog:MatDialog) { }
    
    ngOnInit(): void {
      this.custLoggedIn();
      this.initalizeCartsField();
      this.calcTotalCost();
    }
    
    //pens:Array<Pen> = []; 
    carts: CartDTO[]=[];
    totalCost:number;
    
    
    
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
    
    async custLoggedIn(){
      const customer = this.pcis.getCustomer();
      if (customer === null || customer === undefined) {
        this.router.navigateByUrl('/login');
      }
    }
    
    async clearCart(){
      this.carts=null;
      this.stc.clear();
      await this.calcTotalCost();
      this.custLoggedIn();
      this.router.navigateByUrl("/cart");
    }
    
    async openDialog() {
      const dialogConfig = new MatDialogConfig();
      let cartID = await this.cartService.getLastElementId() + 1;
      dialogConfig.data = {cost: this.totalCost, cartId: cartID, custId: this.pcis.getCustomer().cId};
      this.matDialog.open(OrderComponent, dialogConfig);
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
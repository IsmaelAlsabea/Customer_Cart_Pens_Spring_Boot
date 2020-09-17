import { Component, OnInit } from '@angular/core';
import { Pen } from '../../models/pen'
import { PenService } from 'src/app/services/pen.service';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
// import { PenDialogComponent } from 'src/app/components/pen-dialog/pen-dialog.component'
import { PersistentCustomerInfoService } from 'src/app/services/persistent-customer-info.service';
import { Customer } from 'src/app/models/customer';
import { Router } from '@angular/router';
import { CartService } from 'src/app/services/cart.service';
import { ShopToCartService } from 'src/app/services/shop-to-cart.service';
import { Cart } from 'src/app/models/cart';


@Component({
  selector: 'app-shop-page',
  templateUrl: './shop-page.component.html',
  styleUrls: ['./shop-page.component.css']
})
export class ShopPageComponent implements OnInit {

  selected: string;
  sortType: string;
  selectedPen: Pen;
  penQuantity: number;
  showPopUp: boolean=false;


  constructor(private penService:PenService, 
              private pcis:PersistentCustomerInfoService,
              private cartService: CartService,
              private stc: ShopToCartService, 

              private router:Router) { }

  ngOnInit(): void {
    this.custLoggedIn();
    this.displayPens();
  }

  pens:Array<Pen> = [];

  curCustomer:Customer= this.pcis.getCustomer();

  async displayPens():Promise<void>{
    if(this.sortType === "ascending"){
      this.pens = await this.penService.getAllPensSort(true);
    }
    else if(this.sortType === "descending"){
      this.pens = await this.penService.getAllPensSort(false);
    }
    else{
      this.pens = await this.penService.getAllPens();
    }
  };

  // openDialog(penId:number) {
  //   const dialogConfig = new MatDialogConfig();
  //   dialogConfig.data = penId;
  //   // this.matDialog.open(PenDialogComponent, dialogConfig);
  // }


  custLoggedIn(){
    if(!this.pcis.isLoggedIn()) {
      //alert("You must be logged in to view this page!");
      this.router.navigateByUrl("/login");
    }
  }


  async openDialog(penId: number): Promise<void>{
    this.showPopUp= true;
    this.selectedPen = await this.penService.getPenById(penId);
  }

  async addPenToCart() {
    
    const numcId = this.pcis.getCustomer().cId;

    const cartId =  await this.cartService.getLastElementId() + 1;

    if(this.penQuantity <= 0 || this.penQuantity === undefined) {
      this.penQuantity = 1;
    }
    this.stc.addToCourier(new Cart(cartId, numcId, this.selectedPen.pId, this.penQuantity));
    window.confirm("pen is added to the cart");
  }


  closePopUp():void{
    this.showPopUp=false;
  }

}




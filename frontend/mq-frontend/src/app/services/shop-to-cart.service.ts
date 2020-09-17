import { Injectable } from '@angular/core';
import {Cart} from '../models/cart'
import { PenService } from './pen.service';
import { Pen } from '../models/pen';

@Injectable({
  providedIn: 'root'
})

export class ShopToCartService {
  
  constructor(private ps:PenService) { }
  
  getCourier() : Map<number, Cart>{
    const lsVal= JSON.parse(localStorage.getItem("courier"));
    console.log(lsVal);
    if (lsVal === undefined || lsVal === null || Object.keys(lsVal).length ===0)
      return new Map();

    let map:Map<number, Cart>= new Map (lsVal);
      return map;
  }
  
  //overwrites the pen quantity
  addToCourier(cart: Cart): void{
    let map: Map<number, Cart> = this.getCourier();
    console.log (this.getCourier());
    if (map === undefined || map=== null){
      map= new Map();
    }
    //since cart.pid is the key, if there is a previouse entry with the same key, it will be overwritten.
    map.set(cart.pId, cart);
    localStorage.setItem("courier", JSON.stringify([...map]));
  }
  
  clear():void{
    localStorage.setItem("courier", null);
  }
  
  async getCost(penId:number): Promise<number>{
    const map: Map<number, Cart> = this.getCourier();
    const cart:Cart =  map.get(penId);
    const pen: Pen = await this.ps.getPenById(penId);
    const cost= pen.cost * cart.quantity;
    return cost;
  }
  
}

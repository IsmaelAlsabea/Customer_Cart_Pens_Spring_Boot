import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { Cart} from 'src/app/models/cart'
@Injectable({
  providedIn: 'root'
})


export class CartService {

  constructor(private http:HttpClient) { }

  //x : string = "localhost"
  x : string = "ec2-18-223-112-137.us-east-2.compute.amazonaws.com:9090";
  
  async createAllCartItems (carts: Array<Cart>) : Promise<Array<Cart>>{

    const cartsReturned:Array<Cart> = await this.http.post<Array<Cart>>
              (`http://${this.x}/carts/`, carts).toPromise();
    return cartsReturned;
  }

  async getAllCartsByCartId (cartId: number): Promise <Array<Cart>>{
    
    const cartsReturned:Array<Cart> = await this.http.get<Array<Cart>>
    (`http://${this.x}/carts/${cartId}`).toPromise();
    return cartsReturned;

  }

  async getLastElementId(): Promise<number>{
    const lastCartId:number = await this.http.get<number>
    (`http://${this.x}/carts/last-element`).toPromise();

    return lastCartId;

  }



}

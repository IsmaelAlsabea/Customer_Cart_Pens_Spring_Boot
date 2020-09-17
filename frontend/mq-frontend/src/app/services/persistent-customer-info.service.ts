import { Injectable } from '@angular/core';
import {Customer} from 'src/app/models/customer';

@Injectable({
  providedIn: 'root'
})
export class PersistentCustomerInfoService {

  constructor() { }

  getCustomer(): Customer{
    return JSON.parse(localStorage.getItem('customer'));
  }

  setCustomer(customer:Customer): void {
    localStorage.setItem('customer', JSON.stringify(customer));
}
  //logout customer
  clearCustomer():void{
    localStorage.setItem('customer', "");
  }


  isLoggedIn():boolean{
    const cust : Customer =  this.getCustomer() ;
    if(cust === undefined || cust === null) {
      return false;
    } else {
      return true;
    }
  }

}

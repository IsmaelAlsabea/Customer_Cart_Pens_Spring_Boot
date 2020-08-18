import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Customer} from '../models/customer';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) { }


  currCust:Customer;

  async loginUser(customer:Customer):Promise<Customer>{
    const cust:Customer = await this.http.post<Customer>("http://localhost:8080/login",customer).toPromise();
    console.log(cust);
    return cust;
  }

   setCustomer(customer:Customer) : void {
      this.currCust = customer;
  }


}
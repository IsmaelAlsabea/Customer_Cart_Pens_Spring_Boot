import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Customer} from '../models/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http:HttpClient) { }


  async loginUser(dto):Promise<Customer>{
    const cust:Customer = await this.http.post<Customer>("http://localhost:9090/login",dto).toPromise();
    return cust;
  }



  async getCustomerById(id:number):Promise<Customer> {
    const c:Customer = await this.http.get<Customer>(`http://localhost:9090/customers/${id}`).toPromise();
    return c;
  }

  async updateCustomer(customer:Customer):Promise<Customer> {
    const c:Customer = await this.http.put<Customer>(`http://localhost:9090/customers/`, customer).toPromise();
    return c;
  }


}

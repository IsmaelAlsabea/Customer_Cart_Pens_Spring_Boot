import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Customer} from '../models/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http:HttpClient) { }

    //x : string = "localhost"
    x : string = "ec2-18-223-112-137.us-east-2.compute.amazonaws.com:9090";

  async loginUser(dto):Promise<Customer>{
    const cust:Customer = await this.http.post<Customer>(`http://${this.x}/login`,dto).toPromise();
    return cust;
  }



  async getCustomerById(id:number):Promise<Customer> {
    const c:Customer = await this.http.get<Customer>(`http://${this.x}/customers/${id}`).toPromise();
    return c;
  }

  async updateCustomer(customer:Customer):Promise<Customer> {
    const c:Customer = await this.http.put<Customer>(`http://${this.x}/customers/`, customer).toPromise();
    return c;
  }


}

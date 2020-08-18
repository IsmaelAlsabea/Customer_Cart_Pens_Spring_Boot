import { Component, OnInit } from '@angular/core';
import {Customer} from '../../models/customer';
import {LoginService} from 'src/app/services/login.service';
import { Router } from '@angular/router';

@Component({

  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  constructor(private loginService:LoginService, private router:Router) { }

  userField:string;
  passField:string;

  ngOnInit(): void {
  }

  async loginCust(){
    console.log(this.userField);

    let cust = new Customer(this.userField,this.passField);
    let customer = await this.loginService.loginUser(cust);
    // console.log(customer);

    if (customer === null){
      alert("user not found")
      this.router.navigateByUrl("/login");
      this.userField="";
      this.passField="";
      this.router.navigateByUrl("/login");
      
    }
    else{
      this.router.navigateByUrl("/shop");
      this.loginService.setCustomer(customer);
      console.log(this.loginService.currCust)
    }


  }

}

import { Component, OnInit} from '@angular/core';
import {CustomerService} from 'src/app/services/customer.service';
import {PersistentCustomerInfoService} from 'src/app/services/persistent-customer-info.service'; 
import { Router } from '@angular/router';

@Component({

  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css'] 

  // , '../../common/css/popup.css'
  })
export class LoginPageComponent implements OnInit {

  constructor(private customerService:CustomerService, 
              private router:Router, 
              private pcis: PersistentCustomerInfoService) { }

  userField:string;
  passField:string;

  //popup field for ngIf
  showPopUp: boolean=false;

  ngOnInit(): void {
  }

  async loginCust(){
    let dto = {email: this.userField, password: this.passField};

    let customer = await this.customerService.loginUser(dto);

    if (customer === null){

      this.showPopUp=true;
      this.userField="";
      this.passField="";
      
    }
    else{
      this.pcis.setCustomer(customer);
      this.router.navigateByUrl("/shop");
      
    }

  }

  closePopUp():void{
    this.showPopUp=false;
  }

}

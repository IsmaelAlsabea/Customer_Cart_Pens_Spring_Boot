import { Component, OnInit } from '@angular/core';
import {PersistentCustomerInfoService} from '../../services/persistent-customer-info.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-navigtation-bar',
  templateUrl: './navigtation-bar.component.html',
  styleUrls: ['./navigtation-bar.component.css']
})
export class NavigtationBarComponent implements OnInit {

  constructor(private pcis:PersistentCustomerInfoService, private router:Router) { }

  customerPoints:number;


  ngOnInit(): void {
    //this.custLoggedIn();
  }
  
  custLoggedIn():boolean {
    if(!this.pcis.isLoggedIn()) {
      return false;
    } else {
      this.customerPoints = this.pcis.getCustomer().points;
      return true;
      
    }
  }

  logout(): void{
    localStorage.clear();
    this.router.navigateByUrl("/login");
  }

  
}
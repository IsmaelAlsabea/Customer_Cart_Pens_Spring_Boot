import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Pen } from 'src/app/models/pen'



@Injectable({
  providedIn: 'root'
})
export class PenService {

  constructor(private http:HttpClient) { }

  //x : string = "localhost"
  x : string = "ec2-18-223-112-137.us-east-2.compute.amazonaws.com:9090";


  async getAllPensSort(ascending:boolean):Promise<Array<Pen>> {
    const pens:Array<Pen> = await this.http.get<Array<Pen>>(`http://${this.x}/pens?ascending=${ascending}`).toPromise();
    return pens;
  }

  async getAllPens():Promise<Array<Pen>>{
    const pens:Array<Pen> = await this.http.get<Array<Pen>>(`http://${this.x}/pens`).toPromise();
    return pens;
  }

  async getPenById(id:number):Promise<Pen> {
    const pen:Pen = await this.http.get<Pen>(`http://${this.x}/pens/${id}`).toPromise();
    return pen;
  }

}

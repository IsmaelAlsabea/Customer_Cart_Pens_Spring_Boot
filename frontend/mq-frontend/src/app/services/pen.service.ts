import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Pen } from 'src/app/models/pen'



@Injectable({
  providedIn: 'root'
})
export class PenService {

  constructor(private http:HttpClient) { }

  
  async getAllPensSort(ascending:boolean):Promise<Array<Pen>> {
    const pens:Array<Pen> = await this.http.get<Array<Pen>>(`http://localhost:9090/pens?ascending=${ascending}`).toPromise();
    return pens;
  }

  async getAllPens():Promise<Array<Pen>>{
    const pens:Array<Pen> = await this.http.get<Array<Pen>>(`http://localhost:9090/pens`).toPromise();
    return pens;
  }

  async getPenById(id:number):Promise<Pen> {
    const pen:Pen = await this.http.get<Pen>(`http://localhost:9090/pens/${id}`).toPromise();
    return pen;
  }

}



export class Order{
    oId         : number = 0;
    cartId      : number;
    cId         : number;
    orderDate   : string;

    constructor(oId:number, cartId:number, cId:number, orderDate:string){
        this.oId= oId;
        this.cartId=cartId;
        this.cId=cId;
        this.orderDate=orderDate;
    }

}
export class Order{
    oId         : number = 0;
    cartId      : number;
    cId         : number;
    orderDate   : string;
    orderTotal  : number;

    constructor(oId:number, cartId:number, cId:number, orderDate:string, orderTotal:number){
        this.oId= oId;
        this.cartId=cartId;
        this.cId=cId;
        this.orderDate=orderDate;
        this.orderTotal = orderTotal;
    }

}
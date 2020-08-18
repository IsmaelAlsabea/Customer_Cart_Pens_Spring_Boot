

export class Cart{
    cartId:number;
    cId : number;
    pId : number;
    quantity: number;

    constructor(cartId: number, cId: number, pId:number, quantity: number){
        this.cartId = cartId;
        this.cId =  cId;
        this.pId = pId;
        this.quantity=quantity;
    }

}
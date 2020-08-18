export class Customer{
    id:number;
    firstName:string;
    lastName:string;
    email:string;
    password:string;
    points:number;
    address:string;

    constructor(email:string, password:string){
        this.email = email;
        this.password = password;
    }
}

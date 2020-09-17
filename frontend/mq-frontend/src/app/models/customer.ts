export class Customer{
    cId:number;
    fname:string;
    lname:string;
    email:string;
    password:string;
    points:number;
    address:string;

    constructor(cId:number, fname:string, lname:string, points:number, address:string, email:string, password:string){
        this.email = email;
        this.password = password;
        this.cId = cId;
        this.fname = fname;
        this.lname = lname;
        this.points = points;
        this.address = address;
    }
}

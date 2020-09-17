export class Pen{
    pId:number;
    description: string;
    name: string;
    cost: number;
    image: string;

    constructor(pId:number,description: string,name: string,cost: number,image: string){
        this.pId = pId;
        this.description = description;
        this.cost=cost;
        this.name= name;
        this.image=image;
    }

}
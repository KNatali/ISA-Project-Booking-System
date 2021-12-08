export interface ItemInterface{
    id?:number;
    name:string;
    description:string;
    type:string;
}
export class Item implements ItemInterface{
    id?: number | undefined;
    name: string;
    description: string;
    type:string;
    constructor(obj:ItemInterface){
        this.id=obj.id;
        this.name=obj.name;
        this.description=obj.description;
        this.type=obj.type;
    }
    
}

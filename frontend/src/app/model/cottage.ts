import { Address } from "./address";

export interface CottageInterface{
    id?:number;
    name:string;
    //address:Address;
    state:string;
    street:string;
    city:string;
    description:string;
    grade:number;
    mainPicture:string;
}
export class Cottage implements CottageInterface{
    id?: number | undefined;
    name: string;
    //address: Address;
    description: string;
    grade: number;
    mainPicture:string;
    state:string;
    street:string;
    city:string;

    constructor(obj:CottageInterface){
        this.id=obj.id;
        this.name=obj.name;
        //this.address=obj.address;
        this.state=obj.state;
        this.street=obj.street;
        this.city=obj.city;
        this.description=obj.description;
        this.grade=obj.grade;
        this.mainPicture=obj.mainPicture;
    }
}
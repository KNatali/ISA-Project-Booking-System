import { Address } from "./address";

export interface CottageInterface{
    id?:number;
    name:string;
    address:Address;
    description:string;
    grade:number;
    mainPicture:string;
}
export class Cottage implements CottageInterface{
    id?: number | undefined;
    name: string;
    address: Address;
    description: string;
    grade: number;
    mainPicture:string;

    constructor(obj:CottageInterface){
        this.id=obj.id;
        this.name=obj.name;
        this.address=obj.address;
        this.description=obj.description;
        this.grade=obj.grade;
        this.mainPicture=obj.mainPicture;
    }
}
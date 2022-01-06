import { AdditionalItem } from "./additionalItem";
import { Address } from "./address";
import { CottageBehavioralRules } from "./cottageBehavioralRules";
import { CottageOwner } from "./cottageOwner";
import { Room } from "./rooms";

export interface CottageInterface{
    id?:number;
    name:string;
    state:string;
    street:string;
    city:string;
    description:string;
    grade:number;
    mainPicture:string;
    address: Address;
    price: number;
    maxPersons: number;
    cancellationPercentage: number;
    cottageOwner: CottageOwner;
    rules: CottageBehavioralRules[];
    items: AdditionalItem[];
    rooms: Room[];
}
export class Cottage implements CottageInterface{
    id?: number | undefined;
    name: string;
    address: Address;
    description: string;
    grade: number;
    mainPicture:string;
    state:string;
    street:string;
    city:string;
    price: number;
    cottageOwner: CottageOwner;
    maxPersons: number;
    cancellationPercentage: number;
    rules: CottageBehavioralRules[];
    items: AdditionalItem[];
    rooms: Room[];

    constructor(obj:CottageInterface){
        this.id=obj.id;
        this.name=obj.name;
        this.address=obj.address;
        this.state=obj.state;
        this.street=obj.street;
        this.city=obj.city;
        this.description=obj.description;
        this.grade=obj.grade;
        this.mainPicture=obj.mainPicture;
        this.price=obj.price;
        this.cottageOwner=obj.cottageOwner;
        this.maxPersons=obj.maxPersons;
        this.cancellationPercentage=obj.cancellationPercentage;
        this.rules=obj.rules;
        this.items=obj.items;
        this.rooms=obj.rooms;
    }
}
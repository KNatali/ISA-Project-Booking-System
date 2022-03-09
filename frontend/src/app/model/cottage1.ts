import { AdditionalItem } from "./additionalItem";
import { Address } from "./address";
import { CottageBehavioralRules } from "./cottageBehavioralRules";
import { CottageOwner } from "./cottageOwner";
import { Room } from "./rooms";

export interface CottageInterface{
    id?: number;
    name: string;
    address: Address;
    grade: number;
    price: number;
    maxPersons: number;
    description: string;
    mainPicture: string;
    cancellationPercentage: number;
    cottageOwner: CottageOwner;
    rules: CottageBehavioralRules[];
    items: AdditionalItem[];
    rooms: Room[];
    state:string;
    street:string;
    city:string;
}
export class Cottage implements CottageInterface{
    id?: number;
    name: string;
    address: Address;
    grade: number;
    price: number;
    maxPersons: number;
    description: string;
    mainPicture: string;
    cancellationPercentage: number;
    cottageOwner: CottageOwner;
    rules: CottageBehavioralRules[];
    items: AdditionalItem[];
    rooms: Room[];
    state:string;
    street:string;
    city:string;
    constructor(obj:CottageInterface){
        this.id = obj.id;
        this.name = obj.name;
        this.address = obj.address;
        this.maxPersons = obj.maxPersons
        this.description = obj.description;
        this.grade = obj.grade;
        this.price = obj.price;
        this.mainPicture = obj.mainPicture;
        this.cottageOwner = obj.cottageOwner;
        this.rules = obj.rules;
        this.items = obj.items;
        this.cancellationPercentage = obj.cancellationPercentage;
        this.state=obj.state;
        this.street=obj.street;
        this.city=obj.city;
    }
}
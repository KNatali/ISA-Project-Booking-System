import { Address } from "./address";

export interface BoatInterface{
    id?:number;
    name:string;
    state:string;
    street:string;
    city:string;
    length:number;
    motorNumber:number;
    motorPower:number;
    maxSpeed:number;
    description:string;
    capacity:number;
    grade:number;
    mainPicture:string;
    address: Address;
}
export class Boat implements BoatInterface{
    id?: number | undefined;
    name: string;
    length: number;
    motorNumber: number;
    motorPower: number;
    maxSpeed: number;
    description: string;
    capacity: number;
    grade: number;
    mainPicture:string;
    state:string;
    street:string;
    city:string;
    address: Address;
    constructor(obj:BoatInterface){
        this.id=obj.id;
        this.name=obj.name;
        this.state=obj.state;
        this.street=obj.street;
        this.city=obj.city;
        this.length=obj.length;
        this.motorNumber=obj.motorNumber;
        this.motorPower=obj.motorPower;
        this.maxSpeed=obj.maxSpeed;
        this.description=obj.description;
        this.capacity=obj.capacity;
        this.grade=obj.grade;
        this.mainPicture=obj.mainPicture;
        this.address = obj.address;
    }
    
}

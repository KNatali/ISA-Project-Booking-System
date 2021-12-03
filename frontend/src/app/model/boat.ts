import { Address } from "./address";

export interface BoatInterface{
    id?:number;
    name:string;
    address:Address;
    length:number;
    motorNumber:number;
    motorPower:number;
    maxSpeed:number;
    description:string;
    capacity:number;
    grade:number;
    mainPicture:string;
}
export class Boat implements BoatInterface{
    id?: number | undefined;
    name: string;
    address: Address;
    length: number;
    motorNumber: number;
    motorPower: number;
    maxSpeed: number;
    description: string;
    capacity: number;
    grade: number;
    mainPicture:string
    constructor(obj:BoatInterface){
        this.id=obj.id;
        this.name=obj.name;
        this.address=obj.address;
        this.length=obj.length;
        this.motorNumber=obj.motorNumber;
        this.motorPower=obj.motorPower;
        this.maxSpeed=obj.maxSpeed;
        this.description=obj.description;
        this.capacity=obj.capacity;
        this.grade=obj.grade;
        this.mainPicture=obj.mainPicture;
    }
    
}

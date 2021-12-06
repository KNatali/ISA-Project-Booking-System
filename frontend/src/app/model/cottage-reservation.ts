import { Client } from "./client";
import { Cottage } from "./cottage";

interface CottageReservationInterface{
    id?:number;
    date:Date;
    price:number;
    maxPersons:number;
    duration:number;
    client:Client;
    cottage:Cottage;
}
export class CottageReservation implements CottageReservationInterface{
    id?: number | undefined;
    date: Date;
    price: number;
    maxPersons: number;
    duration: number;
    client: Client;
    cottage: Cottage;
    constructor(obj:CottageReservationInterface){
        this.id=obj.id;
        this.date=obj.date;
        this.client=obj.client;
        this.cottage=obj.cottage;
        this.maxPersons=obj.maxPersons;
        this.price=obj.price;
        this.duration=obj.duration;
    }
}
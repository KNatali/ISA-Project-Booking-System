import { Boat } from "./boat";
import { Client } from "./client";

interface BoatReservationInterface{
    id?:number;
    date:Date;
    price:number;
    maxPersons:number;
    duration:number;
    client:Client;
    boat: Boat;
}
export class BoatReservation implements BoatReservationInterface{
    id?: number | undefined;
    date: Date;
    price: number;
    maxPersons: number;
    duration: number;
    client: Client;
    boat:Boat;
    constructor(obj:BoatReservationInterface){
        this.id=obj.id;
        this.date=obj.date;
        this.client=obj.client;
        this.boat=obj.boat;
        this.maxPersons=obj.maxPersons;
        this.price=obj.price;
        this.duration=obj.duration;
    }
}
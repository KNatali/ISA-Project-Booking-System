import { AdditionalItem } from "./additionalItem";
import { Client } from "./client";
import { Cottage } from "./cottage";

interface CottageReservationInterface{
    id?:number;
    reservationStart: string;
    reservationEnd: string;
    date:Date;
    price:number;
    maxPersons:number;
    duration:number;
    client:Client;
    cottage:Cottage;
    additionalItems: AdditionalItem[];
    systemEarning: number
}
export class CottageReservation implements CottageReservationInterface{
    id?: number | undefined;
    reservationStart: string;
    reservationEnd: string;
    date: Date;
    price: number;
    maxPersons: number;
    duration: number;
    client: Client;
    cottage: Cottage;
    additionalItems: AdditionalItem[];
    systemEarning: number
    constructor(obj:CottageReservationInterface){
        this.id=obj.id;
        this.reservationStart = obj.reservationStart;
        this.reservationEnd = obj.reservationEnd;
        this.date=obj.date;
        this.client=obj.client;
        this.cottage=obj.cottage;
        this.maxPersons=obj.maxPersons;
        this.price=obj.price;
        this.duration=obj.duration;
        this.additionalItems = obj.additionalItems;
        this.systemEarning = obj.systemEarning;
    }
}
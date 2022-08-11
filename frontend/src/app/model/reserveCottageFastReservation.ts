import { Client } from './client';
import { AdditionalItem } from "./additionalItem";
import { Cottage } from "./cottage";

export interface ReserveCottageFastReservationInterface {
    id?: number;
    reservationStart: string;
    reservationEnd: string;
    validityStart: string;
    validityEnd: string;
    maxPersons: number;
    price: number;
    items: AdditionalItem[];
    cottage?: Cottage;
    duration:number;
    client:Client;
}
export class ReserveCottageFastReservation implements ReserveCottageFastReservationInterface {
    id?: number;
    reservationStart: string;
    reservationEnd: string;
    validityStart: string;
    validityEnd: string;
    maxPersons: number;
    price: number;
    items: AdditionalItem[];
    cottage?: Cottage;
    duration:number;
    client:Client;
    constructor(obj: ReserveCottageFastReservationInterface) {
        this.id = obj.id;
        this.reservationStart = obj.reservationStart;
        this.reservationEnd = obj.reservationEnd;
        this.validityStart = obj.validityStart;
        this.validityEnd = obj.validityEnd;
        this.maxPersons = obj.maxPersons;
        this.price = obj.price;
        this.items = obj.items;
        this.cottage = obj.cottage;
        this.duration=obj.duration;
        this.client=obj.client;
    }
}

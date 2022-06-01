import { Client } from './client';
import { AdditionalItem } from "./additionalItem";
import { Boat } from "./boat";

export interface ReserveBoatFastReservationInterface {
    id?: number;
    reservationStart: string;
    reservationEnd: string;
    validityStart: string;
    validityEnd: string;
    maxPersons: number;
    price: number;
    additionalItems: AdditionalItem[];
    boat?: Boat;
    duration:number;
    client:Client;
}
export class ReserveBoatFastReservation implements ReserveBoatFastReservationInterface {
    id?: number;
    reservationStart: string;
    reservationEnd: string;
    validityStart: string;
    validityEnd: string;
    maxPersons: number;
    price: number;
    additionalItems: AdditionalItem[];
    boat?: Boat;
    duration:number;
    client:Client;
    constructor(obj: ReserveBoatFastReservationInterface) {
        this.id = obj.id;
        this.reservationStart = obj.reservationStart;
        this.reservationEnd = obj.reservationEnd;
        this.validityStart = obj.validityStart;
        this.validityEnd = obj.validityEnd;
        this.maxPersons = obj.maxPersons;
        this.price = obj.price;
        this.additionalItems = obj.additionalItems;
        this.boat = obj.boat;
        this.duration=obj.duration;
        this.boat=obj.boat;
    }
}

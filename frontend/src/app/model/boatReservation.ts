import { AdditionalItem } from "./additionalItem";
import { Boat } from "./boat";
import { Client } from "./client";

export interface BoatReservationInterface {
    id?: number;
    reservationStart: Date;
    reservationEnd: Date;
    numberOfPersons: number;
    price: number;
    additionalItems: AdditionalItem[];
    client: Client;
    boat: Boat;
}
export class BoatReservation implements BoatReservationInterface {
    id?: number;
    reservationStart: Date;
    reservationEnd: Date;
    numberOfPersons: number;
    price: number;
    additionalItems: AdditionalItem[];
    client: Client;
    boat: Boat;
    constructor(obj: BoatReservationInterface) {
        this.id = obj.id;
        this.reservationStart = obj.reservationStart;
        this.reservationEnd = obj.reservationEnd;
        this.numberOfPersons = obj.numberOfPersons
        this.price = obj.price;
        this.additionalItems = obj.additionalItems;
        this.client = obj.client;
        this.boat = obj.boat;
    }

}

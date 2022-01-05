import { AdditionalItem } from "./additionalItem";
import { Client } from "./client";
import { Cottage } from "./cottage1";

interface CottageReservationInterface{
    id?: number;
    reservationStart: Date;
    reservationEnd: Date;
    numberOfPersons: number;
    price: number;
    additionalItems: AdditionalItem[];
    client: Client;
    cottage: Cottage;
    disabled: boolean;
}
export class CottageReservation implements CottageReservationInterface{
    id?: number;
    reservationStart: Date;
    reservationEnd: Date;
    numberOfPersons: number;
    price: number;
    additionalItems: AdditionalItem[];
    client: Client;
    cottage: Cottage;
    disabled: boolean;
    constructor(obj:CottageReservationInterface){
        this.id = obj.id;
        this.reservationStart = obj.reservationStart;
        this.reservationEnd = obj.reservationEnd;
        this.numberOfPersons = obj.numberOfPersons
        this.price = obj.price;
        this.additionalItems = obj.additionalItems;
        this.client = obj.client;
        this.cottage = obj.cottage;
        this.disabled = obj.disabled;
    }
}
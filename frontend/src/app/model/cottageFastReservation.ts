import { AdditionalItem } from "./additionalItem";
import { Cottage } from "./cottage";

export interface CottageFastReservationInterface {
    id?: number;
    reservationStart: string;
    reservationEnd: string;
    validityStart: string;
    validityEnd: string;
    maxPersons: number;
    price: number;
    items: AdditionalItem[];
    cottage: Cottage;
    duration:number;
}
export class CottageFastReservation implements CottageFastReservationInterface {
    id?: number;
    reservationStart: string;
    reservationEnd: string;
    validityStart: string;
    validityEnd: string;
    maxPersons: number;
    price: number;
    items: AdditionalItem[];
    cottage: Cottage;
    duration:number;
    constructor(obj: CottageFastReservationInterface) {
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
    }
}

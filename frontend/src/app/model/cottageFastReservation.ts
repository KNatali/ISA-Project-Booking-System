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
    additionalItems: AdditionalItem[];
    cottage: Cottage;
}
export class CottageFastReservation implements CottageFastReservationInterface {
    id?: number;
    reservationStart: string;
    reservationEnd: string;
    validityStart: string;
    validityEnd: string;
    maxPersons: number;
    price: number;
    additionalItems: AdditionalItem[];
    cottage: Cottage;
    constructor(obj: CottageFastReservationInterface) {
        this.id = obj.id;
        this.reservationStart = obj.reservationStart;
        this.reservationEnd = obj.reservationEnd;
        this.validityStart = obj.validityStart;
        this.validityEnd = obj.validityEnd;
        this.maxPersons = obj.maxPersons;
        this.price = obj.price;
        this.additionalItems = obj.additionalItems;
        this.cottage = obj.cottage;
    }
}
import { AdditionalItem } from "./additionalItem";
import { Boat } from "./boat";

export interface BoatFastReservationInterface {
    id?: number;
    reservationStart: string;
    reservationEnd: string;
    validityStart: string;
    validityEnd: string;
    maxPersons: number;
    price: number;
    additionalItems: AdditionalItem[];
    boat: Boat;
    duration:number;
}
export class BoatFastReservation implements BoatFastReservationInterface {
    id?: number;
    reservationStart: string;
    reservationEnd: string;
    validityStart: string;
    validityEnd: string;
    maxPersons: number;
    price: number;
    additionalItems: AdditionalItem[];
    boat: Boat;
    duration:number;
    constructor(obj: BoatFastReservationInterface) {
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
    }
}

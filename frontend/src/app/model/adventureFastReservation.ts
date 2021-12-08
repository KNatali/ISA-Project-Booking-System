import { Client } from './client';
import { AdditionalItem } from "./additionalItem";
import { Address } from "./address";
import { AdventureBehavioralRules } from "./adventureBehavioralRules";
import { AdventureFishingEquipment } from "./adventureFishingEquipment";
import { Instructor } from "./instructor";
import { Adventure } from './adventure';

export interface AdventureFastReservationInterface {
    id?: number;
    reservationStart: Date;
    duration: number;
    validityStart: Date;
    validityEnd: Date;
    maxPersons: number;
    price: number;
    additionalItems: AdditionalItem[];

    adventure: Adventure;


}
export class AdventureFastReservation implements AdventureFastReservationInterface {
    id?: number;
    reservationStart: Date;
    duration: number;
    validityStart: Date;
    validityEnd: Date;
    maxPersons: number;
    price: number;
    additionalItems: AdditionalItem[];

    adventure: Adventure;
    constructor(obj: AdventureFastReservationInterface) {
        this.id = obj.id;
        this.reservationStart = obj.reservationStart;
        this.duration = obj.duration;
        this.validityStart = obj.validityStart;
        this.validityEnd = obj.validityEnd;
        this.maxPersons = obj.maxPersons;
        this.price = obj.price;
        this.additionalItems = obj.additionalItems;

        this.adventure = obj.adventure;


    }

}

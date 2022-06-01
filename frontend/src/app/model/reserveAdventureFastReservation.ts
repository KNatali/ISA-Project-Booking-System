import { Client } from './client';
import { AdditionalItem } from "./additionalItem";
import { Address } from "./address";
import { AdventureBehavioralRules } from "./adventureBehavioralRules";
import { AdventureFishingEquipment } from "./adventureFishingEquipment";
import { Instructor } from "./instructor";
import { Adventure } from './adventure';

export interface ReserveAdventureFastReservationInterface {
    id?: number;
    reservationStart: string;
    reservationEnd: string;
    validityStart: string;
    validityEnd: string;
    maxPersons: number;
    price: number;
    additionalItems: AdditionalItem[];
    adventure?: Adventure;
    durationHours:number;
    client:Client;
}
export class ReserveAdventureFastReservation implements ReserveAdventureFastReservationInterface {
    id?: number;
    reservationStart: string;
    reservationEnd: string;
    validityStart: string;
    validityEnd: string;
    maxPersons: number;
    price: number;
    additionalItems: AdditionalItem[];
    adventure?: Adventure;
    durationHours:number;
    client:Client;
    constructor(obj: ReserveAdventureFastReservationInterface) {
        this.id = obj.id;
        this.reservationStart = obj.reservationStart;
        this.reservationEnd = obj.reservationEnd;
        this.validityStart = obj.validityStart;
        this.validityEnd = obj.validityEnd;
        this.maxPersons = obj.maxPersons;
        this.price = obj.price;
        this.additionalItems = obj.additionalItems;
        this.adventure = obj.adventure;
        this.durationHours=obj.durationHours;
        this.client=obj.client;
    }
}

import { Client } from './client';
import { AdditionalItem } from "./additionalItem";
import { Address } from "./address";
import { AdventureBehavioralRules } from "./adventureBehavioralRules";
import { AdventureFishingEquipment } from "./adventureFishingEquipment";
import { Instructor } from "./instructor";
import { Adventure } from './adventure';

export interface AdventureReservationInterface {
    id?: number;
    reservationStart: string;
    reservationEnd: string;
    numberOfPersons: number;
    price: number;
    additionalItems: AdditionalItem[];
    client: Client;
    adventure: Adventure;

}
export class AdventureReservation implements AdventureReservationInterface {
    id?: number;
    reservationStart: string;
    reservationEnd: string;
    numberOfPersons: number;
    price: number;
    additionalItems: AdditionalItem[];
    client: Client;
    adventure: Adventure;

    constructor(obj: AdventureReservationInterface) {
        this.id = obj.id;
        this.reservationStart = obj.reservationStart;
        this.reservationEnd = obj.reservationEnd;
        this.numberOfPersons = obj.numberOfPersons
        this.price = obj.price;
        this.additionalItems = obj.additionalItems;
        this.client = obj.client;
        this.adventure = obj.adventure;



    }

}

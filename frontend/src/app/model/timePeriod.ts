import { AdditionalItem } from "./additionalItem";
import { Address } from "./address";
import { AdventureBehavioralRules } from "./adventureBehavioralRules";
import { AdventureFishingEquipment } from "./adventureFishingEquipment";
import { Instructor } from "./instructor";
import { UnavailabilityType } from "./unavailabilityType";
import { User } from "./user";


export interface TimePeriodInterface {
    id?: number;
    start: string;
    end: string;
    type: UnavailabilityType;


}
export class TimePeriod implements TimePeriodInterface {
    id?: number;
    start: string;
    end: string;
    type: UnavailabilityType;
    constructor(obj: TimePeriodInterface) {
        this.id = obj.id;
        this.start = obj.start;
        this.end = obj.end;
        this.type = obj.type;


    }

}

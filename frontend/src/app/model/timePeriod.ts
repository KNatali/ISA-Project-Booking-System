import { AdditionalItem } from "./additionalItem";
import { Address } from "./address";
import { AdventureBehavioralRules } from "./adventureBehavioralRules";
import { AdventureFishingEquipment } from "./adventureFishingEquipment";
import { Instructor } from "./instructor";
import { User } from "./user";

export interface TimePeriodInterface {
    id?: number;
    start: string;
    end: string;


}
export class TimePeriod implements TimePeriodInterface {
    id?: number;
    start: string;
    end: string;

    constructor(obj: TimePeriodInterface) {
        this.id = obj.id;
        this.start = obj.start;
        this.end = obj.end;


    }

}

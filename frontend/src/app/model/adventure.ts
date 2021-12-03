import { AdditionalItem } from "./additionalItem";
import { Address } from "./address";
import { AdventureBehavioralRules } from "./adventureBehavioralRules";
import { AdventureFishingEquipment } from "./adventureFishingEquipment";
import { Instructor } from "./instructor";

export interface AdventureInterface {
    id?: number;
    name: string;
    address: Address;
    averageGrade: number;
    maxPersons: number;
    description: string;
    mainPicture: string;
    instructor: Instructor;
    equipment: AdventureFishingEquipment[];
    rules: AdventureBehavioralRules[];
    additionalItems: AdditionalItem[];

}
export class Adventure implements AdventureInterface {
    id?: number;
    name: string;
    address: Address;
    averageGrade: number;
    maxPersons: number;
    description: string;
    mainPicture: string;
    instructor: Instructor;
    equipment: AdventureFishingEquipment[];
    rules: AdventureBehavioralRules[];
    additionalItems: AdditionalItem[];
    constructor(obj: AdventureInterface) {
        this.id = obj.id;
        this.name = obj.name;
        this.address = obj.address;
        this.maxPersons = obj.maxPersons
        this.description = obj.description;
        this.averageGrade = obj.averageGrade;
        this.mainPicture = obj.mainPicture;
        this.instructor = obj.instructor;
        this.equipment = obj.equipment;
        this.rules = obj.rules;
        this.additionalItems = obj.additionalItems;

    }

}

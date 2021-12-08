import { AdditionalItem } from "./additionalItem";
import { Address } from "./address";
import { AdventureBehavioralRules } from "./adventureBehavioralRules";
import { AdventureFishingEquipment } from "./adventureFishingEquipment";
import { Instructor } from "./instructor";
import { User } from "./user";

export interface RegistrationRequestInterface {
    id?: number;
    userDTO: User;
    reason: string;


}
export class RegistrationRequest implements RegistrationRequestInterface {
    id?: number;
    userDTO: User;
    reason: string;

    constructor(obj: RegistrationRequestInterface) {
        this.id = obj.id;
        this.userDTO = obj.userDTO;
        this.reason = obj.reason;


    }

}

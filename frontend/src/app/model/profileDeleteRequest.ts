
import { ProfileDeleteRequestType } from "./profileDeleteRequestType";
import { User } from "./user";

export interface ProfileDeleteRequestInterface {
    id?: number;
    userDTO: User;
    reason: string;
    type: ProfileDeleteRequestType


}
export class ProfileDeleteRequest implements ProfileDeleteRequestInterface {
    id?: number;
    userDTO: User;
    reason: string;
    type: ProfileDeleteRequestType
    constructor(obj: ProfileDeleteRequestInterface) {
        this.id = obj.id;
        this.userDTO = obj.userDTO;
        this.reason = obj.reason;
        this.type = obj.type;


    }

}

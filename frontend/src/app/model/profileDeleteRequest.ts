
import { User } from "./user";

export interface ProfileDeleteRequestInterface {
    id?: number;
    userDTO: User;
    reason: string;


}
export class ProfileDeleteRequest implements ProfileDeleteRequestInterface {
    id?: number;
    userDTO: User;
    reason: string;

    constructor(obj: ProfileDeleteRequestInterface) {
        this.id = obj.id;
        this.userDTO = obj.userDTO;
        this.reason = obj.reason;


    }

}

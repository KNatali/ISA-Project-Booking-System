import { CottageReservation } from "./cottageReservation";
import { Revision } from "./revision";

export interface CottageOwnerRevisionInterface {
    id?: number;
    cottageReservation: CottageReservation;
    revision: Revision;
}
export class CottageOwnerRevision implements CottageOwnerRevisionInterface {
    id?: number;
    cottageReservation: CottageReservation;
    revision: Revision;

    constructor(obj: CottageOwnerRevisionInterface) {
        this.id = obj.id;
        this.cottageReservation = obj.cottageReservation;
        this.revision = obj.revision;

    }

}
import { CottageReservation } from "./cottageReservation";
import { Revision } from "./revision";

export interface CottageRevisionInterface {
    id?: number;
    cottageReservation: CottageReservation;
    revision: Revision;
}
export class CottageRevision implements CottageRevisionInterface {
    id?: number;
    cottageReservation: CottageReservation;
    revision: Revision;

    constructor(obj: CottageRevisionInterface) {
        this.id = obj.id;
        this.cottageReservation = obj.cottageReservation;
        this.revision = obj.revision;

    }

}

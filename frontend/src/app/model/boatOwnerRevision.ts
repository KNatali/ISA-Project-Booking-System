import { BoatReservation } from "./boat-reservation";
import { Revision } from "./revision";

export interface BoatOwnerRevisionInterface {
    id?: number;
    boatReservation: BoatReservation;
    revision: Revision;
}
export class BoatOwnerRevision implements BoatOwnerRevisionInterface {
    id?: number;
    boatReservation: BoatReservation;
    revision: Revision;

    constructor(obj: BoatOwnerRevisionInterface) {
        this.id = obj.id;
        this.boatReservation = obj.boatReservation;
        this.revision = obj.revision;

    }

}

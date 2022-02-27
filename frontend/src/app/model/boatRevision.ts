import { BoatReservation } from "./boat-reservation";
import { Revision } from "./revision";

export interface BoatRevisionInterface {
    id?: number;
    boatReservation: BoatReservation;
    revision: Revision;
}
export class BoatRevision implements BoatRevisionInterface {
    id?: number;
    boatReservation: BoatReservation;
    revision: Revision;

    constructor(obj: BoatRevisionInterface) {
        this.id = obj.id;
        this.boatReservation = obj.boatReservation;
        this.revision = obj.revision;

    }

}

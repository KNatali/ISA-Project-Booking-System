import { AdventureReservation } from './AdventureReservation';
import { Client } from './client';
import { CottageReservation } from './cottageReservation';
import { Revision } from './revision';

export interface AdventureRevisionInterface {
    id?: number;
    adventureReservation: AdventureReservation;
    revision: Revision;
}
export class AdventureRevision implements AdventureRevisionInterface {
    id?: number;
    adventureReservation: AdventureReservation;
    revision: Revision;

    constructor(obj: AdventureRevisionInterface) {
        this.id = obj.id;
        this.adventureReservation = obj.adventureReservation;
        this.revision = obj.revision;

    }

}

import { ActivatedRoute } from '@angular/router';
import { BoatFastReservation } from './boatFastReservation';
import { TimePeriod } from './timePeriod';
export interface EditBoatFastReservationInterface {

    action: BoatFastReservation;
    oldReservationPeriod: TimePeriod;

}
export class EditBoatFastReservation implements EditBoatFastReservationInterface {


    action: BoatFastReservation;
    oldReservationPeriod: TimePeriod;
    constructor(obj: EditBoatFastReservationInterface) {

        this.action = obj.action;
        this.oldReservationPeriod = obj.oldReservationPeriod;
    }

}
import { ActivatedRoute } from '@angular/router';
import { AdventureFastReservation } from './adventureFastReservation';
import { TimePeriod } from './timePeriod';
export interface EditAdventureFastReservationInterface {

    action: AdventureFastReservation;
    oldReservationPeriod: TimePeriod;

}
export class EditAdventureFastReservation implements EditAdventureFastReservationInterface {


    action: AdventureFastReservation;
    oldReservationPeriod: TimePeriod;
    constructor(obj: EditAdventureFastReservationInterface) {

        this.action = obj.action;
        this.oldReservationPeriod = obj.oldReservationPeriod;
    }

}
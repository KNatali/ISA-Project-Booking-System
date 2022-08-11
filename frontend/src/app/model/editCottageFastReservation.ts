import { CottageFastReservation } from "./cottageFastReservation";
import { TimePeriod } from "./timePeriod";

export interface EditCottageFastReservationInterface {

    action: CottageFastReservation;
    oldReservationPeriod: TimePeriod;

}
export class EditCottageFastReservation implements EditCottageFastReservationInterface {


    action: CottageFastReservation;
    oldReservationPeriod: TimePeriod;
    constructor(obj: EditCottageFastReservationInterface) {

        this.action = obj.action;
        this.oldReservationPeriod = obj.oldReservationPeriod;
    }

}
import { BoatReservation } from './boatReservation';
import { Client } from './client';

export interface BoatOwnerReportInterface {
    id?: number;
    boatReservation: BoatReservation;
    checkAdmin: boolean;
    penal: boolean;
    checked: boolean,
    content: string;
}
export class BoatOwnerReport implements BoatOwnerReportInterface {
    id?: number;
    boatReservation: BoatReservation;
    checkAdmin: boolean;
    penal: boolean;
    checked: boolean;
    content: string;

    constructor(obj: BoatOwnerReportInterface) {
        this.id = obj.id;
        this.boatReservation = obj.boatReservation;
        this.checkAdmin = obj.checkAdmin;
        this.penal = obj.penal;
        this.checked = obj.checked;
        this.content = obj.content;
    }

}

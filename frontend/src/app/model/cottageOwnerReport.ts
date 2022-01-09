import { Client } from './client';
import { CottageReservation } from './cottageReservation';

export interface CottageOwnerReportInterface {
    id?: number;
    cottageReservation: CottageReservation;
    checkAdmin: boolean;
    penal: boolean;
    checked: boolean,
    content: string;
}
export class CottageOwnerReport implements CottageOwnerReportInterface {
    id?: number;
    cottageReservation: CottageReservation;

    checkAdmin: boolean;
    penal: boolean;
    checked: boolean;
    content: string;

    constructor(obj: CottageOwnerReportInterface) {
        this.id = obj.id;
        this.cottageReservation = obj.cottageReservation;
        this.checkAdmin = obj.checkAdmin;
        this.penal = obj.penal;
        this.checked = obj.checked;
        this.content = obj.content;
    }

}

import { Client } from './client';
import { Adventure } from './adventure';
import { AdventureReservation } from './AdventureReservation';

export interface InstructorReportInterface {
    id?: number;
    adventureReservation: AdventureReservation;
    checkAdmin: boolean;
    penal: boolean;
    content: string;


}
export class InstructorReport implements InstructorReportInterface {
    id?: number;
    adventureReservation: AdventureReservation;

    checkAdmin: boolean;
    penal: boolean;
    content: string;

    constructor(obj: InstructorReportInterface) {
        this.id = obj.id;
        this.adventureReservation = obj.adventureReservation;
        this.checkAdmin = obj.checkAdmin;
        this.penal = obj.penal;
        this.content = obj.content;


    }

}

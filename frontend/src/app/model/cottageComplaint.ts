
import { Client } from "./client";
import { Cottage } from "./cottage";
import { CottageReservation } from "./cottageReservation";

export interface CottageComplaintInterface {
    id?: number;
    description: string;
    client: Client;
    cottage: CottageReservation;



}
export class CottageComplaint implements CottageComplaintInterface {
    id?: number;
    description: string;
    client: Client;
    cottage: CottageReservation;

    constructor(obj: CottageComplaintInterface) {
        this.id = obj.id;
        this.description = obj.description;
        this.client = obj.client;
        this.cottage = obj.cottage;


    }

}
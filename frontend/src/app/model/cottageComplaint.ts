
import { Client } from "./client";
import { Cottage } from "./cottage";

export interface CottageComplaintInterface {
    id?: number;
    description: string;
    client: Client;
    cottage: Cottage;



}
export class CottageComplaint implements CottageComplaintInterface {
    id?: number;
    description: string;
    client: Client;
    cottage: Cottage;

    constructor(obj: CottageComplaintInterface) {
        this.id = obj.id;
        this.description = obj.description;
        this.client = obj.client;
        this.cottage = obj.cottage;


    }

}
import { Adventure } from "./adventure";
import { AdventureReservation } from "./AdventureReservation";
import { Client } from "./client";

export interface AdventureComplaintInterface {
    id?: number;
    description: string;
    client: Client;
    adventure: Adventure;



}
export class AdventureComplaint implements AdventureComplaintInterface {
    id?: number;
    description: string;
    client: Client;
    adventure: Adventure;

    constructor(obj: AdventureComplaintInterface) {
        this.id = obj.id;
        this.description = obj.description;
        this.client = obj.client;
        this.adventure = obj.adventure;


    }

}
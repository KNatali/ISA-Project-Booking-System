
import { Boat } from "./boat";
import { BoatReservation } from "./boat-reservation";
import { Client } from "./client";

export interface BoatComplaintInterface {
    id?: number;
    description: string;
    client: Client;
    boat: BoatReservation;



}
export class BoatComplaint implements BoatComplaintInterface {
    id?: number;
    description: string;
    client: Client;
    boat: BoatReservation;

    constructor(obj: BoatComplaintInterface) {
        this.id = obj.id;
        this.description = obj.description;
        this.client = obj.client;
        this.boat = obj.boat;


    }

}
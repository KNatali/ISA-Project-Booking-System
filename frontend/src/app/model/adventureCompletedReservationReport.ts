import { Client } from './client';
import { Adventure } from './adventure';

export interface AdventureCompletedReservationRequestInterface {
    id?: number;

    adventure: Adventure;
    client: Client;
    adminCheck: boolean;
    getPenal: boolean;
    content: string;


}
export class AdventureCompletedReservationRequest implements AdventureCompletedReservationRequestInterface {
    id?: number;
    adventure: Adventure;
    client: Client;
    adminCheck: boolean;
    getPenal: boolean;
    content: string;

    constructor(obj: AdventureCompletedReservationRequestInterface) {
        this.id = obj.id;
        this.client = obj.client;
        this.adminCheck = obj.adminCheck;
        this.getPenal = obj.getPenal;
        this.adventure = obj.adventure;
        this.content = obj.content;


    }

}

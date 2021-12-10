import { Cottage } from "./cottage";

export interface RoomInterface {
    id?: number;
    name: string;
    bedsNumber: number;
    cottage: Cottage;
}
export class Room implements RoomInterface {
    id?: number;
    name: string;
    bedsNumber: number;
    cottage: Cottage;

    constructor(obj: RoomInterface) {
        this.id = obj.id;
        this.name = obj.name;
        this.bedsNumber=obj.bedsNumber;
        this.cottage=obj.cottage;
    }

}
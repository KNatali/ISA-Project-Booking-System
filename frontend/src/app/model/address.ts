
export interface AddressInterface {
    id?: number;
    street: string;
    city: string;
    state: string;
    latitude: number;
    longitude: number;


}
export class Address implements AddressInterface {
    id?: number;
    street: string;
    city: string;
    state: string;
    latitude: number;
    longitude: number;

    constructor(obj: AddressInterface) {
        this.id = obj.id;
        this.street = obj.street;
        this.city = obj.city;
        this.state = obj.state
        this.latitude = obj.latitude;
        this.longitude = obj.longitude;


    }

}

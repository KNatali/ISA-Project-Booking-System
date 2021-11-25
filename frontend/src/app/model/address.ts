
export interface AddressInterface {
    id?: number;
    street: string;
    city: string;
    state: string;


}
export class Address implements AddressInterface {
    id?: number;
    street: string;
    city: string;
    state: string;

    constructor(obj: AddressInterface) {
        this.id = obj.id;
        this.street = obj.street;
        this.city = obj.city;
        this.state = obj.state


    }

}

export interface BoatOwnerInterface {
    id?: number ;
    firstName: string;
    lastName: string;
    username: string;
    password: string;
    address: string;
    street: string;
    state: string;
    city: string;
    email: string;
    mobile: string;
    grade?:number;
}
export class BoatOwner implements BoatOwnerInterface {
    id?: number ;
    firstName: string;
    lastName: string;
    username: string;
    password: string;
    address: string;
    street: string;
    state: string;
    city: string;
    email: string;
    mobile: string;
    grade?:number| undefined;

    constructor(obj: BoatOwnerInterface) {
        this.id = obj.id;
        this.firstName = obj.firstName;
        this.lastName = obj.lastName;
        this.username = obj.username
        this.password = obj.password;
        this.address=obj.address;
        this.street = obj.street;
        this.city = obj.city;
        this.state = obj.state;
        this.email = obj.email;
        this.mobile = obj.mobile;
        this.grade=obj.grade;
    }
}

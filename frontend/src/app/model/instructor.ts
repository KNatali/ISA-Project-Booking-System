export interface InstructorInterface {
    id: number;
    firstName: string;
    lastName: string;
    username: string;
    password: string;
    street: string;
    state: string;
    city: string;
    email: string;
    mobile: string;


}
export class Instructor implements InstructorInterface {
    id: number;
    firstName: string;
    lastName: string;
    username: string;
    password: string;
    street: string;
    state: string;
    city: string;
    email: string;
    mobile: string;
    constructor(obj: InstructorInterface) {
        this.id = obj.id;
        this.firstName = obj.firstName;
        this.lastName = obj.lastName;
        this.username = obj.username
        this.password = obj.password;
        this.street = obj.street;
        this.city = obj.city;
        this.state = obj.state;
        this.email = obj.email;
        this.mobile = obj.mobile;

    }


}

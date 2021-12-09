export interface AdminInterface {
    id?: number;
    firstName: string;
    lastName: string;
    username: string;
    password: string;
    street: string;
    state: string;
    city: string;
    email: string;
    mobile: string;

    biography: string;

    grade?: number;
    firstLogin: boolean;


}
export class Admin implements AdminInterface {
    id?: number;
    firstName: string;
    lastName: string;
    username: string;
    password: string;
    street: string;
    state: string;
    city: string;
    email: string;
    mobile: string;
    biography: string;
    firstLogin: boolean;


    grade?: number | undefined;

    constructor(obj: AdminInterface) {
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

        this.biography = obj.biography;
        this.firstLogin = obj.firstLogin;

        this.grade = obj.grade;

    }


}

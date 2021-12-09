/*export class User {
    constructor(
        public id: number,
        public username: string = '',
        public firstName: string = '',
        public lastName: string = '',
        public email: string = '',
        public password: string = '',
        public mobile: string = '',
        public role: string = '',
        public street: string = '',
        public state: string = '',
        public city: string = ''
    ) { }
}*/
export interface UserInterface {
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
    role: string;
    firstLogin: boolean;

}
export class User implements UserInterface {
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
    role: string;
    firstLogin: boolean;


    constructor(obj: UserInterface) {
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
        this.role = obj.role;
        this.firstLogin = obj.firstLogin;
    }


}






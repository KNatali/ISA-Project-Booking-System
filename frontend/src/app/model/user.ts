export class User {
    constructor(
        public id: number,
        public username: string = '',
        public fisrtName: string = '',
        public lastName: string = '',
        public email: string = '',
        public password: string = '',
        public mobile: string = '',
        public role: string = 'Client',
        public street: string = '',
        public state: string = '',
        public city: string = ''
    ) { }
}

export class AuthRequest {
    constructor(public username: string = '', public password: string = '') { }
}

export class ActiveUser {
    asObservable() {
        throw new Error('Method not implemented.');
    }
    constructor(
        public id: number = -1,
        public firstName: string = '',
        public jwt: string = '',
        public role: string = '',
        public username: string = 'sdf'
    ) { }
}

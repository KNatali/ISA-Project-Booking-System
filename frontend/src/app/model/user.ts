export class User {
    constructor(
        public id: number,
        public username: string = '',
        public firstName: string = '',
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





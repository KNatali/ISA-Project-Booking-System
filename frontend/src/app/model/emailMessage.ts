export interface EmailMessageInterface {
    id?: number;
    email: string;
    message: string;

}
export class EmailMessage implements EmailMessageInterface {
    id?: number | undefined;
    email: string;
    message: string;
    constructor(obj: EmailMessageInterface) {
        this.id = obj.id;
        this.email = obj.email;
        this.message = obj.message;
    }

}
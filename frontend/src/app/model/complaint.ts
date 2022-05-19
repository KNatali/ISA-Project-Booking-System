export interface ComplaintInterface {
    id?: number;
    description:string;
    idReservation:number;
}
export class Complaint implements ComplaintInterface{
    id?: number;
    description: string;
    idReservation: number;
    constructor(obj:ComplaintInterface){
        this.id=obj.id;
        this.description=obj.description;
        this.idReservation=obj.idReservation;
    }
}
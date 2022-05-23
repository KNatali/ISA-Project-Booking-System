export interface SearchForReservationInterface {
  id?: number;
  dateAndTime:string;
  numOfDay:number;
  numOfPerson:number;
}
export class SearchForReservation implements SearchForReservationInterface {
  id?: number;
  dateAndTime: string;
  numOfDay:number;
  numOfPerson:number;

  constructor(obj: SearchForReservationInterface) {
      this.id=obj.id;
      this.dateAndTime=obj.dateAndTime;
      this.numOfDay=obj.numOfDay;
      this.numOfPerson=obj.numOfPerson;
  }
}

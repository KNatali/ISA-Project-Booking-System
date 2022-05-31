import { AdditionalItem } from "./additionalItem";

export interface CottageReservationCreateInterface {
  id?: number;
  reservationStart: string;
  numberOfDays:number;
  numberOfPersons: number;
  price: number;
  additionalItems: AdditionalItem[];
  clientId: number;
  cottageId?: number;
  systemEarning: number;
}
export class CottageReservationCreate implements CottageReservationCreateInterface {
  id?: number;
  reservationStart: string;
  numberOfDays:number;
  numberOfPersons: number;
  price: number;
  additionalItems: AdditionalItem[];
  clientId: number;
  cottageId?: number;
  systemEarning: number;
  constructor(obj: CottageReservationCreateInterface) {
      this.id = obj.id;
      this.reservationStart = obj.reservationStart;
      this.numberOfDays=obj.numberOfDays;
      this.numberOfPersons = obj.numberOfPersons
      this.price = obj.price;
      this.additionalItems = obj.additionalItems;
      this.clientId = obj.clientId;
      this.cottageId = obj.cottageId;
      this.systemEarning = obj.systemEarning;
  }

}

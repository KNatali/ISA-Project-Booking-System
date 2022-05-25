import { AdditionalItem } from "./additionalItem";

export interface BoatReservationCreateInterface {
  id?: number;
  reservationStart: string;
  numberOfDays:number;
  numberOfPersons: number;
  price: number;
  additionalItems: AdditionalItem[];
  clientId: number;
  boatId?: number;
  systemEarning: number;
}
export class BoatReservationCreate implements BoatReservationCreateInterface {
  id?: number;
  reservationStart: string;
  numberOfDays:number;
  numberOfPersons: number;
  price: number;
  additionalItems: AdditionalItem[];
  clientId: number;
  boatId?: number;
  systemEarning: number;
  constructor(obj: BoatReservationCreateInterface) {
      this.id = obj.id;
      this.reservationStart = obj.reservationStart;
      this.numberOfDays=obj.numberOfDays;
      this.numberOfPersons = obj.numberOfPersons
      this.price = obj.price;
      this.additionalItems = obj.additionalItems;
      this.clientId = obj.clientId;
      this.boatId = obj.boatId;
      this.systemEarning = obj.systemEarning;
  }

}

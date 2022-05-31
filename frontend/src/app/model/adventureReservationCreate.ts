import { AdditionalItem } from "./additionalItem";

export interface AdventureReservationCreateInterface {
  id?: number;
  reservationStart: string;
  numberOfDays:number;
  numberOfPersons: number;
  price: number;
  additionalItems: AdditionalItem[];
  clientId: number;
  adventureId?: number;
  systemEarning: number;
}
export class AdventureReservationCreate implements AdventureReservationCreateInterface {
  id?: number;
  reservationStart: string;
  numberOfDays:number;
  numberOfPersons: number;
  price: number;
  additionalItems: AdditionalItem[];
  clientId: number;
  adventureId?: number;
  systemEarning: number;
  constructor(obj: AdventureReservationCreateInterface) {
      this.id = obj.id;
      this.reservationStart = obj.reservationStart;
      this.numberOfDays=obj.numberOfDays;
      this.numberOfPersons = obj.numberOfPersons
      this.price = obj.price;
      this.additionalItems = obj.additionalItems;
      this.clientId = obj.clientId;
      this.adventureId = obj.adventureId;
      this.systemEarning = obj.systemEarning;
  }

}

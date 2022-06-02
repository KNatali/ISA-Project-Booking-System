
import { Boat } from "./boat";

export interface SearchAvailableBoatByPriceOrGradeInterface {
  boats:Boat[];
  priceOrGrade:number;
}
export class SearchAvailableBoatByPriceOrGrade implements SearchAvailableBoatByPriceOrGradeInterface {
  boats:Boat[];
  priceOrGrade:number;

  constructor(obj: SearchAvailableBoatByPriceOrGradeInterface) {
    this.boats=obj.boats,
    this.priceOrGrade=obj.priceOrGrade
  }
}

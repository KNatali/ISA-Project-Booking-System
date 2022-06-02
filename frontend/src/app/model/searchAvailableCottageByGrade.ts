import { Adventure } from "./adventure";
import { Cottage } from "./cottage";

export interface SearchAvailableCottageByGradeInterface {
  cottages:Cottage[];
  grade:number;
}
export class SearchAvailableCottageByGrade implements SearchAvailableCottageByGradeInterface {
  cottages:Cottage[];
  grade:number;

  constructor(obj: SearchAvailableCottageByGradeInterface) {
    this.cottages=obj.cottages,
    this.grade=obj.grade
  }
}

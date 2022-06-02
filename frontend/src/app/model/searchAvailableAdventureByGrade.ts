import { Adventure } from "./adventure";

export interface SearchAvailableAdventureByGradeInterface {
  adventures:Adventure[];
  grade:number;
}
export class SearchAvailableAdventureByGrade implements SearchAvailableAdventureByGradeInterface {
  adventures:Adventure[];
  grade:number;

  constructor(obj: SearchAvailableAdventureByGradeInterface) {
    this.adventures=obj.adventures,
    this.grade=obj.grade
  }
}

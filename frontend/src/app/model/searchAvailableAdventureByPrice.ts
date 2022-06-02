import { Adventure } from "./adventure";

export interface SearchAvailableAdventureByPriceInterface {
  adventures:Adventure[];
  price:number;
}
export class SearchAvailableAdventureByPrice implements SearchAvailableAdventureByPriceInterface {
  adventures:Adventure[];
  price:number;

  constructor(obj: SearchAvailableAdventureByPriceInterface) {
    this.adventures=obj.adventures,
    this.price=obj.price
  }
}

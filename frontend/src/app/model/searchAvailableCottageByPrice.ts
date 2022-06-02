import { Adventure } from "./adventure";
import { Cottage } from "./cottage";

export interface SearchAvailableCottageByPriceInterface {
  cottages:Cottage[];
  price:number;
}
export class SearchAvailableCottageByPrice implements SearchAvailableCottageByPriceInterface {
  cottages:Cottage[];
  price:number;

  constructor(obj: SearchAvailableCottageByPriceInterface) {
    this.cottages=obj.cottages,
    this.price=obj.price
  }
}

export interface AdditionalItemInterface {
    id?: number;
    name: string;
    price: number;



}
export class AdditionalItem implements AdditionalItemInterface {
    id?: number;
    name: string;
    price: number;


    constructor(obj: AdditionalItem) {
        this.id = obj.id;
        this.name = obj.name;
        this.price = obj.price;


    }

}
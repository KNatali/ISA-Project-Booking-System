export interface NavigationEquipmentInterface {
    id?: number;
    name: string;
    price: number;



}
export class NavigationEquipment implements NavigationEquipmentInterface {
    id?: number;
    name: string;
    price: number;


    constructor(obj: NavigationEquipment) {
        this.id = obj.id;
        this.name = obj.name;
        this.price = obj.price;
    }

}
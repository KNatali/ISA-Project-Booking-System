export interface NavigationEquipmentInterface {
    id?: number;
    name: string;



}
export class NavigationEquipment implements NavigationEquipmentInterface {
    id?: number;
    name: string;


    constructor(obj: NavigationEquipment) {
        this.id = obj.id;
        this.name = obj.name;
    }

}
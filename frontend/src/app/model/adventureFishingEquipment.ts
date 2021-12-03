export interface AdventureFishingEquipmentInterface {
    id?: number;
    name: string;



}
export class AdventureFishingEquipment implements AdventureFishingEquipmentInterface {
    id?: number;
    name: string;


    constructor(obj: AdventureFishingEquipmentInterface) {
        this.id = obj.id;
        this.name = obj.name;


    }

}
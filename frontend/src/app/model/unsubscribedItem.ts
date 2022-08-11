export interface UnsubscribedItemInterface {
    clientIt: number;
    entityId:number;
}
export class UnsubscribedItem implements UnsubscribedItemInterface {
    clientIt: number;
    entityId:number;
    constructor(obj: UnsubscribedItem) {
        this.clientIt=obj.clientIt;
        this.entityId=obj.entityId;
    }

}

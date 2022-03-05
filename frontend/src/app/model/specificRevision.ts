export interface SpecificRevisionInterface {
    id_reservation: any;
    id_revision: any;
}
export class SpecificRevision implements SpecificRevisionInterface {
    id_reservation: any;
    id_revision: any;

    constructor(obj: SpecificRevisionInterface) {
        this.id_reservation=obj.id_reservation;
        this.id_revision=obj.id_revision
    }
}

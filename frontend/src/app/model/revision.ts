import { RevisionType } from './revisionType';

import { ProfileDeleteRequestType } from "./profileDeleteRequestType";
import { User } from "./user";

export interface RevisionInterface {
    id?: number;
    grade: number;
    revision: string;
    type: RevisionType


}
export class Revision implements RevisionInterface {
    id?: number;
    grade: number;
    revision: string;
    type: RevisionType
    constructor(obj: RevisionInterface) {
        this.id = obj.id;
        this.grade = obj.grade;
        this.revision = obj.revision;
        this.type = obj.type;


    }

}

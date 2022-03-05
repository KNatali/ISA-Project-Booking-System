import { RevisionType } from './revisionType';

import { ProfileDeleteRequestType } from "./profileDeleteRequestType";
import { User } from "./user";
import { Client } from './client';

export interface RevisionInterface {
    id?: number;
    grade: number;
    revision: string;
    type: RevisionType;
    //client?: Client//stavila sam da bude neobavezno zato sto ga nema u modelu


}
export class Revision implements RevisionInterface {
    id?: number;
    grade: number;
    revision: string;
    type: RevisionType
    //client?: Client
    constructor(obj: RevisionInterface) {
        this.id = obj.id;
        this.grade = obj.grade;
        this.revision = obj.revision;
        this.type = obj.type;
        //this.client = obj.client;


    }

}

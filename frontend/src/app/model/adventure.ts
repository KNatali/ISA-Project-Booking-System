import { Instructor } from "./instructor";

export interface AdventureInterface {
    id?: number;
    name: string;
    address: string;
    averageGrade: number;
    maxPersons: number;
    description: string;
    mainPicture: string;
    instructor: Instructor;

}
export class Adventure implements AdventureInterface {
    id?: number | undefined;
    name: string;
    address: string;
    averageGrade: number;
    maxPersons: number;
    description: string;
    mainPicture: string;
    instructor: Instructor;
    constructor(obj: AdventureInterface) {
        this.id = obj.id;
        this.name = obj.name;
        this.address = obj.address;
        this.maxPersons = obj.maxPersons
        this.description = obj.description;
        this.averageGrade = obj.averageGrade;
        this.mainPicture = obj.mainPicture;
        this.instructor = obj.instructor;

    }

}

import { Cottage } from "./cottage";

export interface SystemEarningsInterface {
    id?: number;
    percentage: number;
}
export class SystemEarnings implements SystemEarningsInterface {
    id?: number;
    percentage: number;

    constructor(obj: SystemEarningsInterface) {
        this.id = obj.id;
        this.percentage = obj.percentage;

    }

}
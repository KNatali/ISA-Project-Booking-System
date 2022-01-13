export interface BoatBehavioralRulesInterface {
    id?: number;
    rule: string;



}
export class BoatBehavioralRules implements BoatBehavioralRulesInterface {
    id?: number;
    rule: string;


    constructor(obj: BoatBehavioralRulesInterface) {
        this.id = obj.id;
        this.rule = obj.rule;


    }

}
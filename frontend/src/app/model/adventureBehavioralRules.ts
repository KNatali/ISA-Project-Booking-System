export interface AdventureBehavioralRulesInterface {
    id?: number;
    rule: string;



}
export class AdventureBehavioralRules implements AdventureBehavioralRulesInterface {
    id?: number;
    rule: string;


    constructor(obj: AdventureBehavioralRulesInterface) {
        this.id = obj.id;
        this.rule = obj.rule;


    }

}
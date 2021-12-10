export interface CottageBehavioralRulesInterface {
    id?: number;
    rule: string;



}
export class CottageBehavioralRules implements CottageBehavioralRulesInterface {
    id?: number;
    rule: string;


    constructor(obj: CottageBehavioralRulesInterface) {
        this.id = obj.id;
        this.rule = obj.rule;


    }

}
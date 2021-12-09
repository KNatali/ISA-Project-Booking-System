interface AvailableTermInterface{
    start:Date;
    end:Date;
}
export class AvailableTerm implements AvailableTermInterface{
    start: Date;
    end: Date;
    constructor(obj:AvailableTermInterface){
        this.start=obj.start;
        this.end=obj.end;
    }
}
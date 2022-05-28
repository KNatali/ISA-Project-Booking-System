import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { BoatBehavioralRules } from '../model/boatBehavioralRules';
import { BoatRuleService } from '../service/boat-rule.service';

@Component({
  selector: 'app-boat-rules-edit',
  templateUrl: './boat-rules-edit.component.html',
  styleUrls: ['./boat-rules-edit.component.css']
})
export class BoatRulesEditComponent implements OnInit {
  id: any;
  @Input() showAdd: boolean;
  @Input() showUpdate: boolean;
  @Output() loadBehavioralRules: EventEmitter<any> = new EventEmitter();
  @Input()
  rules: BoatBehavioralRules[];
  newRule: BoatBehavioralRules = new BoatBehavioralRules({
    rule: ""
  }

  )


  formValue1!: FormGroup;
  constructor(private formBuilder: FormBuilder, private route: ActivatedRoute, private boatRuleService: BoatRuleService) { }

  ngOnInit(): void {
    this.formValue1 = this.formBuilder.group({
      rule: ['']
    })
  }

  addRule() {
    this.newRule.rule = this.formValue1.value.rule;
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.boatRuleService.saveBoatRule(this.id, this.newRule)
        .subscribe(data => {
          let ref = document.getElementById('cancel1');
          ref?.click();
          this.formValue1.reset();
          this.loadBehavioralRules.emit();
          alert("Successfully added ner behvioral rule!");
        }, error => {
          alert(error)
        });
    });

  }

  updateRule() {
    this.newRule.rule = this.formValue1.value.rule;
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.boatRuleService.updateBoatRule(this.id, this.newRule)
        .subscribe(data => {
          let ref = document.getElementById('cancel1');
          ref?.click();
          this.formValue1.reset();
          this.loadBehavioralRules.emit();
          alert("Successfully edited behavioral rule");
        }, error => {
          alert(error)
        });
    });
  }

  deleteRule(ruleId: any) {


    this.route.params.subscribe(param => {
      this.id = param.id;
      this.boatRuleService.deleteBoatRule(this.id, ruleId)
        .subscribe(data => {


          alert("Successfully deleted behavioral rule!");
          this.loadBehavioralRules.emit();
        }, error => {
          alert(error)
        });
    });

  }
  editRule(item: any) {
    this.showAdd = false;
    this.showUpdate = true;
    this.formValue1.controls['rule'].setValue(item.rule);
    this.newRule.id = item.id;
  }


}

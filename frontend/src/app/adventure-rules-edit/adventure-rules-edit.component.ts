import { AdventureRuleService } from './../service/adventure-rule.service';
import { AdventureBehavioralRules } from './../model/adventureBehavioralRules';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-adventure-rules-edit',
  templateUrl: './adventure-rules-edit.component.html',
  styleUrls: ['./adventure-rules-edit.component.css']
})
export class AdventureRulesEditComponent implements OnInit {
  id: any;
  @Input() showAdd: boolean;
  @Input() showUpdate: boolean;
  @Output() loadBehavioralRules: EventEmitter<any> = new EventEmitter();
  @Input()
  rules: AdventureBehavioralRules[];
  newRule: AdventureBehavioralRules = new AdventureBehavioralRules({
    rule: ""
  }

  )


  formValue1!: FormGroup;
  constructor(private formBuilder: FormBuilder, private route: ActivatedRoute, private adventureRuleService: AdventureRuleService) { }

  ngOnInit(): void {
    this.formValue1 = this.formBuilder.group({
      rule: ['']
    })
  }

  addRule() {
    this.newRule.rule = this.formValue1.value.rule;
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.adventureRuleService.saveAdventureRule(this.id, this.newRule)
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
      this.adventureRuleService.updateAdvenutureRule(this.id, this.newRule)
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
      this.adventureRuleService.deleteAdventureRule(this.id, ruleId)
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

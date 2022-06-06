import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { CottageBehavioralRules } from '../model/cottageBehavioralRules';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { CottageRuleService } from '../service/cottage-rule.service';


@Component({
  selector: 'app-cottage-rules-edit',
  templateUrl: './cottage-rules-edit.component.html',
  styleUrls: ['./cottage-rules-edit.component.css']
})
export class CottageRulesEditComponent implements OnInit {
  id: any;
  @Input() showAdd: boolean;
  @Input() showUpdate: boolean;
  @Output() loadBehavioralRules: EventEmitter<any> = new EventEmitter();
  @Input()
  rules: CottageBehavioralRules[];
  newRule: CottageBehavioralRules = new CottageBehavioralRules({
    rule: ""
  }
  )


  formValue1!: FormGroup;
  constructor(private formBuilder: FormBuilder, private route: ActivatedRoute, private cottageRuleService: CottageRuleService) { }

  ngOnInit(): void {
    this.formValue1 = this.formBuilder.group({
      rule: ['']
    })
  }

  addRule() {
    this.newRule.rule = this.formValue1.value.rule;
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.cottageRuleService.saveCottageRule(this.id, this.newRule)
        .subscribe(data => {
          let ref = document.getElementById('cancel1');
          ref?.click();
          this.formValue1.reset();
          this.loadBehavioralRules.emit();
          alert("Successfully added new behvioral rule!");
        }, error => {
          alert(error)
        });
    });

  }

  updateRule() {
    this.newRule.rule = this.formValue1.value.rule;
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.cottageRuleService.updateCottageRule(this.id, this.newRule)
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

  editRule(item: any) {
    this.showAdd = false;
    this.showUpdate = true;
    this.formValue1.controls['rule'].setValue(item.rule);
    this.newRule.id = item.id;
  }

}

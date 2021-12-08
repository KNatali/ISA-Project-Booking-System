import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-admin-overview',
  templateUrl: './admin-overview.component.html',
  styleUrls: ['./admin-overview.component.css']
})
export class AdminOverviewComponent implements OnInit {
  formValue: FormGroup;
  percentage: number = 10;
  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
    this.formValue = this.fb.group({

      percentage: ['']

    }

    );
  }

  submit() {
    this.percentage = this.formValue.controls['percentage'].value;
  }

}

import { AdventureFishingEquipment } from './../model/adventureFishingEquipment';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { AdventureService } from '../service/adventure.service';

@Component({
  selector: 'app-adventure-equipment-edit',
  templateUrl: './adventure-equipment-edit.component.html',
  styleUrls: ['./adventure-equipment-edit.component.css']
})
export class AdventureEquipmentEditComponent implements OnInit {
  id: any;
  @Input() showAdd: boolean;
  @Input() showUpdate: boolean;
  @Output() loadEquipment: EventEmitter<any> = new EventEmitter();
  @Input()
  equipment: AdventureFishingEquipment[];
  newEquipment: AdventureFishingEquipment = new AdventureFishingEquipment({

    name: ""
  }

  )


  formValue!: FormGroup;
  constructor(private formBuilder: FormBuilder, private route: ActivatedRoute, private adventureService: AdventureService) { }

  ngOnInit(): void {
    this.formValue = this.formBuilder.group({
      name: ['']
    })
  }

  addEquipment() {
    this.newEquipment.name = this.formValue.value.name;
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.adventureService.saveAdventureEquipment(this.id, this.newEquipment)
        .subscribe(data => {
          let ref = document.getElementById('cancel');
          ref?.click();
          this.formValue.reset();
          this.loadEquipment.emit();
          alert("Successfully added equipment!");
        }, error => {
          alert(error)
        });
    });

  }

  updateEquipment() {
    this.newEquipment.name = this.formValue.value.name;
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.adventureService.updateAdvenutureEquipment(this.id, this.newEquipment)
        .subscribe(data => {
          let ref = document.getElementById('cancel');
          ref?.click();
          this.formValue.reset();
          this.loadEquipment.emit();
          alert("Successfully edited equipment");
        }, error => {
          alert(error)
        });
    });
  }

  deleteEquipment(equipmentId: any) {


    this.route.params.subscribe(param => {
      this.id = param.id;
      this.adventureService.deleteAdventureEquipment(this.id, equipmentId)
        .subscribe(data => {


          alert("Successfully reported patient!");
          this.loadEquipment.emit();
        }, error => {
          alert(error)
        });
    });

  }
  editEquipment(item: any) {
    this.showAdd = false;
    this.showUpdate = true;
    this.formValue.controls['name'].setValue(item.name);
    this.newEquipment.id = item.id;
  }

}

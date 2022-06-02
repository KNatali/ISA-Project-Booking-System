import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { NavigationEquipment } from '../model/navigationEquipment';
import { NavigationEquipmentService } from '../service/navigation-equipment.service';

@Component({
  selector: 'app-boat-navigation-equipment-edit',
  templateUrl: './boat-navigation-equipment-edit.component.html',
  styleUrls: ['./boat-navigation-equipment-edit.component.css']
})
export class BoatNavigationEquipmentEditComponent implements OnInit {
  id: any;
  @Input() showAdd: boolean;
  @Input() showUpdate: boolean;
  @Output() loadNavigationEquipment: EventEmitter<any> = new EventEmitter();
  @Input()
  equipment: NavigationEquipment[];
  newItem: NavigationEquipment = new NavigationEquipment({
    name: ""
  })
  formValue2!: FormGroup;
  constructor(private formBuilder: FormBuilder, private route: ActivatedRoute, private navigationEquipmentService: NavigationEquipmentService) { }

  ngOnInit(): void {
    this.formValue2 = this.formBuilder.group({
      name: [''],
      price: ['']
    })
  }

  addEquipment() {
    this.newItem.name = this.formValue2.value.name;
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.navigationEquipmentService.saveBoatNavigationEquipment(this.id, this.newItem)
        .subscribe(data => {
          let ref = document.getElementById('cancel2');
          ref?.click();
          this.formValue2.reset();
          this.loadNavigationEquipment.emit();
          alert("Successfully added navigation equipment!");
        }, error => {
          alert(error)
        });
    });

  }

  updateEquipment() {
    this.newItem.name = this.formValue2.value.name;
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.navigationEquipmentService.updateBoatNavigationEquipment(this.id, this.newItem)
        .subscribe(data => {
          let ref = document.getElementById('cancel2');
          ref?.click();
          this.formValue2.reset();
          this.loadNavigationEquipment.emit();
          alert("Successfully edited navigation equipment");
        }, error => {
          alert(error)
        });
    });
  }

  deleteEquipment(itemId: any) {


    this.route.params.subscribe(param => {
      this.id = param.id;
      this.navigationEquipmentService.deleteBoatNavigationEquipment(this.id, itemId)
        .subscribe(data => {
          alert("Successfully deleted navigation equipment!");
          this.loadNavigationEquipment.emit();
        }, error => {
          alert(error)
        });
    });

  }

  editEquipment(item: any) {
    this.showAdd = false;
    this.showUpdate = true;
    this.formValue2.controls['name'].setValue(item.name);
    this.newItem.id = item.id;
  }

  deletedeleteEquipmentItem(itemId: any) {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.navigationEquipmentService.deleteBoatNavigationEquipment(this.id, itemId)
        .subscribe(data => {
          alert("Successfully deleted additional item!");
          this.loadNavigationEquipment.emit();
        }, error => {
          alert(error)
        });
    });

  }

}

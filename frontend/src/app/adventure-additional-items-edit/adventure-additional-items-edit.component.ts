import { AdditionalItemService } from './../service/additional-item.service';
import { AdditionalItem } from './../model/additionalItem';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-adventure-additional-items-edit',
  templateUrl: './adventure-additional-items-edit.component.html',
  styleUrls: ['./adventure-additional-items-edit.component.css']
})
export class AdventureAdditionalItemsEditComponent implements OnInit {
  id: any;
  @Input() showAdd: boolean;
  @Input() showUpdate: boolean;
  @Output() loadAdditionalItems: EventEmitter<any> = new EventEmitter();
  @Input()
  additionalItems: AdditionalItem[];
  newItem: AdditionalItem = new AdditionalItem({

    name: "",
    price: 0
  }

  )
  formValue2!: FormGroup;
  constructor(private formBuilder: FormBuilder, private route: ActivatedRoute, private additionalItemService: AdditionalItemService) { }

  ngOnInit(): void {
    this.formValue2 = this.formBuilder.group({
      name: [''],
      price: ['']
    })
  }

  addItem() {
    this.newItem.name = this.formValue2.value.name;
    this.newItem.price = this.formValue2.value.price;
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.additionalItemService.saveAdventureAdditionalItem(this.id, this.newItem)
        .subscribe(data => {
          let ref = document.getElementById('cancel2');
          ref?.click();
          this.formValue2.reset();
          this.loadAdditionalItems.emit();
          alert("Successfully added additional item!");
        }, error => {
          alert(error)
        });
    });

  }

  updateItem() {
    this.newItem.name = this.formValue2.value.name;
    this.newItem.price = this.formValue2.value.price;
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.additionalItemService.updateAdvenutureAdditionalItem(this.id, this.newItem)
        .subscribe(data => {
          let ref = document.getElementById('cancel2');
          ref?.click();
          this.formValue2.reset();
          this.loadAdditionalItems.emit();
          alert("Successfully edited additional item");
        }, error => {
          alert(error)
        });
    });
  }

  deleteItem(itemId: any) {


    this.route.params.subscribe(param => {
      this.id = param.id;
      this.additionalItemService.deleteAdventureAdditionalItem(this.id, itemId)
        .subscribe(data => {


          alert("Successfully deleted additional item!");
          this.loadAdditionalItems.emit();
        }, error => {
          alert(error)
        });
    });

  }
  editItem(item: any) {
    this.showAdd = false;
    this.showUpdate = true;
    this.formValue2.controls['name'].setValue(item.name);
    this.formValue2.controls['price'].setValue(item.price);
    this.newItem.id = item.id;
  }

}

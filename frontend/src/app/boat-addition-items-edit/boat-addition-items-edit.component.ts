import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { AdditionalItem } from '../model/additionalItem';
import { AdditionalItemService } from '../service/additional-item.service';

@Component({
  selector: 'app-boat-addition-items-edit',
  templateUrl: './boat-addition-items-edit.component.html',
  styleUrls: ['./boat-addition-items-edit.component.css']
})
export class BoatAdditionItemsEditComponent implements OnInit {
  id: any;
  @Input() showAdd: boolean;
  @Input() showUpdate: boolean;
  @Output() loadAdditionalItems: EventEmitter<any> = new EventEmitter();
  @Input()
  items: AdditionalItem[];
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
      this.additionalItemService.saveBoatAdditionalItem(this.id, this.newItem)
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
      this.additionalItemService.updateBoatAdditionalItem(this.id, this.newItem)
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
      this.additionalItemService.deleteBoatAdditionalItem(this.id, itemId)
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

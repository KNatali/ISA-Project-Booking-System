import { Component, OnInit } from '@angular/core';
import { Item } from '../model/item';

@Component({
  selector: 'app-subscribe-items-list',
  templateUrl: './subscribe-items-list.component.html',
  styleUrls: ['./subscribe-items-list.component.css']
})
export class SubscribeItemsListComponent implements OnInit {
  items:Item[];
  item1:Item=new Item({
    name:'Litle sweet cottage',
    description:'Cottage near the river with a beautiful view. Surrounded by nature.cottage near the river with a beautiful view. surrounded by nature .cottage near the river with a beautiful view. surrounded by nature .cottage near the river with a beautiful view. surrounded by nature ',
    type:'Cottage'
  })
  item2:Item=new Item({
    name:'Wooden small boat',
    description:'Boat sailing on the Danube, Beautiful views. Possibility to fish. Enjoying the view and the silence. The sound of birds.boat sailing on the Danube, Beautiful views, Possibility to fish. Enjoying the view and the silence. The sound of birds.boat sailing on the Danube, Beautiful views, Possibility to fish. Enjoying the view and the silence. The sound of birds.',
    type:"Boat"
  })
  item3:Item=new Item({
    name:'exclusive yacht ',
    description:'Yacht  near the river with a beautiful view. Surrounded by nature cottage near the river with a beautiful view. surrounded by nature cottage near the river with a beautiful view. surrounded by nature ',
    type:'Boat'
  })
  constructor() {
    this.items=[]
   }

  ngOnInit(): void {
    this.loadData();
    console.log(this.items)
  }
  loadData(){
    this.items.push(this.item1);
    this.items.push(this.item2);
    this.items.push(this.item3);
  }
}

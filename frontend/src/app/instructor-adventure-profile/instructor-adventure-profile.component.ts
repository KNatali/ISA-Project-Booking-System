import { AdditionalItem } from './../model/additionalItem';
import { AdventureBehavioralRules } from './../model/adventureBehavioralRules';
import { AdventureFishingEquipment } from './../model/adventureFishingEquipment';
import { Component, OnInit } from '@angular/core';
import { Adventure } from '../model/adventure';
import { ActivatedRoute } from '@angular/router';
import { AdventureService } from '../service/adventure.service';
import { VERSION } from '@angular/forms';
import { BeforeSlideDetail } from 'lightgallery/lg-events';
import lgZoom from 'lightgallery/plugins/zoom';

@Component({
  selector: 'app-instructor-adventure-profile',
  templateUrl: './instructor-adventure-profile.component.html',
  styleUrls: ['./instructor-adventure-profile.component.css']
})
export class InstructorAdventureProfileComponent implements OnInit {
  name = "Angular " + VERSION.major;
  settings = {
    counter: false,
    plugin: [lgZoom]
  };

  id: number;
  adventure: Adventure;
  currentRate = 8;
  images = [
    {
      img: 'https://mdbootstrap.com/img/Photos/Lightbox/Original/img%20(145).jpg', thumb:
        'https://mdbootstrap.com/img/Photos/Lightbox/Original/img%20(145).jpg', description: 'Image 1'
    },
    {
      img: 'https://mdbootstrap.com/img/Photos/Lightbox/Original/img%20(150).jpg', thumb:
        'https://mdbootstrap.com/img/Photos/Lightbox/Original/img%20(150).jpg', description: 'Image 2'
    },
    {
      img: 'https://mdbootstrap.com/img/Photos/Lightbox/Original/img%20(152).jpg', thumb:
        'https://mdbootstrap.com/img/Photos/Lightbox/Original/img%20(152).jpg', description: 'Image 3'
    },
    {
      img: 'https://mdbootstrap.com/img/Photos/Lightbox/Original/img%20(42).jpg', thumb:
        'https://mdbootstrap.com/img/Photos/Lightbox/Original/img%20(42).jpg', description: 'Image 4'
    },
    {
      img: 'https://mdbootstrap.com/img/Photos/Lightbox/Original/img%20(151).jpg', thumb:
        'https://mdbootstrap.com/img/Photos/Lightbox/Original/img%20(151).jpg', description: 'Image 5'
    },
    {
      img: 'https://mdbootstrap.com/img/Photos/Lightbox/Original/img%20(40).jpg', thumb:
        'https://mdbootstrap.com/img/Photos/Lightbox/Original/img%20(40).jpg', description: 'Image 6'
    },
    {
      img: 'https://mdbootstrap.com/img/Photos/Lightbox/Original/img%20(148).jpg', thumb:
        'https://mdbootstrap.com/img/Photos/Lightbox/Original/img%20(148).jpg', description: 'Image 7'
    },
    {
      img: 'https://mdbootstrap.com/img/Photos/Lightbox/Original/img%20(147).jpg', thumb:
        'https://mdbootstrap.com/img/Photos/Lightbox/Original/img%20(147).jpg', description: 'Image 8'
    },
    {
      img: 'https://mdbootstrap.com/img/Photos/Lightbox/Original/img%20(149).jpg', thumb:
        'https://mdbootstrap.com/img/Photos/Lightbox/Original/img%20(149).jpg', description: 'Image 9'
    }
  ];
  constructor(private route: ActivatedRoute, private adventureService: AdventureService) { }

  ngOnInit(): void {
    this.loadData();
    this.loadEquipment();
    this.loadBehavioralRules();
    this.loadAdditionalItems();
  }

  loadData() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.adventureService.getAdventure(this.id)
        .subscribe((adventure: Adventure) => this.adventure = adventure);

    });

  }

  loadEquipment() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.adventureService.getAdventureEquipment(this.id)
        .subscribe((equipment: AdventureFishingEquipment[]) => this.adventure.equipment = equipment);
    });
  }

  loadBehavioralRules() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.adventureService.getAdventureBehavioralRules(this.id)
        .subscribe((rules: AdventureBehavioralRules[]) => this.adventure.rules = rules);
    });
  }

  loadAdditionalItems() {
    this.route.params.subscribe(param => {
      this.id = param.id;
      this.adventureService.getAdventureAdditionalItems(this.id)
        .subscribe((items: AdditionalItem[]) => this.adventure.additionalItems = items);
    });
  }

  onBeforeSlide = (detail: BeforeSlideDetail): void => {
    const { index, prevIndex } = detail;
    console.log(index, prevIndex);
  };

}

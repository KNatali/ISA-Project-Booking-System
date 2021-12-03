import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ClientService } from '../service/client.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-confirm-registration-client',
  templateUrl: './confirm-registration-client.component.html',
  styleUrls: ['./confirm-registration-client.component.css']
})
export class ConfirmRegistrationClientComponent implements OnInit {
  id:number;
  constructor(private route: ActivatedRoute,private router: Router, private clientService : ClientService) { }

  ngOnInit(): void {
  }
  activateAccount(){
    this.id = this.route.snapshot.params['id'];
    this.clientService.activateById(this.id)
    .subscribe();
    this.router.navigate(['sign-in']);
  }
}

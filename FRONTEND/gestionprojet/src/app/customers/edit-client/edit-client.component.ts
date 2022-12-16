import {Component, OnInit} from '@angular/core';
import {Client} from "../../model/client.model";
import {ClientService} from "../../services/client.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-edit-client',
  templateUrl: './edit-client.component.html',
  styleUrls: ['./edit-client.component.css']
})
export class EditClientComponent implements OnInit{
  client : Client = new Client();
  id:any;
  idcategorie !:number;
  constructor(private clientserv:ClientService,private route:ActivatedRoute,private  router:Router) {
  }
  ngOnInit() {
    this.client = new Client();
    this.id=this.route.snapshot.params['_id'];
    this.clientserv.GetClient(this.id).subscribe(data=>this.client=data),(err:any)=>console.log(err);
  }
  modifierClient(){
    this.clientserv.UpdateClient(this.client.id,this.client).subscribe(data=>this.router.navigate(['customers']));
  }
}

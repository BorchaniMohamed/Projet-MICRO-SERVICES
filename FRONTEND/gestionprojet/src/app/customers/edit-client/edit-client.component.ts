import {Component, OnInit} from '@angular/core';
import {Client} from "../../model/client.model";
import {ClientService} from "../../services/client.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Categorie} from "../../model/categorie.model";

@Component({
  selector: 'app-edit-client',
  templateUrl: './edit-client.component.html',
  styleUrls: ['./edit-client.component.css']
})
export class EditClientComponent implements OnInit{
  client : Client = new Client();
  id:any;
  idcategorie !:number;
  categories = new Array<Categorie>();
  message!:string;
  date=new Date();
  constructor(private clientserv:ClientService,private route:ActivatedRoute,private  router:Router) {
  }
  ngOnInit() {
    this.client = new Client();
    this.id=this.route.snapshot.params['_id'];
    this.clientserv.GetClient(this.id).subscribe(data=>this.client=data),(err:any)=>console.log(err);
    this.clientserv.getAllClientsCategories().subscribe(data=>this.categories=data);

  }
  modifierClient(){
    if((this.idcategorie==null)||(this.idcategorie==null)||(this.idcategorie<0))
    {this.message="Choisir une catégorie"}
    else {
      this.clientserv.UpdateClient(this.client.id, this.client).subscribe(data => this.router.navigate(['customers']));
    }  }

  getValueFromSelectCategorie(value: any) {
      console.log(value)
      if((value==undefined)||(value<0)||(value==null))
          {this.message="Choisir une catégorie"}
      else {
        this.idcategorie=value;
        this.message="Catégorie n° "+value;
        this.client.customerCategory=new Categorie();
        this.client.customerCategory.id=value;
      }

  }
}

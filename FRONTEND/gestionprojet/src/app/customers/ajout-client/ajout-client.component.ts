import {Component, OnInit} from '@angular/core';
import {ClientService} from "../../services/client.service";
import {Router} from "@angular/router";
import {Client} from "../../model/client.model";
import {Adresse} from "../../model/adresse.model";
import {todoClient} from "../../model/todoClient";
import {Categorie} from "../../model/categorie.model";


import {FormGroup} from '@angular/forms';

@Component({
  selector: 'app-ajout-client',
  templateUrl: './ajout-client.component.html',
  styleUrls: ['./ajout-client.component.css']
})
export class AjoutClientComponent implements OnInit{

  newclient : Client = new Client();
  adresseclient : Adresse = new Adresse();
  todoclient : todoClient = new todoClient();
  categclient !: Categorie;
  idcategorie !: number;
  form: FormGroup | undefined;


  constructor(private clientService : ClientService,private router : Router) {}


  ngOnInit() {}
  ajoutClient(){
    this.todoclient.dateOfAction = new Date();
    this.newclient.accountOpenedDate = new Date();
    this.newclient.adresse = new Adresse();
    this.newclient.todocustomer= new todoClient();
    this.newclient.customerCategory = new Categorie();
    //this.newclient.customerCategory.id = this.idcatecorie;

    //this.clientService.GetCategorieById(this.idcatecorie).subscribe(data=>this.categclient=data),
      //(err:any)=>console.log(err);
    //this.clientService.AddAdresse(this.adresseclient).subscribe(data=>  this.adresseclient = data,(err:any)=>console.log(err));
    //this.clientService.AddtodoActionClient(this.todoclient).subscribe(data=> {
      //this.todoclient = data;
      //this.newclient.todocustomer.id = this.todoclient.id;
    //},(err:any)=>console.log(err));
    this.newclient.adresse = this.adresseclient;
    this.newclient.customerCategory.id = this.idcategorie;
    this.newclient.todocustomer = this.todoclient;
    this.clientService.AddClient(this.newclient).subscribe(data=>this.router.navigate(['customers']));
  }

}

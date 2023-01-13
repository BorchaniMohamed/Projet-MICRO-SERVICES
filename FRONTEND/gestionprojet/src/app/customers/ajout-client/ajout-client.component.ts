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
  categories = new Array<Categorie>();
  idcategorie !: number;
  form: FormGroup | undefined;
  message!: string;


  constructor(private clientService : ClientService,private router : Router) {}


  ngOnInit() {
    this.clientService.getAllClientsCategories().subscribe(data=>this.categories=data);
  }
  ajoutClient(){
    if(this.idcategorie==undefined||this.idcategorie<0)
    {
      this.message="Choisir une Catégorie"
    }
    else
    {
      this.todoclient.dateOfAction = new Date();
      this.newclient.accountOpenedDate = new Date();
      this.newclient.adresse = new Adresse();
      this.newclient.todocustomer= new todoClient();
      this.newclient.customerCategory = new Categorie();
      this.newclient.adresse = this.adresseclient;
      this.newclient.customerCategory.id = this.idcategorie;
      this.newclient.todocustomer = this.todoclient;
      this.clientService.AddClient(this.newclient).subscribe(data=>this.router.navigate(['customers']));
    }

  }

  getValueFromSelectCategorie(value: any) {
    console.log(value)
        this.idcategorie=value
        this.message="catégorie "+value+" sélectionner"
  }

  btnannuler() {
    this.message=""
  }
}

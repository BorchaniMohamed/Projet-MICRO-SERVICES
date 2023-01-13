import {Component, OnInit} from '@angular/core';
import {Client} from "../model/client.model";
import {ClientService} from "../services/client.service";
import {Categorie} from "../model/categorie.model";
import {Adresse} from "../model/adresse.model";
import {todoClient} from "../model/todoClient";
import {Router} from "@angular/router";
import {FactureService} from "../services/facture.service";

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent implements  OnInit{
  customers!: Array<Client>;
  newcustomers!:Array<Client>;
  categories!: Array<Categorie>;
  adresses!:Array<Adresse>;
  todoclient!:Array<todoClient>;
  nomcategorie!: string;
  cat: Categorie = new Categorie();
  message!: string;
  date= new Date();


  constructor(private clientService:ClientService,private factureservice : FactureService,private router : Router) {  }
  ngOnInit() : void {
    this.loadClient();
  }

  HandelDeleteClient(p: any) {
    let index=this.customers.indexOf(p);
    this.customers.slice(index,1);
  }

  getAddress(p: Client) {
    if(p.adresse.gouvernorat==null) {var g = ""} else {var g = p.adresse.gouvernorat;}
    if(p.adresse.codepostale==null) {var c = 0}else {var c = p.adresse.codepostale;}
    if(p.adresse.delegation==null) {var d=""}else {var d = p.adresse.delegation;}
    if(p.adresse.localite==null) {var l=""}else {var l = p.adresse.localite;}
    // @ts-ignore
    if(c==0) c=""
    return g+' '+d+' '+l+' '+c;
  }


  getCategorie(p: Client) {
    return p.customerCategory.customerCategoryName;
  }
  supprimerClient(id:any){
    return this.clientService.DeleteClient(id).subscribe(data=>{this.loadClient()});

  }
  DeleteClient(id: number) {
    var ca : number;
    this.factureservice.GetCAByIDClient(id).subscribe(data=> {
      ca = data
      if(ca>0){window.alert('vous ne pouvez pas supprimer un client rattaché à une ou plusieurs factures')}
      else{this.supprimerClient(id);}
    });
  }

  private loadClient() {
    this.clientService.getAllClients().subscribe(data=>this.customers=data),
      (err:any)=>console.log(err);
    this.clientService.getAllClientsCategories().subscribe(data=> {
      this.categories = data;
      console.log(data)
    }),
      (err:any)=>console.log(err);
    this.clientService.getAllClientsAdresses().subscribe(data=>this.adresses=data),
      (err:any)=>console.log(err);
    this.clientService.getAllTodoClient().subscribe(data=>this.todoclient=data),
      (err:any)=>console.log(err);
    this.clientService.getAllNewClients().subscribe(data=>this.newcustomers=data),
      (err:any)=>console.log(err);
  }

  ajoutCategorie() {

    if(this.nomcategorie==undefined||this.nomcategorie.length==0)
    {
      this.message="remplir le champ"
    }
    else {
      this.cat.customerCategoryName=this.nomcategorie;
      this.clientService.AddGategorieClient(this.cat).subscribe();
      window.location.reload();
    }
  }
}

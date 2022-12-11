import {Component, OnInit} from '@angular/core';
import {Client} from "../model/client.model";
import {ClientService} from "../services/client.service";
import {Categorie} from "../model/categorie.model";
import {Adresse} from "../model/adresse.model";
import {todoClient} from "../model/todoClient";

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

  constructor(private clientService:ClientService) {  }
  ngOnInit() : void {
    this.loadClient();
  }

  HandelDeleteClient(p: any) {
    let index=this.customers.indexOf(p);
    this.customers.slice(index,1);
  }

  getAddress(p: Client) {
    return p.adresse.gouvernorat+' '+p.adresse.delegation+' '+p.adresse.localite+' '+p.adresse.codepostale;
  }

  getCategorie(p: Client) {
    return p.customerCategory.customerCategoryName;
  }

  DeleteClient(id: number) {
    return this.clientService.DeleteClient(id).subscribe(data=>{this.loadClient()});
  }

  private loadClient() {
    this.clientService.getAllClients().subscribe(data=>this.customers=data),
      (err:any)=>console.log(err);
    this.clientService.getAllClientsCategories().subscribe(data=>this.categories=data),
      (err:any)=>console.log(err);
    this.clientService.getAllClientsAdresses().subscribe(data=>this.adresses=data),
      (err:any)=>console.log(err);
    this.clientService.getAllTodoClient().subscribe(data=>this.todoclient=data),
      (err:any)=>console.log(err);
    this.clientService.getAllNewClients().subscribe(data=>this.newcustomers=data),
      (err:any)=>console.log(err);
  }
}

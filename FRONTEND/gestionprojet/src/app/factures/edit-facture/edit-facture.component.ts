import {Component, OnInit} from '@angular/core';
import {Facture} from "../../model/facture.model";
import {Client} from "../../model/client.model";
import {Produit} from "../../model/produit.model";
import {LigneFacture} from "../../model/ligneFacture.model";
import {ClientService} from "../../services/client.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FactureService} from "../../services/facture.service";
import {ProduitService} from "../../services/produit.service";

@Component({
  selector: 'app-edit-facture',
  templateUrl: './edit-facture.component.html',
  styleUrls: ['./edit-facture.component.css']
})
export class EditFactureComponent implements OnInit{


  facture:Facture=new Facture();
  produit:Produit=new Produit();
  id:any;
  clients=new Array<Client>();
  produits=new Array<Produit>();
  lignesfactures=new Array<LigneFacture>();
  messageproduit!:string;
  messageclient!:string;

  constructor(private clientserv:ClientService,
              private route:ActivatedRoute,
              private factureserv:FactureService,
              private produitserv:ProduitService,
              private  router:Router) {}

    ngOnInit(){
    this.facture=new Facture();
      this.id=this.route.snapshot.params['_id'];
      this.produitserv.getAllProducts().subscribe(data=>this.produits=data);
      this.clientserv.getAllClients().subscribe(data=>this.clients=data);
      this.factureserv.GetFactureByID(this.id).subscribe(data=>
      {
        this.facture=data
        this.lignesfactures=data.invoiceLines;
      }
        )  ;
  }
  modifierFacture() {

  }

  resetFacture() {

  }

  getstockitemname(p: LigneFacture) {
    return p.stockItem.stockItemName;
  }
}

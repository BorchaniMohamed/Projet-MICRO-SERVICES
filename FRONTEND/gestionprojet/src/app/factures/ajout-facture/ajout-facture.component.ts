import {Component, OnInit} from '@angular/core';
import {FactureService} from "../../services/facture.service";
import {Router} from "@angular/router";
import {ClientService} from "../../services/client.service";
import {ProduitService} from "../../services/produit.service";
import {Facture} from "../../model/facture.model";
import {Produit} from "../../model/produit.model";
import {Client} from "../../model/client.model";
import {LigneFacture} from "../../model/ligneFacture.model";

@Component({
  selector: 'app-ajout-facture',
  templateUrl: './ajout-facture.component.html',
  styleUrls: ['./ajout-facture.component.css']
})
export class AjoutFactureComponent implements OnInit{
 newFacture:Facture = new Facture();
 produits!: Array<Produit>;
 clients!:Array<Client>;
 id_client!:number;
 id_produit= new Array<number>;
 qte_cmd=new Array<number>;
  quantite: number=0;
  date_jour= new Date();
  qte_stq!: number;
  p:Produit = new Produit();
  chaines= new Array();

  lsLigneOrder = new Array<LigneOrder>();

  lignefacture= new Array<LigneFacture>;
  taille=0;

  idprod!:number;
  descrep!:string;
  qtestock!:number;
  message!: string;
  client = new Client();
  messageclient="";


 constructor(private factureservice: FactureService,
             private clientservice: ClientService,
             private produitservice:ProduitService,
             private router:Router) {
 }
  ngOnInit() {
    this.lsLigneOrder=[]
    this.produitservice.getAllProducts().subscribe(data=>this.produits=data);
    this.clientservice.getAllClients().subscribe(data=>this.clients=data);
  }

  ajoutFacture() {
   if(this.lsLigneOrder.length<=0)
   {window.alert("Facture vide")}
    else if(this.messageclient==undefined||this.messageclient.length<=0)
    {window.alert("Ajouter un client")}
    else{
     this.newFacture.customerId=this.id_client;
     this.newFacture.invoiceDate=new Date();
     this.newFacture.invoiceLines= [];
     for(var i = 0; i < this.lsLigneOrder.length; i++){
       this.newFacture.invoiceLines[i]=new LigneFacture();
       this.newFacture.invoiceLines[i].stockItemId=this.lsLigneOrder[i].produitid;
       this.newFacture.invoiceLines[i].quantity=this.lsLigneOrder[i].QteCmmd;
     }
     console.log(this.newFacture);
     this.factureservice.AddFacture(this.newFacture).subscribe(data=>this.router.navigate(['factures']));
     for(var i = 0; i < this.lsLigneOrder.length; i++)
     {
       this.lsLigneOrder[i].QteCmmd;
       this.produitservice.UpdateProduitQuantite(this.lsLigneOrder[i].produitid,this.lsLigneOrder[i].QteCmmd).subscribe();
     }
    }
  }

  getValueFromSelectClient(value: any) {
    this.clientservice.GetClient(value).subscribe(data=>{
      this.client=data
      this.messageclient="id : "+data.id+" Nom : "+data.customerName+" Tel : "+data.phoneNumber
      this.id_client=value;
      console.log(this.id_client);
      console.log(this.client);
      console.log(this.messageclient);
  });
  }




  getValueFromSelectProduit(value: any) {
    this.produitservice.GetProduit(value).subscribe(data => {
      this.p = data;
      console.log(this.p);
      console.log(this.quantite);


      if(this.quantite>this.p.quantity || this.quantite==0 || this.quantite==undefined) {
        this.quantite=0
        this.message="Quantité invalide"
      }
      else if(this.lsLigneOrder.map(e => e.produitid).indexOf(this.p.id)>=0){
        this.quantite=0
        this.message="produit insérer"
      }
       else if(this.lsLigneOrder.map(e => e.produitid).indexOf(this.p.id)==-1)
      {
        this.message=""
        let val = new LigneOrder();
        val.id=this.taille;
        val.description=this.p.stockItemName;
        val.produitid=this.p.id;
        val.QteCmmd=this.quantite;
        val.QteStock=this.p.quantity;
        val.prixprouit=this.p.price;
        val.totalligne=this.p.price*this.quantite;
        val.categorieproduit=this.p.categorie.stockItemCategoryName;
        this.lsLigneOrder.push(val);
        this.taille=this.taille+1;
        console.log(this.lsLigneOrder);
      }

    });



  }


  resetFacture() {
    this.lsLigneOrder=[];
    this.messageclient="";
  }
}
class LigneOrder{
  id!:number;
  produitid!:number;
  description!:string;
  QteStock!:number;
  QteCmmd!:number;
  prixprouit!:number;
  totalligne!:number;
  categorieproduit!:string;

}

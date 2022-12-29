import {Component, OnInit} from '@angular/core';
import {Facture} from "../../model/facture.model";
import {FactureService} from "../../services/facture.service";
import {TransactionService} from "../../services/transaction.service";
import {Router} from "@angular/router";
import {Transaction} from "../../model/transaction.model";

@Component({
  selector: 'app-ajout-transaction',
  templateUrl: './ajout-transaction.component.html',
  styleUrls: ['./ajout-transaction.component.css']
})
export class AjoutTransactionComponent implements OnInit{
  facturesnonpaye!:Array<Facture>;
  transaction=new Transaction();
  methodepayement: any;
  message!:string;
  constructor(private factureService:FactureService,private transactionService:TransactionService,private router : Router) {
  }
  ngOnInit() {
    this.loadFactureNonPaye();
  }

  private loadFactureNonPaye() {
    this.factureService.getAllFactures().subscribe(data=>this.facturesnonpaye=data),
      (err:any)=>console.log(err);
  }

  PayeFacture(facture: Facture) {

    if(this.methodepayement=="" || this.methodepayement==undefined) {
      this.message="Ajouter une méthode de payement"
    }
    else
    {
      this.transaction.transactionDate=new Date();
      this.transaction.invoice_id=facture.id;
      this.transaction.amounttransaction=facture.amount;
      this.transaction.payementMethod=this.methodepayement;
      this.transactionService.AddTransaction(this.transaction).subscribe(data=>this.router.navigate(['transactions']));
      this.factureService.UpdateStatutFacture(facture.id).subscribe();
    }


  }
}

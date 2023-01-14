import {Component, OnInit} from '@angular/core';
import {Facture} from "../../model/facture.model";
import {FactureService} from "../../services/facture.service";
import {TransactionService} from "../../services/transaction.service";
import {Router} from "@angular/router";
import {Transaction} from "../../model/transaction.model";
import {DeviseService} from "../../services/devise.service";
import {Devise} from "../../model/Devise";

@Component({
  selector: 'app-ajout-transaction',
  templateUrl: './ajout-transaction.component.html',
  styleUrls: ['./ajout-transaction.component.css']
})
export class AjoutTransactionComponent implements OnInit{
  facturesnonpaye!:Array<Facture>;
  transaction=new Transaction();
  methodepayement: any;

  devise!: string;
  deiseresult:Devise = new Devise();
  res!:number;



  constructor(private factureService:FactureService,
              private transactionService:TransactionService,
              private deviseservice: DeviseService,
              private router : Router) {
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
      window.alert("Ajouter moyen de payement")
    }
    else if(this.devise==undefined) {
      window.alert("Ajouter Code international devise")
    }
    else
    {
      this.transaction.transactionDate=new Date();
      this.transaction.invoice_id=facture.id;
      this.transaction.amounttransaction=facture.amount;
      this.transaction.devise=this.devise
      this.transaction.payementMethod=this.methodepayement;

      if(this.devise!="TND"){
        this.deviseservice.Getmontant(this.devise,facture.amount.toString()).subscribe(data1=> {
          this.deiseresult = data1
          this.transactionService.AddTransaction(this.transaction,this.deiseresult.result).subscribe(data=>this.router.navigate(['transactions']));
          this.factureService.UpdateStatutFacture(facture.id).subscribe();
        });
      }

      else{
        this.transactionService.AddTransaction(this.transaction,0).subscribe(data=>this.router.navigate(['transactions']));
        this.factureService.UpdateStatutFacture(facture.id).subscribe();
      }




    }


  }
}

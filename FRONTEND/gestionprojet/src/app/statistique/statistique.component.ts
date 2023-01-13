import {Component, OnInit} from '@angular/core';
import {ClientService} from "../services/client.service";
import {FactureService} from "../services/facture.service";
import {ProduitService} from "../services/produit.service";
import {TransactionService} from "../services/transaction.service";
import {Client} from "../model/client.model";

@Component({
  selector: 'app-statistique',
  templateUrl: './statistique.component.html',
  styleUrls: ['./statistique.component.css']
})
export class StatistiqueComponent implements OnInit{
  tableauinfo=new Map();

  clients !: Array<Client>;
  resultCAClient !:Array<StatistiqueClient>;
  mapAsc= new Map<number, number>();
  constructor(private clientService:ClientService,
              private fcatureService:FactureService,
              private produitService:ProduitService,
              private transactionService:TransactionService) {  }
  ngOnInit() : void {
    this.loadStatistiaue();
  }

  private loadStatistiaue() {
    this.fcatureService.getstatistiqueclient().subscribe(data1=> {
      this.resultCAClient = data1;
      //console.log(data1);
    });
    this.fcatureService.getBestClients().subscribe(data=> {
      this.tableauinfo = data;
    });


  }
}
class StatistiqueClient{
  customername!:string;
  cutomerid!:number;
  ca!:number;
  reste!:number;
  payedfacture!:string;
  nonpayedfacture!:string;
  stockItems!:string;
}

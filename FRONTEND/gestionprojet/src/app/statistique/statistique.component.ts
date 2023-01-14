import {Component, OnInit} from '@angular/core';
import {ClientService} from "../services/client.service";
import {FactureService} from "../services/facture.service";
import {ProduitService} from "../services/produit.service";
import {TransactionService} from "../services/transaction.service";
import {Facture} from "../model/facture.model";
import {Produit} from "../model/produit.model";
import {CAparAnnee} from "../model/CAparAnnee";
import {RangProduit} from "../model/RangProduit";

@Component({
  selector: 'app-statistique',
  templateUrl: './statistique.component.html',
  styleUrls: ['./statistique.component.css']
})
export class StatistiqueComponent implements OnInit{
  tableauinfo = new Map();

  nbnewclients !: number;
  resultCAClient !:Array<StatistiqueClient>;
  lsCapParAnnee !:Array<CAparAnnee>;
  rangdesproduits!:Array<RangProduit>
  distinctAnnee !: Array<number>;
  mapAsc= new Map<number, number>();
  nbnewfactures!: number;
  nbnewfprduits: any;
  newtransactions:any;




  constructor(private clientService:ClientService,
              private fcatureService:FactureService,
              private produitService:ProduitService,
              private transactionService:TransactionService) {  }
  ngOnInit() : void {
    this.loadStatistiaue();
  }

  private loadStatistiaue() {

    this.fcatureService.getrangproduit().subscribe(data7=> {
      this.rangdesproduits = data7
      console.log(data7)
    })


    this.clientService.getAllNewClients().subscribe(data3=>this.nbnewclients=data3.length)

    this.fcatureService.getAllNewFacture().subscribe(data4=>this.nbnewfactures=data4.length)

    this.produitService.getNewProduits().subscribe(data5=>this.nbnewfprduits=data5.length)

    this.transactionService.GetNewTransaction().subscribe(data6=>this.newtransactions=data6.length)

    this.fcatureService.getstatistiqueclient().subscribe(data1=> {
      this.resultCAClient = data1;


      this.fcatureService.getstatistiqueclientCaParAnnee().subscribe(data2=> {
        this.lsCapParAnnee = data2;
        this.distinctAnnee = this.lsCapParAnnee.map(a=>a.year).filter( (item,i,arr) => arr.findIndex(t => t === item) === i   );
        //console.log(data2);
      });
    });
    this.fcatureService.getBestClients().subscribe(data=> {
      this.tableauinfo = data;

    });


  }

  recupCAparanne(cutomerid: number, ann: number) {
    var resultCA =(this.lsCapParAnnee.filter((item,i,arr) => item.year === ann  &&  item.cutomerids===cutomerid)[0]) ;
    if(resultCA==undefined){return  0}
    else return resultCA.ca;
  }

  getCA(p: [any, any]) {
    let result : any = [];
    for (let key in p) {
      result = [key, p[key]]
      break;
    }
    return result
  }
}
class StatistiqueClient{
  customername!:string;
  cutomerid!:number;
  ca!:number;
  reste!:number;
  invoicespayed!:Array<Facture>;
  invoicesnotpayed!:Array<Facture>;
  stockItems!:Array<Produit>;
}



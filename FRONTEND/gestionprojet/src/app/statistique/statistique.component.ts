import {Component, OnInit} from '@angular/core';
import {ClientService} from "../services/client.service";
import {FactureService} from "../services/facture.service";
import {ProduitService} from "../services/produit.service";
import {TransactionService} from "../services/transaction.service";
import {Facture} from "../model/facture.model";
import {Produit} from "../model/produit.model";
import {CAparAnnee} from "../model/CAparAnnee";
import {RangProduit} from "../model/RangProduit";
import {Chart, registerables} from "chart.js";

@Component({
  selector: 'app-statistique',
  templateUrl: './statistique.component.html',
  styleUrls: ['./statistique.component.css']
})
export class StatistiqueComponent implements OnInit{
  public chart: any;
  public chartProductRank: any;
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
  anneeproductrank!: number;
  ca: any;
  dettes: any;
  repture: any;
  useddevise: any;

  produitrepture !: Array<Produit>;
  nbprod!: number;
  nbclient!: number;
   x: any;
   y:any;




  constructor(private clientService:ClientService,
              private fcatureService:FactureService,
              private produitService:ProduitService,
              private transactionService:TransactionService) {
    Chart.register(...registerables);
  }
  ngOnInit() : void {
    this.loadStatistiaue();
    this.loadProductRank()
    // this.createChart();
  }

  private loadStatistiaue() {

    this.fcatureService.getCA().subscribe(data=>this.ca=data)
    this.fcatureService.getdettes().subscribe(data=>this.dettes=data)
    this.produitService.getproduitrepture().subscribe(data=>this.repture=data)
    this.transactionService.getnbdevise().subscribe(data=>this.useddevise=data)
    this.produitService.getAllProducts().subscribe(data=>this.nbprod=data.length)
    this.clientService.getAllClients().subscribe(data=>this.nbclient=data.length)
    this.fcatureService.getpassifclient().subscribe(data=>this.x=data)
    this.fcatureService.getpassifproduits().subscribe(data=>this.y=data);
    this.produitService.getlisteProduitrepturestock().subscribe(data=>this.produitrepture=data)


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

  createChart(){
    this.chart = new Chart("MyChart", {
      type: 'bar', //this denotes tha type of chart

      data: {// values on X-Axis
        labels: ['2022-05-10', '2022-05-11', '2022-05-12','2022-05-13',
          '2022-05-14', '2022-05-15', '2022-05-16','2022-05-17', ],
        datasets: [
          {
            label: "Sales",
            data: ['467','576', '572', '79', '92',
              '574', '573', '576'],
            backgroundColor: 'blue'
          },
          {
            label: "Profit",
            data: ['542', '542', '536', '327', '17',
              '0.00', '538', '541'],
            backgroundColor: 'limegreen'
          }
        ]
      },
      options: {
        aspectRatio:2.5
      }

    });
  }

  private loadProductRank() {
    this.fcatureService.getrangproduit2().subscribe(data7=> {
      this.rangdesproduits = data7
      console.log(data7);
      this.createChartProductRank(this.rangdesproduits)
    })
  }

  private createChartProductRank(rangdesproduits: Array<RangProduit>) {
    this.chartProductRank = new Chart("ProductRankChart", {
      type: 'bar', //this denotes tha type of chart

      data: {// values on X-Axis
        labels: rangdesproduits.map(value => value.stockItem.stockItemName),
        datasets: [
          {
            label: "Produits",
            data: rangdesproduits.map(value => value.qteVendue),
            backgroundColor: 'blue'
          },
          // {
          //   label: "Profit",
          //   data: ['542', '542', '536', '327', '17',
          //     '0.00', '538', '541'],
          //   backgroundColor: 'limegreen'
          // }
        ]
      },
      options: {
        aspectRatio:2.5
      }

    });
  }
  onlyUnique(value:any, index:any, self:any) {
    return self.indexOf(value) === index;
  }
  updateproductrang(anneeproductrank: number) {
    console.log(anneeproductrank);
    if(anneeproductrank > 0){
      this.fcatureService.getrangproduit().subscribe(data7=> {


        this.chartProductRank.destroy()

        let arr = data7.filter((item,i,arr)=> item.year == anneeproductrank);
        this.createChartProductRank(arr)

      })
    }else{
      this.chartProductRank.destroy()
      this.createChartProductRank(this.rangdesproduits)
      // this.loadProductRank();

    }




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



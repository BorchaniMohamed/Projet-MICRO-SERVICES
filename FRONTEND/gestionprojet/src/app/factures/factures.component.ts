import {Component, OnInit} from '@angular/core';
import {Facture} from "../model/facture.model";
import {FactureService} from "../services/facture.service";
import {Client} from "../model/client.model";
import {LigneFacture} from "../model/ligneFacture.model";

@Component({
  selector: 'app-factures',
  templateUrl: './factures.component.html',
  styleUrls: ['./factures.component.css']
})
export class FacturesComponent implements OnInit{
  factures!: Array<Facture>;
  lfactures!: Array<LigneFacture>;
  newfactures!: Array<Facture>;
  date=new Date();

  constructor(private factureservice : FactureService) {}
  ngOnInit() : void {
    this.loadCFactures();
  }

  private loadCFactures() {
      this.factureservice.getAllFactures().subscribe(data=>this.factures=data),(err:any)=>console.log(err);
      this.factureservice.getAllFacturesLigne().subscribe(data=>this.lfactures=data),(err:any)=>console.log(err);
      this.factureservice.getAllNewFacture().subscribe(data=>this.newfactures=data);

  }

  getAdresseClient(customer: Client) {
    return customer.adresse.gouvernorat+' '+customer.adresse.delegation+' '+customer.adresse.localite+' '+customer.adresse.codepostale;
  }

  DeleteFacture(id: number) {
    return this.factureservice.DeleteFacture(id).subscribe(data=>{this.loadCFactures()});
  }


}

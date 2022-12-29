import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Facture} from "../model/facture.model";
import {LigneFacture} from "../model/ligneFacture.model";

@Injectable({
  providedIn: 'root'
})
export class FactureService {
  url="http://localhost:8023/";


  constructor(private http:HttpClient) { }

  getAllFactures = (): Observable<Facture[]> => {
    return this.http.get<Facture[]>(this.url+'invoices');
  };
  getAllFacturesLigne =():Observable<LigneFacture[]>=>{
    return this.http.get<LigneFacture[]>(this.url+'invoicesLine')
  }
  getAllNewFacture = ():Observable<Facture[]>=>{
    return this.http.get<Facture[]>(this.url+'newinvoices')
  }
  DeleteFacture(id:number):Observable<Facture>{
    return this.http.get<Facture>(this.url+'deleteInvoice/'+id);
  }
  AddFacture(facture:Facture):Observable<Facture>{
    console.log(JSON.stringify(facture))
    const headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
    return this.http.post<Facture>(this.url+'invoices',facture,{headers : headers});
  }
  UpdateStatutFacture(id:number):Observable<Facture>{
    return this.http.get<Facture>(this.url+'editinvoicestatu/'+id);
  }
}

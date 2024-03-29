import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Produit} from "../model/produit.model";
import {CategorieProduit} from "../model/categorieProduit";
import {Fournisseur} from "../model/fournisseur";

@Injectable({
  providedIn: 'root'
})
export class ProduitService {
  url="http://localhost:8022/";
  constructor(private http:HttpClient) { }

  getAllProducts = (): Observable<Produit[]> => {
    return this.http.get<Produit[]>(this.url+'stockItems');
  };

  getlisteProduitrepturestock = (): Observable<Produit[]> => {
    return this.http.get<Produit[]>(this.url+'listeproduitsenrepture');
  };

  getAllCategories =():Observable<CategorieProduit[]> =>
    {
      return this.http.get<CategorieProduit[]>(this.url+'stockItemCategories');
    }
    getAllFournisseur=():Observable<Fournisseur[]>=>{
      return this.http.get<Fournisseur[]>(this.url+'fournisseurs');
    }
    getNewProduits=():Observable<Produit[]>=>
    {
      return this.http.get<Produit[]>(this.url+'newstockItems');
    }
    getNewFournisseur=():Observable<Fournisseur[]>=>{
      return this.http.get<Fournisseur[]>(this.url+'newcFournisseurs');
    }
  DeleteProduit(id:number):Observable<Produit>{
    return this.http.get<Produit>(this.url+'deleteStockItem/'+id);
  }
  AddProduit(produit:Produit):Observable<Produit>{
    console.log(JSON.stringify(produit))
    const headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
    return this.http.post<Produit>(this.url+'stockItems',produit,{headers : headers});
  }
  GetProduit(id:any):Observable<Produit>{
    return this.http.get<Produit>(this.url+'stockItems/'+id);
  }

  getproduitrepture():Observable<number>{
    return this.http.get<number>(this.url+'produitsrepture/');
  }

  UpdateProduit(id:any,produit:Produit):Observable<Produit>{
    return this.http.put<Produit>(this.url+'stockItems/'+id,produit);
  }
  UpdateProduitQuantite(id:any,qte:any):Observable<Produit>{
    return this.http.get<Produit>(this.url+'stockItems/'+id+'/'+qte);
  }
  AddFournisseur(fournisseur:Fournisseur):Observable<Fournisseur>{
    console.log(JSON.stringify(fournisseur))
    const headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
    return this.http.post<Fournisseur>(this.url+'fournisseurs',fournisseur,{headers:headers});
  }
  AddCategProduit(categorieproduit:CategorieProduit):Observable<CategorieProduit>{
    console.log(JSON.stringify(categorieproduit))
    const headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
    return this.http.post<CategorieProduit>(this.url+'stockItemCategories',categorieproduit,{headers:headers});
  }
}

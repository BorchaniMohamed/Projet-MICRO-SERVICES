import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Produit} from "../model/produit.model";

@Injectable({
  providedIn: 'root'
})
export class ProduitService {
  url="http://localhost:8022/stockItems";

  constructor(private http:HttpClient) { }

  getAllProducts = (): Observable<Produit[]> => {
    return this.http.get<Produit[]>(this.url);
  };
}

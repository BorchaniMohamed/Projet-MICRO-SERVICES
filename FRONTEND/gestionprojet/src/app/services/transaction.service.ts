import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Transaction} from "../model/transaction.model";

@Injectable({
  providedIn: 'root'
})
export class TransactionService {
url="http://localhost:8024/";
  constructor(private http:HttpClient) { }
  getAllTransaction =():Observable<Transaction[]> =>{
    return this.http.get<Transaction[]>(this.url+"transactions");
  };
  AddTransaction(transction:Transaction,montantdevise:number):Observable<Transaction>{
    console.log(JSON.stringify(transction));
    const headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
    return this.http.post<Transaction>(this.url+"transactions/"+montantdevise,transction,{headers:headers});
  };
  GetNewTransaction():Observable<Transaction[]>{
    return this.http.get<Transaction[]>(this.url+"newtransactions");
  }

}

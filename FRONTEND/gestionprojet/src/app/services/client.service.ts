import {Injectable} from '@angular/core';
import {Client} from "../model/client.model";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Categorie} from "../model/categorie.model";
import {Adresse} from "../model/adresse.model";
import {todoClient} from "../model/todoClient";

@Injectable({
  providedIn: 'root'
})
export class ClientService {
  url="http://localhost:8021/";


  constructor(private http:HttpClient) { }

    getAllClients = (): Observable<Client[]> => {
      return this.http.get<Client[]>(this.url+'customers');
    };
    getAllClientsCategories = (): Observable<Categorie[]> => {
      return this.http.get<Categorie[]>(this.url+'customerCategories');
    };
    getAllClientsAdresses = (): Observable<Adresse[]> => {
      return this.http.get<Adresse[]>(this.url+'adresses');
    };
    getAllTodoClient = (): Observable<todoClient[]>=>{
      return this.http.get<todoClient[]>(this.url+'todocustomer');
    }
    getAllNewClients = (): Observable<Client[]> => {
      return this.http.get<Client[]>(this.url+'newcustomers');
    };
    DeleteClient(id:number):Observable<Client>{
      return this.http.get<Client>(this.url+'deleteCustomer/'+id);
    }


}

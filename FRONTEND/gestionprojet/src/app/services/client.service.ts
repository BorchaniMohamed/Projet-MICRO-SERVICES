import {Injectable} from '@angular/core';
import {Client} from "../model/client.model";
import {Observable} from "rxjs";
import {HttpClient, HttpHeaders} from "@angular/common/http";
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
      return this.http.get<Adresse[]>(this.url+'newcadresses');
    };
    getAllTodoClient = (): Observable<todoClient[]>=>{
      return this.http.get<todoClient[]>(this.url+'newcactionstodo');
    }
    getAllNewClients = (): Observable<Client[]> => {
      return this.http.get<Client[]>(this.url+'newcustomers');
    };
    DeleteClient(id:number):Observable<Client>{
      return this.http.get<Client>(this.url+'deleteCustomer/'+id);
    }
    AddClient(client:Client):Observable<Client>{
      console.log(JSON.stringify(client))
      const headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
      return this.http.post<Client>(this.url+'customers',client,{headers : headers});
    }
    GetCategorieById(id:number):Observable<Categorie>{
      return this.http.get<Categorie>(this.url+'customerCategories/'+id);
    }
    AddAdresse(adresse:Adresse):Observable<Adresse>{
      return this.http.post<Adresse>(this.url+'adresses',adresse);
    }
    AddtodoActionClient(todoclient:todoClient):Observable<todoClient>{
      console.log(JSON.stringify(todoclient))
      const headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
      return this.http.post<todoClient>(this.url+'toDoCustomers',todoclient, {headers : headers});
    }
    AddGategorieClient(categorie : Categorie):Observable<Categorie>{
      return this.http.post<Categorie>(this.url+'customerCategories',categorie)
    }
    GetClient(id:any):Observable<Client>{
      return this.http.get<Client>(this.url+'customers/'+id);
    }
    UpdateClient(id:any,client:Client):Observable<Client>{
      return this.http.put<Client>(this.url+'customers/'+id,client);
    }
    GetInfoClient=():Observable<any>=>{
      return this.http.get<any>(this.url+'infocustomers');
    }




}

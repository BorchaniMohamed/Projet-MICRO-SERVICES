import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class DeviseService {
  url="http://localhost:8025/";

  constructor(private http:HttpClient) { }

  Getmontant(devise:string,amount:string){
    return this.http.get<any>(this.url+"deviceDinarsEuro/"+devise+"/"+amount)
}
}

import {Adresse} from "./adresse.model";
import {Categorie} from "./categorie.model";
import {todoClient} from "./todoClient";

export interface Client{
  id : number;
  customerName : string;
  accountOpenedDate : Date;
  dateOfBirith :Date;
  phoneNumber : number;
  customerEmail : string;
  adresse : Adresse;
  customerCategory : Categorie;
  todocustomer : todoClient;
}

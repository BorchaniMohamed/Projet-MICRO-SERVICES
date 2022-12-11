import {Client} from "./client.model";

export interface Facture{
  id:number;
  invoiceDate: Date;
  states : string;
  customer : Client;
  customerId: number;
  amount:number;
  restetopayed:number;

}

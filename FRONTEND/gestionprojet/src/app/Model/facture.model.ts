import {Client} from "./client.model";

export class Facture{
  id!:any;
  invoiceDate!: Date;
  states !: string;
  customer !: Client;
  customerId!: number;
  amount!:number;
  restetopayed!:number;

}

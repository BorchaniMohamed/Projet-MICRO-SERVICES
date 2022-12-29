import {Client} from "./client.model";
import {LigneFacture} from "./ligneFacture.model";

export class Facture{
  id!:any;
  invoiceDate!: Date;
  states !: string;
  customer !: Client;
  customerId!: number;
  amount!:number;
  invoiceLines !: Array<LigneFacture>;


}

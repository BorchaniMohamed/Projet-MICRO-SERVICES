import {Facture} from "./facture.model";

export interface transaction{
  id:number;
  payementMethod:string;
  transactionDate:Date;
  amounttransaction: number;
  invoice : Facture;
  nvoice_id: number;

}

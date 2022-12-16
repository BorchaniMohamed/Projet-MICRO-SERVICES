import {Facture} from "./facture.model";

export class transaction{
  id !:any;
  payementMethod !:string;
  transactionDate !:Date;
  amounttransaction !: number;
  invoice !: Facture;
  nvoice_id !: number;

}

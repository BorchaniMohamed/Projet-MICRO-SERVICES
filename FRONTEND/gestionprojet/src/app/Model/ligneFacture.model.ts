import {Facture} from "./facture.model";
import {Produit} from "./produit.model";

export class LigneFacture{
  id!:number;
  invoice !: Facture;
  stockItem !: Produit;
  stockItemId !: number;
  quantity !: number;
  amountinvoiveline !: number;


}

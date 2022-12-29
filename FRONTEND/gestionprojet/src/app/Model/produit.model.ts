import {CategorieProduit} from "./categorieProduit";
import {Fournisseur} from "./fournisseur";

export class Produit{

  id !: any;
  stockItemName !: string;
  brand !: string;
  carateristique !: string;
  price !: number;
  quantity !: number;
  validTo !: Date;
  validForm !: Date;
  accountOpenedDate!:Date;
  categorie!: CategorieProduit;
  fournisseur!:Fournisseur;
}

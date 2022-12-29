import {Component} from '@angular/core';
import {Produit} from "../model/produit.model";
import {ProduitService} from "../services/produit.service";
import {CategorieProduit} from "../model/categorieProduit";
import {Fournisseur} from "../model/fournisseur";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent {
  produits!: Array<Produit>;
  categorieProduit! : Array<CategorieProduit>;
  newproduits! :Array<Produit>
  newfournisseur!:Array<Fournisseur>
  constructor(private produitService:ProduitService) {  }
  ngOnInit() : void {
   this.loadProuit();
  }

  HandelDeleteClient(p: any) {
    let index=this.produits.indexOf(p);
    this.produits.slice(index,1);
  }

  DeleteProduit(id: any) {
    return this.produitService.DeleteProduit(id).subscribe(data=>{this.loadProuit()});
  }

  private loadProuit() {
    this.produitService.getAllProducts().subscribe(data=>this.produits=data),
      (err:any)=>console.log(err);
    this.produitService.getAllCategories().subscribe(data=>this.categorieProduit=data),
      (err:any)=>console.log(err);
    this.produitService.getNewProduits().subscribe(data=>this.newproduits=data),(err:any)=>console.log(err);
    this.produitService.getNewFournisseur().subscribe(data=>this.newfournisseur=data),(err:any)=>console.log(err);
  }
}

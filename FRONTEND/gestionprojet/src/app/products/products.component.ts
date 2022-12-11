import {Component} from '@angular/core';
import {Produit} from "../model/produit.model";
import {ProduitService} from "../services/produit.service";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent {
  produits!: Array<Produit>;
  constructor(private produitService:ProduitService) {  }
  ngOnInit() : void {
    this.produitService.getAllProducts().subscribe(data=>this.produits=data),
      (err:any)=>console.log(err)
  }

  HandelDeleteClient(p: any) {
    let index=this.produits.indexOf(p);
    this.produits.slice(index,1);
  }

}

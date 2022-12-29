import {Component, OnInit} from '@angular/core';
import {Produit} from "../../model/produit.model";
import {CategorieProduit} from "../../model/categorieProduit";
import {Fournisseur} from "../../model/fournisseur";
import {FormGroup} from "@angular/forms";
import {ProduitService} from "../../services/produit.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-ajout-produit',
  templateUrl: './ajout-produit.component.html',
  styleUrls: ['./ajout-produit.component.css']
})
export class AjoutProduitComponent implements OnInit{
  newproduit: Produit = new Produit();
  categories! : Array<CategorieProduit>;
  fournisseurs! : Array<Fournisseur>;
  id_catg !:number;
  id_frs!:number;
  frs:Fournisseur = new Fournisseur();
  form: FormGroup | undefined;

  constructor(private produiservice:ProduitService,private route : Router) {}

  ngOnInit(){
    this.produiservice.getAllCategories().subscribe(data=>this.categories=data);
    this.produiservice.getAllFournisseur().subscribe(data=>this.fournisseurs=data);
  }

  ajoutProudit() {
    this.newproduit.categorie = new CategorieProduit();
    this.newproduit.fournisseur = new Fournisseur();
    this.newproduit.fournisseur.id=this.id_frs;
    this.newproduit.categorie.id=this.id_catg;
    this.newproduit.accountOpenedDate=new Date();
    this.produiservice.AddProduit(this.newproduit).subscribe(data=>this.route.navigate(['products']));
  }


  getValueFromSelectFournisseur(value: any) {
    this.id_frs=value;
  }
  getValueFromSelectCategorie(value: any) {
    this.id_catg=value;
    console.log(this.id_catg);
  }
}

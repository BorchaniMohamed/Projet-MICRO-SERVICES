import {Component} from '@angular/core';
import {Produit} from "../../model/produit.model";
import {ProduitService} from "../../services/produit.service";
import {ActivatedRoute, Router} from "@angular/router";
import {CategorieProduit} from "../../model/categorieProduit";
import {Fournisseur} from "../../model/fournisseur";

@Component({
  selector: 'app-edit-produit',
  templateUrl: './edit-produit.component.html',
  styleUrls: ['./edit-produit.component.css']
})
export class EditProduitComponent {
  produit:Produit=new Produit();
  id:any;
  idfrs!:number;
  idcteg!:number;
  categories!: Array<CategorieProduit>;
  fournisseurs!:Array<Fournisseur>;
  messagecategorie!: string;
  messageFournisseur!: string;
  constructor(private produiService : ProduitService,private route : ActivatedRoute,private router:Router) {
  }
  ngOnInit() {
    this.produiService.getAllFournisseur().subscribe(data=>this.fournisseurs=data),(err:any)=>console.log(err);
    this.produiService.getAllCategories().subscribe(data=>this.categories=data),(err:any)=>console.log(err);
    this.produit = new Produit();
    this.id=this.route.snapshot.params['_id'];
    this.produiService.GetProduit(this.id).subscribe(data=>this.produit=data),(err:any)=>console.log(err);
  }
  modifierProduit(){
    if(this.idfrs==undefined)
    {this.messageFournisseur="Choisir un fournisseur"}
    if(this.idcteg==undefined)
    {this.messagecategorie="Choisir une catégorie"}
    if(this.idfrs!=undefined && this.idcteg!=undefined)
    {this.produit.fournisseur=new Fournisseur();
      this.produit.categorie=new CategorieProduit();
      this.produit.fournisseur.id=this.idfrs;
      this.produit.categorie.id=this.idcteg;
      this.produiService.UpdateProduit(this.produit.id,this.produit).subscribe(data=>this.router.navigate(['products']));}

  }

  getValueFromSelectCategorie(value: any) {
    this.idcteg=value;
    this.messagecategorie="Fournisseur numéro"+value+" séléctionner"
  }

  getValueFromSelectFournisseur(value: any) {
    this.idfrs=value;
    this.messageFournisseur="Catégorie numéro "+value+" séléctionner"
  }

  resetaction() {
    this.messageFournisseur=""
    this.messagecategorie=""
  }
}

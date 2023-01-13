import {Component} from '@angular/core';
import {Produit} from "../model/produit.model";
import {ProduitService} from "../services/produit.service";
import {CategorieProduit} from "../model/categorieProduit";
import {Fournisseur} from "../model/fournisseur";
import {FactureService} from "../services/facture.service";

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
  fournisseurs !: Array<Fournisseur>;


  messageCategorie!: string;
  nomcategorie!: string;
  cat:CategorieProduit=new CategorieProduit();


  nomfournisseur!: string;
  frs:Fournisseur=new Fournisseur();
  messagefournisseur!:string;
  telfournisseur!:number;
  emailfournisseur!:string;

  nbfactureByproduct!:number;
  date=new Date();





  constructor(private produitService:ProduitService,private factureService:FactureService) {  }
  ngOnInit() : void {
   this.loadProuit();
  }


  supprimerProduit(id:any){return this.produitService.DeleteProduit(id).subscribe(data=>{this.loadProuit()});}

  DeleteProduit(id: any) {
    this.factureService.GetNombreFactureByProduit(id).subscribe(data=>{
      this.nbfactureByproduct=data;
      console.log("id produit : "+id+" nombre produit : "+data);
      if(data>0){window.alert("Vous ne pouvez pas supprimer se produit car il est rélié à "+data+" factures");}
      else{
        window.alert("produit supprimer");
        this.supprimerProduit(id);
      }
      //console.log(data);
    });
    //this.supprimerProduit(id);
  }

  private loadProuit() {
    this.produitService.getAllProducts().subscribe(data=>this.produits=data),
      (err:any)=>console.log(err);
    this.produitService.getAllCategories().subscribe(data=>this.categorieProduit=data),
      (err:any)=>console.log(err);
    this.produitService.getNewProduits().subscribe(data=>this.newproduits=data),(err:any)=>console.log(err);
    this.produitService.getNewFournisseur().subscribe(data=>this.newfournisseur=data),(err:any)=>console.log(err);
    this.produitService.getAllFournisseur().subscribe(data=>this.fournisseurs=data);
  }

  getFrs(p: Produit) {
    return p.fournisseur.nomfournissuer
  }


  ajoutCategorie() {
    if(this.nomcategorie==undefined||this.nomcategorie.length==0)
    {
      this.messageCategorie="remplir le champ"
    }
    else {
      console.log(this.nomcategorie);
      this.cat.stockItemCategoryName=this.nomcategorie;
      this.produitService.AddCategProduit(this.cat).subscribe();
      window.location.reload();
    }
  }

  ajoutFournisseur() {
    if(this.nomfournisseur==undefined||this.nomfournisseur.length==0)
    {
      this.messagefournisseur="remplir le champ nom fournisseur";
      console.log(this.nomfournisseur);
    }
    else{
      console.log(this.nomfournisseur,this.emailfournisseur,this.telfournisseur);
      this.frs.nomfournissuer=this.nomfournisseur;
      this.frs.telephone=this.telfournisseur;
      this.frs.email=this.emailfournisseur;
      this.frs.accountOpenedDate=new Date();
      this.produitService.AddFournisseur(this.frs).subscribe();
      window.location.reload();
    }
  }
}

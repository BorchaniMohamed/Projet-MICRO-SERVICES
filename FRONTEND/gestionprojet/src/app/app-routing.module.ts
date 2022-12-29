import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ProductsComponent} from "./products/products.component";
import {CustomersComponent} from "./customers/customers.component";
import {FacturesComponent} from "./factures/factures.component";
import {TransactionsComponent} from "./transactions/transactions.component";
import {MenuComponent} from "./base/menu/menu.component";
import {SlidebarComponent} from "./base/slidebar/slidebar.component";
import {HomepageComponent} from "./base/homepage/homepage.component";
import {StatistiqueComponent} from "./statistique/statistique.component";
import {AjoutClientComponent} from "./customers/ajout-client/ajout-client.component";
import {EditClientComponent} from "./customers/edit-client/edit-client.component";
import {AjoutProduitComponent} from "./products/ajout-produit/ajout-produit.component";
import {EditProduitComponent} from "./products/edit-produit/edit-produit.component";
import {AjoutFactureComponent} from "./factures/ajout-facture/ajout-facture.component";
import {EditFactureComponent} from "./factures/edit-facture/edit-facture.component";
import {AjoutTransactionComponent} from "./transactions/ajout-transaction/ajout-transaction.component";
import {EditTransactionComponent} from "./transactions/edit-transaction/edit-transaction.component";

const routes: Routes = [
  {path:"products",component:ProductsComponent},
  {path:"customers",component:CustomersComponent},
  {path:"factures",component:FacturesComponent},
  {path:"transactions",component:TransactionsComponent},
  {path:"menu",component:MenuComponent},
  {path:"slidebar",component:SlidebarComponent},
  {path:"homepage",component:HomepageComponent},
  {path:"",component:StatistiqueComponent},
  {path:"statistique",component:StatistiqueComponent},
  {path:"ajoutclient",component:AjoutClientComponent},
  {path:"editclient/:_id",component:EditClientComponent},
  {path:"ajoutproduit",component:AjoutProduitComponent},
  {path:"editproduit/:_id",component:EditProduitComponent},
  {path:"ajoutfacture",component:AjoutFactureComponent},
  {path:"edit-facture/:_id",component:EditFactureComponent},
  {path:"ajouttransaction",component:AjoutTransactionComponent},
  {path:"edit-transaction/:_id",component:EditTransactionComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

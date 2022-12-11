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
  {path:"ajoutclient",component:AjoutClientComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

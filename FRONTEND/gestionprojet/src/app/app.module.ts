import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {ProductsComponent} from './products/products.component';
import {CustomersComponent} from './customers/customers.component';
import {TransactionsComponent} from './transactions/transactions.component';
import {FacturesComponent} from './factures/factures.component';
import {MenuComponent} from './base/menu/menu.component';
import {SlidebarComponent} from './base/slidebar/slidebar.component';
import {HomepageComponent} from './base/devise/homepage.component';
import {StatistiqueComponent} from './statistique/statistique.component';
import {HttpClientModule} from "@angular/common/http";
import {AjoutClientComponent} from './customers/ajout-client/ajout-client.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {EditClientComponent} from './customers/edit-client/edit-client.component';
import {AjoutProduitComponent} from './products/ajout-produit/ajout-produit.component';
import {EditProduitComponent} from './products/edit-produit/edit-produit.component';
import {AjoutFactureComponent} from "./factures/ajout-facture/ajout-facture.component";
import {EditFactureComponent} from "./factures/edit-facture/edit-facture.component";
import {AjoutTransactionComponent} from './transactions/ajout-transaction/ajout-transaction.component';
import {EditTransactionComponent} from './transactions/edit-transaction/edit-transaction.component';

@NgModule({
  declarations: [
    AppComponent,
    ProductsComponent,
    CustomersComponent,
    TransactionsComponent,
    FacturesComponent,
    MenuComponent,
    SlidebarComponent,
    HomepageComponent,
    StatistiqueComponent,
    AjoutClientComponent,
    EditClientComponent,
    AjoutProduitComponent,
    EditProduitComponent,
    AjoutFactureComponent,
    EditFactureComponent,
    AjoutTransactionComponent,
    EditTransactionComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

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
import {HomepageComponent} from './base/homepage/homepage.component';
import {StatistiqueComponent} from './statistique/statistique.component';
import {HttpClientModule} from "@angular/common/http";
import {AjoutClientComponent} from './customers/ajout-client/ajout-client.component';

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
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

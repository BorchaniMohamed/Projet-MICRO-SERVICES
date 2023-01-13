import {Component, OnInit} from '@angular/core';
import {DeviseService} from "../../services/devise.service";
import {Devise} from "../../model/Devise";


@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements  OnInit{
  // euro="EUR";
  // dollar="USD";
  // suisse="CHF";
  // pound="GBP";
  // KSA="SAR";
  // UAE="AED";
  amount="1"
  euro!:any;
  dollar:any;
  suisse:any;
  pound:any;
  KSA:any;
  UAE:any;
  deiseEuro1:Devise = new Devise();
  deiseEuro2:Devise = new Devise();
  deiseEuro3:Devise = new Devise();
  deiseEuro4:Devise = new Devise();
  deiseEuro5:Devise = new Devise();
  deiseEuro6:Devise = new Devise();

  constructor(private deviseService:DeviseService) {
  }
  ngOnInit() : void {
    this.loadDevise();
  }

  private loadDevise() {
  //      this.deviseService.Getmontant("EUR",this.amount).subscribe(data=>{
  //        this.deiseEuro1=data;
  //        this.euro=this.deiseEuro1.result
  //      })
  //   this.deviseService.Getmontant("USD",this.amount).subscribe(data=>{
  //     this.deiseEuro2=data;
  //     this.dollar=this.deiseEuro2.result
  //   })
  //   this.deviseService.Getmontant("CHF",this.amount).subscribe(data=>{
  //     this.deiseEuro3=data;
  //     this.suisse=this.deiseEuro3.result
  //   })
  //   this.deviseService.Getmontant("GBP",this.amount).subscribe(data=>{
  //     this.deiseEuro4=data;
  //     this.pound=this.deiseEuro4.result
  //   })
  //   this.deviseService.Getmontant("SAR",this.amount).subscribe(data=>{
  //     this.deiseEuro5=data;
  //     this.KSA=this.deiseEuro5.result
  //   })
  //   this.deviseService.Getmontant("AED",this.amount).subscribe(data=>{
  //     this.deiseEuro6=data;
  //     this.UAE=this.deiseEuro6.result
  //   })
  }
}


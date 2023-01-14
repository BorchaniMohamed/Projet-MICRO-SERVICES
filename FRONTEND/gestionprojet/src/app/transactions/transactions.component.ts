import {Component, OnInit} from '@angular/core';
import {Transaction} from "../model/transaction.model";
import {TransactionService} from "../services/transaction.service";

@Component({
  selector: 'app-transactions',
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.css']
})
export class TransactionsComponent implements OnInit{

  transactions!:Array<Transaction>;
  date= new Date;
  constructor(private transactionService:TransactionService) {}
  ngOnInit() {
    this.loadTransaction();
  }

  private loadTransaction() {
    this.transactionService.getAllTransaction().subscribe(data=>this.transactions=data),
      (err:any)=>console.log(err);
  }
}

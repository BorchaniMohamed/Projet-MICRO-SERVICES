export class Info {
  rate!:number;
  timestamp!:number;

}


export class requete {
  amount!:number;
  from!:string;
  to!:string;

}

export class Devise{
  date!:Date;
  info!:Info;
  query!:requete;
  result!:number;
  success!:boolean;




}
// {
//   "date": "2023-01-06",
//   "info": {
//   "rate": 0.300605,
//     "timestamp": 1673037963
// },
//   "query": {
//   "amount": 2,
//     "from": "TND",
//     "to": "EUR"
// },
//   "result": 0.60121,
//   "success": true
// }

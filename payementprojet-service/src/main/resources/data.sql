INSERT INTO Customer (name,city) values ('Ali','Sfax');
INSERT INTO Customer (name,city) values ('Ahmed','Paris');
INSERT INTO Invoice (states,customer_id) values ('created',1);
INSERT INTO Invoice (states,customer_id) values ('created',2);
INSERT INTO Transaction(methode,invoice_id, customer_id) values ('banque',1,1);
INSERT INTO Transaction(methode,invoice_id, customer_id) values ('mondat',1,2);




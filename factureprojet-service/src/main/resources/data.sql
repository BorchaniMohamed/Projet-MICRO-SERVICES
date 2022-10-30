-- INSERT INTO Stock_Item (name,prix,qte) values ('hp',12,100);
-- INSERT INTO Stock_Item (name,prix,qte) values ('lg',34,245);
-- INSERT INTO Stock_Item (name,prix,qte) values ('lenovo',77,300);
-- INSERT INTO Customer (name,city) values ('Ali','Sfax');
-- INSERT INTO Customer (name,city) values ('Ahmed','Paris');
INSERT INTO Invoice (states,customer_id) values ('created',1);
INSERT INTO Invoice (states,customer_id) values ('paid',2);
INSERT INTO invoice_line(invoice_id, stock_item_id,qte) values (1,1,123);
INSERT INTO invoice_line(invoice_id, stock_item_id,qte) values (2,2,99);




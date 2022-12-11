INSERT INTO Adresse (Gouvernorat,Delegation,codepostale) values ('SFAX','Agareb',3030);
INSERT INTO Adresse (Gouvernorat,Delegation,codepostale) values ('SFAX','El Amra',3036);
INSERT INTO Adresse (Gouvernorat,Delegation,codepostale) values ('SFAX','Kerkenah',3070);
INSERT INTO Adresse (Gouvernorat,Delegation,codepostale) values ('SFAX','Sakiet Eddaïer',3011);
INSERT INTO Adresse (Gouvernorat,Delegation,codepostale) values ('SFAX','Sfax Ouest',3052);
INSERT INTO Adresse (Gouvernorat,Delegation,codepostale) values ('SFAX','Bir Ali Ben Khélifa',3040);
INSERT INTO Adresse (Gouvernorat,Delegation,codepostale) values ('SFAX','El Hencha',3010);
INSERT INTO Adresse (Gouvernorat,Delegation,codepostale) values ('SFAX','Mahres',3060);
INSERT INTO Adresse (Gouvernorat,Delegation,codepostale) values ('SFAX','Sakiet Ezzit',3021);
INSERT INTO Adresse (Gouvernorat,Delegation) values ('SFAX','Sfax Sud');
INSERT INTO Adresse (Gouvernorat,Delegation,codepostale) values ('SFAX','Djebeniana',3080);
INSERT INTO Adresse (Gouvernorat,Delegation,codepostale) values ('SFAX','Ghraiba',3024);
INSERT INTO Adresse (Gouvernorat,Delegation,codepostale) values ('SFAX','Menzel Chaker',3020);
INSERT INTO Adresse (Gouvernorat,Delegation,codepostale) values ('SFAX','Sfax Médina',3000);
INSERT INTO Adresse (Gouvernorat,Delegation,codepostale) values ('SFAX','Skhira',3050);
INSERT INTO Adresse (Gouvernorat,Delegation,codepostale) values ('SFAX','Tyna',3083);


INSERT INTO customercategory(name) values('particulier');
INSERT INTO customercategory(name) values('entreprise');

INSERT INTO todocustomer(actiontodo) values ( 'appeller client Ali code 1');
INSERT INTO todocustomer(actiontodo) values ( 'appeller client med code 2');
INSERT INTO todocustomer(actiontodo) values ( 'envoyer facture client ahmed code 3');

INSERT INTO Customer (name,phone,mail,customer_category_id,adresse_id,todocustomer_id) values ('Ali',22661936,'ali@yahoo.fr',1,1,1);
INSERT INTO Customer (name,phone,mail,customer_category_id,adresse_id,todocustomer_id) values ('med',44556677,'med@yahoo.fr',2,2,2);
INSERT INTO Customer (name,phone,mail,customer_category_id,adresse_id,todocustomer_id) values ('ahmed',71234566,'ahmed@yahoo.fr',2,3,3);





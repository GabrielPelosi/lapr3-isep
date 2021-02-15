    --Limpa a consola
clear screen;

Insert into LOCAL(name)
VALUES('Trindade');
Insert into LOCAL(name)
VALUES('Castelo do Queijo');
Insert into LOCAL(name)
VALUES('Clérigos');
Insert into LOCAL(name)
VALUES('Majestic');
Insert into LOCAL(name)
VALUES('Bolhão');
Insert into LOCAL(name)
VALUES('Sé');
Insert into LOCAL(name)
VALUES('Cais da Ribeira');

Insert into ADDRESS(lati, longi, alti, localname, windSpeed, windDirection)
VALUES(41.15227, -8.60929, 104, 'Trindade', 100, 1);
Insert into ADDRESS(lati, longi, alti, localname, windSpeed, windDirection)
VALUES(41.16875, -8.68995, 4, 'Castelo do Queijo', 100, 1);
Insert into ADDRESS(lati, longi, alti, localname, windSpeed, windDirection)
VALUES(41.14582, -8.61398, 87, 'Clérigos', 100, 1);
Insert into ADDRESS(lati, longi, alti, localname, windSpeed, windDirection)
VALUES(41.14723, -8.60657, 91, 'Majestic', 100, 1);
Insert into ADDRESS(lati, longi, alti, localname, windSpeed, windDirection)
VALUES(41.14871, -8.60746, 87, 'Bolhão', 100, 1);
Insert into ADDRESS(lati, longi, alti, localname, windSpeed, windDirection)
VALUES(41.14331, -8.60914, 82, 'Sé', 100, 1);
Insert into ADDRESS(lati, longi, alti, localname, windSpeed, windDirection)
VALUES(41.14063, -8.61118, 25, 'Cais da Ribeira', 100, 1);

Insert into PHARMACY(lati, longi)
VALUES(41.15227, -8.60929);
Insert into PHARMACY(lati, longi)
VALUES(41.16875, -8.68995);

Insert into PARK_TYPE(description)
VALUES('Scooter Park');
Insert into PARK_TYPE(description)
VALUES('Drone Park');

Insert into PARK(max_charging_cap, max_parking_cap, id_park_type, id_pharmacy)
VALUES(50, 50, 1, 1);
Insert into PARK(max_charging_cap, max_parking_cap, id_park_type, id_pharmacy)
VALUES(50, 50, 2, 1);
Insert into PARK(max_charging_cap, max_parking_cap, id_park_type, id_pharmacy)
VALUES(50, 50, 1, 2);
Insert into PARK(max_charging_cap, max_parking_cap, id_park_type, id_pharmacy)
VALUES(50, 50, 2, 2);

Insert into VEHICLE_TYPE(description)
VALUES('Scooter');
Insert into VEHICLE_TYPE(description)
VALUES('Drone');

Insert into VEHICLE_STATE(description)
VALUES('Parked');
Insert into VEHICLE_STATE(description)
VALUES('Charging');
Insert into VEHICLE_STATE(description)
VALUES('In use');

Insert into VEHICLE(id_pharmacy, id_vehicle_type, id_vehicle_state, frontalarea, aerodinamic, maxcapacity, charge, weight)
VALUES(1, 1, 2, 0.3, 2.08, 1.5, 100, 15);
Insert into VEHICLE(id_pharmacy, id_vehicle_type, id_vehicle_state, frontalarea, aerodinamic, maxcapacity, charge, weight)
VALUES(1, 2, 1, 0.2, 1.13, 1.5, 100, 1.5);
Insert into VEHICLE(id_pharmacy, id_vehicle_type, id_vehicle_state, frontalarea, aerodinamic, maxcapacity, charge, weight)
VALUES(2, 1, 1, 1.8, 1.13, 1.5, 100, 15);
Insert into VEHICLE(id_pharmacy, id_vehicle_type, id_vehicle_state, frontalarea, aerodinamic, maxcapacity, charge, weight)
VALUES(2, 2, 2, 0.2, 1.13, 1.5, 100, 1);

Insert Into PRODUCT(DESCRIPTION, PRICE, WEIGHT)
VALUES('Ben-U-Ron, 1000 mg x 18 comp',2.79,0.120);
Insert Into PRODUCT(DESCRIPTION, PRICE, WEIGHT)
VALUES('Brufen, 600 mg x 60 comp revest',6.18,0.089);
Insert Into PRODUCT(DESCRIPTION, PRICE, WEIGHT)
VALUES('Reumon Gel',11.30,0.100);
Insert Into PRODUCT(DESCRIPTION, PRICE, WEIGHT)
VALUES('Ben-U-Ron, 500 mg x 18 comp',2.79,0.120);
Insert Into PRODUCT(DESCRIPTION, PRICE, WEIGHT)
VALUES('Brufen, 300 mg x 60 comp revest',6.18,0.089);
Insert Into PRODUCT(DESCRIPTION, PRICE, WEIGHT)
VALUES('Reuman Gel',11.30,0.100);

Insert into STOCK(id_pharmacy, id_product, stock)
VALUES(1, 1, 100);
Insert into STOCK(id_pharmacy, id_product, stock)
VALUES(1, 2, 100);
Insert into STOCK(id_pharmacy, id_product, stock)
VALUES(1, 3, 100);
Insert into STOCK(id_pharmacy, id_product, stock)
VALUES(1, 4, 100);
Insert into STOCK(id_pharmacy, id_product, stock)
VALUES(1, 5, 100);
Insert into STOCK(id_pharmacy, id_product, stock)
VALUES(1, 6, 100);
Insert into STOCK(id_pharmacy, id_product, stock)
VALUES(2, 1, 100);
Insert into STOCK(id_pharmacy, id_product, stock)
VALUES(2, 2, 100);
Insert into STOCK(id_pharmacy, id_product, stock)
VALUES(2, 3, 100);
Insert into STOCK(id_pharmacy, id_product, stock)
VALUES(2, 4, 100);
Insert into STOCK(id_pharmacy, id_product, stock)
VALUES(2, 5, 100);
Insert into STOCK(id_pharmacy, id_product, stock)
VALUES(2, 6, 100);

Insert into USERROLE(DESCRIPTION)
VALUES('Administrator');
Insert into USERROLE(DESCRIPTION)
VALUES('Courier');
Insert into USERROLE(DESCRIPTION)
VALUES('Customer');
Insert into USERROLE(DESCRIPTION)
VALUES('Super Administrator');

INSERT INTO PHUSER ( ID_ROLE,EMAIL,USERNAME,PASSWD)
VALUES(1,'admin@gmail.com','admin','admin');
INSERT INTO PHUSER ( ID_ROLE,EMAIL,USERNAME,PASSWD)
VALUES(1,'josealberto99@gmail.com','JoseAlberto','ab98awf4');
INSERT INTO PHUSER ( ID_ROLE,EMAIL,USERNAME,PASSWD)
VALUES(1,'lauramarisia75@gmail.com','LauraMaria','paulinho');
INSERT INTO PHUSER ( ID_ROLE,EMAIL,USERNAME,PASSWD)
VALUES(1,'fernandinho778@gmail.com','FernandoJose','asc153assd');
INSERT INTO PHUSER ( ID_ROLE,EMAIL,USERNAME,PASSWD)
VALUES(1,'tasmalafredo@gmail.com','AlfrrdoTams','sds56kmka');
INSERT INTO PHUSER ( ID_ROLE,EMAIL,USERNAME,PASSWD)
VALUES(1,'jhuinhirshima@gmail.com','Jhuin','651sa561sa');
INSERT INTO PHUSER ( ID_ROLE,EMAIL,USERNAME,PASSWD)
VALUES(1,'mayyabab@gmail.com','Mayan','651sa561sa');
INSERT INTO PHUSER ( ID_ROLE,EMAIL,USERNAME,PASSWD)
VALUES(2,'courier@gmail.com','courier','courier');
INSERT INTO PHUSER ( ID_ROLE,EMAIL,USERNAME,PASSWD)
VALUES(2,'courier1@gmail.com','courier1','courier1');
INSERT INTO PHUSER ( ID_ROLE,EMAIL,USERNAME,PASSWD)
VALUES(2,'courier2@gmail.com','courier2','courier2');
INSERT INTO PHUSER ( ID_ROLE,EMAIL,USERNAME,PASSWD)
VALUES(2,'courier3@gmail.com','courier3','courier3');
INSERT INTO PHUSER ( ID_ROLE,EMAIL,USERNAME,PASSWD)
VALUES(2,'courier4@gmail.com','courier4','courier4');
INSERT INTO PHUSER ( ID_ROLE,EMAIL,USERNAME,PASSWD)
VALUES(2,'courier5@gmail.com','courier5','courier5');
INSERT INTO PHUSER ( ID_ROLE,EMAIL,USERNAME,PASSWD)
VALUES(2,'courier6@gmail.com','courier6','courier6');
INSERT INTO PHUSER ( ID_ROLE,EMAIL,USERNAME,PASSWD)
VALUES(2,'courier7@gmail.com','courier7','courier7');
INSERT INTO PHUSER ( ID_ROLE,EMAIL,USERNAME,PASSWD)
VALUES(2,'courier8@gmail.com','courier8','courier8');
INSERT INTO PHUSER ( ID_ROLE,EMAIL,USERNAME,PASSWD)
VALUES(2,'courier9@gmail.com','courier9','courier9');
INSERT INTO PHUSER ( ID_ROLE,EMAIL,USERNAME,PASSWD)
VALUES(3,'customer@gmail.com','customer','customer');
INSERT INTO PHUSER ( ID_ROLE,EMAIL,USERNAME,PASSWD)
VALUES(3,'customer1@gmail.com','customer1','customer1');
INSERT INTO PHUSER ( ID_ROLE,EMAIL,USERNAME,PASSWD)
VALUES(4,'superadmin@gmail.com','superadmin','superadmin');

INSERT INTO ADMINISTRATOR( ID_ADMINISTRATOR, ID_PHARMACY)
VALUES (3,2);
INSERT INTO ADMINISTRATOR(ID_ADMINISTRATOR, ID_PHARMACY)
VALUES (6,1);

INSERT INTO COURIER(ID_COURIER,ID_PHARMACY)
VALUES(1,1);
INSERT INTO COURIER(ID_COURIER,ID_PHARMACY)
VALUES(2,1);
INSERT INTO COURIER(ID_COURIER,ID_PHARMACY)
VALUES(3,2);
INSERT INTO COURIER(ID_COURIER,ID_PHARMACY)
VALUES(4,2);
INSERT INTO COURIER(ID_COURIER,ID_PHARMACY)
VALUES(5,2);

INSERT INTO CUSTOMER(ID_CUSTOMER,LATI,LONGI,CREDITS,NIF)
VALUES(1,41.14582, -8.61398,10,123456789);
INSERT INTO CUSTOMER(ID_CUSTOMER,LATI,LONGI,CREDITS,NIF)
VALUES(2,41.14723, -8.60657,50,987654321);
INSERT INTO CUSTOMER(ID_CUSTOMER,LATI,LONGI,CREDITS,NIF)
VALUES(3,41.14871, -8.60746,0,456789123);
INSERT INTO CUSTOMER(ID_CUSTOMER,LATI,LONGI,CREDITS,NIF)
VALUES(4,41.14331, -8.60914,30,951847623);
INSERT INTO CUSTOMER(ID_CUSTOMER,LATI,LONGI,CREDITS,NIF)
VALUES(5,41.14063, -8.61118,10,951857623);

INSERT INTO STATUS(DESCRIPTION)
VALUES('OPEN');
INSERT INTO STATUS(DESCRIPTION)
VALUES('RUNNING');
INSERT INTO STATUS(DESCRIPTION)
VALUES('CLOSE');

INSERT INTO DELIVERY_RUN (id_status,id_vehicle,weight, id_pharmacy)
VALUES(2,1,0,1);
INSERT INTO DELIVERY_RUN (id_status,id_vehicle,weight, id_pharmacy)
VALUES(2,2,0,1);
INSERT INTO DELIVERY_RUN (id_status,id_vehicle,weight, id_pharmacy)
VALUES(2,3,0,2);
INSERT INTO DELIVERY_RUN (id_status,id_vehicle,weight, id_pharmacy)
VALUES(1,4,0,2);

INSERT INTO DRONE_RUN(ID_DELIVERY_RUN)
VALUES(1);
INSERT INTO DRONE_RUN(ID_DELIVERY_RUN)
VALUES(2);

INSERT INTO SCOOTER_RUN(ID_DELIVERY_RUN,ID_COURIER)
VALUES(3,1);
INSERT INTO SCOOTER_RUN(ID_DELIVERY_RUN,ID_COURIER)
VALUES(4,3);


INSERT INTO USERORDER(ID_PHARMACY,ID_CUSTOMER,ID_DELIVERY_RUN,weight)
VALUES(1,1,1,10);
INSERT INTO USERORDER(ID_PHARMACY,ID_CUSTOMER,ID_DELIVERY_RUN,weight)
VALUES(2,2,null,10);
INSERT INTO USERORDER(ID_PHARMACY,ID_CUSTOMER,ID_DELIVERY_RUN,weight)
VALUES(2,2,3,10);

INSERT INTO INVOICE(ID_USERORDER,TOTAL)
VALUES(1,12);
INSERT INTO INVOICE(ID_USERORDER,TOTAL)
VALUES(2,2);
INSERT INTO INVOICE(ID_USERORDER,TOTAL)
VALUES(3,14);

INSERT INTO SHOP_BAG(ID_USERORDER,ID_PRODUCT,QTD)
VALUES(1,1,10);
INSERT INTO SHOP_BAG(ID_USERORDER,ID_PRODUCT,QTD)
VALUES(2,3,7);
INSERT INTO SHOP_BAG(ID_USERORDER,ID_PRODUCT,QTD)
VALUES(3,2,1);

--Limpa a consola
clear screen;
--=======================DROPS TABLES============================
DROP TABLE LOCAL CASCADE CONSTRAINTS ;
DROP TABLE CONNECTIONS CASCADE CONSTRAINTS ;
DROP TABLE ADDRESS CASCADE CONSTRAINTS ;
DROP TABLE PARK_TYPE  CASCADE CONSTRAINTS;
DROP TABLE PARK CASCADE CONSTRAINTS ;
DROP TABLE PHARMACY CASCADE CONSTRAINTS;
DROP TABLE VEHICLE_TYPE CASCADE CONSTRAINTS;
DROP TABLE VEHICLE_STATE CASCADE CONSTRAINTS;
DROP TABLE VEHICLE CASCADE CONSTRAINTS;
DROP TABLE PRODUCT CASCADE CONSTRAINTS;
DROP TABLE STOCK CASCADE CONSTRAINTS;
DROP TABLE USERROLE CASCADE CONSTRAINTS;
DROP TABLE PHUSER CASCADE CONSTRAINTS;
DROP TABLE CUSTOMER CASCADE CONSTRAINTS;
DROP TABLE ADMINISTRATOR CASCADE CONSTRAINTS;
DROP TABLE COURIER CASCADE CONSTRAINTS;
DROP TABLE STATUS CASCADE CONSTRAINTS;
DROP TABLE INVOICE CASCADE CONSTRAINTS;
DROP TABLE NOTIFICATION CASCADE CONSTRAINTS;
DROP TABLE DELIVERY_RUN CASCADE CONSTRAINTS;
DROP TABLE DRONE_RUN CASCADE CONSTRAINTS;
DROP TABLE SCOOTER_RUN CASCADE CONSTRAINTS;
DROP TABLE USERORDER CASCADE CONSTRAINTS;
DROP TABLE BACKORDER CASCADE CONSTRAINTS;
DROP TABLE SHOP_BAG CASCADE CONSTRAINTS;
--========================CREATE TABLES===================
CREATE TABLE LOCAL (
name varchar(250)                           CONSTRAINT nn_LOCAL_name                                                     NOT NULL
);

CREATE TABLE CONNECTIONS (
local1 varchar(250)                           CONSTRAINT nn_LOCAL_name1                                                     NOT NULL,
local2 varchar(250)                           CONSTRAINT nn_LOCAL_name2                                                    NOT NULL
);

CREATE TABLE ADDRESS (
lati float                                     CONSTRAINT nn_ADDRESSS_lati                                                           NOT NULL,
longi float                                    CONSTRAINT nn_ADDRESSS_longi                                                        NOT NULL,
alti float                                    CONSTRAINT nn_ADDRESSS_alti                                                        NOT NULL,
localname varchar(250)                           CONSTRAINT nn_ADDRESSS_localname                                                      NOT NULL,
windSpeed float                             CONSTRAINT nn_ADDRESS_windSpeed                                        NOT NULL,
windDirection CHAR(1)                             CONSTRAINT nn_ADDRESS_windDirection                              NOT NULL
);

CREATE TABLE PHARMACY (
id_pharmacy integer                            GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) 
                                               CONSTRAINT  PK_PHARMACY PRIMARY KEY                                                           NOT NULL, 
lati float                             CONSTRAINT nn_pharmacy_lati                                                                     NOT NULL,
longi float                             CONSTRAINT nn_pharmacy_longi                                                                   NOT NULL
);

CREATE TABLE PARK_TYPE (
id_park_type integer                    GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) 
                                                 CONSTRAINT  PK_PARK_TYPE_id_park_type  PRIMARY KEY                                            NOT NULL, 
description varchar(250)                         CONSTRAINT nn_PARK_TYPE_description                                                 NOT NULL
);

CREATE TABLE PARK ( 
id_park integer                         GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) 
                                               CONSTRAINT  PK_PARK_id_scooterpark PRIMARY KEY                           NOT NULL,  
max_charging_cap integer                          CONSTRAINT nn_PARK_max_charging_cap                                                                    NOT NULL
                                               CONSTRAINT ck_PARK_max_charging_cap                                                           CHECK (max_charging_cap > 0),
max_parking_cap integer                           CONSTRAINT nn_PARK_max_parking_cap                                                                        NOT NULL    
                                               CONSTRAINT ck_PARK_max_parking_cap                                                          CHECK (max_parking_cap  > 0),
id_park_type integer                                    CONSTRAINT nn_park_id_park_type                                                    NOT NULL,
id_pharmacy integer                               CONSTRAINT nn_park_id_pharmacy                                                      NOT NULL
);

CREATE TABLE VEHICLE_TYPE (
id_vehicle_type integer                    GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) 
                                                 CONSTRAINT  PK_VEHICLE_TYPE_id_vehicle_type  PRIMARY KEY                         NOT NULL, 
description varchar(250)                         CONSTRAINT nn_VEHICLE_TYPE__description                       NOT NULL
);

CREATE TABLE VEHICLE_STATE (
id_vehicle_state integer                    GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) 
                                                 CONSTRAINT  PK_VEHICLE_STATE_id_vehicle_state PRIMARY KEY                                            NOT NULL, 
description varchar(250)                         CONSTRAINT nn_VEHICLE_STATE_description                                                 NOT NULL
);

CREATE TABLE VEHICLE(
id_vehicle integer                               GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) 
                                                 CONSTRAINT  PK_VEHICLE PRIMARY KEY                                 NOT NULL,
id_pharmacy integer                              CONSTRAINT  nn_vehicle_id_pharmacy                                       NOT NULL,
id_vehicle_type  integer                                CONSTRAINT  nn_vehicle_id_vehicle_type                                      NOT NULL,
id_vehicle_state integer                          CONSTRAINT  nn_vehicle_id_vehicle_state                                   NOT NULL,
frontalarea integer                               CONSTRAINT  nn_vehicle_frontalarea                                      NOT NULL,
aerodinamic double precision                                 CONSTRAINT  nn_vehicle_aerodinamic                                      NOT NULL,
maxcapacity double precision                               CONSTRAINT  nn_vehicle_maxcapacity                                       NOT NULL,
charge double precision                                       CONSTRAINT  nn_vehicle_charge                                    NOT NULL,
weight double precision                                       CONSTRAINT  nn_vehicle_weight                                      NOT NULL
);

CREATE TABLE PRODUCT (
id_product integer                             GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) 
                                               CONSTRAINT PK_product_id_product PRIMARY KEY                     NOT NULL, 
description varchar(250)                       CONSTRAINT nn_product_description                                                 NOT NULL, 
price NUMERIC(10,2)                            CONSTRAINT nn_product_price                                                            NOT NULL
                                               CONSTRAINT ck_product_price                                                            CHECK (price > 0),
weight NUMERIC(10,2)                           CONSTRAINT nn_product_weight                                                      NOT NULL
                                               CONSTRAINT ck_product_weight                                                            CHECK (weight > 0)   
);

CREATE TABLE STOCK (
id_pharmacy integer                            CONSTRAINT nn_stock_id_pharmacy                 NOT NULL, 
id_product integer                             CONSTRAINT nn_stock_id_product                  NOT NULL, 
stock integer                                  CONSTRAINT nn_stock_stock                       NOT NULL
);

CREATE TABLE USERROLE(
id_role integer                                  GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) 
                                                 CONSTRAINT  PK_USERROLE PRIMARY KEY                           NOT NULL, 
description varchar(250)                         CONSTRAINT nn_userrole_description                                                        NOT NULL
);

CREATE TABLE PHUSER(
id_user integer                                GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) 
                                               CONSTRAINT PK_PhUser_id_user PRIMARY KEY ,
id_role integer                                CONSTRAINT nn_PhUser_id_role                                                                   NOT NULL,
email varchar(250)                             CONSTRAINT ck_PhUser_email                                 CHECK(REGEXP_LIKE(email, '^\w+(\.\w+)*+@\w+(\.\w+)+$' ))
                                               CONSTRAINT uk_PhUser_email                                UNIQUE,
username varchar(250)                          CONSTRAINT nn_PhUser_username                                                               NOT NULL,
passwd varchar(250)                            CONSTRAINT nn_PhUser_passwd                                                                   NOT NULL
);

CREATE TABLE CUSTOMER (
id_customer integer                                 CONSTRAINT nn_custome_id_user                           NOT NULL,
lati float                                     CONSTRAINT nn_CUSTOMER_lati                                                           NOT NULL,
longi float                                    CONSTRAINT nn_CUSTOMER_longi                                                        NOT NULL,
credits integer                                 CONSTRAINT nn_customer_credits                                                                    NOT NULL, 
nif    integer                                  CONSTRAINT nn_customer_nif                                                                          NOT NULL 
                                                CHECK(REGEXP_LIKE(nif , '^\d{9}$'))    
);

CREATE TABLE ADMINISTRATOR (
id_administrator integer                                 CONSTRAINT nn_ADMINISTRATOR_id_administrator                          NOT NULL,
id_pharmacy integer                             CONSTRAINT nn_ADMINISTRATOR_id_pharmacy                           NOT NULL
);

CREATE TABLE COURIER (
id_courier integer                                 CONSTRAINT nn_courier_id_courier   NOT NULL,
id_pharmacy integer                             CONSTRAINT nn_courier_id_pharmacy   NOT NULL
);

CREATE TABLE NOTIFICATION (
id_notification integer                    GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) 
                                                 CONSTRAINT  PK_NOTIFICATION_id_notification  PRIMARY KEY                     NOT NULL, 
id_customer integer                                CONSTRAINT nn_NOTIFICATION_id_costumer                		                 NOT NULL,
description varchar(250)                         CONSTRAINT nn_NOTIFICATION_id_description      	                     NOT NULL
);

CREATE TABLE STATUS (
id_status integer                    GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) 
                                                 CONSTRAINT  PK_STATUS  PRIMARY KEY                                            NOT NULL, 
description varchar(250)                         CONSTRAINT nn_STATUS_description                                                                      NOT NULL
);

CREATE TABLE DELIVERY_RUN (
id_delivery_run integer                           GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) 
                                                  CONSTRAINT  PK_DELIVERY_RUN  PRIMARY KEY                               NOT NULL, 
id_status integer     			                 CONSTRAINT nn_delivery_run_id_status                      NOT NULL,
id_vehicle integer                                 CONSTRAINT nn_delivery_run_id_vehicle                    NOT NULL,
weight integer 					 			   	 CONSTRAINT nn_delivery_run_weight                  NOT NULL,
id_pharmacy integer                               CONSTRAINT nn_delivery_run_id_pharmacy              NOT NULL
);

CREATE TABLE DRONE_RUN (
id_delivery_run integer                                CONSTRAINT nn_DRONE_RUN_id_delivery_run                  NOT NULL

);

CREATE TABLE SCOOTER_RUN (
id_delivery_run integer                                CONSTRAINT nn_SCOOTER_RUN_id_delivery_run                  NOT NULL,
id_courier integer                                 CONSTRAINT nn_SCOOTER_RUN_id_courier            NOT NULL
);

CREATE TABLE USERORDER (
id_userorder integer                              GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) 
                                                  CONSTRAINT PK_USERORDER_id_userorder          PRIMARY KEY,
id_pharmacy integer                               CONSTRAINT nn_userorder_id_pharmacy              NOT NULL,												  
id_customer integer                               CONSTRAINT nn_USERORDER_id_customer                     NOT NULL, 
id_delivery_run integer,
weight integer 					 			   	 CONSTRAINT nn_USERORDER_weight                  NOT NULL
);

CREATE TABLE BACKORDER (
id_backorder integer                              GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) 
                                                  CONSTRAINT PK_BACKORDER_id_backorder          PRIMARY KEY,
id_pharmacy integer                               CONSTRAINT nn_BACKORDER_id_pharmacy              NOT NULL,
id_pharmacy_nearby integer                        CONSTRAINT nn_BACKORDER_id_pharmacy_nearby              NOT NULL,												  
id_product integer                                CONSTRAINT nn_BACKORDER_id_product                NOT NULL,
quantity integer							      CONSTRAINT nn_BACKORDER_quantity               NOT NULL
);

CREATE TABLE SHOP_BAG (
id_userorder integer                              CONSTRAINT nn_SHOP_BAG_id_userorder                                           NOT NULL,
id_product integer                                CONSTRAINT nn_SHOP_BAG_id_product                                                  NOT NULL, 
qtd integer                                       CONSTRAINT nn_invoice_qtd                                                     NOT NULL,
                                                  CONSTRAINT ck_invoice_qtd                                                        CHECK (qtd  > 0)
);

CREATE TABLE INVOICE (
id_userorder integer                              CONSTRAINT nn_INVOICE_id_userorder                                           NOT NULL,
total integer                                     CONSTRAINT nn_INVOICE_total                                                                      NOT NULL
);

--====================================ALTER TABLES=========================================================
ALTER TABLE LOCAL 
ADD ( 
PRIMARY KEY (name)
);

ALTER TABLE CONNECTIONS 
ADD ( 
PRIMARY KEY (local1,local2),
CONSTRAINT  FK_CONNECTIONS_LOCAL1
FOREIGN KEY (local1) REFERENCES LOCAL(name),
CONSTRAINT  FK_CONNECTIONS_LOCAL2
FOREIGN KEY (local2) REFERENCES LOCAL(name)
);

ALTER TABLE ADDRESS 
ADD ( 
PRIMARY KEY (lati, longi),
CONSTRAINT  FK_ADDRESS_LOCAL
FOREIGN KEY (localname) REFERENCES LOCAL(name)
);

ALTER TABLE PARK
ADD(
CONSTRAINT  FK_PARK_PARK_TYPE
FOREIGN KEY (id_park_type) REFERENCES PARK_TYPE(id_park_type),
CONSTRAINT  FK_PARK_PHARMACY
FOREIGN KEY (id_pharmacy) REFERENCES PHARMACY(id_pharmacy)
);

ALTER TABLE PHARMACY
ADD( 
CONSTRAINT  FK_PHARMACY_ADDRESS
FOREIGN KEY (lati, longi) REFERENCES ADDRESS(lati, longi)
);

ALTER TABLE VEHICLE
ADD( 
CONSTRAINT  FK_VEHICLE_PHARMACY
FOREIGN KEY (id_pharmacy) REFERENCES PHARMACY(id_pharmacy),
CONSTRAINT  FK_VEHICLE_VEHICLE_TYPE
FOREIGN KEY (id_vehicle_type) REFERENCES VEHICLE_TYPE(id_vehicle_type),
CONSTRAINT  VEHICLE_STATE
FOREIGN KEY (id_vehicle_state) REFERENCES VEHICLE_STATE(id_vehicle_state)
);

ALTER TABLE STOCK
ADD(
PRIMARY KEY (id_pharmacy, id_product),
CONSTRAINT  FK_STOCK_PHARMACY
FOREIGN KEY (id_pharmacy) REFERENCES PHARMACY(id_pharmacy),
CONSTRAINT  FK_STOCK_PRODUCT
FOREIGN KEY (id_product) REFERENCES PRODUCT(id_product)
);

ALTER TABLE PHUSER
ADD (
CONSTRAINT  FK_PHUSER_USERROLE
FOREIGN KEY (id_role) REFERENCES USERROLE(id_role)
);

ALTER TABLE CUSTOMER
ADD (
PRIMARY KEY (id_customer),
CONSTRAINT  FK_CUSTOMER_PHUSER
FOREIGN KEY (id_customer) REFERENCES PHUSER(id_user),
CONSTRAINT  FK_CUSTOMER_ADDRESS
FOREIGN KEY (lati, longi) REFERENCES ADDRESS(lati, longi)
);

ALTER TABLE ADMINISTRATOR
ADD (
PRIMARY KEY (id_administrator),
CONSTRAINT  FK_ADMISTRATOR_PhUser
FOREIGN KEY (id_administrator) REFERENCES PhUser(id_user),
CONSTRAINT  FK_ADMISTRATOR_Pharmacy
FOREIGN KEY (id_pharmacy) REFERENCES Pharmacy(id_pharmacy)
);

ALTER TABLE COURIER
ADD(
PRIMARY KEY (id_courier),
CONSTRAINT  FK_COURIER_PhUser
FOREIGN KEY (id_courier) REFERENCES PhUser(id_user),
CONSTRAINT  FK_COURIER_PHARMACY
FOREIGN KEY (id_pharmacy) REFERENCES PHARMACY(id_pharmacy)
);

ALTER TABLE NOTIFICATION
ADD(
CONSTRAINT  FK_NOTIFICATION_COSTUMER
FOREIGN KEY (id_customer) REFERENCES CUSTOMER(id_customer)
);

ALTER TABLE DELIVERY_RUN
ADD(
CONSTRAINT  FK_DELIVERY_RUN_VEHICLE
FOREIGN KEY (id_vehicle) REFERENCES VEHICLE(id_vehicle),
CONSTRAINT  FK_DELIVERY_RUN_STATUS
FOREIGN KEY (id_status) REFERENCES STATUS(id_status),
CONSTRAINT  FK_DELIVERY_RUN_PHARMACY
FOREIGN KEY (id_pharmacy) REFERENCES PHARMACY(id_pharmacy)
);

ALTER TABLE DRONE_RUN
ADD(
CONSTRAINT  FK_DRONE_RUN_DELIVERY_RUN
FOREIGN KEY (id_delivery_run) REFERENCES DELIVERY_RUN(id_delivery_run)
);

ALTER TABLE SCOOTER_RUN
ADD(
CONSTRAINT  FK_SCOOTER_RUN_DELIVERY_RUN
FOREIGN KEY (id_delivery_run) REFERENCES DELIVERY_RUN(id_delivery_run),
CONSTRAINT  FK_SCOOTER_RUN_DELIVERY_RUN_COURIER
FOREIGN KEY (id_courier) REFERENCES COURIER(id_courier)

);

ALTER TABLE USERORDER
ADD(
CONSTRAINT  FK_USERORDEER_CUSTOMEER
FOREIGN KEY (id_customer) REFERENCES CUSTOMER(id_customer),
CONSTRAINT  FK_USERORDER_PHARMACY
FOREIGN KEY (id_pharmacy) REFERENCES PHARMACY(id_pharmacy),
CONSTRAINT  FK_USERORDEER_DELIVEERY_RUN
FOREIGN KEY (id_delivery_run) REFERENCES DELIVERY_RUN(id_delivery_run)
);

ALTER TABLE BACKORDER
ADD(
CONSTRAINT  FK_BACKORDER_PHARMACY
FOREIGN KEY (id_pharmacy) REFERENCES PHARMACY(id_pharmacy),
CONSTRAINT  FK_BACKORDER_PHARMACY_NEAR
FOREIGN KEY (id_pharmacy_nearby) REFERENCES PHARMACY(id_pharmacy),
CONSTRAINT  FK_BACKORDER_PRODUCT
FOREIGN KEY (id_product) REFERENCES PRODUCT(id_product)
);

ALTER TABLE SHOP_BAG
ADD(
PRIMARY KEY (id_userorder, id_product),
CONSTRAINT  FK_SHOP_BAG_USERORDER
FOREIGN KEY (id_userorder) REFERENCES USERORDER(id_userorder),
CONSTRAINT  FK_USERORDER_DELIVERY_RUN
FOREIGN KEY (id_product) REFERENCES PRODUCT(id_product)
);

ALTER TABLE INVOICE
ADD(
PRIMARY KEY (id_userorder),
CONSTRAINT  FK_INVOICE_USERORDER
FOREIGN KEY (id_userorder) REFERENCES USERORDER(id_userorder)
);

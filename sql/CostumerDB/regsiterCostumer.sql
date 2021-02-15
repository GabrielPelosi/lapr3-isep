CREATE OR REPLACE PROCEDURE add_costumer (
    c_phuser_id             CUSTOMER.ID_CUSTOMER%TYPE,
    c_lati                    CUSTOMER.LATI%TYPE,
    c_longi                   CUSTOMER.LONGI%TYPE,
    c_cred                   CUSTOMER.CREDITS%TYPE,
    c_nif                  CUSTOMER.NIF%TYPE) AS
BEGIN
INSERT INTO CUSTOMER(ID_CUSTOMER, LATI, LONGI,CREDITS,NIF) VALUES (c_phuser_id, c_lati, c_longi,c_cred,c_nif);
END;

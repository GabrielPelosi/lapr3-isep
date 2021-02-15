
CREATE OR REPLACE PROCEDURE create_user_order (
    u_costumer_id             pharmacy.id_pharmacy%TYPE,
    u_pharmacy_id                     pharmacy.id_pharmacy%TYPE) AS
BEGIN
INSERT INTO userorder(ID_CUSTOMER, ID_PHARMACY) VALUES (u_costumer_id, u_pharmacy_id);
END;



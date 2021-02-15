
CREATE OR REPLACE PROCEDURE add_courier (
    c_pharmacy_id             pharmacy.id_pharmacy%TYPE,
    c_ph_user_is            phuser.id_user%TYPE) AS
BEGIN
INSERT INTO COURIER(ID_COURIER, ID_PHARMACY) VALUES (c_ph_user_is, c_pharmacy_id);
END;


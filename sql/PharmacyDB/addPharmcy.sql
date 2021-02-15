

/*ADD PHARMACY*/
CREATE OR REPLACE PROCEDURE addPharmacy (
    p_lati             pharmacy.lati%TYPE,
    p_longi            pharmacy.longi%TYPE) AS
BEGIN
INSERT INTO pharmacy(lati, longi) VALUES (p_lati, p_longi);
END;


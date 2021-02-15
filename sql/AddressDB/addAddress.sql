/*ADD ADDRESS*/
CREATE OR REPLACE PROCEDURE addAddress (
    a_lati             address.lati%TYPE,
    a_longi            address.longi%TYPE,
    a_elev              address.longi%TYPE,
    address_name           local.name%TYPE) AS
BEGIN

INSERT INTO LOCAL(NAME) VALUES(address_name);

INSERT INTO address(lati, longi, alti, localname, windSpeed, windDirection) VALUES (a_lati, a_longi,a_elev, address_name,100,1);

END;
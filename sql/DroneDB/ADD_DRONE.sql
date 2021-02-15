CREATE OR REPLACE PROCEDURE ADD_DRONE (
    pharmacy_id   NUMBER,
     max_battery   NUMBER,
    actual_battery    NUMBER,
    aero   NUMBER,
    front   NUMBER,
    weight   NUMBER
    ) AS
BEGIN
    INSERT INTO VEHICLE(ID_PHARMACY,    ID_VEHICLE_TYPE, ID_VEHICLE_STATE, FRONTALAREA,  AERODINAMIC,       MAXCAPACITY,         CHARGE,              WEIGHT) 

    VALUES              (pharmacy_id,2,1,front,aero,max_battery,actual_battery,weight);
END;

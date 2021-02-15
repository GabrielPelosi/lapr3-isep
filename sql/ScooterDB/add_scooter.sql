CREATE OR REPLACE PROCEDURE add_scooter (
    pharmacy_id             VEHICLE.ID_PHARMACY%TYPE,
     max_battery             VEHICLE.MAXCAPACITY%TYPE,
    actual_battery          VEHICLE.CHARGE%TYPE,
    aero                    VEHICLE.AERODINAMIC%TYPE,
    front                   VEHICLE.FRONTALAREA%TYPE,
    weight                      VEHICLE.WEIGHT%TYPE
    ) AS
BEGIN
INSERT INTO VEHICLE(ID_PHARMACY,    ID_VEHICLE_TYPE, ID_VEHICLE_STATE, FRONTALAREA,  AERODINAMIC,       MAXCAPACITY,         CHARGE,              WEIGHT)

VALUES              (pharmacy_id,     1,                  1,               front,        aero,     max_battery,   actual_battery,   weight);
END;


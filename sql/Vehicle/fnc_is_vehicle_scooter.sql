create or replace function fnc_is_vehicle_drone(VehicleID Vehicle.ID_VEHICLE%TYPE)
RETURN Vehicle.ID_VEHICLE%TYPE
is id_v Vehicle.ID_VEHICLE%TYPE;
begin
    select v.ID_VEHICLE into id_v
    from Vehicle v
    where v.ID_VEHICLE = VehicleID AND v.ID_VEHICLE_TYPE = 2;
    
    return id_v;
end;
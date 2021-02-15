create or replace FUNCTION get_last_drone_created

RETURN SYS_REFCURSOR IS
    cur_drone SYS_REFCURSOR;
BEGIN
    OPEN cur_drone FOR 
    SELECT MAX( id_vehicle)
FROM vehicle
WHERE ID_VEHICLE_TYPE=2 
order by id_vehicle DESC ;
    RETURN cur_drone;
END;
create or replace FUNCTION get_last_scooter_created

RETURN SYS_REFCURSOR IS
    cur_scooter SYS_REFCURSOR;
BEGIN
    OPEN cur_scooter FOR 
    SELECT MAX( id_vehicle)
FROM vehicle
WHERE ID_VEHICLE_TYPE=1
order by id_vehicle DESC ;
    RETURN cur_scooter;
END;
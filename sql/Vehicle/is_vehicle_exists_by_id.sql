create or replace FUNCTION is_vehicle_exists_by_id( param_id_vehicle  vehicle.id_vehicle%TYPE ) 

RETURN SYS_REFCURSOR IS
    cur_vehicle SYS_REFCURSOR;
BEGIN
    OPEN cur_vehicle FOR SELECT id_vehicle from vehicle WHERE vehicle.id_vehicle = param_id_vehicle;

    RETURN cur_vehicle;
END;
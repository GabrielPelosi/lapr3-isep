create or REPLACE FUNCTION vehicleFree(param_id_vehicle NUMBER)
RETURN SYS_REFCURSOR IS
    cur_vehifre SYS_REFCURSOR;
BEGIN
    OPEN cur_vehifre FOR SELECT MAX(ID_STATUS) from DELIVERY_RUN WHERE DELIVERY_RUN.ID_VEHICLE=param_id_vehicle ;
    RETURN cur_vehifre;
END; 

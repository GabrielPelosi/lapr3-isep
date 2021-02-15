create or replace FUNCTION get_last_userorder_created

RETURN SYS_REFCURSOR IS
    cur_userorder SYS_REFCURSOR;
BEGIN
    OPEN cur_userorder FOR 
    SELECT  MAX(ID_USERORDER)
FROM USERORDER
WHERE id_delivery_run is null
order by ID_USERORDER  ;
    RETURN cur_userorder;
END;
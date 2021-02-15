create or replace function fnc_get_free_couriers
RETURN SYS_REFCURSOR
is cursor_couriers SYS_REFCURSOR;
begin
    open cursor_couriers for
    select c.id_courier from Courier c
    inner join scooter_run sr on c.id_courier not in sr.id_courier;
    return cursor_couriers;
end;
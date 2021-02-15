create or replace procedure prc_add_drone_delivery(idDelivery DELIVERY_RUN.id_delivery_run%type)
IS
begin
    Insert into drone_run(id_delivery_run)
    VALUES(idDelivery);

end;
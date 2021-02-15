create or replace procedure prc_add_scooter_delivery(idDelivery DELIVERY_RUN.id_delivery_run%type, idCourier Courier.id_courier%type)
IS
begin
    Insert into scooter_run(id_delivery_run, id_courier)
    VALUES(idDelivery, idCourier);

end;
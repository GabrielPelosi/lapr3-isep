create or replace trigger trgNotifyCustomer
    before update of ID_STATUS on DELIVERY_RUN
    for each row
    DECLARE
    id_cus NUMBER;
    BEGIN
    select id_customer   into id_cus from userorder where userorder.id_delivery_run=:old.id_delivery_run;
BEGIN
    if(:new.id_status=2) then 
        insert INTO NOTIFICATION (id_customer,description) Values( id_cus ,'Your order is being delivered' );
        end if;
end;
end;
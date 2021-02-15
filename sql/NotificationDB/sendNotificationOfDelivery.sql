create or replace Trigger sendNotificationOfDelivery
after update of id_delivery_run_state on Delivery_run
declare
    cs_costumer SYS_REFCURSOR;
    id_c costumer.id_costumer%type;
begin   

    open cs_costumer for
        select u.id_costumer from userorder u where u.ID_DELIVERY_RUN = :new.ID_DELIVERY_RUN;
        
    loop
        fetch cs_costumer into id_c;
        
        insert into notification(id_customer, description) values (ud_c, 'Encomenda a caminho');
        exit when cs_costumer%notfound;
    
    end loop;

    close cs_costumer;

end;
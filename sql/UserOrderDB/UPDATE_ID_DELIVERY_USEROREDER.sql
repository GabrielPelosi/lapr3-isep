CREATE OR REPLACE PROCEDURE UPDATE_ID_DELIVERY_USEROREDER(

    c_id_user NUMBER,
    o_new_delivery Number) AS

BEGIN
  UPDATE userorder 
        SET ID_DELIVERY_RUN=o_new_delivery
        Where ID_USERORDER = c_id_user;

END UPDATE_ID_DELIVERY_USEROREDER;
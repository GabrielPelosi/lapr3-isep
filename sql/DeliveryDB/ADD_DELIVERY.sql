create or replace PROCEDURE ADD_DELIVERY(s_state NUMBER,s_vehicleId NUMBER,s_weight NUMBER)
AS
BEGIN
  INSERT INTO DELIVERY_RUN(ID_STATUS, ID_VEHICLE, WEIGHT) 
VALUES(s_state,s_vehicleId,s_weight);
END;
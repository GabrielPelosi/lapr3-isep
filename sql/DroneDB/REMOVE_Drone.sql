create or replace PROCEDURE remove_drone(droneid Number)
 AS
 drone_invalido EXCEPTION;
BEGIN
if fnccheckdrone(droneid)then 
DELETE FROM vehicle WHERE id_vehicle= remove_drone.droneid;
else
raise drone_invalido;
end if;
EXCEPTION
when drone_invalido then
RAISE_APPLICATION_ERROR(-20002, 'Drone doesnt exis.');
END remove_drone;

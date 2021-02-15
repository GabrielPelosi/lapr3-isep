create or replace PROCEDURE remove_scooter (scooterid Number) AS
scooter_invalido EXCEPTION;
BEGIN
if fnccheckscooter(scooterid)then 
DELETE FROM vehicle WHERE id_vehicle= remove_scooter.scooterid;
else
raise scooter_invalido;
end if;
EXCEPTION
when scooter_invalido then
RAISE_APPLICATION_ERROR(-20002, 'Scooter doesnt exis.');
END remove_scooter;

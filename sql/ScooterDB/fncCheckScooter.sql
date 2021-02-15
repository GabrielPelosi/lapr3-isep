create or REPLACE FUNCTION fnccheckscooter(scooterid Number)
Return boolean
IS

contagem_scooter INTEGER := 0; 
BEGIN
select count(v.ID_VEHICLE)  into contagem_scooter from vehicle v
where v.ID_VEHICLE =scooterid
and v.ID_VEHICLE_TYPE=1;
IF contagem_scooter>0 then
RETURN true;
else
return false;
END if;
End;




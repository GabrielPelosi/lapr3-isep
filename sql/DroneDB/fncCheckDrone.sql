create or REPLACE FUNCTION fnccheckdrone(droneid Number)
Return boolean
IS

contagem_drone INTEGER := 0; 
BEGIN
select count(v.ID_VEHICLE)  into contagem_drone from vehicle v
where v.ID_VEHICLE =droneid
and v.ID_VEHICLE_TYPE=2;
IF contagem_drone>0 then
RETURN true;
else
return false;
END if;
End;



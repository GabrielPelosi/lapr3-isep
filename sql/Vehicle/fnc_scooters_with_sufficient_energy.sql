create or replace function fnc_scooters_with_sufficient_energy(energy integer)
return sys_refcursor
is cursor_scooter sys_refcursor;
begin
    
    open cursor_scooter for
        select v.id_vehicle from VEHICLE v
        where (v.maxcapacity * v.charge) >= energy ;
        
    return cursor_scooter;
end;
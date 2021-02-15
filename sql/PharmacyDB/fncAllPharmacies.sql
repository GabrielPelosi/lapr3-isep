create or replace function fncAllPharmacies
return sys_refcursor
is pharmacy_cursor sys_refcursor;
begin
    open pharmacy_cursor for
        select * from pharmacy;
        
    return pharmacy_cursor;
end;
create or replace function fncAddressByLocation(local Local.Name%Type)
RETURN SYS_REFCURSOR
is cursor_addresses SYS_REFCURSOR;
begin
    open cursor_addresses for
    select * from Address a
    inner join Local l on a.localNAME = l.NAME;
    return cursor_addresses;
end;
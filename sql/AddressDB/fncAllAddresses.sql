create or replace function fncAllAddresses
RETURN SYS_REFCURSOR
is cursor_address SYS_REFCURSOR;
begin
    open cursor_address for
    select * from Address;
    return cursor_address;
end;
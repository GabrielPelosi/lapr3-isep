create or replace function fncAllLocationsWithConnections
RETURN SYS_REFCURSOR
is cursor_connections SYS_REFCURSOR;
begin
    open cursor_connections for
    select * from Connections;
    return cursor_connections;
end;
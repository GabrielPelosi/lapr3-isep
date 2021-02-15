create or replace function fncAllStreetCrossings
RETURN SYS_REFCURSOR
is sc_cursor SYS_REFCURSOR;
begin
    open sc_cursor for
    select * from street_crossing;
    return sc_cursor;
end;
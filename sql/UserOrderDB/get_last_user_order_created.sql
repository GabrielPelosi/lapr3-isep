
CREATE OR REPLACE FUNCTION get_last_user_order_created

RETURN SYS_REFCURSOR IS
    cur_userorder SYS_REFCURSOR;
BEGIN
OPEN cur_userorder FOR SELECT id_userorder from userorder WHERE ROWNUM = 1 order by id_userorder DESC;


RETURN cur_userorder;
END;

CREATE OR REPLACE FUNCTION get_last_phuser_created

RETURN SYS_REFCURSOR IS
    cur_phuser SYS_REFCURSOR;
BEGIN
OPEN cur_phuser FOR SELECT id_user from PhUser WHERE ROWNUM = 1 order by id_user DESC;


RETURN cur_phuser;
END;
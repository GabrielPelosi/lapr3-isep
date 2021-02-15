create or replace PROCEDURE addPHUser(u_role_id NUMBER, email VARCHAR, userName VARCHAR, passwd VARCHAR)
AS
BEGIN
INSERT INTO PHUser(id_role, email, username, passwd) VALUES(u_role_id, email, userName, passwd);
END;

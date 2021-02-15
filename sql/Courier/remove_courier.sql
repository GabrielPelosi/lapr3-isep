

create or replace PROCEDURE remove_courier_by_email
            (ph_email_to_delete phuser.email%TYPE)
AS
BEGIN


DELETE FROM COURIER WHERE id_courier=(SELECT id_user
                                      FROM PHUSER ph WHERE ph.email = ph_email_to_delete);

DELETE FROM PHUSER WHERE id_user =(SELECT id_user
                                   FROM PHUSER ph WHERE ph.email = ph_email_to_delete);

END;

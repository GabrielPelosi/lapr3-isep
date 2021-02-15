
CREATE OR REPLACE PROCEDURE create_new_notification (
    n_id_costumer             notification.id_customer%TYPE,
    n_description                     notification.description%TYPE) AS
BEGIN
INSERT INTO notification(ID_CUSTOMER, description) VALUES (n_id_costumer, n_description);
END;

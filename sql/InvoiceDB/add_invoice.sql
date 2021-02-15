CREATE OR REPLACE PROCEDURE add_invoice (
    i_user_order_id             userorder.id_userorder%TYPE,
    i_total                     invoice.total%TYPE) AS
BEGIN
INSERT INTO INVOICE(ID_USERORDER, TOTAL) VALUES (i_user_order_id, i_total);
END;

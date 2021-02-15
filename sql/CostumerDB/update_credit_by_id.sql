CREATE OR REPLACE PROCEDURE update_credit_by_id (
    c_id_costomer             customer.id_customer%TYPE,
    o_new_credits                    customer.credits%TYPE) AS
BEGIN

UPDATE customer
SET credits=(credits + o_new_credits)
Where id_customer = c_id_costomer;

END;
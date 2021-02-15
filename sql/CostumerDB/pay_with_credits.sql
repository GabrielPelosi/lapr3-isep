
CREATE OR REPLACE PROCEDURE pay_with_credits( param_customer_id  customer.id_customer%TYPE)
AS
BEGIN
UPDATE customer
SET credits=(credits - 10)
Where id_customer=param_customer_id;

END;

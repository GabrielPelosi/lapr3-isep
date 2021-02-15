
CREATE OR REPLACE FUNCTION has_enough_credits_by_id( param_customer_id  customer.id_customer%TYPE )

RETURN SYS_REFCURSOR IS
    cur_cred SYS_REFCURSOR;
BEGIN
OPEN cur_cred FOR SELECT credits from customer WHERE customer.id_customer = param_customer_id;
RETURN cur_cred;
END;


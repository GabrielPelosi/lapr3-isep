
CREATE OR REPLACE FUNCTION is_costumer_exists (
    c_id_costomer             customer.id_customer%TYPE)
RETURN SYS_REFCURSOR IS
    cur_costumer SYS_REFCURSOR;
BEGIN
OPEN cur_costumer FOR SELECT id_customer from customer WHERE customer.id_customer = c_id_costomer;


RETURN cur_costumer;
END;

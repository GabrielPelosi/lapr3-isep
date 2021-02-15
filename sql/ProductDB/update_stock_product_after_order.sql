
create or replace PROCEDURE update_stock_product_after_order(
    p_id_pharmacy             pharmacy.id_pharmacy%TYPE,
    p_id_product                     product.id_product%TYPE,
    p_prod_quantity               stock.stock%TYPE)

IS
    stock_stock                stock.stock%TYPE;

cursor c2 is
SELECT stock
FROM stock sto
         INNER JOIN PHARMACY pha ON pha.id_pharmacy = sto.id_pharmacy
         INNER JOIN PRODUCT prod ON prod.id_product = sto.id_product
where pha.id_pharmacy=p_id_pharmacy and prod.id_product=p_id_product;

BEGIN

open c2;
fetch c2 into stock_stock;

UPDATE stock
SET stock=(stock_stock - p_prod_quantity)
Where id_product=p_id_product and id_pharmacy=p_id_pharmacy;

END;
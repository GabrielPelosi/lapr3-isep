
create or replace PROCEDURE update_stock_product (
    stock_id_product              stock.id_product%TYPE,
    stock_id_pharmacy             pharmacy.id_pharmacy%TYPE,
    qnt_stock                     stock.stock%TYPE
) IS 

 stock_stock                stock.stock%TYPE;

cursor c2 is
SELECT stock
FROM stock sto
         INNER JOIN PHARMACY pha ON pha.id_pharmacy = sto.id_pharmacy
         INNER JOIN PRODUCT prod ON prod.id_product = sto.id_product
where pha.id_pharmacy=stock_id_pharmacy and prod.id_product=stock_id_product;

BEGIN


open c2;
fetch c2 into stock_stock;


UPDATE stock
SET stock=(qnt_stock + stock_stock)
Where stock.id_pharmacy=stock_id_pharmacy and stock.id_product=stock_id_product;


END;


CREATE OR REPLACE FUNCTION get_stock_product_of_pharmacy_by_ids (
    param_product_id IN product.id_product%TYPE,
    param_id_pharmacy IN pharmacy.id_pharmacy%TYPE
) RETURN SYS_REFCURSOR IS
    cur_prod SYS_REFCURSOR;
BEGIN
OPEN cur_prod FOR select sto.stock as stock
                        from STOCK sto
                        INNER JOIN PHARMACY pha ON pha.id_pharmacy = sto.id_pharmacy
                        INNER JOIN PRODUCT prod ON prod.id_product = sto.id_product
                        where pha.id_pharmacy=param_id_pharmacy and prod.id_product=param_product_id;
RETURN cur_prod;
END;
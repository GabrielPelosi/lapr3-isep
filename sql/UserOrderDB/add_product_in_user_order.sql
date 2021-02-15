CREATE OR REPLACE PROCEDURE add_product_in_user_order (
    sb_userorder_id             shop_bag.id_userorder%TYPE,
    sb_product_id                     shop_bag.id_product%TYPE,
    sb_prod_quantity               shop_bag.qtd%TYPE) AS
BEGIN
INSERT INTO shop_bag(ID_USERORDER, ID_PRODUCT, QTD) VALUES (sb_userorder_id, sb_product_id,sb_prod_quantity);
END;


create or replace function fnc_getAllPharmaciesWithProduct(idProduto Product.ID_PRODUCT%type, quantity integer)
RETURN SYS_REFCURSOR
IS cursor_pharmacies SYS_REFCURSOR;
BEGIN
    open cursor_pharmacies for
        select * from Pharmacy p
        inner join STOCK s on( p.ID_PHARMACY = s.ID_PHARMACY AND idProduto = s.ID_PRODUCT AND quantity <= s.stock);

    return cursor_pharmacies;
END;
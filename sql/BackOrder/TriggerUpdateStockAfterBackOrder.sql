create or replace Trigger UpdateStockAfterBackOrder
    after insert
    on BackOrder
    for each row
    
declare 

    qt backOrder.quantity%TYPE;
    askPharm backOrder.ID_pharmacy%TYPE;
    srcPharm backOrder.ID_pharmacy%TYPE;
    prod product.ID_Product%TYPE;
    stockFinal backOrder.quantity%TYPE;
    qtAskPharm backOrder.quantity%TYPE;




begin

    qt:=:new.quantity;
    askPharm:=:new.id_pharmacy;
    srcPharm:=:new.id_pharmacy_nearby;
    prod:=:new.id_Product;

    select  sto.stock into qtAskPharm from stock sto where sto.id_pharmacy=askPharm AND sto.id_product = prod;

    stockFinal:= qt-qtAskPharm;


 UPDATE stock 
    SET stock=(qtAskPharm + stockFinal)
    Where stock.id_pharmacy=askPharm and stock.id_product=prod;
  
  
  update_stock_product_after_Order(srcPharm,prod,stockFinal);


end;
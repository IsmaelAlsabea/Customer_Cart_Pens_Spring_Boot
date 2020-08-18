

CREATE OR REPLACE PROCEDURE tear_down_mqdp()
BEGIN

drop table cust_order ;
drop table cart;
drop table customer;
drop table pen;

END;





CREATE OR REPLACE PROCEDURE set_up_mqdb()
BEGIN
CREATE TABLE customer(
c_id int PRIMARY KEY AUTO_INCREMENT, 
email varchar(200) NOT NULL UNIQUE,
password varchar(200) NOT NULL,
address varchar(200) NOT NULL,
firstname varchar(200) NOT NULL,
lastname varchar(200) NOT NULL,
points int); 

CREATE TABLE pen(
p_id int PRIMARY KEY AUTO_INCREMENT, 
cost int NOT NULL,
name varchar(200) NOT NULL,
description varchar(200),
caption_image varchar(350) NOT NULL);


CREATE TABLE cart(
cart_id int Not NULL, 
c_id int NOT NULL,
p_id int NOT NULL,
quantity int NOT NULL,
primary key (cart_id, c_id, p_id),
CONSTRAINT fk_cart_customer FOREIGN KEY cart(c_id) REFERENCES customer(c_id),
CONSTRAINT fk_order_pen FOREIGN KEY cart(p_id) REFERENCES pen(p_id)
);

CREATE TABLE cust_order(
o_id int PRIMARY KEY AUTO_INCREMENT, 
cart_id int NOT NULL,
c_id int NOT NULL,
order_date DATETIME NOT NULL,

-- CONSTRAINT fk_cust_order_cart FOREIGN KEY cust_order(cart_id) REFERENCES cart(cart_id),
CONSTRAINT fk_cust_order_customer FOREIGN KEY cust_order(c_id) REFERENCES customer(c_id)
);
END;




CREATE OR REPLACE PROCEDURE populate_mqdb()
BEGIN
INSERT INTO customer VALUES(0, 'penguy37@gmail.com', 'pen123', '485 Pen St.', 'Mr.', 'Pen', 1000);
INSERT INTO customer VALUES(0, 'pengirl37@gmail.com', 'penvalley', '1200 Pen City Bvld.', 'Ms.', 'Pen', 1500);
INSERT INTO customer VALUES(0, 'normalguy12@gmail.com', 'strongpassword', '123 address', 'Normal', 'Guy', 3);
INSERT INTO customer VALUES(0, 'penlord1@pen.com', 'pens4life', 'pen', 'Craig', 'Craigson', 2000000);

INSERT INTO pen VALUES(0, 30, 'Nemosine Singularity', 'Demonstrator that comes with a cartridge convereter.', 'assets/img/nemosine_singularity.jpeg');
INSERT INTO pen VALUES(0, 5, 'Jinhao Shark Pen', 'Want to have a cool pen with a shark name? This one\'s for you', 'assets/img/jinhao_shark.jpeg');
INSERT INTO pen VALUES(0, 20, 'Pilot Metropolitan', 'This pen will make you feel really important', 'assets/img/pilot_metropolitam.jpeg');
INSERT INTO pen VALUES(0, 30, 'Lamy Safari', 'Beginner friendly pen to start off your collection right.', 'assets/img/lamy_safari.jpeg');
INSERT INTO pen VALUES(0, 200, 'Pilot Vanishing Point', 'This pen is a status symbol. You can\'t go wrong with a pen like this.', 'assets/img/pilot_vanishing_point.jpeg');
INSERT INTO pen VALUES(0, 7500000, 'Fulgor Nocturnus Tibaldi', 'Please talk to an accountant before considering purcahse.', 'assets/img/tibaldi.jpeg');

-- <img [src]={{ (result of api call > model).img_src }} />

insert into cart values (1, 1, 1, 3), (1,1,2,5), (1,1,3,10);
insert into cart values (2, 2,1, 8 ), (2,2,3,7), (2,2,4,11);
insert into cart values (3, 1, 1,3),  (3, 1,2,4), (3,1,4, 20);


insert into cust_order values (0, 1, 1, CURRENT_TIMESTAMP( ));
insert into cust_order values (0, 2, 2, CURRENT_TIMESTAMP( ));
insert into cust_order values (0, 3, 1, CURRENT_TIMESTAMP( ));

END;




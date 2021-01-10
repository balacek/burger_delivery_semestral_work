create sequence hibernate_sequence start 1 increment 1
create table adress (adress_id int8 not null, city varchar(100), postal_code varchar(15), street varchar(100), primary key (adress_id))
create table burger (burger_id int8 not null, burger_name varchar(50), order_fk int8, primary key (burger_id))
create table customer (customer_id int8 not null, allow_newsletters boolean, customer_type varchar(50), email varchar(50), name varchar(30), password varchar(255), phone numeric(19, 2), surname varchar(30), primary key (customer_id))
create table delivery_order (order_id int8 not null, created timestamp, orderstate varchar(50), total_price numeric(19, 2), adress_fk int8, order_fk int8, primary key (order_id))
create table ingredient (ingredient_id int8 not null, amount int4, price int8, type varchar(150), primary key (ingredient_id))
create table ingredient_fk (ingredient_id int8 not null, burger_id int8 not null)
alter table if exists customer add constraint UK_dwk6cx0afu8bs9o4t536v1j5v unique (email)
alter table if exists burger add constraint FK3vj2t9p0f36gw8ator67casdo foreign key (order_fk) references delivery_order
alter table if exists delivery_order add constraint FKkcad0dpm32wp5w24ho53rhnom foreign key (adress_fk) references adress
alter table if exists delivery_order add constraint FKn0hfao3mkratdwr6nb9q4k2va foreign key (order_fk) references customer
alter table if exists ingredient_fk add constraint FKkicfs6qpynbapnp66ub1tfgr8 foreign key (burger_id) references ingredient
alter table if exists ingredient_fk add constraint FKlloq9ein91nglp5707acsje37 foreign key (ingredient_id) references burger
create sequence hibernate_sequence start 1 increment 1
create table adress (adress_id int8 not null, city varchar(100), postal_code varchar(15), street varchar(100), primary key (adress_id))
create table burger (burger_id int8 not null, burger_name varchar(50), order_fk int8, primary key (burger_id))
create table customer (customer_id int8 not null, allow_newsletters boolean, customer_type varchar(50), email varchar(50), name varchar(30), password varchar(255), phone numeric(19, 2), surname varchar(30), primary key (customer_id))
create table delivery_order (order_id int8 not null, created timestamp, orderstate varchar(50), total_price numeric(19, 2), adress_fk int8, order_fk int8, primary key (order_id))
create table ingredient (ingredient_id int8 not null, amount int4, price int8, type varchar(150), primary key (ingredient_id))
create table ingredient_fk (ingredient_id int8 not null, burger_id int8 not null)
alter table if exists customer add constraint UK_dwk6cx0afu8bs9o4t536v1j5v unique (email)
alter table if exists burger add constraint FK3vj2t9p0f36gw8ator67casdo foreign key (order_fk) references delivery_order
alter table if exists delivery_order add constraint FKkcad0dpm32wp5w24ho53rhnom foreign key (adress_fk) references adress
alter table if exists delivery_order add constraint FKn0hfao3mkratdwr6nb9q4k2va foreign key (order_fk) references customer
alter table if exists ingredient_fk add constraint FKkicfs6qpynbapnp66ub1tfgr8 foreign key (burger_id) references ingredient
alter table if exists ingredient_fk add constraint FKlloq9ein91nglp5707acsje37 foreign key (ingredient_id) references burger
create sequence hibernate_sequence start 1 increment 1
create table adress (adress_id int8 not null, city varchar(100), postal_code varchar(15), street varchar(100), primary key (adress_id))
create table burger (burger_id int8 not null, burger_name varchar(50), order_fk int8, primary key (burger_id))
create table customer (customer_id int8 not null, allow_newsletters boolean, customer_type varchar(50), email varchar(50), name varchar(30), password varchar(255), phone numeric(19, 2), surname varchar(30), primary key (customer_id))
create table delivery_order (order_id int8 not null, created timestamp, orderstate varchar(50), total_price numeric(19, 2), adress_fk int8, order_fk int8, primary key (order_id))
create table ingredient (ingredient_id int8 not null, amount int4, price int8, type varchar(150), primary key (ingredient_id))
create table ingredient_fk (ingredient_id int8 not null, burger_id int8 not null)
alter table if exists customer add constraint UK_dwk6cx0afu8bs9o4t536v1j5v unique (email)
alter table if exists burger add constraint FK3vj2t9p0f36gw8ator67casdo foreign key (order_fk) references delivery_order
alter table if exists delivery_order add constraint FKkcad0dpm32wp5w24ho53rhnom foreign key (adress_fk) references adress
alter table if exists delivery_order add constraint FKn0hfao3mkratdwr6nb9q4k2va foreign key (order_fk) references customer
alter table if exists ingredient_fk add constraint FKkicfs6qpynbapnp66ub1tfgr8 foreign key (burger_id) references ingredient
alter table if exists ingredient_fk add constraint FKlloq9ein91nglp5707acsje37 foreign key (ingredient_id) references burger
create sequence hibernate_sequence start 1 increment 1
create table adress (adress_id int8 not null, city varchar(100), postal_code varchar(15), street varchar(100), primary key (adress_id))
create table burger (burger_id int8 not null, burger_name varchar(50), order_fk int8, primary key (burger_id))
create table customer (customer_id int8 not null, allow_newsletters boolean, customer_type varchar(50), email varchar(50), name varchar(30), password varchar(255), phone numeric(19, 2), surname varchar(30), primary key (customer_id))
create table delivery_order (order_id int8 not null, created timestamp, orderstate varchar(50), total_price numeric(19, 2), adress_fk int8, order_fk int8, primary key (order_id))
create table ingredient (ingredient_id int8 not null, amount int4, price int8, type varchar(150), primary key (ingredient_id))
create table ingredient_fk (ingredient_id int8 not null, burger_id int8 not null)
alter table if exists customer add constraint UK_dwk6cx0afu8bs9o4t536v1j5v unique (email)
alter table if exists burger add constraint FK3vj2t9p0f36gw8ator67casdo foreign key (order_fk) references delivery_order
alter table if exists delivery_order add constraint FKkcad0dpm32wp5w24ho53rhnom foreign key (adress_fk) references adress
alter table if exists delivery_order add constraint FKn0hfao3mkratdwr6nb9q4k2va foreign key (order_fk) references customer
alter table if exists ingredient_fk add constraint FKkicfs6qpynbapnp66ub1tfgr8 foreign key (burger_id) references ingredient
alter table if exists ingredient_fk add constraint FKlloq9ein91nglp5707acsje37 foreign key (ingredient_id) references burger
create sequence hibernate_sequence start 1 increment 1
create table adress (adress_id int8 not null, city varchar(100), postal_code varchar(15), street varchar(100), primary key (adress_id))
create table burger (burger_id int8 not null, burger_name varchar(50), order_fk int8, primary key (burger_id))
create table customer (customer_id int8 not null, allow_newsletters boolean, customer_type varchar(50), email varchar(50), name varchar(30), password varchar(255), phone numeric(19, 2), surname varchar(30), primary key (customer_id))
create table delivery_order (order_id int8 not null, created timestamp, orderstate varchar(50), total_price numeric(19, 2), adress_fk int8, order_fk int8, primary key (order_id))
create table ingredient (ingredient_id int8 not null, amount int4, price int8, type varchar(150), primary key (ingredient_id))
create table ingredient_fk (ingredient_id int8 not null, burger_id int8 not null)
alter table if exists customer add constraint UK_dwk6cx0afu8bs9o4t536v1j5v unique (email)
alter table if exists burger add constraint FK3vj2t9p0f36gw8ator67casdo foreign key (order_fk) references delivery_order
alter table if exists delivery_order add constraint FKkcad0dpm32wp5w24ho53rhnom foreign key (adress_fk) references adress
alter table if exists delivery_order add constraint FKn0hfao3mkratdwr6nb9q4k2va foreign key (order_fk) references customer
alter table if exists ingredient_fk add constraint FKkicfs6qpynbapnp66ub1tfgr8 foreign key (burger_id) references ingredient
alter table if exists ingredient_fk add constraint FKlloq9ein91nglp5707acsje37 foreign key (ingredient_id) references burger
create sequence hibernate_sequence start 1 increment 1
create table adress (adress_id int8 not null, city varchar(100), postal_code varchar(15), street varchar(100), primary key (adress_id))
create table burger (burger_id int8 not null, burger_name varchar(50), order_fk int8, primary key (burger_id))
create table customer (customer_id int8 not null, allow_newsletters boolean, customer_type varchar(50), email varchar(50), name varchar(30), password varchar(255), phone numeric(19, 2), surname varchar(30), primary key (customer_id))
create table delivery_order (order_id int8 not null, created timestamp, orderstate varchar(50), total_price numeric(19, 2), adress_fk int8, order_fk int8, primary key (order_id))
create table ingredient (ingredient_id int8 not null, amount int4, price int8, type varchar(150), primary key (ingredient_id))
create table ingredient_fk (ingredient_id int8 not null, burger_id int8 not null)
alter table if exists customer add constraint UK_dwk6cx0afu8bs9o4t536v1j5v unique (email)
alter table if exists burger add constraint FK3vj2t9p0f36gw8ator67casdo foreign key (order_fk) references delivery_order
alter table if exists delivery_order add constraint FKkcad0dpm32wp5w24ho53rhnom foreign key (adress_fk) references adress
alter table if exists delivery_order add constraint FKn0hfao3mkratdwr6nb9q4k2va foreign key (order_fk) references customer
alter table if exists ingredient_fk add constraint FKkicfs6qpynbapnp66ub1tfgr8 foreign key (burger_id) references ingredient
alter table if exists ingredient_fk add constraint FKlloq9ein91nglp5707acsje37 foreign key (ingredient_id) references burger
create sequence hibernate_sequence start 1 increment 1
create table adress (adress_id int8 not null, city varchar(100), postal_code varchar(15), street varchar(100), primary key (adress_id))
create table burger (burger_id int8 not null, burger_name varchar(50), order_fk int8, primary key (burger_id))
create table customer (customer_id int8 not null, allow_newsletters boolean, customer_type varchar(50), email varchar(50), name varchar(30), password varchar(255), phone numeric(19, 2), surname varchar(30), primary key (customer_id))
create table delivery_order (order_id int8 not null, created timestamp, orderstate varchar(50), total_price numeric(19, 2), adress_fk int8, order_fk int8, primary key (order_id))
create table ingredient (ingredient_id int8 not null, amount int4, price int8, type varchar(150), primary key (ingredient_id))
create table ingredient_fk (ingredient_id int8 not null, burger_id int8 not null)
alter table if exists customer add constraint UK_dwk6cx0afu8bs9o4t536v1j5v unique (email)
alter table if exists burger add constraint FK3vj2t9p0f36gw8ator67casdo foreign key (order_fk) references delivery_order
alter table if exists delivery_order add constraint FKkcad0dpm32wp5w24ho53rhnom foreign key (adress_fk) references adress
alter table if exists delivery_order add constraint FKn0hfao3mkratdwr6nb9q4k2va foreign key (order_fk) references customer
alter table if exists ingredient_fk add constraint FKkicfs6qpynbapnp66ub1tfgr8 foreign key (burger_id) references ingredient
alter table if exists ingredient_fk add constraint FKlloq9ein91nglp5707acsje37 foreign key (ingredient_id) references burger
create sequence hibernate_sequence start 1 increment 1
create table adress (adress_id int8 not null, city varchar(100), postal_code varchar(15), street varchar(100), primary key (adress_id))
create table burger (burger_id int8 not null, burger_name varchar(50), order_fk int8, primary key (burger_id))
create table customer (customer_id int8 not null, allow_newsletters boolean, customer_type varchar(50), email varchar(50), name varchar(30), password varchar(255), phone numeric(19, 2), surname varchar(30), primary key (customer_id))
create table delivery_order (order_id int8 not null, created timestamp, orderstate varchar(50), total_price numeric(19, 2), adress_fk int8, order_fk int8, primary key (order_id))
create table ingredient (ingredient_id int8 not null, amount int4, price int8, type varchar(150), primary key (ingredient_id))
create table ingredient_fk (ingredient_id int8 not null, burger_id int8 not null)
alter table if exists customer add constraint UK_dwk6cx0afu8bs9o4t536v1j5v unique (email)
alter table if exists burger add constraint FK3vj2t9p0f36gw8ator67casdo foreign key (order_fk) references delivery_order
alter table if exists delivery_order add constraint FKkcad0dpm32wp5w24ho53rhnom foreign key (adress_fk) references adress
alter table if exists delivery_order add constraint FKn0hfao3mkratdwr6nb9q4k2va foreign key (order_fk) references customer
alter table if exists ingredient_fk add constraint FKkicfs6qpynbapnp66ub1tfgr8 foreign key (burger_id) references ingredient
alter table if exists ingredient_fk add constraint FKlloq9ein91nglp5707acsje37 foreign key (ingredient_id) references burger
create sequence hibernate_sequence start 1 increment 1
create table adress (adress_id int8 not null, city varchar(100), postal_code varchar(15), street varchar(100), primary key (adress_id))
create table burger (burger_id int8 not null, burger_name varchar(50), order_fk int8, primary key (burger_id))
create table customer (customer_id int8 not null, allow_newsletters boolean, customer_type varchar(50), email varchar(50), name varchar(30), password varchar(255), phone numeric(19, 2), surname varchar(30), primary key (customer_id))
create table delivery_order (order_id int8 not null, created timestamp, orderstate varchar(50), total_price numeric(19, 2), adress_fk int8, order_fk int8, primary key (order_id))
create table ingredient (ingredient_id int8 not null, amount int4, price int8, type varchar(150), primary key (ingredient_id))
create table ingredient_fk (ingredient_id int8 not null, burger_id int8 not null)
alter table if exists customer add constraint UK_dwk6cx0afu8bs9o4t536v1j5v unique (email)
alter table if exists burger add constraint FK3vj2t9p0f36gw8ator67casdo foreign key (order_fk) references delivery_order
alter table if exists delivery_order add constraint FKkcad0dpm32wp5w24ho53rhnom foreign key (adress_fk) references adress
alter table if exists delivery_order add constraint FKn0hfao3mkratdwr6nb9q4k2va foreign key (order_fk) references customer
alter table if exists ingredient_fk add constraint FKkicfs6qpynbapnp66ub1tfgr8 foreign key (burger_id) references ingredient
alter table if exists ingredient_fk add constraint FKlloq9ein91nglp5707acsje37 foreign key (ingredient_id) references burger

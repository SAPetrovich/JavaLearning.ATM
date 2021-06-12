drop table if exists accounts CASCADE;
drop table if exists cards CASCADE;
drop table if exists clients CASCADE;

create table clients
    (id bigint auto_increment primary key
    ,first_name varchar
    ,last_name varchar
    ,holder_name varchar
    );

create table accounts
    (id bigint auto_increment primary key
    ,number varchar(20)
    ,currency_code varchar(3)
    ,balance decimal(38,0)
    ,client_id bigint not null references clients(id) on delete cascade on update cascade
    );

create table cards
  ( id bigint auto_increment primary key
  , number varchar
  , holder_name varchar
  , expiration_year int
  , expiration_month int
  , pin_code varchar
  , security_code varchar
  , client_id bigint not null references clients(id) on delete cascade on update cascade
  , account_id bigint not null references accounts(id) on delete cascade on update cascade
  );

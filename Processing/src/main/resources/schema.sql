drop table if exists accounts CASCADE;
drop table if exists cards CASCADE;
drop table if exists clients CASCADE;

create table clients
    (id bigint auto_increment primary key
    ,first_name varchar not null
    ,last_name varchar
    ,holder_name varchar(50)
    );

create table accounts
    (id bigint auto_increment primary key
    ,number varchar(20) not null
    ,currency_code varchar(3) not null
    ,balance decimal(38,0) not null default 0
    ,client_id bigint not null references clients(id) on delete cascade on update cascade
    );

create table cards
  ( id bigint auto_increment primary key
  , number varchar not null
  , holder_name varchar(50) not null
  , expiration_date date not null
  , pin_code varchar not null
  , security_code varchar not null
  , client_id bigint not null references clients(id) on delete cascade on update cascade
  , account_id bigint not null references accounts(id) on delete cascade on update cascade
  );

insert into clients (id, first_name, last_name, holder_name) values
 (1, 'Иван', 'Иванов', 'IVAN IVAONOV')
,(2, 'Пётр', 'Петров', 'PITER PETROV')
,(3, 'Александр', 'Сидоров', 'ALEKSANDR SIDOROV')
,(4, 'Леонид', 'Кукушкин', 'LEONID KUKUSHKIN')
;

insert into accounts (id, number, currency_code, balance, client_id) values
 (1, '0000000000000000010' ,'RUB' , 1000, 1) -- счет Ивана Иванова
,(2, '0000000000000000020' ,'TUG' , 2000, 1) -- счет Ивана Иванова
,(3, '0000000000000000030' ,'RUB' , 3000, 2) -- счет Петра Петрова
,(4, '0000000000000000040' ,'RUB' , 4000, 3) -- счет Александра Сидорова
;

insert into cards (id, number, holder_name, expiration_year, expiration_month, pin_code, security_code, client_id, account_id) values
  (1, '1234123412340001' ,'IVAN IVAONOV'      , year(current_date)-1, 1, '0001', '100', 1, 1) -- истек срок действия
 ,(2, '1234123412340002' ,'IVAN IVAONOV'      , year(current_date)+1, 2, '0002', '200', 1, 1) -- активная к своему счету Ивана Иванова
 ,(3, '1234123412340003' ,'IVAN IVAONOV'      , year(current_date)+1, 3, '0003', '300', 1, 3) -- активная к чужому счету Петра Петрова
 ,(4, '1234123412340004' ,'PITER PETROV'      , year(current_date)+1, 4, '0004', '400', 3, 3) -- активная к своему счету Петра Петрова
 ,(5, '1234123412340005' ,'ALEKSANDR SIDOROV' , year(current_date)+1, 5, '0005', '500', 4, 4) -- активная к своему счету Александра Сидорова
;

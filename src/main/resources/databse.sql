create database accountingProgram1 CHARACTER SET utf8;
use accountingProgram1;
insert into vat (percents, value) values ('0%', 1.00), ('5%', 1.05), ('8%', 1.08), ('23%', 1.23);
insert into invoice_direction (direction) values ('sell'), ('buy');

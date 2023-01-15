drop database if exists bancoHoras;
create database bancoHoras;
use bancoHoras;

create table usuarioAdm (
	re		int				primary key not null,
    senha	varchar(100)	not null
);

create table papamike (
	re		int				primary key not null unique,
    horas	decimal(8,1)
);

create table addHora (
	re		int		not null,
    data	date,
	horas	decimal(8,1),
    obs		varchar(140)
);

create table subHora (
	re		int		not null,
	data	date,
	horas	decimal(8,1),
    obs		varchar(140)
);

delimiter $
create procedure addHora (
	
    re		int,
    data	date,
	horas	decimal(8,1),
    obs		varchar(140)
    )
    begin
		insert ignore into papamike (re, horas) 
        values (re, horas);
		update papamike set horas = papamike.horas + horas where re = papamike.re;
        insert into addHora values(re, data, horas, obs);
	end$
delimiter ;

delimiter $
create procedure subHora (
	
    re		int,
    data	date,
	horas	decimal(8,1),
    obs		varchar(140)
    )
    begin
		insert ignore into papamike (re, horas) 
        values (re, horas);
		update papamike set horas = papamike.horas - horas where re = papamike.re;
        insert into subHora values(re, data, horas, obs);
	end$
delimiter ;
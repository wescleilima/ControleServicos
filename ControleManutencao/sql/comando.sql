-- SQL
-- linguagem de consulta esctruturada
-- comando de DDL
-- linguagem de defini√ß√£o de dados 
create database controle_manutencao;
show databeses;
use controle_manutencao;
create table quadro(
-- chave primaria
-- c√≥digo unico dentro da tabela
cod 		   int primary key auto_increment,
descricao  varchar(100),
status         varchar(10),
local          varchar(20),
responsavel   varchar(25),
dt_inicio   varchar(8),
dt_fim   varchar(8)

);
show tables;
desc quadro;

-- DML (Linguagem de manipulaÁ„o de dados)
-- insert - update - delete
insert into quadro(
	descricao   ,
	status      ,
	local       ,
	responsavel ,
	dt_inicio   ,
	dt_fim      ,
	)
values ('Vazamento',
		'Agendado',
		'Quarto 10',
		'Andre',
		'05/06/2019',
		'06/06/2019'
		);

-- consulta no banco de dados
select * from quadro;


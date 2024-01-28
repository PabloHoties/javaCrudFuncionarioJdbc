create table funcionario(
			id			uuid			primary key,
			nome		varchar(100)	not null,
			cpf			varchar(14)		not null,
			matricula	varchar(10)		not null,
			salario		decimal(10, 2)	not null);
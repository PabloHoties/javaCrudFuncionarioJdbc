CREATE TABLE  funcionario(
			id			UUID				PRIMARY KEY,
			nome		VARCHAR(100)	NOT NULL,
			cpf			VARCHAR(14)		NOT NULL,
			matricula	VARCHAR(10)		NOT NULL,
			salario		DECIMAL(10, 2)	NOT NULL);
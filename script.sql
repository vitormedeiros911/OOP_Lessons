
CREATE TABLE Estado (
	id    INTEGER      NOT NULL PRIMARY KEY,
	nome   VARCHAR(255) NOT NULL,
	uf  VARCHAR(2)      NOT NULL, 
);

CREATE TABLE Cidade (
	id    INTEGER      NOT NULL PRIMARY KEY,
	nome  VARCHAR(45)  NOT NULL,
	idEstado INTEGER NOT NULL,
	FOREIGN KEY (idEstado) REFERENCES Estado (id)
);

CREATE TABLE Cliente (
	id INTEGER      NOT NULL PRIMARY KEY,
	nome       VARCHAR(255) NOT NULL,
	telefone   VARCHAR(50),
	email      VARCHAR(10), 
	cpf        VARCHAR(11),
	logradouro VARCHAR(50),
	bairro     VARCHAR(05),
	cep        VARCHAR(14),
	idCidade          INTEGER     NOT NULL,
	ativo      CHAR(1)     NOT NULL CHECK (UPPER(ATIVO_CLIENTE) IN ('S', 'N')),
	FOREIGN KEY (idCidade) REFERENCES Cidade(idCidade)
);

CREATE TABLE Fornecedor (
	id      INTEGER      NOT NULL PRIMARY KEY,
	nome    VARCHAR(45)  NOT NULL,
	telefone VARCHAR(45), 
	email VARCHAR(45),  
	cnpj VARCHAR(14), 
	ativo    CHAR(1)      NOT NULL CHECK (UPPER(ATIVO_CLIENTE) IN ('S', 'N')),
	
);

CREATE TABLE Produto (
	id    INTEGER NOT  NULL PRIMARY KEY,
	nome   VARCHAR(255) NOT NULL,
	preco  FLOAT        NOT NULL,
	codigo CHAR(13),
);

CREATE TABLE Pedido (
	id INTEGER NOT NULL PRIMARY KEY,
	idProduto INTEGER NOT NULL,
	idCliente INTEGER NOT NULL,
	quantidade INTEGER NOT NULL,
	valor_total INTEGER NOT NULL,
	desconto INTEGER,
	criadoEm DATETIME,
	status 	VARCHAR(45),
	FOREIGN KEY (idProduto) REFERENCES Produto(idProduto)
	FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente)
);


CREATE GENERATOR G_ESTADO;
CREATE GENERATOR G_CIDADE;
CREATE GENERATOR G_CLIENTE;
CREATE GENERATOR G_FORNECEDOR;
CREATE GENERATOR G_PRODUTO;

----------------------------------------------------------------------------------------------------------


INSERT INTO ESTADO VALUES (GEN_ID(G_ESTADO, 1), 'PARANÁ',    'PR', 'S');
INSERT INTO ESTADO VALUES (GEN_ID(G_ESTADO, 1), 'SÃO PAULO', 'SP', 'S');


INSERT INTO CIDADE VALUES (GEN_ID(G_CIDADE, 1), 'UMUARAMA', 1, 'S');
INSERT INTO CIDADE VALUES (GEN_ID(G_CIDADE, 1), 'CAMPINAS', 2, 'S');
INSERT INTO CIDADE VALUES (GEN_ID(G_CIDADE, 1), 'CURITIBA', 1, 'S');
INSERT INTO CIDADE VALUES (GEN_ID(G_CIDADE, 1), 'SOROCABA', 2, 'S');


INSERT INTO CLIENTE VALUES (GEN_ID(G_CLIENTE, 1), 'CLIENTE A',          NULL,   NULL,     NULL,       NULL,        NULL,                 NULL,          NULL,             NULL,             NULL, 4, 'S');
INSERT INTO CLIENTE VALUES (GEN_ID(G_CLIENTE, 1), 'CLIENTE B',            '',     '',       '',         '',          '',                   '',            '',               '',               '', 1, 'N');
INSERT INTO CLIENTE VALUES (GEN_ID(G_CLIENTE, 1), 'CLIENTE C',       'RUA A',  '123', 'AP. 31', 'BAIRRO A', '12345-789',     '123.456.789-01', '9.876.543-2',  '(12)3456-7890', '(12)98765-4321', 4, 'N');
INSERT INTO CLIENTE VALUES (GEN_ID(G_CLIENTE, 1), 'CLIENTE D',       'RUA B', '3876',       '', 'BAIRRO B', '56789-540', '32.123.456/0001-84', '12.324.658-4', '(44)5342-7659', '(44)93246-4687', 1, 'S');
INSERT INTO CLIENTE VALUES (GEN_ID(G_CLIENTE, 1), 'CLIENTE E',            '',     '',       '',         '',          '',                   '',             '',              '',               '', 3, 'N');


INSERT INTO FORNECEDOR VALUES (GEN_ID(G_FORNECEDOR, 1), 'FORNECEDOR A',    NULL,   NULL,     NULL,       NULL,        NULL,                 NULL,           NULL,            NULL,             NULL, 1, 'N');
INSERT INTO FORNECEDOR VALUES (GEN_ID(G_FORNECEDOR, 1), 'FORNECEDOR B',      '',     '',       '',         '',          '',                   '',             '',              '',               '', 2, 'S');
INSERT INTO FORNECEDOR VALUES (GEN_ID(G_FORNECEDOR, 1), 'FORNECEDOR C', 'RUA A',  '123',       '', 'BAIRRO A', '12345-789',     '123.456.789-01',  '9.876.543-2', '(12)3456-7890', '(12)98765-4321', 3, 'S');
INSERT INTO FORNECEDOR VALUES (GEN_ID(G_FORNECEDOR, 1), 'FORNECEDOR D', 'RUA B', '3876', 'AP. 40', 'BAIRRO B', '56789-540', '32.123.456/0001-84', '12.324.658-4', '(44)5342-7659', '(44)93246-4687', 4, 'N');
INSERT INTO FORNECEDOR VALUES (GEN_ID(G_FORNECEDOR, 1), 'FORNECEDOR E',      '',     '',       '',         '',          '',                   '',             '',              '',               '', 3, 'N');


INSERT INTO PRODUTO VALUES (GEN_ID(G_PRODUTO, 1), 'PRODUTO A', 100.0,              '',  50.0, 'S');
INSERT INTO PRODUTO VALUES (GEN_ID(G_PRODUTO, 1), 'PRODUTO B', 200.0,            NULL,   0.0, 'N');
INSERT INTO PRODUTO VALUES (GEN_ID(G_PRODUTO, 1), 'PRODUTO C', 35.50, '7896190012342', 150.0, 'S');
INSERT INTO PRODUTO VALUES (GEN_ID(G_PRODUTO, 1), 'PRODUTO D', 83.10,              '',   5.0, 'S');
INSERT INTO PRODUTO VALUES (GEN_ID(G_PRODUTO, 1), 'PRODUTO E',  12.0,              '',  40.0, 'S');






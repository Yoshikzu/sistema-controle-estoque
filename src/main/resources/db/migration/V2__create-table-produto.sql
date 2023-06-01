CREATE TABLE produto(
        id serial not null,
        nome character varying(100),
        codigo_barras character varying(100),
        quantidade_minima integer,
        saldo_inicial integer,
        data_cadastro date not null,
        primary key(id)
)
CREATE TABLE movimentacao(
        id serial not null,
        produto_id int not null,
        tipo_movimento character varying(100),
        quantidade integer,
        data_movimentacao date not null,
        primary key(id)
)
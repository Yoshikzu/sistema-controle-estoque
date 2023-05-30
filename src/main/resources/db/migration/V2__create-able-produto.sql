CREATE TABLE produto(
        id serial not null,
        nome character varying(100),
        codigobarras character varying(100),
        quantidademinima integer,
        saldoinicial integer,
        datacadastro datetime not null,
        primary key(id)
)
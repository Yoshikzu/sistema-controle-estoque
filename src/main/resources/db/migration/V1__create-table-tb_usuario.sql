CREATE TABLE tb_usuario(
        id serial not null,
        nivelusuario character varying(100),
        nome character varying(100),
        email character varying(100),
        login character varying(100) not null,
        senha character varying(255) not null,
        primary key(id)
)
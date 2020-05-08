create table usuario (
    id_user bigint not null auto_increment,
    nome varchar(60) not null,
    sobrenome varchar (60) not null,
    sexo enum('M','F'),
    data_nascimento date,
    telefone varchar(15),
    email varchar(60) not null,
    status enum('ATIVO','INATIVO') not null,
    endereco_id bigint,

    primary key (id_user)
);


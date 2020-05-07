create table usuario (
    id bigint not null auto_increment,
    nome varchar(60) not null,
    sobrenome varchar (60) not null,
    data_nascimento datetime not null,
    telefone varchar(20) not null,
    email varchar(60) not null,
    status varchar(20) not null,

    primary key (id)
);
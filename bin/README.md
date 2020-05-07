# Spring Rest - Projeto Integrador CIS

Serviço em desenvolvimento

## Passos iniciais

Recomendo utilizar alguma IDE [Spring Tools](https://spring.io/tools).

### Pre-requisitos

```
- JDK 11
- Wamp
- Postman
- WorkBench
```

### Configurações de Persistência de Dados

Para configurar o banco de dados com o Spring, abra o arquivo **application.properties** que está no diretório 
**_src/main/resourse/_** e adicione as seguintes linhas. 

```
spring.datasource.url=jdbc:mysql://localhost:3308/osworks?createDatabaseIfNotExist=true&serverTimezone=UTC
spring.datasource.username=nomedeusuario
spring.datasource.password=senhadobanco
```
**ATENÇÃO:** a porta default do banco de dados é 3306, no meu caso a porta utilizada é **3308** porque na porta default
foi configurado para o banco de dados mariaDB de maneira automática pelo próprio WAMP durante a sua instalação.

### Configuração Flyway

Flyway é uma ferramenta que ajuda na organizar dos scripts SQL para que possam ser versionadas.
Alem da possibilidade versionamento de banco de dados, há outros benefícios como os listado a baixo.

* Sincronizar o banco de dados com a versão da aplicação;
* Saber quais scripts SQL foram executados ou não;
* Automatizar a execução dos scripts;
* Criar um banco de dados do zero;
* Permite criar um rollback de mudanças no banco de dados (útil em casos raros).

####  Configurando o Flyway via script

crie o diretório **_src/main/resourse/db/migration_** para adicionar todas instruções de comandos SQL.
No diretório criado adicione as instruções sql com o nome **V001__cria-tabela-cliente.sql** 

**Importante:** 
Todo arquivo.sql deve iniciar com **V** + **o numero da versao** + **__** (2 underscore).
[Ver mais informações](https://flywaydb.org/documentation/migrations#naming)

Ex:

```
V001__o-que-essa-instrucao-faz.sql
V002__o-que-essa-instrucao-faz.sql
V003__o-que-essa-instrucao-faz.sql
V004__o-que-essa-instrucao-faz.sql
```

#### Instrução SQL para criar a tabela cliente
```
create table cliente (
	id bigint not null auto_increment,
    nome varchar(60) not null,
    email varchar(255) not null,
    telefone varchar(20) not null,
    
    primary key (id)
);
```

#### Instrução SQL para criar a tabela ordem de servico
```
create table ordem_servico(
	id bigint not null auto_increment,
    cliente_id bigint not null,
    descricao text not null,
    preco decimal(10,2) not null,
    status varchar(20) not null,
    data_abertura datetime not null,
    data_finalizacao datetime,
    
    primary key (id) 
);

alter table ordem_servico add constraint fk_ordem_servico_cliente 
foreign key (cliente_id) references cliente (id);
```

#### Instrução SQL para criar a tabela comentario
```
create table comentario(
	id bigint not null auto_increment,
    ordem_servico_id bigint not null,
	descricao text not null,
    data_envio datetime not null,
	
    primary key (id)
);

alter table comentario add constraint fk_comentario_ordem_servico
foreign key (ordem_servico_id) references ordem_servico (id);
```

## Alguns links de recursos utilizados

* [HTTP_Status](https://developer.mozilla.org/pt-BR/docs/Web/HTTP/Status) - Significado de códigos de status HTTP
* [Spring Data JPA](https://maven.apache.org/) - Para implementação de repositórios baseados JPA
* [ModelMapper](https://rometools.github.io/rome/) -  framework que realiza o mapeamento de objetos de forma inteligente
* [SpringBoot-devtools](https://docs.spring.io/spring-boot/docs/1.5.16.RELEASE/reference/html/using-boot-devtools.html) -  ferramenta responsável pelo restart automático da aplicação a cada alteração.
* [Flyway Migration](https://flywaydb.org/) -  Controle de versão para banco de dados


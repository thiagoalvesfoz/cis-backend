# Spring Rest - Projeto Integrador CIS

Serviço em desenvolvimento

## Passos iniciais

Recomendo utilizar alguma IDE [Spring Tools](https://spring.io/tools).

### Pre-requisitos

```
- JDK 11
- Wamp
- Postman
- WorkBench (Opcional)
```

### Configurações de Persistência de Dados

Para configurar o banco de dados com o Spring, abra o arquivo **application.properties** que está no diretório 
**_src/main/resourse/_** e adicione as seguintes linhas. 

```
spring.datasource.url=jdbc:mysql://localhost:3308/projeto_cis?createDatabaseIfNotExist=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=
```
**ATENÇÃO:** a porta default do banco de dados é 3306, no meu caso a porta utilizada é **3308** porque na porta default
foi configurado para o banco de dados mariaDB de maneira automática pelo próprio WAMP durante a sua instalação.


## Tecnologias Utilizadas
```
* Spring Boot
* Spring Data JPA
* Apache Tomcat
* Mavem
* Postman
* MySQL
* Java JDK 11
```


## Alguns links de recursos utilizados

* [HTTP_Status](https://developer.mozilla.org/pt-BR/docs/Web/HTTP/Status) - Significado de códigos de status HTTP
* [Spring Data JPA](https://maven.apache.org/) - Para implementação de repositórios baseados JPA
* [ModelMapper](https://rometools.github.io/rome/) -  framework que realiza o mapeamento de objetos de forma inteligente
* [SpringBoot-devtools](https://docs.spring.io/spring-boot/docs/1.5.16.RELEASE/reference/html/using-boot-devtools.html) -  ferramenta responsável pelo restart automático da aplicação a cada alteração.


# Spring Rest - Projeto Integrador CIS

Serviço em desenvolvimento

## Passos iniciais

Recomendo utilizar alguma IDE [Spring Tools](https://spring.io/tools).

### Pre-requisitos

```
- JDK 11
- H2 Database
- Postman
```

## Clonando e configurando o projeto pelo Eclipse
- - -

1. #### Fork do projeto:  
1.1. Clique em `FORK` ou [clique aqui](https://github.com/thiagoalvesfoz/cis-backend/fork "Fork do cis-backend");  
1.2. Uma cópia do projeto será feita e você será redirecionado para o seu perfil;    
1.3. Localize o projeto no seu repositório e clique em clone. 

2. #### Clone seu fork pelo Eclipse:
2.1. Abra seu Eclipse;   
2.2. Acesse `File > Import...`          
2.3. Escolha a opção `Projects from Git`       
2.4. Escolha a opção `Clone URI`;  
    `Os campos referente a localização devem ser preenchidos automaticamente. Caso contrário, retorne ao item 1.3.`    
2.5. Clique em Next;  
2.6. Em `Local destination` você pode alterar o local onde o projeto será clonado, definindo por exemplo seu workspace;  
2.7. Em `Select a wizard to use importing projects` escolha a opção `Import as general project` 
2.8. Finish.

3. #### Configurando como Maven Project:
3.1. Clique com o botão direito sobre o projeto e escolha a opção `Configure > Convert to Maven Project`      
3.2. Espere o download de todas as dependecias do projeto


Se tudo ocorreu conforme o esperado você está pronto para executar o projeto.
- - -

### Configurações de Persistência de Dados

Para configurar o banco de dados H2, abra o arquivo **application-test.properties** que está no diretório 
**_src/main/resourse/_**. 

```
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=test
spring.datasource.password=

spring.h2.console.enabled=true
spring.h2.console.path=/h2
```
**URL DO BANCO** localhost:8080/h2

- - -
## Tecnologias Utilizadas
```
* Spring Boot
* Spring Data JPA
* Apache Tomcat
* H2 Database
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


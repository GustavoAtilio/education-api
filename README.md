# education-api

## Tecnologias Versão 
```
Java: 17.0.5
Postgres: 15.1
Docker: 20.10.21
```

## Banco de dados no docker
```
docker run --name api_education -e POSTGRES_PASSWORD=3sBZ1LXvdwu2ma6J -p 5432:5432 -d postgres
```
## Criar banco de dados 
```
create database api_education;
```

### Arquivo backup SQL api_education_sql.sql

### Arquivo postman presente na raiz do projeto api_education.postman_collection.json

### Executar Projeto
```
java -jar education-api-0.0.1-SNAPSHOT.jar
```

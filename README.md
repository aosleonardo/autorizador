
# Autorizador de pagamentos

![java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![docker](https://img.shields.io/badge/-Docker-black?style=for-the-badge&logo=docker)

A VR processa todos os dias diversas transações de Vale Refeição e Vale Alimentação, entre outras.
De forma breve, as transações saem das maquininhas de cartão e chegam até uma de nossas aplicações, conhecida como *autorizador*, que realiza uma série de verificações e análises. Essas também são conhecidas como *regras de autorização*.


## Autores

- [@Leonardo Oliveira](https://www.linkedin.com/in/leonardo-augusto-oliveira-silva-41b7aa23/)


## Referência

- [Chain of Responsibility](https://refactoring.guru/pt-br/design-patterns/chain-of-responsibility)


## Funcionalidades

- Criar novo cartão
- Obter saldo do Cartão
- Realizar uma Transação

## Documentação

### Diagramas

#### Modelagem do banco de dados
![dataBase.png](tools%2Fdrawio%2FdataBase.png)

#### Modelo da API de Transações
![transacoes.png](tools%2Fdrawio%2Ftransacoes.png)

### Swagger-iu
Execute a aplicação

```bash
mvn clean package spring-boot:run
```

Abra a URL no seu navegador

http://localhost:8080/swagger-ui/index.html#

## Stack utilizada

**Back-end:** Java 21

**DataBase:** MySql, MongoDB

**Infraestrutura:** Docker


## Documentação da API

#### Criar novo cartão

```http
  POST  /cartoes
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `numeroCartao` | `string` | **Obrigatório**. |
| `senha` | `string` | **Obrigatório**. |

#### Obter saldo do Cartão

```http
  GET /cartoes/{numeroCartao}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `numeroCartao`      | `string` | **Obrigatório**. 

#### Realizar uma Transação

```http
  POST /transacoes
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `numeroCartao`      | `string` | **Obrigatório**. 
| `senhaCartao`      | `string` | **Obrigatório**.
| `valor`      | `Long` | **Obrigatório**.

## Instalação

Instale my-project com npm

```bash
  npm install my-project
  cd my-project
```

## Deply Docker


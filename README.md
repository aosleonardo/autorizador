
# Autorizador de pagamentos

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

## Melhorias

Que melhorias você fez no seu código? Ex: refatorações, melhorias de performance, acessibilidade, etc


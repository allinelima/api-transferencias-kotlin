# API Transferências - Kotlin

## Descrição

Esta API foi desenvolvida para realizar transferências entre contas bancárias, utilizando **Kotlin** e **Spring Boot** com um banco de dados **H2** em memória. A API suporta as operações básicas de cadastro de clientes, consulta de contas, transferência de valores entre contas e visualização de transferências realizadas.

## Tecnologias Utilizadas

- **Kotlin** como linguagem principal.
- **Spring Boot** para construção da API REST.
- **H2 Database** para armazenamento em memória.
- **JUnit** para testes unitários.
- **Gradle** como gerenciador de dependências.

## Funcionalidades

A API oferece os seguintes endpoints:

### 1. Cadastrar Cliente

Cadastra um cliente com as seguintes informações: `nome`, `número da conta` e `saldo`.

- **Endpoint:** `POST /clientes`
- **Body:**
    ```json
    {
        "nome": "João Silva",
        "numeroConta": "12345",
        "saldo": 100.0
    }
    ```
- **Resposta (sucesso):**
    ```json
    {
        "id": 1,
        "nome": "João Silva",
        "numeroConta": "12345",
        "saldo": 100.0
    }
    ```

### 2. Listar Todos os Clientes

Recupera todos os clientes cadastrados na base de dados.

- **Endpoint:** `GET /clientes`
- **Resposta (sucesso):**
    ```json
    [
        {
            "id": 1,
            "nome": "João Silva",
            "numeroConta": "12345",
            "saldo": 100.0
        },
        {
            "id": 2,
            "nome": "Maria Oliveira",
            "numeroConta": "67890",
            "saldo": 150.0
        }
    ]
    ```

### 3. Buscar Cliente por Número da Conta

Busca um cliente utilizando o número da conta bancária.

- **Endpoint:** `GET /clientes/{numeroConta}`
- **Exemplo de URL:** `GET /clientes/12345`
- **Resposta (sucesso):**
    ```json
    {
        "id": 1,
        "nome": "João Silva",
        "numeroConta": "12345",
        "saldo": 100.0
    }
    ```
- **Resposta (não encontrado):**
    ```json
    {
        "error": "Cliente não encontrado"
    }
    ```

### 4. Realizar Transferência

Realiza uma transferência entre duas contas, verificando se a conta de origem tem saldo suficiente e se o valor da transferência é inferior a R$ 100.

- **Endpoint:** `POST /clientes/transferir`
- **Parâmetros de Query:**
    - `origem`: Número da conta de origem.
    - `destino`: Número da conta de destino.
    - `valor`: Valor da transferência (máximo de R$ 100).

  **Exemplo de request:**
  ```bash
  POST /clientes/transferir?origem=12345&destino=67890&valor=50.0

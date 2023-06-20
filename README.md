# Payment Service

O Payment Service é responsável pelo processamento de pagamentos e recebimentos.

## Descrição

O Payment Service é um microserviço independente que oferece funcionalidades para processar transações financeiras de pagamentos e recebimentos.

## Requisitos do Sistema

- Java 17: [Instalar Java 17](https://www.oracle.com/java/technologies/downloads/)
- Maven: [Instalar Maven](https://maven.apache.org/install.html)
- Docker: [Instalar Docker](https://docs.docker.com/get-docker/)
- Docker Compose: [Instalar Docker Compose](https://docs.docker.com/compose/install/)

Certifique-se de ter os requisitos acima instalados e configurados corretamente em seu ambiente.

## Integrações

O Payment Service se integra com os seguintes serviços:

- Account Management Service: responsável pelo gerenciamento de contas de usuários.
- Transaction Service: responsável pelo histórico de transações financeiras.

## Construindo o Projeto

Para construir o microserviço Payment, siga as etapas abaixo:

1. Certifique-se de ter o Java 17 e o Maven instalados e configurados corretamente em seu ambiente.
2. Navegue até a raiz do projeto.
3. Execute o seguinte comando para construir o projeto:

  ```bash
   mvn clean package
  ```

  ```bash
   docker build -t payment-management .
  ```

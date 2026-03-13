# Kafka Example

Projeto educacional para praticar e entender como implementar o Apache Kafka com Spring Boot. O exemplo simula um fluxo de pedidos: o **Producer** cria um pedido e publica no Kafka, o **Consumer** escuta o topic, processa o pedido e atualiza o status.

## Tecnologias

- Java 21 · Spring Boot · Apache Kafka · Spring Data JPA · H2 · Maven

## Pré-requisitos

- Java 21+
- Maven
- Docker e Docker Compose

## Como rodar

**1. Suba a infraestrutura Kafka**
```bash
docker-compose up -d
```

**2. Inicie o Consumer** (porta 8081)
```bash
cd kafka-example-consumer
mvn spring-boot:run
```

**3. Inicie o Producer** (porta 8082)
```bash
cd kafka-example-producer
mvn spring-boot:run
```

## Fluxo do sistema

1. Crie um pedido via `POST /producer/order` passando o `idProduct`
2. O Producer salva o pedido com status `AGUARDANDO_PAGAMENTO` e publica no topic `pedidos-topic`
3. O Consumer recebe a mensagem, calcula o total e salva o pedido com status `PAGO`

> Um produto padrão já é inserido automaticamente via `data.sql`. Para consultá-lo: `GET http://localhost:8082/producer/product`

## Interfaces úteis

| | URL |
|---|---|
| Kafka UI | http://localhost:8080 |
| H2 Producer | http://localhost:8082/h2-console |
| H2 Consumer | http://localhost:8081/h2-console |

> JDBC URL do H2: `jdbc:h2:mem:pedidosdb`

## Postman

Importe o arquivo `kafka-example-producer.postman_collection.json` para testar os endpoints.

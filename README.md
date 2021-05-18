# AforoTest-Invoice
El microservicio de invoices, debe listar las facturas de clientes y además debe consumir una cola para cambiar el estado de la factura cuando esta se paga a través del microservicio de pago.

## Instalación
Todos los microservicios deben estar demtro de la RED aforo255-test

```bash
docker network create aforo255-test
```

Este Microservicio Maneja una conexión a una Base de datos PostgreSql por lo que se debe instalar su respectiva Imagen

```bash
docker run -p 5432:5432  --name test-postgres --network aforo255-test -e POSTGRES_PASSWORD=123456 -e  POSTGRES_DB=db_invoice -d postgres:12-alpine
```

Este Microservicio se conecta al Broker Kafka, para cambiar el estado de las facturas cuando sean pagadas desde el microservio de pago, por lo que se utiliza la siguiente imagen:

```bash
docker run -p 2181:2181 -d -p 9092:9092 --name test-servicekafka --network aforo255-test -e ADVERTISED_HOST=127.0.0.1  -e NUM_PARTITIONS=3 johnnypark/kafka-zookeeper
```

Finalmente para instalar el Microservicio, se debe ejecutar el archivo [test-invoice.sh](https://github.com/jhonariza03/AforoTest-Invoice/blob/main/test-ms-invoice/test-invoice.sh) que se encuentra en la raiz del proyecto

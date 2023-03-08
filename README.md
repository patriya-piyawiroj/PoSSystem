# E-commerce PoS System
A Kotlin gRPC PoS backend system for making payments. 

## Quickstart

### Start Postgres database

  ```sh
  docker-compose up
  ```
By default, the server will be started on localhost:5432. However, this can be configured in [docker-compose.yml](/docker-compose.yml)

Database configuration details can be found under [docs/database.md](docs/database.md)

### Run Server
  ```sh
  ./gradlew :server:PaymentServer
  ```
Payment server will start on localhost:50051. This is configurable in [config/application.yaml](/server/src/main/kotlin/payment/config/application.yaml) 

API descriptions can be found at [docs/api.md](docs/api.md)

### Test
To run unit tests and output coverage [build/report/kover/html/index.html](/server/build/report/kover/html/index.html):

 ```sh
  ./gradlew :server:koverHtmlReport
  ```

Or download a gRPC Client such as Ezy and import the proto files at [protos/src/main/proto](protos/src/main/proto/payment/payment.proto):

![Screen Shot 2566-03-09 at 00.06.24.png](..%2F..%2FDesktop%2FScreen%20Shot%202566-03-09%20at%2000.06.24.png)



## Sub-directories 
#### Project
```agsl
├── PoSSystem
    ├── data         # database seed data
    ├── docs         # detailed documentation
    ├── protos       # proto definitions
    ├── scripts      # startup scripts, including database creation
    ├── server       # gRPC payment service server
    └──  stub         # generated gRPC method stubs
```

#### server
```agsl
├── payment
    ├── config          # application configurations
    ├── dao             # interface for accessing repository
    ├── dto             # data models
    ├── repository      # Postgres repository implementations
    ├── server          # where the main application is run
    ├── service         # gRPC service implementatinos
    └── utils           # utitlity function include time convertors
```

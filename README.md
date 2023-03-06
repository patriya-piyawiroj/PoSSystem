# gRPC Kotlin examples

TODO:
- Put pool sizing and configurations in DB docs and config file
- Describe dependencies and frameowkrs
- Try to validate the fields in request response
- Load balancing https://www.vinsguru.com/grpc-load-balancing-with-nginx/
- Log errors
- Migrate to Spring for Db management https://kotlinlang.org/docs/jvm-spring-boot-using-crudrepository.html
- Request validators
- Load setting from application.yaml
- Pass connection in as a string to service
- Stackdriver logging + Confluence documentation + Swagger docs
- Unit tests

## Examples

This directory contains several Kotlin gRPC examples. You can find detailed
instructions for building and running the two main examples from the [grpc.io
Kotlin/JVM][] pages:

- **Greeter** ("hello world"): for details, see [Quick start][].
- **Route guide**: for details, see [Basics tutorial][]

Instructions for the remaining examples are provided below.

## File organization

The example sources are organized into the following top-level folders:

- [protos][]: `.proto` files (shared across examples)
- [stub][]: regular Java & Kotlin stub artifacts from [protos][]
- [stub-lite][]: lite Java & Kotlin stub artifacts from [protos][]
- [stub-android][]: Android-compatible Java & Kotlin stub artifacts from [protos][]
- [client](client): Kotlin clients based on regular [stub][] artifacts
- [server](server): Kotlin servers based on regular [stub][] artifacts
- [native-client](native-client) : GraalVM Native Image clients based [stub-lite][]
- [android](android): Kotlin Android app based on [stub-android][]

## Instructions for running other examples

- <details>
  <summary>Multiple-services animals example</summary>

  Start the server:

  ```sh
  ./gradlew :server:AnimalsServer
  ```

  In another console, run the client against the "dog", "pig", and "sheep" services:

  ```sh
  ./gradlew :client:AnimalsClient --args=dog
  ./gradlew :client:AnimalsClient --args=pig
  ./gradlew :client:AnimalsClient --args=sheep
  ```
  </details>
  

[Basics tutorial]: https://grpc.io/docs/languages/kotlin/basics/
[grpc.io Kotlin/JVM]: https://grpc.io/docs/languages/kotlin/
[protos]: protos
[Quick start]: https://grpc.io/docs/languages/kotlin/quickstart/
[stub]: stub
[stub-android]: stub-android
[stub-lite]: stub-lite

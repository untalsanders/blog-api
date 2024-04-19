# Blog RESTful API

## :checkered_flag: How To Start

   1. Install Java 17, go link for install [SDKMAN](https://sdkman.io/install)

      ```shell
      sdk install java x.y.z-vendor
      ```

   2. Set it as your default JVM

      ```shell
      export JAVA_HOME='$HOME/.sdkman/candidates/java/current'
      ```

   3. Clone this repository:

      ```shell
      git clone https://github.com/untalsanders/blog-api.git
      ```

   4. Run application

      ```shell
      # Dev Environment
      ./gradlew bootRun --args='--spring.profiles.active=dev --server.port=8080'
      ```
      ```shell
      # Prod Environment
      ./gradlew bootRun --args='--spring.profiles.active=prod --server.port=8080'
      ```

      To `production` you must provide as following variables environment, e.g.

      - DB_HOST=127.0.0.1
      - DB_PORT=5432
      - DB_USER=postgres
      - DB_PASS=12345
      - DB_NAME=my_db

      **Example:**

      ```shell
      # Prod Environment
      DB_HOST=localhost DB_PORT=5432 DB_USER=postgres DB_PASS=12345 DB_NAME=blog ./gradlew bootRun --args='--spring.profiles.active=prod --server.port=8080'
      ```

## :whale: Build and Run with Docker

   1. **Build Image**

      ```shell
      # Build image
      docker build -t sandersgutierrez/blog-api:latest .
      ```

   2. **Run a container**

      ```shell
      # Create and run a container
      docker run -p 8080:8080 --name blog-app \
          --env PORT=8080 \
          --env DB_HOST=localhost \
          --env DB_PORT=5432 \
          --env DB_NAME=blog \
          --env DB_USER=postgres \
          --env DB_PASS=12345 \
          sandersgutierrez/blog-api:latest
      ```

## :wolf: Author

- [Sanders Gutiérrez](https://untalsanders.github.io) - System Engineer (Java Developer)

## :unlock: License

This project is software licensed under the [BSL 1.0 license](LICENSE).

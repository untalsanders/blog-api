# MinData Challenge

## :tea: Introduction

This is a demo application for a challenge in selection process for Java Developer in the company 
[MinData](https://www.linkedin.com/company/mindata/).

## :checkered_flag: How To Start

1. Install Java 17, go link for install [SDKMAN](https://sdkman.io/install)

   ```shell
   sdk install java x.y.z-open
   ```

2. Set it as your default JVM
   ```shell
   export JAVA_HOME='$HOME/.sdkman/candidates/java/current'
   ```
3. Clone this repository:
   ```shell
   git clone https://github.com/sandersgutierrez/challenge-avoristech.git
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

## 👨🏿‍💻 Author

- [Sanders Gutiérrez](https://sandersgutierrez.github.io) - System Engineer (Sr. Java Developer)

## :unlock: License

This project is open-sourced software licensed under the [MIT licence](LICENCE).
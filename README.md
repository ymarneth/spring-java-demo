# A Spring Boot application with Gradle written in Java

## Get the project up and running

### Prerequisites

* OpenJDK 21 ([Eclipse Temurin](https://hub.docker.com/_/eclipse-temurin) distribution recommended)
* [Docker](https://docs.docker.com/install/)
* [node.js](https://nodejs.org/en/download/) (use the latest LTS version)

----------

#### IDE

Recommended IDE is IntelliJ IDEA or Visual Studio Code.

##### IntelliJ IDEA

Initial import: File -> New -> Project from existing sources; choose repository root directory and follow wizard for Gradle project import.


##### Visual Studio Code

Open the project folder in Visual Studio Code.

You will need to install some extensions to run the project:

- [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=vmware.vscode-boot-dev-pack)
- [Gradle for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-gradle)
- [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)


Dependencies should be installed automatically. If not, run a `./gradlew --refresh-dependencies` and `./gradlew build`.

You should then be able to Run the project from SpringJavaDemoApplication.java. Make sure to follow the Configuration Steps first though.

### Backend module

- Windows: `gradlew.bat :spring-java-demo-app:bootRun`
- Linux, macOS: `./gradlew :spring-java-demo-app:bootRun`

or run from your respective IDE.

There is an in-memory h2 database configured. It will start automatically when the application starts. Please be advised, that data is not persisted when the application is stopped.


### UI module

- `cd spring-java-demo-ui`
- Run `npm install` to install all dependencies
- Run `ng serve` to start a local UI-Server
- Open your Browser: http://localhost:4020

The ui is configured to proxy requests to the running backend. Make sure to use the `/api` prefix when building services.


## Running Tests

### Backend Tests

```
gradlew test      # Runs unit tests only
gradlew check     # Runs all tests
```

Or without gradle via the context menu in the IDE (may be faster).

### UI Tests

```
cd spring-java-demo-ui
ng test
```

Or from the context menu in your IDE (may need some configuration)

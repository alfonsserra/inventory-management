# `inventory-management` — Inventory Management projects

This project is an application skeleton for a Inventory Management application.

## Getting Started

To get you started you can simply clone the `inventory-management` repository and install the dependencies:

### Prerequisites

You need [git][git] to clone the `inventory-management` repository.

You will need [Java™ SE Development Kit 8][jdk-download] and [Maven][maven].

### Clone `inventory-management`

Clone the `inventory-management` repository using git:

```bash
git clone https://github.com/alfonsserra/inventory-management.git
cd inventory-management
```

### Install Dependencies

In order to install the dependencies and generate the Uber jar you must run:

```bash
mvn clean install
```

### Run

To launch the server, simply run with java -jar the generated jar file.

```bash
java -jar inventory-management-1.0.jar
```

## API

You will find the swagger UI at http://localhost:8080/swagger-ui.html

## Docker

### Build docker image

There is an Automated Build Task in Docker Cloud in order to build the Docker Image. 
This task, triggers a new build with every git push to your source code repository to create a 'latest' image.
There is another build rule to trigger a new tag and create a 'version-x.y.z' image

You can always manually create the image with the following command:

```bash
docker build -t alfonsserra/inventory-management . 
```

### Run the container

```bash
docker run -e 8080:8080 alfonsserra/inventory-management
```

The app will be available at http://localhost:8080/swagger-ui.html



[git]: https://git-scm.com/
[sboot]: https://projects.spring.io/spring-boot/
[maven]: https://maven.apache.org/download.cgi
[jdk-download]: http://www.oracle.com/technetwork/java/javase/downloads


Check http://www.baeldung.com/jackson-annotations for JSON annotations
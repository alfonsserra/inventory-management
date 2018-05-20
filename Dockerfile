### STAGE 1: Build ###

# We label our stage as 'builder'
FROM maven:alpine as builder

## Storing node modules on a separate layer will prevent unnecessary npm installs at each build
RUN mkdir /inventory-management

WORKDIR /inventory-management

COPY . .

## Build the angular app in production mode and store the artifacts in dist folder
RUN mvn package

### STAGE 2: Setup ###

FROM openjdk:8-jre-alpine


COPY --from=builder /inventory-management/target/inventory-management-1.0.jar inventory-management.jar


CMD ["java","-jar","inventory-management.jar"]

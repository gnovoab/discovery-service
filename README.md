# Overview

Service discovery pattern implementation, where every microservice is registered and a client microservice looks up the Eureka server to get a dependent microservice to get the job done.

### Guides
The following guides illustrates how to use certain features concretely:

* [Service Registration and Discovery](https://microservices.io/patterns/service-registry.html)

### Running the application

* Run `./gradlew build`
* Run `./gradlew bootRun`

### Build and Run Docker container
* `./gradlew build -x test`
* `docker build -f ./Dockerfile -t discovery-service:local .`
* `docker run --rm -it -p 8761:8761 -e spring.profiles.active=default --env MANAGEMENT_PATH=/admin --name discovery-service discovery-service:local` 

### Build and Deploy Docker container in K8 manually
* `./gradlew build -x test`
* `docker build -f ./Dockerfile -t {docker_username}/discovery-service:latest .`     
* `docker push {docker_username}/discovery-service:latest`
* `kubectl create -f ./deployments/{environment_profile}.yml`

### Eureka Dashboard

[http://localhost:8761/](http://localhost:8761/)


### Endpoints documentation

[http://localhost:8761/swagger-ui.html](http://localhost:8761/swagger-ui.html  )  

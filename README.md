# Kafka PubSub Demo

## Overview

This project demonstrates the integration of Spring Boot with Apache Kafka for building a scalable and event-driven architecture. Docker is used for containerization and deployment.

## Prerequisites

- Docker
- Java Development Kit (JDK)
- Maven

## Getting Started

1. **Clone the Repository:**

    ```bash
    git clone https://github.com/Sheersendu/Kafka_PubSub.git
    cd Kafka_PubSub
    ```

2. **Build the Spring Boot Application:**

    ```bash
    mvn clean install
    ```

3. **Start Docker Containers:**

    ```bash
    docker-compose up
    ```

    This will start Zookeeper, Kafka, and the Spring Boot application in separate containers.

4. **Access the Application:**

    The Spring Boot application will be available at [http://localhost:8080](http://localhost:8080). Check the logs for Kafka container to ensure successful initialization.

## Project Structure

- `src/main/java`: Contains the Java source code for the Spring Boot application.
- `docker-compose.yml`: Configuration file for Docker Compose, defining services (Zookeeper, Kafka, Spring App).

## Configuration

- **Spring Boot:**
  - Modify `application.properties` or `application.yml` in the Spring Boot application for specific configurations.
  - Set Kafka bootstrap servers, topics, etc.

- **Docker Compose:**
  - Adjust Kafka container configurations in `docker-compose.yml` if needed.

## Usage

- The Spring Boot application interacts with Kafka. Send requests to the exposed APIs to produce and consume messages.
- Explore the Kafka topics using Kafka tools or your preferred Kafka management tool.

## Cleanup

To stop and remove the containers, run:

```bash
docker-compose down

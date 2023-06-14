FROM eclipse-temurin:20-alpine

LABEL mentainer="arbaazsayed1602@gmail.com"

WORKDIR /app

COPY target/cosmosdb-ops-v1.jar /app/cosmosdb-ops-v1.jar

ENTRYPOINT ["java", "-jar", "cosmosdb-ops-v1.jar"]
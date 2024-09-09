# Etapa 1: Construcción del JAR
FROM maven:3.9.9-openjdk-18 AS builder

# Copia el código fuente al contenedor
WORKDIR /app
COPY . /app

# Construye el archivo JAR
RUN mvn clean package

# Etapa 2: Ejecutar el JAR
FROM openjdk:18-jdk

# Copia el archivo JAR desde la etapa de construcción
COPY --from=builder /app/target/BackendTest-0.0.1-SNAPSHOT.jar /app/BackendTest-0.0.1-SNAPSHOT.jar

# Establece el directorio de trabajo
WORKDIR /app

# Define el comando para ejecutar el JAR
ENTRYPOINT ["java", "-jar", "BackendTest-0.0.1-SNAPSHOT.jar"]

# Etapa 1: Construcción del JAR
FROM maven AS builder

# Establece el directorio de trabajo
WORKDIR /app

# Copia el código fuente al contenedor
COPY . /app

# Construye el archivo JAR
RUN mvn clean package -DskipTests

# Etapa 2: Ejecutar el JAR
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR desde la etapa de construcción
COPY --from=builder /app/target/BackendTest-0.0.1-SNAPSHOT.jar /app/BackendTest-0.0.1-SNAPSHOT.jar

# Define el comando para ejecutar el JAR
ENTRYPOINT ["java", "-jar", "BackendTest-0.0.1-SNAPSHOT.jar"]
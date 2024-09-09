FROM openjdk:17-jdk-slim

# Copia el archivo JAR al contenedor
COPY target/BackendTest-0.0.1-SNAPSHOT.jar /app/BackendTest-0.0.1-SNAPSHOT.jar

# Establece el directorio de trabajo
WORKDIR /app

# Expone el puerto en el que la aplicación Spring Boot se ejecutará
EXPOSE 8080

# Comando para ejecutar la aplicación Spring Boot
ENTRYPOINT ["java", "-jar", "BackendTest-0.0.1-SNAPSHOT.jar"]
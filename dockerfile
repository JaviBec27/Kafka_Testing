# Este Dockerfile crea una imagen de Docker para un proyecto Spring Boot llamado test que usa JDK 17.

# La imagen de base openjdk:17-alpine contiene una instalación de Java 17..
FROM openjdk:17-alpine


# El directorio de trabajo de la imagen es /app.
WORKDIR /app


# El archivo JAR de su proyecto Spring Boot se copia en el directorio de trabajo de la imagen.
COPY target/test-0.0.1-SNAPSHOT.jar /app/app.jar


# El punto de entrada de la imagen es java -jar app.jar, que ejecutará su aplicación Spring Boot.
ENTRYPOINT ["java", "-jar", "app.jar"]



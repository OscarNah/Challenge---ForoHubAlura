# Challenge ForoHub

Este es un desafío en el marco del programa ONE dictado por Alura Latam y Oracle Next Education.

ForoHub es una API diseñada para crear y gestionar tópicos, permitiendo a los usuarios crear, actualizar, listar y eliminar tópicos que se almacenan en una base de datos.

## Funcionalidades
- **Crear Tópico**: Permite crear un nuevo tópico y guardarlo en la base de datos.
- **Listar Tópicos**: Muestra todos los tópicos registrados en la base de datos.
- **Actualizar Tópico**: Actualiza los detalles de un tópico existente.
- **Eliminar Tópico**: Elimina (lógicamente) un tópico de la base de datos.

## Requisitos previos
- Java JDK 8 o superior.
- Maven 3.x.x.
- Base de datos MySQL configurada.

## Instrucciones de instalación
1. Clona este repositorio en tu máquina local:
https://github.com/OscarNah/Challenge---ForoHubAlura
2. Importa el proyecto en tu IDE favorito como un proyecto Maven.
3. Configura tu base de datos en 'application.properties':
```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/<NOMBRE_DE_TU_BD>
spring.datasource.username=<TU_USUARIO>
spring.datasource.password=<TU_CONTRASEÑA>
```
4. Ejecuta la aplicación desde `ForoHubApplication.java`.


## Dependencias utilizadas
- spring-boot-starter-web
- spring-boot-devtools
- lombok
- spring-boot-starter-data-jpa
- flyway-core
- flyway-mysql
- mysql-connector-j
- spring-boot-starter-validation
- spring-boot-starter-security
- java-jwt

## Tecnologías utilizadas
- Java
- Spring Boot
- Hibernate
- Maven
- MySQL

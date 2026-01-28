# 🎮 Biblioteca de Videojuegos - Spring Boot

Este es un proyecto de gestión de videojuegos desarrollado con **Java 17** y **Spring Boot**. La aplicación permite visualizar un catálogo completo de juegos, filtrar por plataforma y ver detalles específicos de cada título.

## 🛠️ Tecnologías utilizadas

* **Backend:** Java 17, Spring Boot 3, Spring Data JPA.
* **Base de Datos:** MySQL (ejecutándose en Docker).
* **Frontend:** Thymeleaf + Bootstrap (Diseño basado en wireframes).
* **ORM:** Hibernate.
* **Gestión de dependencias:** Maven.

## 🚀 Configuración y Ejecución

### 1. Base de Datos (Docker)
Asegúrate de tener un contenedor de MySQL corriendo. La aplicación utiliza una base de datos llamada `Videojuegos` y la tabla `games`.

### 2. Configuración del proyecto
Ajusta las credenciales de tu base de datos en el archivo `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/Videojuegos
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password
Markdown

# 🚛 Sistema de Gestión de Valores Web

Plataforma web centralizada para la gestión de solicitudes de recolección de valores, administración de entidades financieras y control operativo. Este sistema permite a clientes corporativos programar recolecciones y a los analistas gestionar la logística de manera segura y eficiente.

---

## 🛠️ Stack Tecnológico

Este proyecto ha sido desarrollado siguiendo una arquitectura de software robusta y escalable:

* **Lenguaje:** Java 17 (LTS)
* **Framework Backend:** Spring Boot 3.x
* **Gestor de Dependencias:** Maven
* **Base de Datos:** MySQL (vía XAMPP)
* **Seguridad:** Spring Security & JWT (JSON Web Tokens)
* **Documentación API:** Swagger / OpenAPI

---

## 📋 Prerrequisitos

Antes de ejecutar el proyecto, asegúrate de tener instalado el siguiente software en tu entorno local:

1.  **Java Development Kit (JDK) 17 o superior:**
    * Descargar: [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) o [OpenJDK](https://jdk.java.net/).
    * *Verificar instalación:* `java -version`
2.  **XAMPP (para MySQL):**
    * Descargar: [Apache Friends](https://www.apachefriends.org/es/index.html).
3.  **Git:**
    * Para clonar el repositorio.
4.  **IDE Recomendado:**
    * Visual Studio Code (con Extension Pack for Java) o IntelliJ IDEA.

---

## 🚀 Guía de Instalación y Despliegue

Sigue estos pasos para levantar el entorno de desarrollo localmente.

### 1. Clonar el Repositorio

Abre tu terminal y ejecuta:

```bash
git clone [https://github.com/TU_USUARIO/sistema-gestion-valores.git](https://github.com/TU_USUARIO/sistema-gestion-valores.git)
cd sistema-gestion-valores
2. Configuración de la Base de Datos (MySQL)
Abre XAMPP Control Panel e inicia los módulos Apache y MySQL.

Abre tu navegador y ve a http://localhost/phpmyadmin.

Crea una nueva base de datos llamada estrictamente: sistema_valores (Cotejamiento recomendado: utf8mb4_general_ci).

(Opcional) Si tienes un script SQL inicial, impórtalo desde la pestaña "Importar".

3. Configuración de Spring Boot
Navega al archivo de configuración del proyecto: src/main/resources/application.properties.

Verifica que la URL de conexión apunte a la base de datos correcta (sistema_valores) y que las credenciales coincidan con XAMPP:

Properties

# Configuración de Conexión a Base de Datos
spring.datasource.url=jdbc:mysql://localhost:3306/sistema_valores?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=
# (Deja password vacío si usas XAMPP por defecto)

# JPA / Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
4. Compilar y Ejecutar
Usa el wrapper de Maven (mvnw) incluido en el proyecto para descargar las dependencias y correr la aplicación.

En Windows (CMD / PowerShell):

Bash

./mvnw clean install
./mvnw spring-boot:run
En Linux / Mac:

Bash

chmod +x mvnw
./mvnw clean install
./mvnw spring-boot:run
Si todo es correcto, verás en la consola algo como: Started ValoresApplication in 3.456 seconds (JVM running for 4.123)

📦 Extensiones Recomendadas (VS Code)
Si utilizas Visual Studio Code, te recomendamos instalar las siguientes extensiones para facilitar el desarrollo:

Extension Pack for Java (Microsoft): Incluye soporte básico, debugger y Maven.

Spring Boot Extension Pack (VMware): Soporte avanzado para Spring, navegación de beans y live actuator.

Lombok Annotations Support: Si el proyecto utiliza Lombok para reducir código repetitivo.

Thunder Client o Postman: Para probar los endpoints de la API REST.

🧪 Pruebas de Funcionamiento
Una vez el servidor esté corriendo (generalmente en el puerto 8080):

API Health Check:

Abre tu navegador en: http://localhost:8080/api/health (si creaste este endpoint).

Documentación Swagger (Si aplica):

Visita: http://localhost:8080/swagger-ui.html

👥 Contribución
Haz un Fork del proyecto.

Crea una rama para tu feature (git checkout -b feature/nueva-funcionalidad).

Haz Commit de tus cambios (git commit -m 'Agrega nueva funcionalidad').

Haz Push a la rama (git push origin feature/nueva-funcionalidad).

Abre un Pull Request.

📄 Licencia
Este proyecto está bajo la Licencia MIT - mira el archivo LICENSE para detalles.

Desarrollado por: [Tu Nombre] - Estudiante de Ingeniería de Sistemas - Universidad del Valle

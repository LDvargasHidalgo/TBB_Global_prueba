# ⚛️ PruebaTBTBGlobal
## Introducción 🚀

Bienvenido a **PruebaTBTBGlobal**, un proyecto que incluye una base de datos MySQL, una API desarrollada en Spring Boot y una aplicación web construida con Angular CLI. A continuación, encontrarás las instrucciones para configurar y ejecutar cada parte del proyecto.

## Parte 1: Bases de Datos 
En la carpeta **bases de datos** encontrarás los scripts utilizados para crear y poblar la base de datos MySQL. Los archivos **ScriptDDL** contienen las instrucciones para la creación de las tablas, mientras que en **ScriptDML** encontrarás el llenado de las tablas y las consultas correspondientes. El modelo entidad-relación está disponible en el archivo **MER**.

## Parte 2: Interfaz de Programación de Aplicaciones (API)
### Tecnologías Utilizadas
- Spring Boot 3.1.5
- Java 17

### Dependencias
- Spring Web 
- MySQL Driver
- Lombok
- Spring Data JPA
- Swagger

### Configuración Local
1. Crea la base de datos utilizando los scripts proporcionados anteriormente.
2. Asegúrate de usar las mismas versiones de las tecnologías mencionadas para evitar conflictos.
3. Utiliza un entorno de desarrollo compatible con Spring Boot, como Eclipse, NetBeans, SpringToolSuite o IntelliJ.
4. En el archivo de propiedades, actualiza las siguientes propiedades con tu nombre de usuario y contraseña de MySQL:
   - `spring.datasource.username=usuario_mysql`
   - `spring.datasource.password=password_mysql`
5. Ejecuta el programa desde el archivo `ApiApplication`.
6. Una vez que el programa esté en funcionamiento, puedes consultar los endpoints en la documentación de Swagger:
   - [Documentación de Swagger Local](http://localhost:8080/swagger-ui/swagger-ui/index.html)

### Acceso Remoto
También puedes acceder a mi API en línea y probar los siguientes endpoints desde Postman:

- **GET:** https://sordid-cough-production.up.railway.app/api/courses
- **GET:** https://sordid-cough-production.up.railway.app/api/courses/1
- **POST:** https://sordid-cough-production.up.railway.app/api/courses
- **PUT:** https://sordid-cough-production.up.railway.app/api/courses/1
- **DELETE:** https://sordid-cough-production.up.railway.app/api/courses/1

## Parte 3: Aplicación Web
### Tecnologías Utilizadas
- Angular CLI: 16.2.2
- Node: 18.17.1
- Gestor de Paquetes: npm 9.6.7
- Bootstrap 5
- Font Awesome
- Google Maps

### Configuración Local
1. Desde el directorio principal, ejecuta el comando `npm install` para instalar las dependencias.
2. Luego, utiliza `ng serve` para ejecutar el proyecto.
3. Abre tu navegador y accede a la siguiente URL: [http://localhost:4200/](http://localhost:4200/)

### Acceso Remoto
La aplicación web también está disponible en línea. Puedes visitarla en la siguiente URL:
- [Aplicación Web en línea]https://tbb-global-prueba.vercel.app/table)


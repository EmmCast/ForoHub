# ForoHub


## Descripción del Proyecto

ForoHub es una aplicación de foro en línea construida con Spring Boot. La aplicación permite a los usuarios crear, leer, actualizar y eliminar (CRUD) entidades como Cursos, Perfiles, Usuarios, Tópicos y Respuestas.

## Características

- **Autenticación y Autorización**
  - Registro de nuevos usuarios
  - Login de usuarios
  - Protección de endpoints con JWT
- **Gestión de Cursos**
  - Crear curso
  - Obtener todos los cursos
  - Obtener curso por ID
  - Actualizar curso
  - Eliminar curso
- **Gestión de Perfiles**
  - Crear perfil
  - Obtener todos los perfiles
  - Obtener perfil por ID
  - Actualizar perfil
  - Eliminar perfil
- **Gestión de Usuarios**
  - Crear usuario
  - Obtener todos los usuarios
  - Obtener usuario por ID
  - Actualizar usuario
  - Eliminar usuario
- **Gestión de Tópicos**
  - Crear tópico
  - Obtener todos los tópicos
  - Obtener tópico por ID
  - Actualizar tópico
  - Eliminar tópico
- **Gestión de Respuestas**
  - Crear respuesta
  - Obtener todas las respuestas
  - Obtener respuesta por ID
  - Actualizar respuesta
  - Eliminar respuesta
- **Swagger**
  - Documentación de API interactiva con Swagger

## Endpoints

### Autenticación y Autorización

- `POST /auth/register` - Registro de nuevo usuario
- `POST /auth/login` - Login de usuario

### Cursos

- `POST /cursos` - Crear curso
- `GET /cursos` - Obtener todos los cursos
- `GET /cursos/{id}` - Obtener curso por ID
- `PUT /cursos/{id}` - Actualizar curso
- `DELETE /cursos/{id}` - Eliminar curso

### Perfiles

- `POST /perfiles` - Crear perfil
- `GET /perfiles` - Obtener todos los perfiles
- `GET /perfiles/{id}` - Obtener perfil por ID
- `PUT /perfiles/{id}` - Actualizar perfil
- `DELETE /perfiles/{id}` - Eliminar perfil

### Usuarios

- `POST /usuarios` - Crear usuario
- `GET /usuarios` - Obtener todos los usuarios
- `GET /usuarios/{id}` - Obtener usuario por ID
- `PUT /usuarios/{id}` - Actualizar usuario
- `DELETE /usuarios/{id}` - Eliminar usuario

### Tópicos

- `POST /topicos` - Crear tópico
- `GET /topicos` - Obtener todos los tópicos
- `GET /topicos/{id}` - Obtener tópico por ID
- `PUT /topicos/{id}` - Actualizar tópico
- `DELETE /topicos/{id}` - Eliminar tópico

### Respuestas

- `POST /respuestas` - Crear respuesta
- `GET /respuestas` - Obtener todas las respuestas
- `GET /respuestas/{id}` - Obtener respuesta por ID
- `PUT /respuestas/{id}` - Actualizar respuesta
- `DELETE /respuestas/{id}` - Eliminar respuesta

## Instalación y Configuración

1. Clona el repositorio:
    ```sh
    git clone https://github.com/tu-usuario/ForoHub.git
    cd ForoHub
    ```

2. Configura las propiedades de la base de datos en `src/main/resources/application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/foro_hub
    spring.datasource.username=tu_usuario
    spring.datasource.password=tu_contraseña
    spring.jpa.hibernate.ddl-auto=update
    ```

3. Ejecuta la aplicación:
    ```sh
    ./mvnw spring-boot:run
    ```

4. Accede a la documentación de Swagger en:
    ```
    http://localhost:8080/swagger-ui/index.html
    ```

## Tecnologías Utilizadas

- Java
- Spring Boot
- Spring Security
- JWT
- Swagger
- MySQL
- Maven
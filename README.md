# Eureka Exercise - Spring Boot 3 + MySQL + Docker

Proyecto de ejemplo que implementa una API REST con Spring Boot 3, utilizando MySQL como base de datos y Docker para el despliegue. El sistema maneja entidades relacionadas (Especificación y Oferta) a través de un atributo en común.

## 🚀 Requisitos Previos

- [Docker Desktop](https://www.docker.com/products/docker-desktop) (Windows/macOS) o [Docker Engine](https://docs.docker.com/engine/install/) (Linux)
- [Docker Compose](https://docs.docker.com/compose/install/) (generalmente viene con Docker Desktop)

> **Nota importante**: No es necesario instalar Java, Maven ni MySQL en tu sistema local, ya que todo se ejecutará dentro de contenedores Docker.

## 🛠️ Cómo comenzar

1. Clona el repositorio:
   ```bash
   git clone <url-del-repositorio>
   cd springboot-1
   ```

2. Construye las imágenes y levanta los contenedores:
   ```bash
   docker compose up -d --build
   ```

3. La aplicación estará disponible en: http://localhost:8080
4. La base de datos MySQL estará disponible en: localhost:3306

### Credenciales de la base de datos
- Usuario: `eureka`
- Contraseña: `secret`
- Base de datos: `eureka`

### Comandos útiles

📝 Ver logs de la aplicación:
```bash
docker compose logs -f app
```

🛑 Detener y eliminar contenedores:
```bash
docker compose down -v
```


## 🌐 Endpoints de la API

### Ofertas (entidad secundaria)
- `GET /api/ofertas` - Lista todas las ofertas
- `GET /api/ofertas/{id}` - Obtiene una oferta por su ID

### Especificaciones (entidad principal)
- `GET /api/especificaciones` - Lista todas las especificaciones
- `GET /api/especificaciones?ofertaId=1` - Filtra especificaciones por ID de oferta
- `GET /api/especificaciones/{id}` - Obtiene una especificación por su ID
- `POST /api/especificaciones` - Crea una nueva especificación
- `DELETE /api/especificaciones/{id}` - Elimina una especificación

#### Ejemplo de solicitud POST para crear una Especificación:
```json
{
  "ofertaId": 1,
  "numeroVacantes": 2,
  "personalACargo": 0,
  "modalidadTrabajo": "Híbrido",
  "categoria": "Desarrollo",
  "sector": "Fintech",
  "nivelProfesional": "Senior",
  "departamento": "TI",
  "experienciaMinima": "5 años",
  "jornadaLaboral": "Completa",
  "formacionMinima": "Ingeniería en Informática"
}
```

## 🏗️ Estructura del Proyecto

```
src/main/java/com/eureka6/semana1/
├── config/           # Configuraciones de la aplicación
├── controller/       # Controladores REST
├── dto/              # Objetos de Transferencia de Datos
├── entity/           # Entidades JPA
├── repository/       # Repositorios de Spring Data JPA
├── service/          # Lógica de negocio
└── Semana1Application.java  # Clase principal

src/main/resources/
├── application.yml   # Configuración de la aplicación
└── data.sql          # Datos iniciales

Dockerfile           # Configuración para construir la imagen Docker
docker-compose.yml   # Configuración de los servicios Docker
```

## 🛠 Tecnologías Utilizadas

### Backend
- **Java 17** - Lenguaje de programación
- **Spring Boot 3** - Framework para aplicaciones Java
- **Spring Data JPA** - Para la capa de persistencia
- **Lombok** - Para reducir código boilerplate
- **ModelMapper** - Para el mapeo entre entidades y DTOs de forma sencilla

### Base de Datos
- **MySQL 8** - Sistema de gestión de bases de datos relacional

### Contenedorización
- **Docker** - Para empaquetar la aplicación y sus dependencias
- **Docker Compose** - Para orquestar múltiples contenedores

### Herramientas de Desarrollo
- **Maven** - Gestión de dependencias y construcción del proyecto
- **Git** - Control de versiones

## 📦 Datos de Ejemplo

El sistema carga automáticamente datos de ejemplo al iniciar desde `src/main/resources/data.sql`, incluyendo ofertas de ejemplo y sus especificaciones asociadas.

## 🔄 Persistencia de Datos

- Los datos de MySQL se persisten en un volumen de Docker llamado `db_data`
- Esto evita la pérdida de datos al detener o reiniciar los contenedores
- El volumen se almacena en el host en una ubicación gestionada por Docker

## 📝 Notas Adicionales

- La aplicación está configurada para desarrollo local con Docker
- Las variables de entorno están configuradas en el archivo `docker-compose.yml`
- Para entornos de producción, se recomienda revisar las configuraciones de seguridad
- No se requiere configuración adicional más allá de lo especificado en este documento

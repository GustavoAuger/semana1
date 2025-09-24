# Eureka Exercise - Spring Boot 3 + MySQL + Docker

Proyecto de ejemplo para el ejercicio: entidad principal y secundaria relacionadas por un atributo en común, con capas separadas, persistencia en MySQL y despliegue vía Docker Compose.

- Entidad principal: `Especificacion` (atributo en común: `ofertaId`)
- Entidad secundaria: `Oferta` (se asocia desde `Especificacion.ofertaId` hacia `Oferta.id`)

## Requisitos
- Java 17
- Maven 3.9+
- Docker y Docker Compose

## Cómo ejecutar

1. Build de la imagen y levantar stack (app + MySQL):

```bash
docker compose up -d --build
```

La app levantará en `http://localhost:8080` y MySQL en `localhost:3306`.

Credenciales MySQL por defecto:
- user: `eureka`
- password: `secret`
- db: `eureka`

2. Logs de la app:
```bash
docker compose logs -f app
```

3. Parar y eliminar contenedores:
```bash
docker compose down -v
```

## Endpoints

- Ofertas (entidad secundaria)
  - GET `http://localhost:8080/api/ofertas`
  - GET `http://localhost:8080/api/ofertas/{id}`

- Especificaciones (entidad principal)
  - GET `http://localhost:8080/api/especificaciones`
  - GET `http://localhost:8080/api/especificaciones?ofertaId=1`
  - GET `http://localhost:8080/api/especificaciones/{id}`
  - POST `http://localhost:8080/api/especificaciones`
  - DELETE `http://localhost:8080/api/especificaciones/{id}`

Body JSON de ejemplo para crear Especificación:
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

## Datos de ejemplo
Se cargan automáticamente desde `src/main/resources/data.sql`:
- Ofertas de ejemplo y especificaciones asociadas por `oferta_id`.

## Estructura de paquetes
- `com.eureka.eurekaexercise.entity` (entidades JPA)
- `com.eureka.eurekaexercise.repository` (repositorios Spring Data JPA)
- `com.eureka.eurekaexercise.service` (servicios)
- `com.eureka.eurekaexercise.controller` (controladores REST)

## Compilar sin Docker

```bash
mvn clean package -DskipTests
java -jar target/semana1-0.0.1-SNAPSHOT.jar
```

Configurar variables de entorno o `application.yaml` para tu base local.

## Notas
- Relación entre entidades realizada de forma explícita a través del atributo en común `Especificacion.ofertaId` hacia `Oferta.id` (sin anotaciones de relación JPA), como requiere el enunciado.
- Hibernate `ddl-auto=update` para facilitar la ejecución; en producción se recomienda migraciones con Flyway/Liquibase.
 - El servicio MySQL en Docker Compose usa un volumen `db_data` para persistir los datos en el host, evitando pérdidas al pausar o recrear contenedores.

## Publicación en GitHub
1. Inicializa git y realiza el primer commit.
2. Crea un repositorio en GitHub y agrega el remote.
3. Empuja la rama principal.

```bash
git init
git add .
git commit -m "Semana 1: Spring Boot 3 + MySQL + Docker"
git branch -M main
git remote add origin https://github.com/<tu-usuario>/semana1.git
git push -u origin main
```

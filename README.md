# Java JPA Mechanics

This project is a focused Spring Boot + JPA/Hibernate app for Java developers exploring JPA mechanics and interview-style scenarios.

## Features
- N+1 issue example and fixed version
- Entity lifecycle demo
- Lazy vs eager fetch demo
- Optimistic locking example
- Inheritance mapping example
- SQL injection example (vulnerable native query) and fixed (parameterized) version
- Hibernate question catalog endpoint

## Run locally

### Local profile (H2 in-memory database)

No external database required. Run with the `local` profile:

```bash
mvn spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=local"
```

Once running, access the H2 console at: http://localhost:8080/h2-console

| Field    | Value               |
|----------|---------------------|
| JDBC URL | `jdbc:h2:mem:testdb`|
| User Name| `sa`                |
| Password | (leave empty)       |

### Production profile (PostgreSQL)

1. Create a PostgreSQL database named `hibernateqa`.
2. Set the connection password via environment variable:

```bash
export DB_PASSWORD=your_db_password
```

3. Start the app:

```bash
mvn spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=prod"
```

## Endpoints

- `/hibernate/questions`
- `/hibernate/nplusone/bad`
- `/hibernate/nplusone/fixed`
- `/hibernate/lifecycle/demo`
- `/hibernate/fetch/customers`
- `/hibernate/locking/deposit/{id}?amount=100`
- `/hibernate/inheritance/employee`
- `/hibernate/inheritance/manager`
- `/hibernate/cache/product/{id}`
- `/hibernate/sqlinjection/vulnerable?name=...` (string-concatenated native SQL, exploitable with e.g. `' OR '1'='1`)
- `/hibernate/sqlinjection/fixed?name=...` (parameterized query, same input treated as literal data)

## SQL scripts

- `sql/ddl.sql`
- `sql/data.sql`

## Notes

This project is designed for interview preparation and real code-based examples rather than production-ready architecture.

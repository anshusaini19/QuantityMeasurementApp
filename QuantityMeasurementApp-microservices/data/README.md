# Quantity Measurement App — Microservices

Split into 3 independent projects, business logic untouched:

```
authservice/       -> Spring Boot, port 8080  (Google OAuth2 login + JWT issuing)
quantityservice/   -> Spring Boot, port 8081  (Quantity CRUD/compare/convert/history, H2 DB)
frontend/          -> Vite/React, port 5173   (unchanged, only proxy target updated)
```

## authservice (8080)
Owns: `SecurityConfig`, `JwtAuthenticationFilter`, `OAuth2LoginSuccessHandler`, `JwtUtil`, Google OAuth2 config, and the `static/index.html` redirect stub.
Run:
```
cd authservice
mvn spring-boot:run
```

## quantityservice (8081)
Owns: `Quantity`, `IMeasurable`, unit enums, controller, DTOs, entity, repository, service, exceptions, Swagger config, H2 DB + schema.sql.
Also carries its own copy of `JwtUtil` / `JwtAuthenticationFilter` (same shared secret as authservice) purely to validate the JWT on incoming requests — it does not issue tokens.
Run:
```
cd quantityservice
mvn spring-boot:run
```

## frontend (5173)
Same code as before. The only change: `vite.config.js`'s dev proxy for `/api` now points at `http://localhost:8081` (quantityservice) instead of 8080, since quantity endpoints moved there. Google login still goes straight to `http://localhost:8080` (authservice) via `config.backendOrigin`, exactly as before.
Run:
```
cd frontend
npm install
npm run dev
```

## Important
Both services share the same JWT secret (`ThisIsMyVerySecretKeyForJwtAuthentication12345`) so a token issued by authservice is accepted by quantityservice. If you change it, change it in both places.


# How to run application

1. Install docker if not installed before
2. Run DB as docker service `docker-compose up`
3. Set configuration on application-local.properties as `spring.jpa.hibernate.ddl-auto=create`
4. Run application with profile `local`
5. Open `http://localhost:8080/swagger-ui/index.html` on browser
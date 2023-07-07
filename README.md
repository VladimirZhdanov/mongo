Run mongo container:
```
docker compose -f docker-compose.yml up
docker compose -f docker-compose.yml down
```

Go to mongo sh:
```
docker ps 
docker exec -it mongo-mongo-1 mongosh
db.auth("mongo","password")

or 

docker exec -it mongo-mongo-1 mongosh --port 27017  --authenticationDatabase \
    "admin" -u "mongo" -p
```

Create database and user:
```
use mongoDB

db.createUser(
    {
        user: "user",
        pwd:  "password",
        roles: [ { role: "readWrite", db: "mongoDB" }]
    }
)
```
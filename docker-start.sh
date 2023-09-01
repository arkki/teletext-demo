#!/bin/sh

# Build webapp
mvn clean package

# Build and start containers
docker-compose down
docker-compose up -d

# Init DB
docker-compose exec -T mongo sh -c '/usr/bin/mongorestore --gzip --archive' < ./db/dump_2023-08-31.gz

# Tail logs
docker-compose logs -f
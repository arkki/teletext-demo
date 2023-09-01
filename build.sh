#!/bin/sh

# Build webapp
./mvnw clean package

docker-compose -f docker-compose-build.yml build
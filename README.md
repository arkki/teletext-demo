# Demo API for Yle teksti-tv
It can be used for fetching historical teksti-tv pages as PNG images.

**NOTE:** The data provided is pre-downloaded and populated in DB and it's very limited! There is no active integration updating the database. In real world PNG files would be served from for example S3 - like it's done in Yle API.

## Stack
- Spring Boot 3.1.3
- MongoDB 7


## Usage
http://localhost:8080 - landing page with test cases.

API GET endpoint: /v1/{page}/{subpage}.png?app_id=[id]&app_key=[key]&time=[optional epoch]

## Development
Current helper scripts require Docker and internet access for downloading containers.

### MongoDB
Webapp depends on local MongoDB installation to work. 
Use script `docker-mongo-start.sh` to start MongoDB in Docker container and exposing port `27017` to the host. 
Teletext database is restored to MongoDB container from `db/dump_2023-08-31.gz` as part of the start script.

### Spring Boot
Use script `start.sh` to start Spring Boot with `dev` profile. 
This profile is required for connection to a local MongoDB running at `localhost:27017`.

To use Java Remote Debugging use script `debug.sh` to expose debug port at `localhost:5005`.

## Build dependencies
- Linux / macOS
- Maven
- Java 17
- Docker & Docker Compose for building prod image


## Runtime dependencies
- Local MongoDB running at `localhost:27017`. DB dump can be restored from `/db/dump_2023-08-31.gz`

## Prod build and running in Docker
Use script `docker-start.sh` to build for prod and run webapp.
This scripts handles everything including initiating teletext database in MongoDB container. Only port 8080 is exposed on host. 

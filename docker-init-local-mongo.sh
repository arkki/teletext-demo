#!/bin/sh

docker run -d  -p 27017:27017 --name mongo mongo
docker exec -i mongo sh -c '/usr/bin/mongorestore --gzip --archive' < ./db/dump_2023-08-31.gz
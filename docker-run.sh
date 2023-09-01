#!/bin/sh

docker run --rm -it -p 8080:8080 --network mongo-net --name teletext olliniinioja-teletext:0.0.1-tomcat
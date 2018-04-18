#!bin/bash

echo "building archive image"
cd archive
mvn package docker:build
cd ..

echo "building devices image"
cd devices
mvn package docker:build
cd ..

echo "building vacations image"
cd vacations
mvn package docker:build
cd ..

echo "building eureka image"
cd eureka
mvn package docker:build
cd ..

echo "building images finished"

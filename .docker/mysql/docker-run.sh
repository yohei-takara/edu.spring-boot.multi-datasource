#!/bin/bash
set -Ceu

DATABASE_NAME=multi_datasource

echo "Please enter Contena's port."
read CONTENA_PORT

echo "Please enter Contena's name."
read CONTENA_NAME

echo "Please chose background run. (y/n)"
read BACKGROUND_RUN

case "${BACKGROUND_RUN}" in
  y)
    docker run \
      -v ${PWD}/setting:/etc/mysql/conf.d \
      -v ${PWD}/initialize:/docker-entrypoint-initdb.d \
      --name ${CONTENA_NAME} \
      -e MYSQL_ROOT_PASSWORD=root \
      -e MYSQL_DATABASE=${DATABASE_NAME} \
      -p ${CONTENA_PORT}:3306 \
      -d \
      mysql:5.6
    ;;
  n)
    docker run \
      -v ${PWD}/setting:/etc/mysql/conf.d \
      -v ${PWD}/initialize:/docker-entrypoint-initdb.d \
      --name ${CONTENA_NAME} \
      -e MYSQL_ROOT_PASSWORD=root \
      -e MYSQL_DATABASE=${DATABASE_NAME} \
      -p ${CONTENA_PORT}:3306 \
      mysql:5.6
    ;;
  *)
    echo "Docker contena start fails."
esac

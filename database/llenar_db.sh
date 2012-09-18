#!/bin/bash

cd ./database

mysql --database=ISO2 --user=root --password=pass < tildes.sql
mysql --database=ISO2 --user=root --password=pass < generar_base_datos.sql
mysql --database=ISO2 --user=root --password=pass < correosvalidos.sql


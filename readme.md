## DATABASE

1. connect to pg server: `psql -h 127.0.0.1 -p 5432 -U postgres`
2. create db: `create database invoices_db;`
3. connect to db :`\c invoices_db`
4. execute `create_db.sql` script to create schema
5. insert inital data, using `initial_data.sql` script
6. check tables: `\dt` command

## Build Jar

from project root dir `gradle init --type java-library `

## Stack
1. Java 17
2. Gradle 7.6
3. Spring Boot, Hibernate
4. Postgres 15
5. Lombok

## Endpoints

 1. create POST api/v1/cashreceipt
 2. 

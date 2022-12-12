# In-Progress Personal Project

## Table of Contents

1.  [Overview](#Overview)
2.  [Description](#Description)
3.  [Usage](#Usage)
4.  [Installation](#Installation)
5.  [Libraries](#Libraries)
6.  [License](#License)

## Overview

In-Progress.

- Database: built in PostgreSQL, SQL
- Client: built in React, TypeScript
- Server: built in Spring Boot, Java
- Github: [GitHub](https://github.com/justinthelaw?tab=repositories)
- LinkedIn: [LinkedIn](https://www.linkedin.com/in/justinwingchunglaw/)

## Description

In-Progress.

### Client Design

Description

### Server Design

Description

### Database Design

Description

## Usage

### Client

Description

### Server

Description

### Database

Description

## Installation

### Set-up Script

- To automate the updating of all configuration files, a bash script named `setup.sh` has been provided.

- Run `chmod +x scripts/[insert scropt name].sh` to give permission for a bash script to run.

- The `setup.sh` script does the following:

  - Moves a copy of the .env file to the client folder and appends "REACT_APP\_" to the front of all variables.
  - Moves a copy of the .env file to the server folder

### Docker

1. Go to the config folder and modify the .env.example file using the [format in this README](#Environment-Variables) and the format in the provided .env.example file. Delete the ".example" extension from the .env filename before running the application.

2. Start your Docker application

3. Run `scripts/setup.sh`

4. Run `docker-compose --env-file ./config/.env up --build` and using your browser, proceed to the address and port for the client as specified in your .env file (e.g. http://localhost:3000).

5. To access the server, proceed to the address and port for the server as specified in your .env file (e.g. http://localhost:8080)

### Source Code

1. Modify the .env.example file using the format commented within the .env.example file. Delete the .example portion of the extension from the .env file before running the application.

2. Start your Docker application

3. Run `scripts/setup.sh`

4. Start your Docker app and run the following command to spin-up PostgreSQL and the required database: `docker run --rm --name justinthelaw -v $PWD/db:/docker-entrypoint-initdb.d/ --env-file ./config/.env -p $(awk -F "=" '/PG_PORT/{print $NF}' ./config/.env):5432 postgres:latest`

5. Go to the client folder and execute `npm install`

6. Go to the client and execute `npm start` to start the React application.

7. Go to the server Spring Boot Java project and run your IDE's compile and run function.

8. (OPTIONAL) Alternatively, you can build the `.jar` file using your IDE or the CLI and run the resulting Spring Boot build.

9. Proceed to the address and port for the client as specified in your .env file (e.g. http://localhost:3000)

10. Proceed to the address and port for the API server as specified in your .env file (e.g. http://localhost:8080)

## Environment Variables

Environment variables that control the operation of the app are defined in the
`.env` file in the application root. These variables and their usage are shown
in the following table.

Environment variables maintained in the `.env` file are made available to the
application code via `process.env.<variable-name>`. For example, the
port for the client is accessed in the code by referencing
`process.env.PORT`.

| Environment Variable | Description                              | Example Setting  | Applicability    |
| :------------------- | :--------------------------------------- | :--------------- | :--------------- |
| CHOKIDAR_USEPOLLING  | Allows hot reloads of React App          | true             | client           |
| HOST_DB              | Docker host for database                 | postgres         | server           |
| HOST_DEV             | Local and/or container host for server   | localhost        | server, client   |
| HOST_LIVE            | Deployed host for server                 | justinthelaw.com | server, client   |
| PROTO_DEV            | Local and/or container protocol          | http             | server, client   |
| PROTO_LIVE           | Deployed protocol                        | https            | server, client   |
| API_PORT             | Local and/or container port API server   | 8080             | server, client   |
| POSTGRES_DB          | Database name                            | mydatabase       | server, database |
| POSTGRES_USER        | PostgreSQL username                      | postgres         | server, database |
| POSTGRES_PASSWORD    | PostgreSQL password                      | docker           | server, database |
| PG_PORT              | Local and/or container port for database | 5432             | server, database |

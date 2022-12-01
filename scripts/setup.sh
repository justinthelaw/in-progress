#!/bin/bash
printf "> Copying environment variables to client and server...\n"
cp ./config/.env ./client/
cp ./config/.env ./server/src/main/resources
printf "> Appending React prefix to client .env file...\n"
sed -i -e 's/^/REACT_APP_/' ./client/.env && printf "> Setup complete!\n"
#!/bin/bash
cp ./config/.env ./client/
sed -i -e 's/^/REACT_APP_/' ./client/.env && printf "Setup complete!\n"
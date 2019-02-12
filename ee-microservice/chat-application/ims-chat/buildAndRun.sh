#!/bin/sh

echo "START RUN THE SCRIPT"



# Package application - war file 
mvn clean package 
 

# Build Docker image 
docker build -t org.jee8ng/ims-chat .

# Run docker iamge - expose port 8084

docker rm -f ims-chat || true && docker run --rm -d -p 8084:8080 --name ims-chat org.jee8ng/ims-chat 




# Run docker container 
echo "SCRIPT RUN SUCCESSFUL"




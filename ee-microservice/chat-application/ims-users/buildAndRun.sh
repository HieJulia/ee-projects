#!/bin/sh
 

 

echo "Start running application..."

# Package the application 
mvn clean package



# Build the image 
docker build -t org.jee8ng/ims-users .


# Run Docker image 

docker rm -f ims-users || true && docker run --rm -d -p 8081:8080 --name ims-users org.jee8ng/ims-users


echo "Finnish running application... "






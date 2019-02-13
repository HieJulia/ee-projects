# Java EE micro service starter kit with docker, payara micro, arquillian on AWS Cloud 
+ Starter project kit 

## Stack
+ AWS : AWS ElasticBeanstalk - AWS Code Pipeline - AWS Code Build 
+ Java EE - microservice 
+ Docker
+ Application server : Payara micro 
+ Test : 
    + Unit test :
    + Integration test : Arquillian on AWS cloud 


##  Setting up properties 

Before changing properties you need to setup:


* AWS IAM user account with Elastic Beanstalk / EC2 Container read write permissions.

```json
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "VisualEditor0",
            "Effect": "Allow",
            "Action": [
                "s3:PutObject",
                "s3:GetObject",
                "s3:ListBucket",
                "s3:GetObjectVersion"
            ],
            "Resource": "arn:aws:s3:::elasticbeanstalk-*"
        },
        {
            "Sid": "VisualEditor1",
            "Effect": "Allow",
            "Action": [
                "ecr:GetDownloadUrlForLayer",
                "ecr:GetAuthorizationToken",
                "ecr:UploadLayerPart",
                "elasticbeanstalk:CreateApplicationVersion",
                "ecr:ListImages",
                "ecr:PutImage",
                "ecr:BatchGetImage",
                "ecr:CompleteLayerUpload",
                "ecr:DescribeImages",
                "elasticbeanstalk:DescribeApplicationVersions",
                "ecr:DescribeRepositories",
                "ecr:InitiateLayerUpload",
                "ecr:BatchCheckLayerAvailability",
                "ecr:GetRepositoryPolicy"
            ],
            "Resource": "*"
        }
    ]
}
```

* EC2 Container Registry and Elastic Beanstalk Single environment application with docker engine

Change aws config in gradle.properties:
```properties
groupName=icoder
awsECRName=YOUR_EC_REPOSITORY_NAME
awsId=YOUR_AWS_ID
awsEBSApp=YOUR_ELASTIC_BEANSTALK_APPLICATION_NAME
awsRegion=eu-central-1
```


+ Give Read - Write permission : `chown -R ec2-user 777`



###  Build project 


+ `gradle clean build -Penv=local`


###  Starting embedded server
Server will be running on default port 8080 / or 8087 

+ Start server : `gradle startServer`


### Starting unit tests:

+ Start unit test : `gradle test`



### Starting integration test with arquillian - Integration test 
Run integration test 

+ Tests Docker compose started 

+ Local data store - run in docker 

Run compose once:
`gradle dockerCompose`

Start test 
`gradle itest`


###  Starting/stopping docker server

`gradle startDocker`

`gradle stopDoker`

###  Publishing to ecr repository ECR

This command creates elastic beanstalk application deployment version 
and publish baked container to EC2 Container Repository:

+ Create Elastic Beanstalk application deployment version 
+ Publish baked container to EC2 Container Repository


`gradle clean publishToECR -Penv=prod`


### Example running apps manually: Example running appsa

+ Run project as jar applications - Configure IDE - run jar application - so you can debug it 

+ Build application locally : `gradle build -Penv=local`

+ Deploy war file to payara server : `java -jar ./pajara-micro.jar --deploy ./build/libs/starter-1.0.0.war`

+ Run application with Payara micro : `gradle downloadPayaraMicro`


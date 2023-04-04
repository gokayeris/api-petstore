# api-petstore swagger 
- API Automation Testing Using Java, cucumber and restAssured

- Specs:  /https://petstore.swagger.io/ 

### dependencies:
- [cucumber-java](https://mvnrepository.com/artifact/io.cucumber/cucumber-java)
- [cucumber-junit](https://mvnrepository.com/artifact/io.cucumber/cucumber-junit)
- [rest-assured](https://mvnrepository.com/artifact/io.rest-assured/rest-assured)
- [lombok](https://mvnrepository.com/artifact/org.projectlombok/lombok)
- [gson](https://mvnrepository.com/artifact/com.google.code.gson/gson)


### Setting Up
These instructions will get you a copy of the project up and running on your local machine.

- *clone the repo:*
```shell
git clone  https://github.com/gokayeris/api-petstore.git
```

- *set project sdk as 11*

Running tests from terminal:
```shell
mvn verify --file pom.xml
```
- In this project I used github actions.

- If you want to use same pipeline setup just add following variables defined inside the workflows/maven.yml to your github repository as secret variables.

### About scenarios:

Automated scenarios are:
- Get request for pet endpoint(api)
- Post request for Store Order(api)
- Post request for user(api)

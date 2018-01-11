README.md
==========

This project is meant for password validation service.
Developed on Java 1.8 version, and maven 3.3.9, eclipse-neon
1) Goto the  project - password-validate-service
> cd password-validation-service

2) Project can be installed using 
> mvn clean install

3) For PMD,  execute below command. PMD file can be found under 'target/pmd.xml'
> mvn pmd:pmd

4) For Findbugs execute below command. Reports can be found under 'target/site/'
> mvn site

5) Unit test cases(Junit) and Integrated(Mockito) test cases have written.

6) Password rules can be controlled(disable or enable) in 'application.properties'

7) The project can be run using below command -
> java -jar -Dspring.profiles.active=dev target/password-validation-service-0.0.1-SNAPSHOT.jar

8) Goto Postman, and select 'POST' method, and add the url as 'http://localhost:8080/passwordService/validatePassword'
In 'RequestBody' give different values like 
abcde
Abcde
12345
abcde12345
abab
ab1ab1
prefixabab

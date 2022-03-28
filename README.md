# tqs_97631
TQS lab classes

mvn install -DskipTests=true

./mvnw spring-boot:run

mvn package clean

mvn clean test jacoco:report
depois de correr ir a target/site/jacoco/index.html

docker run -d --name sonarqube -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true -p 9000:9000 sonarqube:latest

http://localhost:9000   ->   admin:password

sqp_ef7546cc6bd28e47212daec341727a6ea1c8ef2b

mvn clean verify sonar:sonar   -Dsonar.projectKey=tqs_euromilhoes   -Dsonar.host.url=http://localhost:9000   -Dsonar.login=sqp_ef7546cc6bd28e47212daec341727a6ea1c8ef2b -e

-------------------------------------------------------

1 bug - Save and re-use this "Random", in Dip.java
0 vulnerabilities
1 security hotspot because of the use of Random in Dip.java
29 code smells
72% coverage with 10 unit tests
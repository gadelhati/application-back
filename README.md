# Application _Back_

![github](https://img.shields.io/github/stars/gadelhati/demo?style=social "Github")
![java](https://img.shields.io/badge/java-8-6495ED "Java")
![springboot](https://img.shields.io/badge/springboot-2.4.5-6495ED "Spring Boot")
![react](https://img.shields.io/badge/react-17.0.2-6495ED "React")

#### Necessary Tech stack:

<a href="https://www.w3.org/html/" target="_blank">
    <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/html5/html5-original-wordmark.svg" alt="html5" width="25" height="25"/>
</a>
<a href="https://www.w3schools.com/css/" target="_blank">
    <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/css3/css3-original-wordmark.svg" alt="css3" width="25" height="25"/>
</a>
<a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript" target="_blank">
    <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/javascript/javascript-original.svg" alt="javascript" width="25" height="25"/>
</a>
<a href="https://getbootstrap.com" target="_blank">
    <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/bootstrap/bootstrap-plain-wordmark.svg" alt="bootstrap" width="25" height="25"/>
</a>
<a href="https://www.java.com" target="_blank">
    <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="25" height="25"/>
</a>
<a href="https://www.postgresql.org" target="_blank">
    <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/postgresql/postgresql-original-wordmark.svg" alt="postgresql" width="25" height="25"/>
</a>
<a href="https://spring.io/" target="_blank">
    <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="25" height="25"/>
</a>
<a href="https://git-scm.com/" target="_blank">
    <img src="https://www.vectorlogo.zone/logos/git-scm/git-scm-icon.svg" alt="git" width="25" height="25"/>
</a>

[comment]: <> (<a href="https://www.linux.org/" target="_blank">)
[comment]: <> (    <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/linux/linux-original.svg" alt="linux" width="25" height="25"/>)
[comment]: <> (</a>)
[comment]: <> (<a href="https://www.docker.com/" target="_blank">)
[comment]: <> (    <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/docker/docker-original-wordmark.svg" alt="docker" width="25" height="25"/>)
[comment]: <> (</a>)

<a href="https://heroku.com" target="_blank">
    <img src="https://www.vectorlogo.zone/logos/heroku/heroku-icon.svg" alt="heroku" width="25" height="25"/>
</a>
<a href="https://www.nginx.com" target="_blank">
    <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/nginx/nginx-original.svg" alt="nginx" width="25" height="25"/>
</a>

[comment]: <> (<a href="https://www.jenkins.io" target="_blank">)
[comment]: <> (    <img src="https://www.vectorlogo.zone/logos/jenkins/jenkins-icon.svg" alt="jenkins" width="25" height="25"/>)
[comment]: <> (</a>)

<a href="https://nodejs.org" target="_blank">
    <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/nodejs/nodejs-original-wordmark.svg" alt="nodejs" width="25" height="25"/>
</a>
<a href="https://reactjs.org/" target="_blank">
    <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/react/react-original-wordmark.svg" alt="react" width="25" height="25"/>
</a>
<a href="https://materializecss.com/" target="_blank">
    <img src="https://raw.githubusercontent.com/prplx/svg-logos/5585531d45d294869c4eaab4d7cf2e9c167710a9/svg/materialize.svg" alt="materialize" width="25" height="25"/>
</a>
<a href="https://redux.js.org" target="_blank">
    <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/redux/redux-original.svg" alt="redux" width="25" height="25"/>
</a>

## Description
The codes FM 12 - XI SYNOP and FM 13 - XI SHIP are preset number sequences
that encode observations made at a Surface Meteorological Station (SYNOP) or from
Stations on board ships (SHIP).
A inciativa de criar um
The initiative to create a program in which the code is typed instead of being filled out on paper. Automating the exchange and its consequent inclusion in historical database.

### LICENCE
```
MIT License

Copyright (c) 2020 Jason Watmore

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
### Roadmap

[//]: # (q1 If you have ideas for releases in the future, it is a good idea to list them in the README.)
- [ ] filter by OM
- [ ] filter by Role
- [ ] set up Role and Privileges
- [ ] set up Role Hierarchy
- [ ] change default jwt to personal jwt
- [ ] change application.properties to [dev using h2, and prod using postgres]
- [ ] add Internationalization to ValidationMessages.properties
- [ ] sggeer something is not showing (Whitelabel Error Page)


### how to create this project
> [https://start.spring.io/](https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.4.5.RELEASE&packaging=war&jvmVersion=1.8&groupId=br.eti.gadelha&artifactId=gadelha&name=gadelha&description=Demo%20project%20for%20Spring%20Boot%20to%20Gadelha&packageName=br.eti.gadelha.gadelha&dependencies=lombok,web,h2,devtools,configuration-processor,jersey,security,data-jpa,postgresql,cloud-config-server,actuator,validation)

### how to stop application on localhost
```
netstat -a -n -o
tskill "NÚMERO DO PID"
```
## how to run project
```
mvn spring-boot:run
```
Isso irá gerar a Base de dados. Acessível através da url.
Para abrir console do banco de dados **H2**, acesse:

> [http://localhost:8080/h2-ui](http://localhost:8080/h2-ui)

### Deploy
```
cp /home/<user>/appliation-back.war /opt/tomcat/webapps
```

### HTTP Status code list:

> [HHTP Status Code](https://httpstatuses.com/)
### Run Your Maven Build Anywhere with the Maven Wrapper

>[Run Maven Build Anywhere with the Maven Wrapper](https://reflectoring.io/maven-wrapper/)
```
mvn -N io.takari:maven:0.7.7:wrapper
mvn -N io.takari:maven:wrapper -Dmaven=3.6.3
mvnw clean install
```

### Alter JDBC URL to path described on console:
```
2021-04-18 21:44:01.317  INFO 7560 --- [  restartedMain] o.s.b.a.h2.H2ConsoleAutoConfiguration    : H2 console available at '/h2-ui'. Database available at 'jdbc:h2:mem:testdb'
```
in case:
```
jdbc:h2:mem:testdb
```
Aplication _Spring Boot_ for: [projet on redemine](https://redmine.chm.mb/projects/siscoep){:target="_blank"}

### Requirements
For building and running the application you need:

- [x] [JDK](https://www.oracle.com/java/technologies/javase/javase8u211-later-archive-downloads.html) - Neste projeto utilzamos a versão JDK 8 update 211.
- [x] [Lombok](https://projectlombok.org/) - Download the Lombok plugin for your IDE. This is required to add Lombok dependency support.

### Running

First, clone the project and build locally:

```
git clone http://10.5.193.26/00038059/application-back
```
## how to create file _.war_, type on intellij terminal:

```
mvn clean package
```
two files with the extension .war will be created, the one with the shortest name will be used.

### On Server

```
systemctl stop tomcat
rm /opt/tomcat/webapps/<old_version>.war
rm -Rfv /opt/tomcat/webapps/<old_version>
cp /home/<user>/<application_name>.war /opt/tomcat/webapps/
chown tomcat:tomcat /opt/tomcat/webapps/<application_name>.war
systemctl start tomcat
```

## Dependency
```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-security</artifactId>
</dependency>

<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>

<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<scope>runtime</scope>
</dependency>

<dependency>
	<groupId>io.jsonwebtoken</groupId>
	<artifactId>jjwt</artifactId>
	<version>0.9.1</version>
</dependency>
```

## Configure Spring Datasource, JPA, App properties
Open `src/main/resources/application.properties`

```properties
spring.datasource.url= jdbc:postgresql://localhost:5432/synoptic_observation
spring.datasource.username= postgres
spring.datasource.password= password

spring.jpa.properties.hibernate.dialect= org.hibernate.spatial.dialect.postgis.PostgisDialect
spring.jpa.hibernate.ddl-auto= create

# App Properties
gadelha.app.jwtSecret= gadelhaSecretKey
gadelha.app.jwtExpirationMs= 604800000
gadelha.app.jwtRefreshExpirationMs= 12000000
```

### Features
These are the paths to services:

- [x] [CREATE](http://127.0.0.1/application-back/synopticObservation/) - path to item creation;
- [x] [RETRIEVE_ALL](http://127.0.0.1/application-back/synopticObservation/) - path to retrieve of all items;
- [ ] [RETRIEVE](http://127.0.0.1/application-back/synopticObservation/id) - path to retrieve of an item by id;
- [ ] [RETRIEVE](http://127.0.0.1/application-back/synopticObservation/id) - path to retrieve of an item by source;
- [x] [UPDATE](http://127.0.0.1/application-back/synopticObservation/id) - path to update an item;
- [x] [DELETE](http://127.0.0.1/application-back/synopticObservation/id) - path to delete an item;
- [x] [DELETE_ALL](http://127.0.0.1/application-back/synopticObservation/) - path to delete all items;
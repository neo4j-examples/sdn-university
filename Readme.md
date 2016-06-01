Hilly Fields Technical College
==============================
![Logo](https://github.com/neo4j/neo4j-ogm/blob/master/neo4j-spring-examples/sdn-boot/src/main/webapp/assets/images/engineering-dept.JPG)

This project is a demo application for the [Spring Data Neo4j 4.1](https://github.com/SpringSource/spring-data-neo4j)
library which provides convenient access to the [Neo4j](http://neo4j.org) graph database.

This tutorial is a fully functioning micro-service based web-application built using the following components

- Spring Boot 1.4
- Spring Data Neo4j 4.1
- Angular.js
- Twitter Bootstrap UI

The application's domain is a fictitious educational institution: Hilly Fields Technical College. The application allows you to manage the College's Departments, Teaching Staff, Subjects, Students and Classes.

It leverages the power of Spring Data Neo4j/Spring Boot and in particular the new Neo4j Object Graph mapping technology to provide a RESTful interface with which the web client interacts. The application is entirely stateless: every interaction involves a call to a Neo4j server, hopefully demonstrating the speed of the new technology, even over the wire.

> This version uses a Neo4j remote server. If you are interested in using Spring Data Neo4j 4.1 with embedded Neo4j, head over here https://github.com/neo4j-examples/sdn4-university/tree/4.1-embedded

WARNING
-------
By default, the application will attempt to use a Neo4j instance running on the same machine as the application server, and on the standard port 7474. *IT WILL DESTROY ALL THE DATA IN THAT DATABASE AT STARTUP*. So if you don't want that to happen please back up any existing database first.

Spring Boot Configuration
-------------------------
SDN4-University uses the spring-boot-starter for SDN, available in Spring Boot 1.4 and later versions.
 
The starter will auto-configure the application from the `application.properties` file in the `config` directory. 
The following properties are defined: 

    # connection string to the Neo4j database
    spring.data.neo4j.URI=http://neo4j:password@localhost:7474
    spring.data.neo4j.session.scope=session
    
Application Configuration
-------------------------

Application Configuration is very simple:

```
@SpringBootApplication
@EnableTransactionManagement
@NodeEntityScan(basePackages = "school.domain")
public class Application {

    public static void main(String[] args) {
        new SpringApplication(Application.class).run(args);
    }

}
```

> Note the annotation `@NodeEntityScan`. This defines the packages that contain your application's domain classes. It is used by Spring Boot to configure the Neo4j OGM SessionFactory, so there is no need to explicitly manage this yourself. 

Start Neo4j
-----------

Now start your Neo4j server instance, if its not already running. 

**You should back up any data you want to keep because the application will purge any existing data first**

Starting the application
------------------------

    cd neo4j-spring-examples/sdn4-university
    mvn spring-boot:run

Authentication
--------------
The application itself does not require any authentication, but if you are running against Neo4j 2.2 or later,
you'll need to provide connection credentials for the database. 

These can be specified in `application.properties` located in  `config`. You can embed the credentials in the URI string, for example: 

    spring.data.neo4j.URI=http://bilbo:baggins@localhost:7474 

or you can supply them as distinct properties:

    spring.data.neo4j.username=bilbo
    spring.data.neo4j.password=baggins

Loading the initial dataset
---------------------------
The application can load a set of base data, to get you started. Please be aware that this will destroy
any existing data that may previously exist, so take a backup.

    http://localhost:8080/api/reload

This will pre-load the Neo4j database with a handful of departments, a dozen or so subjects and teachers,
and 200 students. You'll probably want to enrol them in classes...

Exploring the API:
-----------------
The JSON resources from the server can be inspected from the /api/... URLs, e.g.

    http://localhost:8080/api/departments/
    http://localhost:8080/api/subjects/
    http://localhost:8080/api/teachers/
    http://localhost:8080/api/students/
    http://localhost:8080/api/classes/

Running the Hilly Fields web application
----------------------------------------
Simply point your browser at the root URL:

    http://localhost:8080

Stopping the application server
-------------------------------
You can stop the application server at any time by pressing Ctrl-C in the console window from where you launched it.

Make it better!
---------------
If you'd like to develop this application further, you will need to install node.js if it is not already installed:

- Node.js v0.10x+
- npm (which comes bundled with Node) v2.1.0+

Visit the node.js website for details of installing node.js for your particular operating system.

Once node is installed you'll then need to grab the following npm packages:

    npm install --global bower grunt-cli

License
-------
Permission to use this software is granted under the MIT License, a copy of which appears below:

Copyright © 2015-2016 Graph Aware Ltd - Neo Technology, Inc.

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
documentation files (the "Software"), to deal in the Software without restriction, including without limitation the 
rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit 
persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the 
Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO 
THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS 
OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT 
OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.





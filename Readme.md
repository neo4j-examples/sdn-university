Hilly Fields Technical College
==============================

Overview
--------

This demo web application shows developers how to quickly get started with [Spring Data Neo4j](https://github.com/spring-projects/spring-data-neo4j) library and the [Neo4j](http://neo4j.org) graph database.  For the non Spring version of this application please check out [Neo4j OGM University](https://github.com/neo4j-examples/neo4j-ogm-university).

Hilly Fields Technical College is a fictitious educational institution. This application allows you to manage its departments, teaching staff, subjects, students and classes.

This project is built using:

- Spring Boot 2.0.0 BUILD-SNAPSHOT
- Spring Data Neo4j 5
- Neo4j OGM 3.0.0
- AngularJS 1.6
- Bootstrap 3.3


It leverages combines the power Spring Data and Spring Boot with the Neo4j Object Graph Mapper(OGM) via a RESTful interface with which a web client application like AngularJS or ReactJS may interact.


Getting Started
---------------

### Prerequisites

You will need to following to run this application:

- [Java 8+](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
- [Maven](https://maven.apache.org/)


### Download the application

Either [download](https://github.com/neo4j-examples/sdn-university/archive/master.zip) the application or use `git` to clone the application:

```
git clone git@github.com:neo4j-examples/sdn-university.git
cd sdn-university
```

### Starting the application

No configuration is required as this application will run with a temporary embedded Neo4j Database by default. See below on how to set this up with a standalone Neo4j Server using bolt or the http drivers.

You can start the application using maven:

```
mvn spring-boot:run
```

And that's it! Head to <http://localhost:8080> to see your application running.

> **NOTE**
> If you restart your application you may notice changes made in your database disappear.
> That's because if you don't supply a directory to house the database only a temporary data store is set up (and gets destroyed on close).
> If you want the data to persist between restarts then in your favourite editor modify `src/main/resources/application.properties` and add a new line with `spring.data.neo4j.uri=file:///var/tmp/neo4j.db` or wherever you want your database to reside.

#### Using the binary Bolt driver

If you'd like to run this application using the fast bolt driver against a standalone Neo4j instance then you will need to do the following.

1. Mark sure you have a [Neo4j](http://neo4j.org) instance installed and running.
1. Change the `pom.xml` to comment out the embedded driver and the embedded neo4j instance dependencies and instead uncomment the bolt driver.
1. You'll need to provide connection credentials for the database to the bolt driver. To do this is to set the Neo4j username and password in `src/main/resources/application.properties`
    ```
    spring.data.neo4j.uri=bolt://localhost
    spring.data.neo4j.username=<your username>
    spring.data.neo4j.password=<your password>

    ```
1. You can then start the application using the same maven run command shown above.

#### Using the HTTP driver

If you'd like to run this application using the original REST HTTP driver against a standalone Neo4j instance then you will need to do the following.

1. Mark sure you have a [Neo4j](http://neo4j.org) instance installed and running.
1. Change the `pom.xml` to comment out the embedded driver and the embedded neo4j instance dependencies and instead uncomment the http driver.
1. You'll need to provide connection credentials for the database to the bolt driver. To do this is to set the Neo4j username and password in `src/main/resources/application.properties`
    ```
    spring.data.neo4j.uri=http://localhost:7474
    spring.data.neo4j.username=<your username>
    spring.data.neo4j.password=<your password>

    ```
1. You can then start the application using the same maven run command shown above.

### Loading the initial dataset

> **WARNING**
>
> By default, the application will use an Neo4j embedded instance of Neo4j.
> If you are running this application with the bolt or http drivers be careful as **IT WILL DESTROY ALL THE DATA IN THAT DATABASE** after hitting the URL below.
> So if you don't want that to happen please back up any existing database first.

You may notice that there is no data for you to interact with. To fix this hit the following endpoint from your browser or using `curl`:

<http://localhost:8080/api/reload>

This will pre-load the Neo4j database with a handful of departments, a dozen or so subjects and teachers,
and 200 students. You'll probably want to enrol them in classes...


### Stopping the application server

You can stop the application server at any time by pressing `Ctrl-C` in the console window from where you launched it.


Make it better!
---------------

If you'd like to contribute to the development of this application you will need to install:

- [NodeJS](https://nodejs.org/en/)
- [Bower](https://bower.io/)
- [GruntJS](http://gruntjs.com/)

Once you have followed their instruction on installation you will need to install the project's node and bower dependencies via:

```
git clone git@github.com:neo4j-examples/sdn-university.git
cd sdn-university
npm install  && bower install
```

You can then run the front end angular application simply by using:

```
grunt serve
```



If you would like to prepare a releasable version of your front end assets you can run:

```
grunt clean build
```

Your assets will then be available in the `src/main/resources/static` directory.

You can then run the maven boot run command to see your application served up entirely from Spring Boot!


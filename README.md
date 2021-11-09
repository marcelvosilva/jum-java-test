# Getting Started

First thing to do is to go in the application.properties file and change the spring.datasource.url to point to where the samples.db file is. In my computer it was on
C:\\Users\\marce\\Desktop\\exec_java\\exec_java\\sample.db

How to compile: Make sure you clone the project locally, and go in the application.properties file and change the spring.datasource.url to point to where the samples.db file is. In my computer it was on C:\\Users\\marce\\Desktop\\exec_java\\exec_java\\sample.db. You find this file in the resources directory too. After that just run "mvn clean install" on the root directory of the project (where the pom.xml file is).

After compiling, just execute "java -jar {jar file path}" or run the project through your IDE. The enpoint will be available on the URL: "http://localhost:8082/api/customers". Or if you have docker installed, just run the dockerfile.

To access the webpage, just enter on the frontend directory and double click on index.html and you can open it through your favorite browser.

Java Version: 11 (JDK 11.0.13.8-hotspot)

Tips:

- To view the api documentation, just access "http://localhost:8082/swagger-ui/" when the app is running.



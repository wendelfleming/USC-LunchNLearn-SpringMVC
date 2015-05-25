# USC-LunchNLearn-SpringMVC
USC Lunch-n-Learn for SpringMVC

This project is a Lunch-n-Learn for the University of Southern California.  The main topic will be Spring MVC,
but there are a lot of easter eggs in here.  So lets begin.

The project format is using Gradle.  If you don't have Gradle installed, that is OK.  It is boot strapped with
a Gradle wrapper.  To start you can execute the following gradle commands:

- gradlew tasks - show a list of Gradle tasks that can be executed.
- gradlew build - build the project
- gradlew test - run the unit tests
- gradlew jettyRunWar - starts Jetty - http://localhost:8080/lunchnlearn/spring/index.html

If you want to use an IDE (Eclipse or IntelliJ), it can also help with that.

https://docs.gradle.org/current/userguide/eclipse_plugin.html

To set up Eclipse, run the following commands:

- gradlew eclipse
- gradlew eclipse Java - NOTE: the capital J
- gradlew eclipse War

Once this is done, you can use File -> Import... -> Existing Projects into Workspace to import the project
into your workspace.



If you want to use IntelliJ, run the following command:

- gradlew idea

Or you can create a new IntelliJ project yourself by using the following instructions:

https://www.jetbrains.com/idea/help/creating-a-gradle-project.html

(Personally, I recommend the above for just Importing from Gradle because it sets things up in an IntelliJ way.)



This project is using the following technologies:
- Java 8
- Gradle
- Spring MVC
- JQuery
- Spring Data
- HSQLDB
- Jackson JSON
- JUnit
- Hamcrest

Here is a list of Easter Eggs features.  Some of which will be covered during the session, the
others are free to be discovered on your own (marked with *).  Some I would like to get to if time
is available (marked with +).

- Automatic configuration by using <servlet_name>-servlet.xml for XML based Spring configuration
- Spring MVC Annotation configuration for web controllers
- Spring MVC form:form, c:url, and other JSP custom tags
- Spring MVC EL tags
- Custom EL tags
- Spring MVC @RequestMapping and @PathVariable
- Spring MVC @RestController for REST calls
- REST calls to handle GET, PUT, and DELETE
- JQuery REST calls using PUT and DELETE
- JQuery dynamic form binding
- Spring Interceptors of controllers
- *jbreadcrumbs - the app uses jbreadcrumbs:
        http://www.comparenetworks.com/developers/jqueryplugins/jbreadcrumb.html
- *Java JPA entity configuration
- *Spring Data Repository interface based configuration
- *Spring Data http://docs.spring.io/spring-data/jpa/docs/current/reference/html/
- *Spring Data method name based queries
- *Spring Data JSON database loading for the application
- *Spring Data JSON database loading for unit testing
- *Spring Data persistence configuration without using persistence.xml
- +JUnit testing
- +Hamcrest matching during JUnit testing
- +Mocking a Spring MVC Web Application for testing with JUnit + Hamcrest

NOTE: This code is not 100% production quality code.  It was made for this session.  Also, there is
not much JavaDoc within the code itself.  The unit test are there as examples and not an attempt at
full coverage.  Also, there are duplicate configuration files within /main/resources and
/test/resources which I haven't cleaned up (do NOT do that in production code).

ADDENDUM:  A lot of this configuration and wiring can be greatly simplified by using Spring Boot.  I
highly recommend learning Spring Boot for new Spring based projects.  Spring Boot is now on my
study list.

All source code if freely available to use in your projects.

Thanks,

wendel
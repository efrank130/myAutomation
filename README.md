# Automation Testing project-IKEA online
This is a testing automation project that tests a online store: https://www.ikea.com/eg/en/

Project's language and frameworks:
* Java
* Selenium

Framework overview:

The framework utilizes a parent pom.xml and a common framework which is then added as a dependency to each individual test suite.
Using a parent pom allows the infrastructure team the ability to properly maintain all dependency versions and therefore avoid conflicts between projects.
This and the use of a common framework as a JAR and Maven dependency allows separate automation testers to manage their own repository while still being able to
use common methods for test execution.

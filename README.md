#My Retail [![Build Status](https://travis-ci.org/lenzenc/myretail.svg?branch=master)](https://travis-ci.org/lenzenc/myretail)
My Retail is a sample application showing how to provide a RESTFul API using a Java stack.

Source code for this project can be found here; [https://github.com/lenzenc/myretail](https://github.com/lenzenc/myretail)

All commits to master and branches kick off a Continuous Integration build that can be found here; [https://travis-ci.org/lenzenc/myretail](https://travis-ci.org/lenzenc/myretail)

## Overview
At the core of this application is a Domain Model called Product which provides simple attributes of what a product might be associated with, such as;
* Identify (DB)
* SKU (Unique External Identifier)
* Name (Description or Name of the Product)
* Category
* Price

On top of the Domain Model there is a "service" call InventoryFinder that provides services related to finding Products given different attributes such as SKU and Category.

Services of InventoryFinder as exposed externally via a RESTFul API layer using Spring MVC, the main controller is called ProductController.  See below for the API end points available to be functionally tested.

## Running
This project is using a Gradle build structure and has a plugin that embeds Tomcat into it.  The following command can be used to run this sample application.
 
    gradlew clean tomcatRun
    
### REST EndPoints
The following REST end points are available for functional testing of this application.
    
#### GET: v1/products
Provides a list of all products.

    http://localhost:8080/myretail/v1/products
    
#### GET: v1/products?category=toys
Finds all products for a given product category.

    http://localhost:8080/myretail/v1/products?category=toys
    
#### GET: v1/products/{sku}
Finds a product for a given SKU.

`NOTE` - SKU is considered a unique value in this application and is better to be used as an external identifier than a DB surrogate key.

    http://localhost:8080/myretail/v1/products/IOL123

## Testing
The following commands can be used to test the functionality of this application.

### Unit Tests
This command runs just the unit tests of this application.  Unit tests are considered as tests that focus on individual functionality and typically mocks up dependencies.

    gradlew test

### Integration Tests
This command runs just the integration tests of this application.  Integration tests are considered as tests that depend on external resources such as a DB or tests a combination of components together.

### All Tests
This command will run both unit and integration tests together and should be considered the main test command to run to ensure all tests are passing.

    gradlew allTests

## Development
As standard practice "project" file for an IDE are not checked into this projects repository.  However, given your typical/popular IDE they can be generated very easily.

### Eclipse
The following Gradle command will generate project files for Eclipse;

    gradlew eclipse
    
### IntelliJ
In most cases, if you are using a new version of IntelliJ, then all you need to do is import this project directory as a Gradle project from within IntelliJ which will generate the proper project files for this application.
    
There is also a Gradle command that will do the same as importing the project, similar to the Eclipse command;
    
    gradlew idea
    
### Building
This application can be built using the following command;
    
    gradlew clean build
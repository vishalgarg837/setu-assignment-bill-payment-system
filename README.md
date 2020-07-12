-- Langauge Used: Java
  - Language Version: 8
  - Build Automation Tool: Maven
  - Framework: Dropwizard
  - Database: Postgres
  
-- Prerequisites
   1. Maven should be installed as it would be required to build the project.
   2. Java8 should also be installed.

-- Assumptions
 1. No error is thrown even if payment is done after due date. 

-- Note
 1. Only the two APIs are exposed as per the requirement, test data is generated using 
    GenerateTestData.java in test package and it's ignored by default so it needs to be run 
    after commenting Ignore annotation if fresh data is required.
 2. API Key is hard-coded as it's out of the scope of problem statement.

-- How to execute the code
 1. Go to project directory and create Jar using command "mvn clean install" - It will create jar with name bill-payment-system-1.0-SNAPSHOT.jar in target folder in current project.
 2. Go to target folder e.g. /bill-payment-system/target/ and run jar using following command:
   java -jar bill-payment-system-1.0-SNAPSHOT.jar server <path_to_config_file>
 3. Postgres database needs to be configured locally.
   
-- API Key - f2717bab-2b22-4010-aad1-a5607f2c0b8e

-- Sample API Request and Responses: Visit https://hackmd.io/@ranjth-setu/r1rVE0Y28

-- Host: https://setu-assignment-bill-payment.herokuapp.com

   

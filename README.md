**Task Title**: Devowelizer
**Task Description**: Install & run docker. Make sure the container is up and running. Invoke a GET call on Service API with Endpoint(input), and verify the API response that should return input without vowels.
**Overview**: Implemented automation task to test this task and committed source to GIT repository. However, before run maven POM.xml to execute all test cases written in feature file, make sure Docker container is up and running. During automation development and testing process, several key aspects were addressed to enhance the "reliability" of the project. This section outlines the "defects" identified
**Test Automation**: The test development on Intellij IDE with the BDD style framework
**Projected Skillset**: Java, JUnit, Rest assured, Maven, Gherkin, Windows OS
**Reporting**: Added configurations to generate detailed HTML reports for both Maven Surefire and Cucumber. This allows for better visibility into test results, making it easier to identify issues and track test coverage.

**Test case development and Coverage:**
1. Test cases written in BDD for API (Because to showcase my knowledge and establish my core strengh of UI Automation)
2. Covered more than 12 test cases all for different type of edge cases including ASCII characters
3. For easy maintenance, used Scenario-outline in feature file

**Execution**: Open project in IDE, Select POM.XML. Open it in terminal. Enter the 'mvn clean install' and then 'mvn test' command
  
**Reporting** target/cucumber-html-report.html is used to generate reports automatically after execution. Just refresh the target folder under structure
Attached the picture of a report below
![DevowelizerTest-Report](https://github.com/user-attachments/assets/74346b9c-d364-4992-911c-fcb74b2bdd4b)

**My observations**:
# Observation1: Some cases failing intermittently and throwing 500 internal server error. There is a reliability issue on API Service
i.e. If the 1. input 'world$empi*re'; 2. input 'w0rld_EmpirE/'; 3. coevolutionary;
**Reason**: There might be some time limitation. Sometimes, time constraint causes the API service unable to parse subsequent requests. Hence, at least 3 to 5 requests throwing 500 error during automation execution. Able to repeat manually for somecases. Access to server logs could reveal more details.

# Observation2: Some cases giving wrong response. The camel case vowel letters are not vomitted from response returned
i.e. If the 1. input 'Intermediate'; Expected is 'ntrmdt' but found 'Íntrmdt'
Although the response code is 200
**Reason** Server is unable to handle such type of camel case. 

If the ticketing system is available the observations can be logged i.e. Jira system

**Limitations**:
1. Not tested Non-ASCII characters in the entire case. No Requirement is mentioned.
2. Puncuation mark '?' at the end of input, throwing 'IllegalArgumentException' but information on how to test this is not provided in requirement
3. If Punctuation mark '?' exist in the middle of input, ignores any of its following letters whatever from the input
4. No requirement mentioned the input size, I have tested 99 characters for a simple word but no issue 

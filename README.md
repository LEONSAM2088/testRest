# Test RestApi


## Reports
- Path of bug reports: targets/site/surefire-report.html (after run [site])
- Test cases describe in testCases.md

## Stack

- Testing framework: JUnit
- Build tool: Maven
- HTTP client: RestAssured

## DESCRIPTION:

### NEED TO DO:
1. Create and automate ALL necessary test cases using Java, JavaScript or Python programming languages (preferably Java) for EACH of the following actions:
- Filtering by query parameters (like /posts?userId=1)
- Get a resource by id
- Get list of all resources
You don't need to cover cases about CREATE, UPDATE and DELETE operations in this task.
Preferable technical stack for Java: 
- Testing framework: TestNG, JUnit
- Build tool: Maven, Gradle
- Assertion libraries: Hamcrest
- HTTP client: RestAssured, Retrofit
2. Describe P0 test cases in plain text about CREATE, UPDATE and DELETE operations.
To CREATE a resource you need to fill the next mandatory fields in the body of the request: title, body, userId.
To UPDATE a resource you need to fill necessary filed(s) in the body of the request.
UPDATE and DELETE operations are possible by the id of the resource.
Describe your test cases in the next format:
Summary	Steps	Expected result
		
3. Create a bug report for the next issue:
The request GET /posts/0 returned 404 Not Found, but you expect an empty list with 200 OK


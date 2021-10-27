# Test RestApi


## Reports
- Path of bug reports: targets/site/surefire-report.html (after run [site])
	![image](https://user-images.githubusercontent.com/54098301/138978010-0401b067-ce43-4b62-9f5a-a582f930003b.png)
	![image](https://user-images.githubusercontent.com/54098301/138978166-0ec7994c-3c65-4b5f-bc80-e2b5d30c3af4.png)

- Test cases describe in testCases.md

| Summary | Steps  | Expected  | Result  |
|---|---|---|---|
| Verify response when a GET all resources request is used  | #1  | The status code must be 200, and the response should not be empty | Status code is 200, and response isn't empty  |
| Verify response when a GET resources by 'userId' request is used  | #2  | The 'userId' must be equal to the specified ID| userId is equal to specified ID  | 
| Verify response when a GET resources by 'id' request is used  | #3  | The 'id' must be equal to the specified ID  | 'id' is equal to specified ID  |
| Verify response when a CREATE resources request is used | #4 | The status code must be 201, and the fields in response must be equal fields in request | The status code is 201, and fields in response is equal fields in request |
| Verify response when a UPDATE resources request is used | #5 | The status code must be 200. PUT request should return only the specified field and 'id', and the PATCH request should return all fields | Status code is 200, PUT request returned the specified fields, and PATCH returned all fields |
| Verify response when a DELETE resources request is used | #6 | The status code must be 200 | The status code is 200 |	


## Stack

- Testing framework: JUnit
- Build tool: Maven
- HTTP client: RestAssured

## DESCRIPTION:

### DONE:
1. Created and automated ALL necessary test cases using Java programming language for EACH of the following actions:
- Filtering by query parameters (like /posts?userId=1)
- Get a resource by id
- Get list of all resources

2. Described P0 test cases in plain text about CREATE, UPDATE and DELETE operations.
- To CREATE a resource filled the next mandatory fields in the body of the request: title, body, userId.
- To UPDATE a resource filled necessary filed(s) in the body of the request.
- Described test cases.

		
3. Created a bug report for the next issue:
`The request GET /posts/0 returned 404 Not Found, but you expect an empty list with 200 OK`


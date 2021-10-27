# Test RestApi


## Reports
- Bug report: 
	
| Summary | Image  | Expected  | Result  | Bug Severity | Type of bug |
|---|---|---|---|---|---|
|The request GET /posts/0 returned 404 Not Found |![image](https://user-images.githubusercontent.com/54098301/138980980-546d2040-a1b8-4696-b6d6-cb4feefc59c2.png)| Empty list with code 200|Status code 404| S2 | Functional |

![image](https://user-images.githubusercontent.com/54098301/138982456-2ef63d67-6138-4c56-9b69-d9ecc91af657.png)

- Test cases: 

	also described in `targets/site/surefire-report.html` (after run `site`)

| Summary | Steps  | Expected  | Result  |
|---|---|---|---|
| Verify response when a `GET` all resources request is used  | #1  | The status code must be 200, and the response should not be empty | Status code is 200, and response isn't empty  |
| Verify response when a `GET` resources by 'userId' request is used  | #2  | The 'userId' must be equal to the specified ID| userId is equal to specified ID  | 
| Verify response when a `GET` resources by 'id' request is used  | #3  | The 'id' must be equal to the specified ID  | 'id' is equal to specified ID  |
| Verify response when a `CREATE` resources request is used | #4 | The status code must be 201, and the fields in response must be equal fields in request | The status code is 201, and fields in response is equal fields in request |
| Verify response when a `UPDATE` resources request is used | #5 | The status code must be 200. `PUT` request should return only the specified field and 'id', and the `PATCH` request should return all fields | Status code is 200, `PUT` request returned the specified fields, and `PATCH` returned all fields |
| Verify response when a `DELETE` resources request is used | #6 | The status code must be 200 | The status code is 200 |	


## Stack

- Testing framework: JUnit
- Build tool: Maven
- HTTP client: RestAssured
- Assertion libraries: Hamcrest

## DESCRIPTION:

### DONE:
1. Created and automated ALL necessary test cases using Java programming language for EACH of the following actions:
- Filtering by query parameters (like /posts?userId=1)
- Get a resource by id
- Get list of all resources

2. Described P0 test cases in plain text about CREATE, UPDATE and DELETE operations.
		
3. Created a bug report for the next issue:
`The request GET /posts/0 returned 404 Not Found, but you expect an empty list with 200 OK`


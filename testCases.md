# Description of my test cases

| Summary | Steps  | Expected  | Result  |
|---|---|---|---|
| Verify response when a GET all resources request is used  | #1  | The status code must be 200, and the response should not be empty | Status code is 200, and response isn't empty  |
| Verify response when a GET resources by 'userId' request is used  | #2  | The 'userId' must be equal to the specified ID| userId is equal to specified ID  | 
| Verify response when a GET resources by 'id' request is used  | #3  | The 'id' must be equal to the specified ID  | 'id' is equal to specified ID  |
| Verify response when a CREATE resources request is used | #4 | The status code must be 201, and the fields in response must be equal fields in request | The status code is 201, and fields in response is equal fields in request |
| Verify response when a UPDATE resources request is used | #5 | The status code must be 200. PUT request should return only the specified field and 'id', and the PATCH request should return all fields | Status code is 200, PUT request returned the specified fields, and PATCH returned all fields |
| Verify response when a DELETE resources request is used | #6 | The status code must be 200 | The status code must is 200 |
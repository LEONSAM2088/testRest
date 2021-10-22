import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;
import pojos.UserPojo;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class APIFilteringTest {

    private static final String requestCreateBody = """
            {
              "userId": "1",
              "title": "bar",
              "body": "foo"\s
            }""";

    private static final String requestPutBody = """
            {
              "title": "foo",
              "body": "baz",
              "userId": "1",
              "id": "1"\s
            }""";

    private static final String requestPatchBody = """
            {
              "title": "testTitle"\s
            }""";


    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
          }

    @Test
    public void getAResourceByUserId() {



        assertThat("It should be empty", getByUsersId(-1), equalTo(new ArrayList<>()));
        assertThat("It should be empty", getByUsersId(125), equalTo(new ArrayList<>()));
        assertFalse("It should not be empty", getByUsersId(8).isEmpty());

        given()
                .contentType(ContentType.JSON)
                .get("/posts/122")
                .then().statusCode(404);

        for (UserPojo s: getByUsersId(4)
             ) {
            assertEquals(4, s.getUserId());
        }

        List<UserPojo> res = getByUsersId(8);
        assertEquals("""
                occaecati a doloribus
                iste saepe consectetur placeat eum voluptate dolorem et
                qui quo quia voluptas
                rerum ut id enim velit est perferendis""", res.get(0).getBody());
    }

    @Test
    public void  getAResourceById() {



        assertThat("It should be empty", getById(-1), equalTo(new ArrayList<>()));
        assertThat("It should be empty", getById(125), equalTo(new ArrayList<>()));
        assertFalse("It should not be empty", getById(15).isEmpty());


        given()
                .contentType(ContentType.JSON)
                .get("https://jsonplaceholder.typicode.com/posts/125")
                .then().statusCode(404);

        given()
                .contentType(ContentType.JSON)
                .get("https://jsonplaceholder.typicode.com/posts/5")
                .then().statusCode(200);



        assertEquals("Id is not equal 7",7, getById(7).get(0).getId());


        Response response =
        given()
                .contentType(ContentType.JSON)
                .get("https://jsonplaceholder.typicode.com/posts/0")
                .then().extract().response();
        assertEquals("The request GET /posts/0 returned 404 Not Found, but expect an empty list with 200 OK",200, response.statusCode());

    }

    @Test
    public void getListOfAllResources() {
        List<UserPojo> res = given()
                .get("https://jsonplaceholder.typicode.com/posts" )
                .then()
                .statusCode(200).extract().jsonPath().getList("", UserPojo.class);

        assertFalse(res.isEmpty());
    }




    @Test
    public void createOperation() {
        Response response = given()
                .contentType(ContentType.JSON)
                .and()
                .body(requestCreateBody)
                .when()
                .post("/posts")
                .then()
                .extract().response();

        assertEquals(201, response.statusCode());
        assertEquals("bar", response.jsonPath().getString("title"));
        assertEquals("foo", response.jsonPath().getString("body"));
        assertEquals("1", response.jsonPath().getString("userId"));
        assertEquals("101", response.jsonPath().getString("id"));
    }

    @Test
    public void UpdateOperations() {


        Response response_put = given()
                .contentType(ContentType.JSON)
                .and()
                .body(requestPutBody)
                .when()
                .put("/posts/1")
                .then()
                .extract().response();

        assertEquals(200, response_put.statusCode());
        assertEquals("foo", response_put.jsonPath().getString("title"));
        assertEquals("baz", response_put.jsonPath().getString("body"));
        assertEquals("1", response_put.jsonPath().getString("userId"));
        assertEquals("1", response_put.jsonPath().getString("id"));

        Response response_patch = given()
                .contentType(ContentType.JSON)
                .and()
                .body(requestPatchBody)
                .when()
                .patch("/posts/1")
                .then()
                .extract().response();

        assertEquals(200, response_patch.statusCode());
        assertEquals("testTitle", response_patch.jsonPath().getString("title"));
        assertEquals("1", response_patch.jsonPath().getString("userId"));
        assertEquals("1", response_patch.jsonPath().getString("id"));
    }

    @Test
    public void deleteOperation() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .delete("/posts/1")
                .then()
                .extract().response();

        assertEquals(200, response.statusCode());
    }

    public List<UserPojo> getByUsersId(long id) {
        return given()
                .contentType(ContentType.JSON)
                .param("userId", id)
                .get("/posts")
                .then().statusCode(200).extract().jsonPath().getList("", UserPojo.class);


    }
    public List<UserPojo> getById(long id) {
        return given()
                .contentType(ContentType.JSON)
                .param("id", id)
                .get("/posts")
                .then().statusCode(200).extract().jsonPath().getList("", UserPojo.class);
    }


}

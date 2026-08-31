package lesson8;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;

public class TestRequestMethods {
    @Test
    public void get_thenStatus200test() {
        given()
                .baseUri("http://postman-echo.com")
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("args", response -> hasEntry("foo1", "bar1"))
                .body("args", response -> hasEntry("foo2", "bar2"));

    }

    @Test
    public void postRawTextTest() {
        String requestBody = "{\n" +
                "    \"test\": \"value\"\n" +
                "}";

        given()
                .baseUri("https://postman-echo.com")
                .contentType("application/json")
                .header("Cookie", "__cf_bm=LZNl0uf_9KD3oEjKo5HO49F4Uy8wJ2_.t.Q7XzL0jvk-1788154283.2227778-1.0.1.1-en84ybOvSGM8DP8NYvYq563feFdMlMFe2OkrXxedNit2l5s7AMrmSMUzJGOScuRJy2crNiopl5EZ6fOqcXX8kl60gS3Nr8xxJTzWpyXDhCCXV1jk3pMu7pJ.9DtuMu9D; _cfuvid=UePWPW5_XRtL4Ls1csx93g1HIipi10q3aMU5eR458XY-1788154283.2227778-1.0.1.1-vSNljpoQpd3DeGysGXhZKMQuKkQW2GX3QrOd3CCbdqI; sails.sid=s%3A25ka2ttk2Xa4P6u1y6mRVcaUarwRYZKX.hocZHV7U49ohaYguurwbizc2CtxUOs0nqfaQ4m0CRQc")
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("json.test", equalTo("value"));
    }

    @Test
    public void postFormDataTest() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"));
    }

    @Test
    public void putTextDataTest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .header("Cookie", "__cf_bm=c4c2J1Mn0NiGu2TJLwEOp4mJ08LXBs1k2WdM38lIRNo-1788157878.5181868-1.0.1.1-4qgpWlfR3revFJY_L3rSszDhMrLD4GLC6aNpVeBlayadDhOqJiT6LrqJHhBV4iWVnVI9d3YiurfdBX5hnzt.TjdLrQyHHQ_yiB8NuZjOGnPj5fL787rodapLh4N164v_; _cfuvid=UePWPW5_XRtL4Ls1csx93g1HIipi10q3aMU5eR458XY-1788154283.2227778-1.0.1.1-vSNljpoQpd3DeGysGXhZKMQuKkQW2GX3QrOd3CCbdqI; sails.sid=s%3AO8kviw6ZCul-giBFCTlHUr930SnaxfbK.IMm5Q0%2FEIgpaklkvNjvOuREhSgfH6fmKGSWkc3d5woM")
                .body(requestBody)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }

    @Test
    public void patchTextDataTest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .header("Cookie", "__cf_bm=c4c2J1Mn0NiGu2TJLwEOp4mJ08LXBs1k2WdM38lIRNo-1788157878.5181868-1.0.1.1-4qgpWlfR3revFJY_L3rSszDhMrLD4GLC6aNpVeBlayadDhOqJiT6LrqJHhBV4iWVnVI9d3YiurfdBX5hnzt.TjdLrQyHHQ_yiB8NuZjOGnPj5fL787rodapLh4N164v_; _cfuvid=UePWPW5_XRtL4Ls1csx93g1HIipi10q3aMU5eR458XY-1788154283.2227778-1.0.1.1-vSNljpoQpd3DeGysGXhZKMQuKkQW2GX3QrOd3CCbdqI; sails.sid=s%3AO8kviw6ZCul-giBFCTlHUr930SnaxfbK.IMm5Q0%2FEIgpaklkvNjvOuREhSgfH6fmKGSWkc3d5woM")
                .body(requestBody)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }

    @Test
    public void deleteTextDataTest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .header("Cookie", "__cf_bm=c4c2J1Mn0NiGu2TJLwEOp4mJ08LXBs1k2WdM38lIRNo-1788157878.5181868-1.0.1.1-4qgpWlfR3revFJY_L3rSszDhMrLD4GLC6aNpVeBlayadDhOqJiT6LrqJHhBV4iWVnVI9d3YiurfdBX5hnzt.TjdLrQyHHQ_yiB8NuZjOGnPj5fL787rodapLh4N164v_; _cfuvid=UePWPW5_XRtL4Ls1csx93g1HIipi10q3aMU5eR458XY-1788154283.2227778-1.0.1.1-vSNljpoQpd3DeGysGXhZKMQuKkQW2GX3QrOd3CCbdqI; sails.sid=s%3AO8kviw6ZCul-giBFCTlHUr930SnaxfbK.IMm5Q0%2FEIgpaklkvNjvOuREhSgfH6fmKGSWkc3d5woM")
                .body(requestBody)
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }
}



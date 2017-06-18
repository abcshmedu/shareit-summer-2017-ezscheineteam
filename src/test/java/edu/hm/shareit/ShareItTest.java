package edu.hm.shareit;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import edu.hm.shareit.business.ServiceStatus;
import edu.hm.shareit.filter.AuthenticationFilter;
import edu.hm.shareit.util.AuthServToken;
import io.restassured.http.ContentType;

@SuppressWarnings({"JavadocType", "JavadocMethod"})
public class ShareItTest {

    private final String token;
    
    public ShareItTest() {
        AuthServToken authServToken = new AuthServToken();
        token = authServToken.getToken("WalterWhite", "knockknock");
    }
    
    static {
        basePath = "/shareit/media";
    }
    
    @Test
    public void testJsonMappingException() {
        given()
        .header(AuthenticationFilter.TOKEN_HEADER_FIELD, token)
        .contentType(ContentType.JSON)
        .body("{\"titel\":\"titel\",\"author\":\"author\",\"isbn\":\"42\"}")
        .when().post("/books")
        .then()
        .statusCode(ServiceStatus.ERROR_PARSING_JSON.getStatus())
        .body("status", equalTo(ServiceStatus.ERROR_PARSING_JSON.getStatus()))
        .body("detail", equalTo(ServiceStatus.ERROR_PARSING_JSON.getDetail()));
    }

}

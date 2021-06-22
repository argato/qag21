package helpers;

import static io.restassured.RestAssured.given;

import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;

public class Browserstack {

  public static final BrowserstackConfig browserstackConfig =
      ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

  public static String videoUrl(String sessionId) {
    return given()
        .auth().basic(browserstackConfig.username(), browserstackConfig.key())
        .when()
        .get(browserstackConfig.sessionUrl() + sessionId + ".json")
        .then()
        .statusCode(200)
        .log().body()
        .extract()
        .response()
        .path("automation_session.video_url");
  }
}
package Utils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.*;

public class SpecBuild {

    public static RequestSpecification requestSpecBuilder() throws IOException {

        PrintStream ps = new PrintStream(new FileOutputStream("log.txt", true));
        RequestSpecBuilder request = new RequestSpecBuilder().setBaseUri(ReusableMethods.getProperty("baseURI")).setContentType(ContentType.JSON)
                .addQueryParam("key","qaclick123")
                .addHeader("Content-Type", "application/json")
                .addFilter(RequestLoggingFilter.logRequestTo(ps))
                .addFilter(ResponseLoggingFilter.logResponseTo(ps));
        return request.build();
    }
    
    public static ResponseSpecification responseSpecBuilder() {
        ResponseSpecBuilder response = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON);
        return response.build();
    }
}

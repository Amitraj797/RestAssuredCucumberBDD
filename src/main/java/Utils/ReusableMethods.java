package Utils;

import io.restassured.path.json.JsonPath;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReusableMethods {

    public static JsonPath rawToJson(String response)
    {
        return new JsonPath(response);
    }

    public static String getProperty(String key) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis= new FileInputStream("src/test/resources/global.properties");
        prop.load(fis);
        return prop.getProperty(key);
    }

}

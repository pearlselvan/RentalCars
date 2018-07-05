package utils;
import org.apache.log4j.Logger;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
// AppConfigUtility class for reading App.Properties config values
public class AppConfigUtility {
    final static Logger logger = Logger.getLogger(AppConfigUtility.class);
    private static final Map<String, String> map = new HashMap<String, String>();

    static {
        Properties prop = new Properties();
        try (InputStream input = new FileInputStream("src/main/resources/App.Properties")) {
            prop.load(input);
            map.put("carJsonFileName", prop.getProperty("json.car.filename"));
            map.put("carAudiMake", prop.getProperty("json.car.audi.make"));
            map.put("carTeslaMake", prop.getProperty("json.car.tesla.make"));
            map.put("carAudiBlack", prop.getProperty("json.car.audi.black"));
            map.put("carTeslaBlue", prop.getProperty("json.car.tesla.blue"));
            map.put("carSchemaFileName", prop.getProperty("car.json.schema.filename"));
            map.put("carInvalidSchemaFileName", prop.getProperty("car.json.invalid.schema.filename"));
        } catch(Exception e) {
            //we can do the exception handling
            logger.fatal("Got Exception reading auth.properties :" + e);
        }
    }

    /**
     *
     * @return map of the app configuration
     */

    private static Map<String, String> initialize() {
        return map;
    }
    public static String getValue(String key) {
        return AppConfigUtility.initialize().get(key);
    }
}
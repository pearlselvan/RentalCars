package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Cars;
import org.apache.log4j.Logger;
import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import static utils.AppConfigUtility.getValue;

import java.io.IOException;
import java.util.List;

/**
 * Util Class for reading json file as Object and Validate Json Schema
 */
public class JsonUtils {

    final  static Logger logger = Logger.getLogger(JsonUtils.class);


    public static String getSonStringFromList(List<String> list) {
        String arrayToJson = null ;

        ObjectMapper listobjectMapper = new ObjectMapper();
        try {
            arrayToJson   = listobjectMapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        logger.info(" getSonStringFromList : " +arrayToJson);
        return arrayToJson;
    }

    /**
     *
     * @param jsonFileName
     * @param schemaFileName
     * @return boolean True if json valid
     */
    public static boolean checkJsonSchema(String jsonFileName,String schemaFileName) {


        boolean isValid = false;
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        JSONObject jsonSchema = new JSONObject(
                new JSONTokener(classloader.getResourceAsStream(schemaFileName)));
        JSONObject jsonSubject = new JSONObject(new JSONTokener(classloader.getResourceAsStream(jsonFileName)));
        Schema schema = SchemaLoader
                .load(jsonSchema);
        try {
            schema.validate(jsonSubject);
            logger.info("Json Validation is success");
            isValid=true;

        } catch ( ValidationException e) {
            logger.fatal("Json Validation Exception  : " +e.getMessage());

        }

        return isValid;

    }

    /**
     *
     * @param filename
     * @return Car json object
     */
    public static Cars getJsonObject(String filename) {
        Cars cars = null;
        if (checkJsonSchema(getValue("carJsonFileName"),getValue("carSchemaFileName"))) {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                cars = objectMapper.readValue(classloader.getResourceAsStream(getValue("carJsonFileName")), Cars.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return cars;
    }
}

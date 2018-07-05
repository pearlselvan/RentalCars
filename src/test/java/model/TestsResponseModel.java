package model;

import org.junit.Before;
import org.junit.Test;
import service.CarService;
import service.RentalCarCache;
import service.RentalCarServiceImpl;
import utils.JsonUtils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static utils.AppConfigUtility.getValue;

public class TestsResponseModel {

    CarService rentalCarService = new RentalCarServiceImpl();

    JsonUtils jsonUtils = new JsonUtils();
    Cars car = null ;

    @Before
    public  void runOnceBeforeClass() {
        car = JsonUtils.getJsonObject(getValue("carJsonFileName"));
    }


    @Test
    public void testCarExist() {
        assertNotNull(car.getCar().get(0).getMake());
    }


    @Test
    public void testMetaData() {
        assertNotNull(car.getCar().get(0).getMetadata().get(0).getColor());
    }

    @Test
    public void testDataServiceCache() {
        assertTrue(RentalCarCache.getJsonCacheList().size() != 0);
    }


}

package repository;

import model.Cars;
import org.junit.Before;
import org.junit.Test;
import service.CarService;
import service.RentalCarCache;
import service.RentalCarServiceImpl;
import utils.JsonUtils;

import java.util.List;

import static org.junit.Assert.*;
import static utils.AppConfigUtility.getValue;

public class TestsData {


    CarService rentalCarService = new RentalCarServiceImpl();
    List<CarDataRepo> carJsonList = RentalCarCache.getJsonCacheList();

    JsonUtils jsonUtils = new JsonUtils();
    Cars car = null ;

    @Before
    public  void runOnceBeforeClass() {
        car = JsonUtils.getJsonObject(getValue("carJsonFileName"));

    }


   @Test
   public void testCreateData() {
       CarDataRepo carDataRepo = new CarDataRepo();
       carDataRepo.setCarMake("BMW");
       assertEquals("BMW",carDataRepo.getCarMake());
   }


   @Test
   public void testScehmaDataType(){
        assertFalse(JsonUtils.checkJsonSchema(getValue("carInvalidSchemaFileName"),getValue("carSchemaFileName")));

   }

   @Test
   public void testCreteObject() {
        CarDataRepo minCooper = new CarDataRepo(2190.76,2256.43,5
                           ,24,150, 15,"Mini Cooper","Dent in left door","GREEN","09AGHY611111JITEG98K","A100");
       assertEquals("GREEN",minCooper.getColor());
       assertEquals("Dent in left door",minCooper.getNotes());
   }


    @Test
    public void testCarService() {
        assertTrue(rentalCarService.getCarNotesByColor(carJsonList,getValue("carTeslaMake"),getValue("carTeslaBlue")).size() !=0);
    }

}

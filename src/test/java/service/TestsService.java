package service;

import model.Cars;
import org.junit.Before;
import org.junit.Test;
import repository.CarDataRepo;
import utils.JsonUtils;

import java.util.List;

import static utils.AppConfigUtility.getValue;

import static org.junit.Assert.*;

public class TestsService {
    CarService rentalCarService = new RentalCarServiceImpl();
    List<CarDataRepo> carJsonList = RentalCarCache.getJsonCacheList();
    Cars car = null ;

    @Before
    public  void runOnceBeforeClass() {

        car = JsonUtils.getJsonObject(getValue("carJsonFileName"));
    }


    @Test
    public void testCarMake() {
        assertNotNull(car.getCar().get(0).getMake());
    }


    @Test
    public void testCarColorByModel() {
        assertTrue(rentalCarService.getCarNotesByColor(carJsonList,getValue("carTeslaMake"),getValue("carTeslaBlue")).size() !=0);
    }

    @Test
    public void testLowestPrice() {
        assertTrue(rentalCarService.findLowestPrice(carJsonList) !=0.0);
    }


    @Test
    public void testHighestProfit() {
        assertTrue(rentalCarService.highestProfitCarOftheYear(carJsonList) !=0.0);
    }

    @Test
    public void testHighestProfitoftheYear() {
        CarDataRepo minCooper = new CarDataRepo(2190.76,2256.43,5
                ,24,150, 15,"Mini Cooper","Dent in left door","Green","09AGHY611111JITEG98K","A100");
        carJsonList.add(minCooper);
        CarDataRepo benzModel = new CarDataRepo(2000.76,500.43,8
                ,34,180, 12,"Benz Super","Dent in right door","White","78119065611111JEG98K","A200");
        carJsonList.add(minCooper);
        assertTrue(rentalCarService.findLowestPrice(carJsonList) < 150);
        assertFalse(rentalCarService.findLowestPrice(carJsonList) > 180);

    }

}

package appMain;

import org.apache.log4j.Logger;
import repository.CarDataRepo;
import service.CarService;
import service.RentalCarServiceImpl;


import service.RentalCarCache;
import utils.JsonUtils;

import static utils.AppConfigUtility.getValue;

import java.util.List;


public class RentalCarApp {

    static CarService rentalCarService = new RentalCarServiceImpl();
    static RentalCarCache vehicleDataService = new RentalCarCache();
    static List<CarDataRepo> carJsonList  = vehicleDataService.getJsonCacheList();


    final  static Logger logger = Logger.getLogger(RentalCarApp.class);

    public static void main(String[] args) {

        //Question 1 :
        displayNotes(carJsonList,getValue("carTeslaMake"),getValue("carTeslaBlue"));

       //Question 2 :
        lowestPerDayRental(carJsonList);

        //Question 3: Find the highest revenue generating car
        findHighestProfit(carJsonList);
    }


    public static void displayNotes(List<CarDataRepo> carJsonList, String carMake,String carColor) {
        rentalCarService.getCarNotesByColor(carJsonList,carMake,carColor).forEach(
                car -> System.out.println("Teslas Notes for Car Color Blue : " +car.getNotes())
        );
    }


    //Return all cars which have the lowest per day rental cost for Price only and Price after discounts
    public static void lowestPerDayRental(List<CarDataRepo> carJsonList) {
        System.out.println("Lowest Rental Per day " +rentalCarService.findLowestPrice(carJsonList));

    }

    public static void findHighestProfit(List<CarDataRepo> carJsonList) {
        System.out.println("Highest Profit " +rentalCarService.highestProfitCarOftheYear(carJsonList));

    }

}

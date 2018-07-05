package service;

import repository.CarDataRepo;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Implementation for Car Service interface for car json data analysis
 */
public class RentalCarServiceImpl implements CarService {
    final  static Logger logger = Logger.getLogger(RentalCarServiceImpl.class);

  // For storing lowest price in Hash map to reuse this in finding highest profit
    static  HashMap<String, Double> lowestPriceMap = new HashMap<>();
    static {
        RentalCarCache.loadCarJsonCache();
    }

    /**
     *
     * @param carJsonList
     * @param carName
     * @param color
     * @return : Matched color and carname from json car object
     */
    public List<CarDataRepo> getCarNotesByColor(List<CarDataRepo> carJsonList , String carName, String color) {
        return carJsonList.stream().filter(
                listdata ->
                        carName.equals(listdata.getCarMake()) &&
                                color.equals(listdata.getColor())).collect(Collectors.toList());

    }
    /**
     *
     * @param carJsonList
     * @return Lowest price from the list of car object
     */
    public Double findLowestPrice(List<CarDataRepo> carJsonList) {
        int price,discounts = 0 ;
        Double discount, priceVal,dicountPrice,actualPrice= 0.0;
        String vin = null;
        PriorityQueue<Double> lowestPriceQueue = new PriorityQueue<>();
        for (int i=0;i<carJsonList.size()-1;i++) {
            price = carJsonList.get(i).getActualPrice();
            discounts = carJsonList.get(i).getDiscountPrice();
            discount = Double.valueOf(discounts);
            priceVal = Double.valueOf(price);
            dicountPrice = priceVal * discount/100 ;
            actualPrice = priceVal - dicountPrice ;
            lowestPriceQueue.add(actualPrice);
            vin=carJsonList.get(i).getVin() ;
            lowestPriceMap.put(vin,actualPrice);
        }
        System.out.println("Vin number for lowest price rental car : " +vin);
        return lowestPriceQueue.peek();
    }
    /**
     *
     * @param carJsonList
     * @return Highest Profit from the list of car object
     */
    public Double highestProfitCarOftheYear(List<CarDataRepo> carJsonList) {
        PriorityQueue<Double> highProfitqueue = new PriorityQueue<>(Collections.reverseOrder());
        int totalRentalCount =  0 , lastWeekRentalCount= 0, yearRentalCount = 0;
        String vin=null;
        for (int i=0;i<carJsonList.size()-1;i++) {
            Double yearMaintenanceCost = carJsonList.get(i).getYearMaintenanceCost();
            Double depreciationCost = carJsonList.get(i).getDepreciationCost();
            Double totalExpense = yearMaintenanceCost + depreciationCost ;
            lastWeekRentalCount = carJsonList.get(i).getLastWeekRentalCount();
            yearRentalCount = carJsonList.get(i).getYearRentalCount();
            totalRentalCount = lastWeekRentalCount + yearRentalCount ;
            vin = carJsonList.get(i).getVin() ;

            if (lowestPriceMap.size() <= 0)
                findLowestPrice(carJsonList);

            Double actualPrice = lowestPriceMap.get(vin);
            Double revenueBeforeExpense = totalRentalCount *  actualPrice;
            Double revenueAfterExpense = revenueBeforeExpense -  totalExpense;
            highProfitqueue.add(revenueAfterExpense);

        }
        System.out.println("Vin for Highest Profit Car in Year" +vin);
        return highProfitqueue.peek();
    }
}
package service;

import model.Cars;
import repository.CarDataRepo;
import utils.JsonUtils;
import java.util.LinkedList;
import java.util.List;
import static utils.AppConfigUtility.getValue;


public class RentalCarCache {
    static Cars car = null;
    static List<CarDataRepo> jsonCacheList = new LinkedList<>();
    public static List<CarDataRepo> getJsonCacheList() {
        return jsonCacheList;
    }

    public static void setJsonCacheList(List<CarDataRepo> jsonCacheList) {
        RentalCarCache.jsonCacheList = jsonCacheList;
    }


    /**
     *
     * @return : List of car object for processing CarService
     */
    public static List<CarDataRepo> loadCarJsonCache() {
        Double yearMaintenanceCost ,depreciationCost = 0.0  ;
        Integer lastWeekRentalCount, yearRentalCount = 0 ;
        String carMake,carColor , carNotes ,vin , carModel = null ;
        car=JsonUtils.getJsonObject(getValue("json.car.filename"));
        for (int i=0;i<=car.getCar().size()-1;i++) {
            int price = car.getCar().get(i).getPerdayrent().get(0).getPrice();
            int discounts = car.getCar().get(i).getPerdayrent().get(0).getDiscount();
            yearMaintenanceCost = car.getCar().get(i).getMetrics().get(0).getYoymaintenancecost();
            depreciationCost = car.getCar().get(i).getMetrics().get(0).getDepreciation();
            lastWeekRentalCount = car.getCar().get(i).getMetrics().get(0).getRentalcount().get(0).getLastweek();
            yearRentalCount = car.getCar().get(i).getMetrics().get(0).getRentalcount().get(0).getYeartodate();
            carMake = car.getCar().get(i).getMake();
            carColor = car.getCar().get(i).getMetadata().get(0).getColor();
            carNotes = car.getCar().get(i).getMetadata().get(0).getNotes();
            carModel = car.getCar().get(i).getModel();
            vin = car.getCar().get(i).getVin();
            CarDataRepo metricDataRepo = new CarDataRepo(yearMaintenanceCost,depreciationCost,lastWeekRentalCount
                    ,yearRentalCount,price, discounts,carMake,carNotes,carColor,vin,carModel);
            jsonCacheList.add(metricDataRepo);
        }
        setJsonCacheList(jsonCacheList);
        return jsonCacheList;
    }
}

package service;

import model.Cars;
import repository.CarDataRepo;
import java.util.List;

/**
 * Car Service interface for car json data analysis
 */
public interface CarService {
     public Double highestProfitCarOftheYear(List<CarDataRepo> carJsonList);
     public Double findLowestPrice(List<CarDataRepo> carJsonList);
     public List<CarDataRepo> getCarNotesByColor(List<CarDataRepo> carJsonList,String carName, String color);
}
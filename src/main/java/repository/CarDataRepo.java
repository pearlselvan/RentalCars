package repository;

public class CarDataRepo {

    //metrics object
    private Double yearMaintenanceCost ;
    private Double depreciationCost ;
    private Integer lastWeekRentalCount ;
    private Integer yearRentalCount ;

    //perdayrent Object
    private Integer actualPrice ;
    private Integer discountPrice ;

    //metadata
    private String carMake ;
    private String notes ;
    private String color ;
    private String vin ;
    private String model ;

    public CarDataRepo(Double yearMaintenanceCost, Double depreciationCost, Integer lastWeekRentalCount, Integer yearRentalCount, Integer actualPrice, Integer discountPrice, String carMake, String notes, String color, String vin, String model) {
        this.yearMaintenanceCost = yearMaintenanceCost;
        this.depreciationCost = depreciationCost;
        this.lastWeekRentalCount = lastWeekRentalCount;
        this.yearRentalCount = yearRentalCount;
        this.actualPrice = actualPrice;
        this.discountPrice = discountPrice;
        this.carMake = carMake;
        this.notes = notes;
        this.color = color;
        this.vin = vin;
        this.model = model;
    }

    public CarDataRepo() {

    }
    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getYearMaintenanceCost() {
        return yearMaintenanceCost;
    }

    public void setYearMaintenanceCost(Double yearMaintenanceCost) {
        this.yearMaintenanceCost = yearMaintenanceCost;
    }

    public Double getDepreciationCost() {
        return depreciationCost;
    }

    public void setDepreciationCost(Double depreciationCost) {
        this.depreciationCost = depreciationCost;
    }

    public Integer getLastWeekRentalCount() {
        return lastWeekRentalCount;
    }

    public void setLastWeekRentalCount(Integer lastWeekRentalCount) {
        this.lastWeekRentalCount = lastWeekRentalCount;
    }

    public Integer getYearRentalCount() {
        return yearRentalCount;
    }

    public void setYearRentalCount(Integer yearRentalCount) {
        this.yearRentalCount = yearRentalCount;
    }

    public Integer getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(Integer actualPrice) {
        this.actualPrice = actualPrice;
    }

    public Integer getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Integer discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public String toString() {
        return "CarDataRepo{" +
                "yearMaintenanceCost=" + yearMaintenanceCost +
                ", depreciationCost=" + depreciationCost +
                ", lastWeekRentalCount=" + lastWeekRentalCount +
                ", yearRentalCount=" + yearRentalCount +
                ", actualPrice=" + actualPrice +
                ", discountPrice=" + discountPrice +
                ", carMake='" + carMake + '\'' +
                ", notes='" + notes + '\'' +
                ", color='" + color + '\'' +
                ", vin='" + vin + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}

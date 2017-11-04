package products;

public class Car extends Vehicle {

    private int numberOfSeats;
    private String airConditionerType;

    public Car(String id, String brand, String model, Double price, String category, String type, Double height, Double width, Double depth, int weight, Double reviewPoint, String vehicleType, int power, String fuelType, int numberOfSeats, String airConditionerType) {
        super(id, brand, model, price, category, type, height, width, depth, weight, reviewPoint, vehicleType, power, fuelType);
        this.numberOfSeats = numberOfSeats;
        this.airConditionerType = airConditionerType;
    }

    public Car(String brand, String model, Double price, String category, String type, Double height, Double width, Double depth, int weight, String vehicleType, int power, String fuelType, int numberOfSeats, String airConditionerType) {
        super(brand, model, price, category, type, height, width, depth, weight, vehicleType, power, fuelType);
        this.numberOfSeats = numberOfSeats;
        this.airConditionerType = airConditionerType;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getAirConditionerType() {
        return airConditionerType;
    }

    public void setAirConditionerType(String airConditionerType) {
        this.airConditionerType = airConditionerType;
    }
}
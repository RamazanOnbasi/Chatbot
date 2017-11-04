package products;

import org.bson.Document;

public class Motorcycle extends Vehicle {
    private boolean windshield;
    private boolean carrierBox;

    public Motorcycle(String id, String brand, String model, Double price, Double height, Double width, Double depth, int weight, Double reviewPoint, String vehicleType, int power, String fuelType, boolean windshield, boolean carrierBox) {
        super(id, brand, model, price, "Motorcycle", height, width, depth, weight, reviewPoint, vehicleType, power, fuelType);
        this.windshield = windshield;
        this.carrierBox = carrierBox;
    }

    public Motorcycle(String brand, String model, Double price, Double height, Double width, Double depth, int weight, String vehicleType, int power, String fuelType, boolean windshield, boolean carrierBox) {
        super(brand, model, price, "Motorcycle", height, width, depth, weight, vehicleType, power, fuelType);
        this.windshield = windshield;
        this.carrierBox = carrierBox;
    }

    public boolean isWindshield() {
        return windshield;
    }

    public void setWindshield(boolean windshield) {
        this.windshield = windshield;
    }

    public boolean isCarrierBox() {
        return carrierBox;
    }

    public void setCarrierBox(boolean carrierBox) {
        this.carrierBox = carrierBox;
    }

    @Override
    public Document toDocument(){
        return super.toDocument()
                .append("Wind Shield", isWindshield())
                .append("Power", isCarrierBox());
    }
}

package products;

import org.bson.Document;

public class MobilePhone extends ConsumerElectronics {

    private int cameraResolution;
    private String os;
    private int ramSize;

    public MobilePhone(String id, String brand, String model, Double price, Double height, Double width, Double depth, int weight, Double reviewPoint, Double screenSize, int storageSize, int cameraResolution, String os, int ramSize) {
        super(id, brand, model, price, "Mobile Phone", height, width, depth, weight, reviewPoint, screenSize, storageSize);
        this.cameraResolution = cameraResolution;
        this.os = os;
        this.ramSize = ramSize;
    }

    public MobilePhone(String brand, String model, Double price, Double height, Double width, Double depth, int weight, Double screenSize, int storageSize, int cameraResolution, String os, int ramSize) {
        super(brand, model, price, "Mobile Phone", height, width, depth, weight, screenSize, storageSize);
        this.cameraResolution = cameraResolution;
        this.os = os;
        this.ramSize = ramSize;
    }

    public int getCameraResolution() {
        return cameraResolution;
    }

    public void setCameraResolution(int cameraResolution) {
        this.cameraResolution = cameraResolution;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public int getRamSize() {
        return ramSize;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public Document toDocument(){
        return super.toDocument()
                .append("Camera Resolution", getCameraResolution())
                .append("OS", getOs())
                .append("RAM Size", getRamSize());
    }

    @Override
    public String toString(){
        return super.toString() + " --CellPhone [cameraResolution=" + cameraResolution + " MP" + ", os=" + os + ", ramSize=" + ramSize + "GB" + "]";
    }
}
package products;

import org.bson.Document;

    public class Laptop extends ConsumerElectronics {
        private int ramSize;
        private String cpuModel;
        private String os;

    public Laptop(String id, String brand, String model, Double price, Double height, Double width, Double depth, int weight, Double reviewPoint, Double screenSize, int storageSize, int ramSize, String cpuModel, String os) {
        super(id, brand, model, price,"Laptop", height, width, depth, weight, reviewPoint,  screenSize ,storageSize);
        this.ramSize = ramSize;
        this.cpuModel = cpuModel;
        this.os = os;
    }

    public Laptop(String brand, String model, Double price, Double height, Double width, Double depth, int weight, Double screenSize, int storageSize, int ramSize, String cpuModel, String os) {
        super(brand, model, price,"Laptop", height, width, depth, weight, screenSize ,storageSize);
        this.ramSize = ramSize;
        this.cpuModel = cpuModel;
        this.os = os;
    }


    public int getRamSize() {
        return ramSize;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public String getCpuModel() {
        return cpuModel;
    }

    public void setCpuModel(String cpuModel) {
        this.cpuModel = cpuModel;
    }

    public String getOs(){
        return os;
    }

    public void setOs(String os){
        this.os = os;
    }

    @Override
    public Document toDocument(){
        return super.toDocument()
                .append("RAM Size", getRamSize())
                .append("CPU Model", getCpuModel())
                .append("OS", getOs());
    }

    @Override
    public String toString() {
        return super.toString() + " --Laptop [ramSize=" + ramSize + ", cpuModel=" + cpuModel + "]";
    }
}
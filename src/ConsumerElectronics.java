public abstract class ConsumerElectronics extends Product {

    private Double screenSize;
    private int storageSize;

    public ConsumerElectronics(int id, String brand, String model, Double price, Double height, Double width, Double depth, int weight, Double screenSize, int storageSize) {
        super(id, brand, model, price, "Consumer Electronics", height, width, depth, weight);
        this.screenSize = screenSize;
        this.storageSize = storageSize;
    }

    public Double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(Double screenSize) {
        this.screenSize = screenSize;
    }

    public int getStorageSize() {
        return storageSize;
    }

    public void setStorageSize(int storageSize) {
        this.storageSize = storageSize;
    }

    @Override
    public String toString() {
        return super.toString() + " --ConsumerElectronics [screenSize=" + screenSize + "″" + ", storageSize" + storageSize + "GB" + ", storageSize" + "]";
    }
}
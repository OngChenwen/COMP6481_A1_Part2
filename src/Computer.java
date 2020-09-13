public class Computer {
    private String brand;
    private String model;
    private long SN;
    private double price;
    //Constructors
    public Computer(String brandName, String modelName, long serialName, double itemPrice){
        this.brand = brandName;
        this.model = modelName;
        this.SN = serialName;
        this.price = itemPrice;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setSN(long SN) {
        this.SN = SN;
    }

    public long getSN() {
        return SN;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return "Computer:" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", SN=" + SN +
                ", price=" + price +
                '}';
    }
}

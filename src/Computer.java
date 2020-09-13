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

}

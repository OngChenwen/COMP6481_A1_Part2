public class Computer {
    private String brand;
    private String model;
    private long SN;
    private double price;
    private int counter = 0;
    //Constructors
    public Computer(String brandName, String modelName, long serialName, double itemPrice){
        this.brand = brandName;
        this.model = modelName;
        this.SN = serialName;
        this.price = itemPrice;
        counter++;
    }

    public Computer(){}

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

    public int getCounter() {
        return counter;
    }

    public int findNumberOfCreatedComputers(){
        if(getCounter() == 0){ return 0; }
            else {return getCounter();}
    }

    public boolean equals(Computer computer1, Computer  computer2){
        if(computer1.getBrand() == computer2.getBrand() && computer1.getModel() ==computer2.getModel()
                && computer1.getPrice() == computer2.getPrice()){
            return true;
        }else {
            return false;
        }
    }
}

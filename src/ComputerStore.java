import java.awt.print.Book;
import java.util.Scanner;

public class ComputerStore {

    final static String password = "password";
    private static final int SIZE = 10;
    Computer[] computerList = new Computer[SIZE];
    int counter = 0;

    public static void displayMenu(){
        System.out.println("What do you want to do?");
        System.out.println("    1. Enter new computer (Password Required)");
        System.out.println("    2. Change information of a computer (Password Required)");
        System.out.println("    3. Display all computers by a specific brand");
        System.out.println("    4. Display all computers under a certain a price.");
        System.out.println("    5. Quit");


    }

    public ComputerStore(){
        Scanner scan = new Scanner(System.in);
        int times = 3;
        int counterForPassword = 0;

        System.out.println("**** Welcome ****");
        displayMenu();

        while (true){
            System.out.println("Please enter option number: ");
            int choice = scan.nextInt();

            if(choice == 5){
               System.out.println("Thanks for visiting!!");
               break;
            }

            switch (choice){
                case 1: {


                    for(int i = 0; i<times; i++){
                        System.out.println("Please enter password: ");
                        String keyPassword = scan.next();

                        counterForPassword++;
                        if(keyPassword.equals(password)){
                            i=3;
                            // add computers
                            System.out.println("Please enter how many computers you wanna add : ");
                            int numOfComputer = scan.nextInt();
                            if(numOfComputer > SIZE){
                                System.out.println("Space unavailable !!");

                            }else {

                                for(int k =0; k< numOfComputer; k++){
                                    addComputer(); }

                            }
                            displayMenu();
                            continue;
                        }

                        if(counterForPassword== 3){
                            System.out.println("**************************");
                            System.out.println("Password entered limited!!");
                            System.out.println("                          ");
                            displayMenu();
                            continue;
                        }
                    }

                } break;

                case 2:{modifyComputer(); }break;
                case 3:{
                    DisplayCompBySpecifiedBrand();
                } break;
                case 4:DisplayCompByPrice(); break;
                default:
                    System.out.println("Error");
                    displayMenu();
                    continue;
            }
        }

    }


    public void addComputer() {
    if(counter < SIZE){
        System.out.println("Reminding Space : " + (SIZE -counter));
        Scanner input = new Scanner(System.in);

        System.out.println("----------------------");

            System.out.println("Please enter computer brand: ");
            String brand = input.nextLine();
            System.out.println("Please enter computer model: ");
            String model = input.nextLine();
            System.out.println("Please enter computer Serial Number: ");
            long serialNumber = input.nextLong();
            System.out.println("Please enter price: ");
            double price = input.nextDouble();
            Computer computer = new Computer(brand,model,serialNumber,price);
            computerList[counter] = computer;
            counter++;

            System.out.println("New computer Added");


        }
    }



    public void modifyComputer(){

    }

    public void DisplayCompBySpecifiedBrand() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the brand name: ");
        String name = scan.next();

        int id = findComputersBy(name);
        for(int i = 0; i < counter; i++) {
            if (id > -1) {
                System.out.println("**********************");
                System.out.println("Computer " + (i+1) + " information: ");
                System.out.println("Brand: " + computerList[id].getBrand());
                System.out.println("Model: " + computerList[id].getModel());
                System.out.println("Serial Number: " + computerList[id].getSN());
                System.out.println("Price: " + computerList[id].getPrice());
            }

        }


    }

    public int findComputersBy(String brandName){
        int id = -1;
        for(int i = 0; i < counter ; i++){
            if(computerList[i].getBrand().equals(brandName)){
                id = i;
                break;
            }else if(i<counter){
                continue;
            }else {
                System.out.println("Not Found");
                break;
            }
        }

        return id;
    }

    public void DisplayCompByPrice(){

    }



    public static void main(String[] args) {
        new ComputerStore();
    }
}







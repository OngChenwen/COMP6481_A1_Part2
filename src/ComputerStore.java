import java.util.Scanner;

public class ComputerStore {

    final static String password = "password";
    private static final int SIZE = 10;
    Computer[] computerList = new Computer[SIZE];
    int counter = 0;
    int computerIndex;

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
                            displayMenu();
                            continue;
                        }
                    }

                } break;

                case 2:{
                    for(int i = 0; i<times; i++){
                        System.out.println("Please enter password: ");
                        String keyPassword = scan.next();

                        counterForPassword++;
                        if(keyPassword.equals(password)){
                            i=3;
                            // modify computer
                            System.out.println("Please enter the computer number you want to modify : ");
                            int computerIndex = scan.nextInt();
                            while(computerList[computerIndex] == null){

                                        System.out.println("   There is no Computer object at the specified index location");
                                        System.out.println ("  Do you want to: ");
                                        System.out.println ("  1.Enter another computer");
                                        System.out.println ("  2.Go back to the main menu");
                                        int choose = scan.nextInt();
                                        if(choose == 1){

                                            modifyComputer();
                                        }
                                        else if (choose == 2){
                                            displayMenu();
                                        }

                            else {

                                    modifyComputer();
                                }
                                displayMenu();
                            }

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

                }break;

                case 3:{
                    DisplayCompBySpecifiedBrand();
                } break;

                case 4:{
                    DisplayCompByPrice();
                } break;

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
        Scanner scanModify = new Scanner(System.in);
        System.out.println("**********************");
        System.out.println("Computer " + (computerIndex) + " information: ");
        System.out.println("Brand: " + computerList[computerIndex].getBrand());
        System.out.println("Model: " + computerList[computerIndex].getModel());
        System.out.println("Serial Number: " + computerList[computerIndex].getSN());
        System.out.println("Price: " + computerList[computerIndex].getPrice());
        System.out.println("What information would you like to change");
        System.out.println("    1. brand");
        System.out.println("    2. model");
        System.out.println("    3. SN");
        System.out.println("    4. price");
        System.out.println("    5. Quit");
        System.out.println("Enter your choice >");
        int choose = scanModify.nextInt();
        if (choose == 1){

        }else{
            System.out.println("Input invalid");
        }
        if (choose == 2){

        }else{
            System.out.println("Input invalid");
        }
        if (choose == 3){

        }else{
            System.out.println("Input invalid");
        }
        if (choose == 4){

        }else{
            System.out.println("Input invalid");
        }
        if (choose == 5){

        }else{
            System.out.println("Input invalid");
        }



    }

    public void DisplayCompBySpecifiedBrand() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the brand name: ");
        String name = scan.next();

        for(int i =0; i <counter ; i++){
            if(computerList[i].getBrand().equals(name)){
                displaySearchingResult(i);
            }
        }


    }



    public void DisplayCompByPrice(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the price: ");
        double inputPrice = scan.nextDouble();

        for(int i = 0; i<counter; i++){
            if(computerList[i].getPrice() < inputPrice){
                displaySearchingResult(i);
            }
        }

    }

    public void displaySearchingResult(int i) {
        System.out.println("**********************");
        System.out.println("Computer " + (i+1) + " information: ");
        System.out.println("Brand: " + computerList[i].getBrand());
        System.out.println("Model: " + computerList[i].getModel());
        System.out.println("Serial Number: " + computerList[i].getSN());
        System.out.println("Price: " + computerList[i].getPrice());
    }

    public void modifyResult(int computerIndex){


    }
    public static void main(String[] args) {
        new ComputerStore();
    }
}







import java.util.Scanner;

public class ComputerStore {

    final static String password = "password";
    private static final int SIZE = 10;
    Computer[] computerList = new Computer[SIZE];
    int counter = 0;
    int flagOfNonExits = 0;

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
                        }
                    }

                } break;

                case 2:{modifyComputer();
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

            System.out.println("**New computer Added**");


        }
    }



    public void modifyComputer() {
        Scanner scan = new Scanner(System.in);
        int times = 3;
        int counterForPassword = 0;
        for (int i = 0; i < times; i++) {
            System.out.println("Please enter password: ");
            String keyPassword = scan.next();

            counterForPassword++;
            if (keyPassword.equals(password)) {
                i=3;
                System.out.println("Enter your Computer Number:");
                int cmd = scan.nextInt();
                //display information
                int indexofarray = cmd -1;
                displayCompInOption2(indexofarray);
                // computer does not exist
                if (flagOfNonExits ==1){
                    System.out.println("Option 1 : Enter new computer" );
                    System.out.println("Option 2 : Go back to main menu");

                    int cmdNoExits = scan.nextInt();

                    if(cmdNoExits ==1){
                        System.out.println("Enter the Computer Number which you wanna change:");
                        cmd = scan.nextInt();
                        displayCompInOption2(indexofarray);
                        flagOfNonExits = 0;
                    }

                    if(cmdNoExits == 2) {
                        displayMenu();
                        continue;
                    }
                }
                if(flagOfNonExits ==0 ){
                        printOp2Menu();
                        int option = scan.nextInt();
                        switchForChange(option,cmd);

                }



                // illegal password entering time reached
                if (counterForPassword == 3) {
                    System.out.println("**************************");
                    System.out.println("Password entered limited!!");
                    System.out.println("                          ");
                    displayMenu();
                }

            }
        }
    }
    public void switchForChange(int opt,int ComputerIndex) {
        Scanner scanner = new Scanner(System.in);
        String string="";
        while (true) {

            if (opt ==5){
                System.out.println("**Quit**");
                displayMenu();
                break;

            }

            switch (opt) {
                //Change brand
                case 1:
                    System.out.println("Enter new Brand:");
                    string = scanner.next();
                    computerList[ComputerIndex].setBrand(string);
                    System.out.print("Changed!\n" +
                            "new information for computer: " + ComputerIndex +"\n" +
                                    "Changed Brand: " + computerList[ComputerIndex].getBrand() +"\n"
                            );

                    printOp2Menu();

                case 2:
                    System.out.println("Enter new Model:");
                    string = scanner.next();
                    computerList[ComputerIndex].setModel(string);
                    System.out.print("Changed!\n" +
                            "new information for computer: " + ComputerIndex +"\n" +
                            "Changed Model: " + computerList[ComputerIndex].getModel() +"\n"
                    );

                    printOp2Menu();
                    break;
                case 3:
                    System.out.println("Enter new SN:");
                    long SNNumber = scanner.nextLong();
                    computerList[ComputerIndex].setSN(SNNumber);
                    System.out.print("Changed!\n" +
                            "new information for computer: " + ComputerIndex +"\n" +
                            "Changed SN: " + computerList[ComputerIndex].getSN() +"\n"
                    );

                    printOp2Menu();
                    break;
                case 4:
                    System.out.println("Enter new price:");
                    double price = scanner.nextDouble();
                    computerList[ComputerIndex].setPrice(price);
                    System.out.print("Changed!\n" +
                            "new information for computer: " + ComputerIndex +"\n" +
                            "Changed Price: " + computerList[ComputerIndex].getPrice()+"\n"
                    );

                    printOp2Menu();
                    break;
            }
        }
    }
    public void displayCompInOption2(int index){
        if(computerList[index] == null){
            flagOfNonExits = 1;
            System.out.println("Error! Computer " + index + " does not exist!" );
        }else {
            System.out.println("Computer #"+ (index+1));
            System.out.println("Brand: " + computerList[index].getBrand());
            System.out.println("Model: " + computerList[index].getModel());
            System.out.println("SN:" + computerList[index].getSN());
            System.out.println("Price: " + computerList[index].getPrice());
        }
    }
    public void printOp2Menu(){
        System.out.println(">>>What information you want to change?");
        System.out.print("1.Brand\n" +
                "2.model\n" +
                "3.SN\n" +
                "4.price\n" +
                "5.Quit\n"
        );

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


    public static void main(String[] args) {
        new ComputerStore();
    }
}







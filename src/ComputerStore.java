import java.util.Scanner;

public class ComputerStore {

    final static String password = "password";
    Scanner input;

    public static void displayMenu(){
        System.out.println("**** Welcome ****");
        System.out.println("What do you want to do?");
        System.out.println("1. Enter new computer (Password Required");
        System.out.println("2. Change information of a computer (Password Required)");
        System.out.println("3. Display all computers by a specific brand");
        System.out.println("4. Display all computers under a certain a price.");
        System.out.println("5. Quit");


    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int enterTimes = 3;

        System.out.println("Please enter the maximum capacity of computers : ");
        int capacityOfComputer = input.nextInt();

        // Array of Computers
        Computer[] inventory = new Computer[capacityOfComputer];


        while (true) {
            switch (input.nextInt()) {
                case 1: {
                    int remindingSpace = capacityOfComputer;
                    System.out.println("Please enter your password!");
                    if (input.nextLine() == password) {
                        System.out.println("Pleas enter number of computers you want:");
                        int inputNum = input.nextInt();
                        //check if it has enough space for input
                        if(inputNum > remindingSpace){
                            System.out.println("Error! Reminding space is : " + remindingSpace);
                        }else {
                                for(int i =0; i< remindingSpace; i++){
                                    System.out.println("Please enter computer brand: ");
                                    String brand = input.nextLine();
                                    System.out.println("Please enter computer model: ");
                                    String model = input.nextLine();
                                    System.out.println("Please enter computer Serial Number: ");
                                    long serialNumber = input.nextLong();
                                    System.out.println("Please enter price: ");
                                    double price = input.nextDouble();
                                    inventory[i] = new Computer(brand,model,serialNumber,price);
                                    remindingSpace -=1;
                                }

                            }
                        } else {
                        // 3 times done, display menu
                        enterTimes -=1;
                        if(enterTimes == 0){
                            displayMenu();
                        }

                    }
                    }


                }

            }
        }
}







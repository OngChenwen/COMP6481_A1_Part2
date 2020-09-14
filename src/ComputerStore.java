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

        System.out.println("**** Welcome ****");
        displayMenu();

        while (true){
            int choice = scan.nextInt();

            if(choice == 5){
               System.out.println("Thanks for visiting!!");
               break;
            }

            switch (choice){
                case 1:{
                    System.out.println("Please enter password");
                    String keyPassword = scan.next();
                    if(keyPassword.equals(password)){
                        addComputer();
                    }
                    }
                case 2:modifyComputer();
                case 3:DisplayCompBySpecifiedBrand();
                case 4:DisplayCompByPrice();

            }
        }

    }

    public void addComputer() {
    if(counter < SIZE){
        System.out.println("Reminding Space : " + counter);
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

    }

    public void DisplayCompByPrice(){

    }


    public static void main(String[] args) {
        new ComputerStore();
    }
}







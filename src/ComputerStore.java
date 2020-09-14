import java.util.Scanner;

public class ComputerStore {

    final String password = "password";
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
        System.out.println("Please enter the maximum capacity of computers ");
        int capacityOfComputer =  input.nextInt();

        // Array of Computers
        Computer[] inventory = new Computer[capacityOfComputer];

        switch (input.nextInt()){
            case 1:{
                System.out.println("Please enter your password!");
                if(input.nextLine() == "password"){
                    System.out.println("Pleas enter number of computers you want:");
                    int inputNum = input.nextInt();


                }

            }
        }

    }




}

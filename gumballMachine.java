import java.util.*;
import java.io.*;
class gumballMachine {
    public static void main(String[] args) {
        gumballVendingMachine();
    }

    public static void gumballVendingMachine() {
        Scanner in = new Scanner(System.in);
        //initializing constant values for the coin
        int QUARTER_VALUE = 25;
        int NICKEL_VALUE = 5;
        int DIME_VALUE = 10;
        int quarters = 0;
        int nickels = 0;
        int dimes = 0;
        boolean finalCoinInsert = false;
        while(!finalCoinInsert) {
            System.out.println("Please enter a coin"); //asks user to insert coin
            String input = in.nextLine();
            if(input.equals("25")) {  //checks if the coin is quarter, dime, nickel or NA
                quarters++;
            } else if(input.equals("10")) {
                dimes++;
            } else if (input.equals("5")) {
                nickels++;
            } else {
                System.out.println("Invalid Currency"); 
            }
            System.out.println("Do you want to enter more coins? (Yes / No)"); //asks if user wants to enter more coins
            input = in.nextLine();
            input = input.toLowerCase();
            if(input.equals("yes")) {
	    //if user wants to continue the program will keep running
                continue;
            } else if(input.equals("no")) {
	    //if user does not want to continue the program will take it as final coin
                finalCoinInsert = true;
            } else {
                System.out.println("Invalid command");
            }
        }
        int amount = quarters*QUARTER_VALUE + nickels*NICKEL_VALUE + dimes*DIME_VALUE;
        System.out.println("Amount entered: " + amount);
        boolean finalBall = false;
        while(!finalBall) {
            System.out.println("Please select the color");
            String input = in.nextLine();
            input = input.toLowerCase();
	//if user wants a red ball
            if(input.equals("red")) {
                if(amount >= 5) {
	        //will check if user has enough amount to dispense the red ball
                    System.out.println("Red ball dispensed");
                    amount -= 5;
                } else {
	        //if user does not have enough amount it will ask user to start a new transaction
                    System.out.println("Not enough amount entered. Please start a new transaction.");
                    finalBall = true;
                }
            } 	
    //if user wants a yellow ball
    else if(input.equals("yellow")) {
                if(amount >= 10) {
	        //will check if user has enough amount to dispense the yellow ball
                    System.out.println("Yellow ball dispensed");
                    amount -= 10;
                } else {
	        //if user does not have enough amount it will ask user to start a new transaction
                    System.out.println("Not enough amount entered. Please start a new transaction.");
                    finalBall = true;
                }
            } else {
                System.out.println("Invalid command");
            }
            if(!finalBall) {
	    //ask user if they want a new ball
                System.out.println("Do you want more balls? (Yes / No)");
                input = in.nextLine();
                input = input.toLowerCase();
                if(input.equals("yes")) {
	        //if yes program will continue
                    continue;
                } else if(input.equals("no")) {
	        //if no program will end
                    finalBall = true;
                } else {
                    System.out.println("Invalid command");
                }
            }
        }
        
        int tempAmount = amount;
        int quartersReturned = tempAmount / QUARTER_VALUE;
        tempAmount = tempAmount - quartersReturned*QUARTER_VALUE;
        int dimesReturned = tempAmount / DIME_VALUE;
        tempAmount = tempAmount - dimesReturned*DIME_VALUE;
        int nickelsReturned = tempAmount / NICKEL_VALUE;
        tempAmount = tempAmount - nickelsReturned*NICKEL_VALUE;
        //Below statements will print how many each coins do the user have
        System.out.println("Number of Quarters returned: " + quartersReturned);
        System.out.println("Number of Dimes returned: " + dimesReturned);
        System.out.println("Number of Nickels returned: " + nickelsReturned);
        System.out.println(amount + " is returned");
        return;
    }
}

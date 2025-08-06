package studentrecord.util;

import studentrecord.exceptions.MaxAttemptExceededException;

import java.util.Scanner;

public class InputValidationUtils {


    //method to validate Integer input and return proper exception
    public static Integer validateIntegerInput(String input){

        int attempt = 0;//initializing variable for max limit

        while(attempt<3){ // a loop for retry limit
            try{
                 return Integer.parseInt(input);//converting string input to integer and returning back

            }catch (NumberFormatException ne){
                System.out.println("Invalid Input! ");
                attempt=attempt+1;
                if (attempt < 3) {
                    System.out.print("Please enter Numeric value.Try again: ");
                    Scanner sc = new Scanner(System.in);
                   input =  sc.nextLine();//taking input
                }
            }

        }
            //if the limit exceed throwing exception
          throw  new MaxAttemptExceededException("Max attempts exceeded! Returning to main main");
    }

    // method to validte input string and throw proper exception
    public static String validateStringInput(String input){
        int attempts = 0;// initializing variable for max limit
        Scanner sc = new Scanner(System.in);

        while (attempts < 3) { // a loop for retry limit

            // input allow letters, numbers, and spaces and reject empty input
            if (!input.isEmpty() && input.matches("[a-zA-Z0-9 ]+")) {
                return input;
            } else {
                attempts=attempts+1;
                if(attempts<3){

                    System.out.print("Invalid input! Please enter only letters, numbers, and spaces.");

                    input =  sc.nextLine();//taking input

                }
            }
        }
        //if the limit exceed throwing exception
        throw new MaxAttemptExceededException("Max attempts exceeded! Returning to main menu.");
    }


}

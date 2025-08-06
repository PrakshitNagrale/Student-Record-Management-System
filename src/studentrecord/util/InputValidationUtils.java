package studentrecord.util;

import studentrecord.exceptions.MaxAttemptExceededException;

import java.util.Scanner;

public class InputValidationUtils {



    public static Integer validateIntegerInput(String input){

        int attempt = 0;

        while(attempt<3){
            try{
                 return Integer.parseInt(input);

            }catch (NumberFormatException ne){
                System.out.println("Invalid Input! ");
                attempt=attempt+1;
                if (attempt < 3) {
                    System.out.print("Please enter Numeric value.Try again: ");
                    Scanner sc = new Scanner(System.in);
                   input =  sc.nextLine();
                }
            }

        }

          throw  new MaxAttemptExceededException("Max attempts exceeded! Returning to main main");
    }


    public static String validateStringInput(String input){
        int attempts = 0;
        Scanner sc = new Scanner(System.in);

        while (attempts < 3) {

            // Allow letters, numbers, and spaces. Reject empty input.
            if (!input.isEmpty() && input.matches("[a-zA-Z0-9 ]+")) {
                return input;
            } else {
                attempts=attempts+1;
                if(attempts<3){

                    System.out.print("Invalid input! Please enter only letters, numbers, and spaces.");

                    input =  sc.nextLine();

                }
            }
        }

        throw new MaxAttemptExceededException("Max attempts exceeded! Returning to main menu.");
    }


}

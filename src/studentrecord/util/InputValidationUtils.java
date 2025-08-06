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
}

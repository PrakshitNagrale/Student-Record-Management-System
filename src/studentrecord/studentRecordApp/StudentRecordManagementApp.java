package studentrecord.studentRecordApp;

import studentrecord.studentRecordsService.StudentRecordManagement;
import studentrecord.studentRecordsService.StudentRecordManagementImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentRecordManagementApp {

   private Scanner sc;
   private StudentRecordManagement studentRecordManagement;

    public StudentRecordManagementApp() {
        this.sc = new Scanner(System.in);
        this.studentRecordManagement = new StudentRecordManagementImpl();
    }


   public void startStudentRecordManagementApplication(){


       System.out.println("\n***** Student Record Management System *****");


       boolean keepContinue = true;

       while(keepContinue) {

           System.out.println("1. Add Student");
           System.out.println("2. View Student By Id");
           System.out.println("3. View All Students");
           System.out.println("4. Update Student");
           System.out.println("5. Delete Student");
           System.out.println("6. Exit");

           System.out.println("Choose an option to perform : ");

           try {
               String input = sc.nextLine(); //reading full line,to avoid input mismatch exception,if user enters characters instead of number
               int option = Integer.parseInt(input); // converting it to int

               switch (option) {

                   case 1:
                       studentRecordManagement.addStudent();
                       break;

                   case 2:
                       studentRecordManagement.viewStudentById();
                       break;

                   case 3:
                       studentRecordManagement.viewAllStudents();
                       break;

                   case 4:
                       studentRecordManagement.updateStudent();
                       break;

                   case 5:
                       studentRecordManagement.deleteStudent();
                       break;


                   case 6:
                       System.out.println(" **** Application Terminated! ****");
                       keepContinue = false;
                       break;

                   default:
                       System.out.println("----Invalid Input! Please try again!----");

               }

           } catch (NumberFormatException e) {
               System.out.println("Invalid Input!. Please enter a valid number (1-6)");
               System.out.println("----------------------------------------------------");
           }
       }


   }



}

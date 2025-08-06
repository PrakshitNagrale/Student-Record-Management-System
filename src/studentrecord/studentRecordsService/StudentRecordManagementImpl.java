package studentrecord.studentRecordsService;

import studentrecord.client.StudentClient;
import studentrecord.exceptions.IdAlreadyExistsException;
import studentrecord.exceptions.InvalidIdException;
import studentrecord.exceptions.ListIsEmptyException;
import studentrecord.exceptions.MaxAttemptExceededException;
import studentrecord.models.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentRecordManagementImpl implements StudentRecordManagement {

    StudentClient studentClient=null;
    Scanner sc ;

    public StudentRecordManagementImpl(){
        studentClient = new StudentClient();
        sc = new Scanner(System.in);
    }

    @Override
    public void addStudent() {

        Student student =null;
                try{
                    student =  studentClient.addStudent(); //getting student details
                }catch (IdAlreadyExistsException idAlreadyExistsException){
                    System.out.println(idAlreadyExistsException.getMessage());
                    return;
                }catch (MaxAttemptExceededException maxLimit){
                    System.out.println(maxLimit.getMessage());
                    return;
                }

        System.out.println(student);
        System.out.println("Student Details Added Successfully!");
        System.out.println("-------------------------------------");

    }

    @Override
    public void viewStudentById() {

       try{                                             //check is list  empty
           studentClient.checkIsListEmpty();

       }catch (ListIsEmptyException listIsEmptyException){
           System.out.println(listIsEmptyException.getMessage());
           return;
       }
        //take input from user
        System.out.println("Please Enter the Student Id : ");
        int student_id = sc.nextInt();

        Student student=null;
        try{
            //getting student details by id
            student = studentClient.viewStudentById(student_id);
        } catch (InvalidIdException e) {
            System.out.println(e.getMessage());
            return;
        }
        //print the  student details
        System.out.println("---- Student Details ----");
        System.out.println(student);
        System.out.println("------------------------------------");

    }

    @Override
    public void viewAllStudents() {

        try{                                        //check is list  empty
            studentClient.checkIsListEmpty();

        }catch (ListIsEmptyException listIsEmptyException){
            System.out.println(listIsEmptyException.getMessage());
            return;
        }

        //get all student records
        ArrayList<Student> studentList = studentClient.getAllStudents();


        //if the list is not empty , print student records
        System.out.println("----Students Records----");

        //iterating on the student list to get all the student details
       for(Student student : studentList){
         System.out.println(student);
         System.out.println("-----------------------");
      }
    }

    @Override
    public void updateStudent() {

        try{                                        //check is list  empty
            studentClient.checkIsListEmpty();

        }catch (ListIsEmptyException listIsEmptyException){
            System.out.println(listIsEmptyException.getMessage());
            return;
        }
         //take input from user
        System.out.println("Please Enter the Student Id to Update: ");
        int student_id = sc.nextInt();

        Student updatedStudent =null;
        try{
            //getting student details by id
            updatedStudent = studentClient.updateStudentDetails(student_id);
        } catch (InvalidIdException e) {
            System.out.println(e.getMessage());
            return;
        }
                //print updated student details
        System.out.println("-------------------------------------");
        System.out.println(updatedStudent);
        System.out.println("Student Details Updated Successfully!");
        System.out.println("-------------------------------------");

    }

    @Override
    public void deleteStudent() {

        try{                                        //check is list  empty
            studentClient.checkIsListEmpty();

        }catch (ListIsEmptyException listIsEmptyException){
            System.out.println(listIsEmptyException.getMessage());
            return;
        }
        //take input from user
        System.out.println("Please Enter the Student Id to delete: ");
        int student_id = sc.nextInt();

        Student deletedStudent =null;
        try{
            //getting student details by id
            deletedStudent = studentClient.deleteStudentDetails(student_id);
        } catch (InvalidIdException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("-------------------------------------");
        System.out.println(deletedStudent);
        System.out.println("Student Details Deleted Successfully!");
        System.out.println("-------------------------------------");

    }

}

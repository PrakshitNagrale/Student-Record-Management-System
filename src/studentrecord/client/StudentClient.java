package studentrecord.client;

import studentrecord.exceptions.IdAlreadyExistsException;
import studentrecord.exceptions.InvalidIdException;
import studentrecord.exceptions.ListIsEmptyException;
import studentrecord.exceptions.MaxAttemptExceededException;
import studentrecord.models.Student;
import studentrecord.util.InputValidationUtils;

import java.util.ArrayList;
import java.util.Scanner;

import static studentrecord.util.InputValidationUtils.validateIntegerInput;

public class StudentClient {

    ArrayList<Student> studentList;
    Scanner sc ;

    public StudentClient() {
        this.studentList = new ArrayList<>();
        this.sc = new Scanner(System.in);
    }


    public Student addStudent()throws MaxAttemptExceededException {

            //take input from user
            System.out.println("Please Enter The Student Id : ");

             int id =  InputValidationUtils.validateIntegerInput(sc.nextLine());

               //to check if the id already exist in list
               Student   student1 =  getStudentById(id);

                if(student1!=null){       //throw exception if id already present
                    throw new IdAlreadyExistsException("-----Student ID already exists. Please enter a different ID----");
                }

               Student student  = new Student();//creating object of student


                //if the id is unique,set the student id
                student.setId(id);
//                sc.nextLine(); //to clear1

                //inserting user details
                student = insertStudentDetails(student);

                studentList.add(student); //add student details to list

                return student;
    }

    public Student viewStudentById(int id){

        int  student_id =id;

        //getting student details by id
        Student student = getStudentById(student_id);

        //if the student with id doest not exists
        if(student == null){
            throw new InvalidIdException("----Student Id doest not Exists! Please try again----");
        }

        return  student;

    }

    //to get all the students
    public ArrayList<Student> getAllStudents(){

        return studentList;

    }

    public Student updateStudentDetails(int id) {

        int student_id = id;

        //getting student details by id
        Student student = getStudentById(student_id);

        //if the student with id doest not exists
        if(student == null){
            throw new InvalidIdException("----Student Id doest not Exists! Please try again----");
        }

        //if the id exists ,print the existing student details
        System.out.println("Current Student Details : ");
        System.out.println(student);
        System.out.println("-----------------------");

        //updating user details
        return  insertStudentDetails(student);

    }

    public Student deleteStudentDetails(int id) {

        int student_id = id;

        //getting student details by id
       Student student = getStudentById(student_id);

        //if the student with id doest not exists
        if(student == null){
            throw new InvalidIdException("----Student Id doest not Exists! Please try again----");
        }
        //remove student from list
        studentList.remove(student);

        return student;
    }



    //to insert the student details
    Student insertStudentDetails(Student student)throws MaxAttemptExceededException{


        System.out.println("Please Enter The Student Name : ");
        student.setName(InputValidationUtils.validateStringInput(sc.nextLine()));

        System.out.println("Please Enter The Student Age : ");
        student.setAge(InputValidationUtils.validateIntegerInput(sc.nextLine()));
        System.out.println("Please Enter The Student RollNo. : ");
        student.setRollNo(InputValidationUtils.validateIntegerInput(sc.nextLine()));
        System.out.println("Please Enter The Student Marks: ");
        student.setMarks(InputValidationUtils.validateIntegerInput(sc.nextLine()));

        System.out.println("Please Enter The Student Department : ");
        student.setDepartment(InputValidationUtils.validateStringInput(sc.nextLine()));

        return student;


    }

    //to get student details by id
     Student getStudentById(int id){

        for(Student student : studentList){ //iterating on the list
            if(student.getId() == id){

                return student;
            }
        }
        return  null;

    }

    //to check empty list
     public void checkIsListEmpty(){

        if(studentList.isEmpty()){

            throw  new ListIsEmptyException("----No Students Present!. Please Add Students Details----");
        }
        return;
    }


}

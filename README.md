** Student Record Management System – Console Application **
- The Student Record Management System is a Java-based console application that enables efficient and structured management of student records. 
It follows Object-Oriented Programming principles and utilizes custom exception handling, interface-based design, and utility classes to ensure clean, maintainable, and modular code.

This project simulates real-world CRUD operations—Create, Read, Update, and Delete—on student data, providing a user-friendly menu-driven interface.
 
** Features :-

- Add new student records (with input validation and retry mechanism).

- View student details by ID

- View all student records

- Update student information

- Delete student record by ID

- Handles invalid input, duplicate IDs, and empty list scenarios using custom exceptions


**  Technologies Used :-
- Java (JDK 17+)

- Scanner for input handling

- Exception handling using custom-defined exceptions

- Object-Oriented Programming (Abstraction, Encapsulation)

- Interface and Implementation design

- Utility class for input validation

** Package Structure -

- studentRecordApp/ -->    Main application class with the menu
- studentRecordsService/ -->  Business logic and service interface
- client/         -->        Core functionality like input and student operations
- exceptions/     -->       Contains Custom exception classes
- models/        -->          Contains Student model (POJO)
- util/        -->            Utility class for input validation

** Custom Exceptions :-

- IdAlreadyExistsException – Thrown when duplicate ID is entered.

- InvalidIdException – Thrown when student ID is not found.

- ListIsEmptyException – Thrown when student list is empty.

- MaxAttemptExceededException – Thrown after repeated invalid input attempts.

** Highlights:-

- Input handling using a utility class (InputValidationUtils)

- Retry mechanism to limit invalid input attempts

- Readable console output with clear user instructions

- Easily extendable design for future enhancements (e.g., file/database integration)

** Example output:-

***** Student Record Management System *****
1. Add Student
2. View Student By Id
3. View All Students
4. Update Student
5. Delete Student
6. Exit
   Choose an option to perform :
   1

- Please Enter The Student Id :
   1
- Please Enter The Student Name :
   Yogesh
- Please Enter The Student Age :
   27
- Please Enter The Student RollNo. :
   54
- Please Enter The Student Marks:
   87
- Please Enter The Student Department :
   Computer Science

- Student Id: 1
- Student Name: Yogesh
- Student RollNo: 54
- Student Age: 27
- Student Marks: 87
- Student Department: Computer Science 
- Student Details Added Successfully!
-------------------------------------
1. Add Student
2. View Student By Id
3. View All Students
4. Update Student
5. Delete Student
6. Exit
   Choose an option to perform :
   6
- **** Application Terminated! ****

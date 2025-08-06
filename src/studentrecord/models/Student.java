package studentrecord.models;

public class Student {


    private int id;
    private String name;
    private  int rollNo;
    private int age;
    private int marks;
    private String department;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    //overriding toString method to add the student details into list instead of hashcode value
   @Override
    public String toString(){

        return "Student Id: "+this.id+
                "\nStudent Name: "+this.name+
                "\nStudent RollNo: "+this.rollNo+
                "\nStudent Age: "+this.age+
                "\nStudent Marks: "+this.marks+
                "\nStudent Department: "+this.department;
   }
}

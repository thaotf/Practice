package arraylist;

public class Student{
    // add any fields that a single student should have such as student id and
    // ...
    private static Student student;
    private IdGen idGen = IdGen.instance();
    private int studentId;
    private String firstName;
    private String middleIni;
    private String lastName;
    ArrayBag studentList = new ArrayBag();

    private Student() {
    }
    
    public static Student instance(){
        if (student == null){
            return student = new Student();
        } else {
            return student;
        }
    }
    
     public Student(String firstName, String middleIni, String lastName) {
         this.studentId = idGen.getId();
         this.firstName = firstName;
         this.middleIni = middleIni;
         this.lastName = lastName;
    }
     
    public int getStudentId(){
        return studentId;
    }
    
    public void setStudentId(int studentId){
        this.studentId = studentId;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleIni() {
        return middleIni;
    }

    public void setMiddleIni(String middleIni) {
        this.middleIni = middleIni;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String toString(){
        String output = "";
        output += String.format("%d %s %s %s", studentId, firstName, middleIni, lastName);
        return output;
    }
}

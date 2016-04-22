package arraylist;
import java.util.Iterator;

public class Driver {
    public static void main(String[] args) {
        ArrayBag student = new ArrayBag();

        student.add(new Student("Billy", "B", "Thorten"));
        student.add(new Student("Billy", "D", "Williams"));
        student.add(new Student("Billy", "G", "Williams"));

        // You need to instantiate Iterator<Object> for this to work. Object 
        for (Iterator<Object> iter = student.studentIterator(); iter.hasNext();) {
                System.out.println(iter.next());
        }
    }
}

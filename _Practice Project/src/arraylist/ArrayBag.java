package arraylist;
import java.util.Iterator;

public class ArrayBag {
    private Student[] student;
    private int numberOfStudents;

    public ArrayBag() {
        student = new Student[10];
        numberOfStudents = 0;
    }
    
    public ArrayBag(int maxSize) {
        student = new Student[maxSize];
    }

    public void add(Student element) {
        student[numberOfStudents++] = element;
    }
    
    // Inter class for the ArrayBag list
    public class StudentIterator implements Iterator<Object>{
        private int iteratorCount;
        
        @Override
        public boolean hasNext() {
            return iteratorCount < numberOfStudents;
        }

        @Override
        public Student next() {
            return student[iteratorCount++];
        }
    }
    
    // Method to access the StudentIterator Class
    public StudentIterator studentIterator(){
        return new StudentIterator();
    }
        
}

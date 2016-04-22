package calendar;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Calendar {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    private int start;
    private int year;
    private int month;
    
    public Calendar(){
    }
    
    public void createCalendar(){
        
        System.out.print("Start day ");
        start = numberReader();
        
        System.out.print("year ");
        year = numberReader();
        printMe();
        
    }

    
    
    public String stringReader() {
        try {
            return read.readLine();
        } catch (IOException e) {
            System.out.println("Input Error");
            e.printStackTrace();
        }
        return null;
    }
    
    public int numberReader() {
        while (true) {
            try {
                return Integer.parseInt(stringReader());
            } catch (NumberFormatException e) {
                System.out.print("enter a number ");
            }
        }
    } 
    
    public String toString(){
        String output = "";
        output += year;
        return output;
    }
    
    public void printMe(){
        System.out.println(toString());
    }
    
    public static void main(String[] args) {
        Calendar calendar = new Calendar();
        calendar.createCalendar();
    }
    
    
}

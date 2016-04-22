package guessbirthday;
import java.io.BufferedReader;import java.io.IOException;
import java.io.InputStreamReader;


public class GuessBirthday {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private int day;
    
    public GuessBirthday(){
    }
    
    public void set(){
        message();
        System.out.println(" 1  3  5  7\n"
                         + " 9 11 13 15\n"
                         + "17 19 21 23\n"
                         + "25 27 29 31");
        if (yesNo() == true){
            day += 1;
        }
        
        System.out.println();
        message();
        System.out.println(" 2  3  6  7\n"
                         + "10 11 14 15\n"
                         + "18 19 22 23\n"
                         + "26 27 30 31");
        if (yesNo() == true){
            day += 2;
        }
        
        System.out.println();
        message();
        System.out.println(" 4  5  6  7\n"
                         + "12 13 14 15\n"
                         + "20 21 22 23\n"
                         + "28 29 30 31");
        if (yesNo() == true){
            day += 4;
        }
        
        System.out.println();
        message();
        System.out.println(" 8  9 10 11\n"
                         + "12 13 14 15\n"
                         + "24 25 26 27\n"
                         + "28 29 30 31");
        if (yesNo() == true){
            day += 8;
        }
        
        System.out.println();
        message();
        System.out.println("16 17 18 19\n"
                         + "20 21 22 23\n"
                         + "24 25 26 27\n"
                         + "28 29 30 31");
        if (yesNo() == true){
            day += 16;
        }
        
        printMe();
    }
    
    public String toString(){
        return "\n\nThe day of your birth is " + day ;
    }
    
    public void printMe(){
        System.out.println(toString());
    }
    public String stringReader(){
            try {
                return reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return null; 
        }
    }
    
    public void message(){
        System.out.println("Is the day of your birth in this set Y/N");
    }
    
    public boolean yesNo() {
        char ch = stringReader().toUpperCase().charAt(0);
        while (ch != 'Y' && ch != 'N') {
            System.out.print("Enter Y/N: ");
             ch = stringReader().toUpperCase().charAt(0);
            }
        if (ch != 'Y') {
            return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        GuessBirthday guessBirthday = new GuessBirthday();
        guessBirthday.set();
    }
}


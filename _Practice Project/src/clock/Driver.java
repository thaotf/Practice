package clock;

public class Driver {
    public static void main(String[] args) {
        
        TestClock seconds = new TestClock();
        seconds.currentTime();
        
        System.out.println(seconds.toString());
        
    }
}

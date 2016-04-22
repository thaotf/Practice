package clock;

public class TestClock {
    private long hour;
    private long minute;
    private long second;
    
    public TestClock(){
    }

    public void currentTime(){
        hour = System.currentTimeMillis() / 60;
        hour = hour % 24;
        
        minute = System.currentTimeMillis() / 60;
        minute = minute % 60;
        
        second = System.currentTimeMillis() / 1000;
        second = second % 60;
    }

    
        

    public String toString (){
        String output = "";
        output += hour + " " + minute + " " + second;
        return output;
    }
    
    
  

}

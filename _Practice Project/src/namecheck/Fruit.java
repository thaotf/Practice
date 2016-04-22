package namecheck;

public class Fruit {
    String fruit;
    
    public Fruit(String fruit){
        this.fruit = fruit;
        
        Runnable r = new Runnable(){
            public void run(){
                runWork();
            }
        };
        Thread t = new Thread(r);
        t.start();
    }
    
    private void runWork(){
        try{
            for ( int i = 0; i < 10; i++ ){
                System.out.println((i + 1) + " Fruit= " + fruit);
                Thread.sleep(1000);
            }
        } catch ( InterruptedException e){
            // do nothing
        }
    }
}

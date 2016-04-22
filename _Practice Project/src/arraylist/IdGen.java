package arraylist;

public class IdGen {
    private static IdGen idGen;
    private int id = 0;
    
    private IdGen(){
    }

    public static IdGen instance(){
        if ( idGen == null){
            return idGen = new IdGen();
        } else {
            return idGen;
        }
    }
    
    public int getId(){
        return id++;
    }
}

package arraybag;

public class StudentList {
    int manyItems;
	private int[] studendId;
	private int[] studentSSNum;
	private String[] firstName;
	private String[] middleIni;
	private String[] lastName;
	
	public StudentList(){
	    final int INITIAL_CAPACITY = 10;
	    manyItems = 10;
		studendId = new int[INITIAL_CAPACITY];
		studentSSNum = new int[INITIAL_CAPACITY];
		firstName = new String[INITIAL_CAPACITY];
		middleIni = new String[INITIAL_CAPACITY];
		lastName = new String[INITIAL_CAPACITY];
	}
	
	public StudentList(int initalCapacity){
	    if (initalCapacity < 0){
	        throw new IllegalArgumentException("Initial capacity is negative: " + initalCapacity);
	    }
	    manyItems = 0;
	      
	    
	}
	
	public void add(int[] studentId, int[] studentSSNum, String[] FirstName, String[] middleIni, String[] lastName){
	    this.studendId = studentId;
	    this.studentSSNum = studentId;
	    this.firstName = FirstName;
	    this.middleIni = middleIni;
	    this.lastName = lastName;
	    
	}
	
	public void ensureCapacity(int minimunCapacity){
	    int[] biggerArray;
	    if (studendId.length < minimunCapacity ){
	        biggerArray = new int[minimunCapacity];
	        System.arraycopy(studendId, 0, biggerArray, 0, manyItems);
	    }
	}
	
}

package passwordcheck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PasswordCheck {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private String password;
    private final String PATTERN = "(?=(.*[A-Z]){2})(?=(.*[a-z]){2})(?=(.*\\d){2})^.*";
    // (?=^.{8,30}$)(?=(.*\\d){2})(?=(.*[A-Za-z]){2})(?=.*[!@#$%^&*?])(?!.*[\\s])^.*
    
    public PasswordCheck() {
        password = null;
    }

    
    public void run() {
        while (true){
            password = "s3F3sG";
//            password = stringInput("Enter password");
            System.out.println(password);
//            System.out.println(password.matches(PATTERN));
            if (passwordIsGood()){
                System.out.println("Accepted");
                break;
            } else {
                System.out.println("Not strong enough. Try again.");
            }
        }
    }
    
   public boolean passwordIsGood(){
       return password.matches(PATTERN);
   }
    
    public String stringInput(String prompt){
        System.out.print(prompt + " ");
        while (true) {
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

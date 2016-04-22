package payroll;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;

public class PayrollCalculator {
    private static PayrollCalculator payrollCalculator; 
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private String firstName;
    private String lastName;
    private String ssn;
    private double payRate;
    private double hoursWorked;
    private final double FEDTAX = .2;
    private final double STATETAX = .1;
    
    private PayrollCalculator(){
    }
    
    public static PayrollCalculator instance(){
        if (payrollCalculator == null){
            return payrollCalculator = new PayrollCalculator();
        } else {
            return payrollCalculator;
        }
    }
    
    public PayrollCalculator(String firstName, String lastName, String ssn, int payRate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.payRate = payRate;
    }
    
    public void payroll(){
        firstName = stringReader("First name");
        lastName = stringReader("Last name");
        ssn = stringReader("Social Security Number");
        payRate = intReader("Pay rate");
        hoursWorked = intReader("Hours Worked");
        
        System.out.println(toString());
    }
    
    public double gross(){
        return payRate * hoursWorked;
    }
    
    public double fedWithholding(){
        return (gross() * FEDTAX);
    }
    
    public double stateWithholding(){
        return gross() * STATETAX;
    }
    
    public double totalDeductions(){
        return fedWithholding() + stateWithholding();
    }
    
    public String toString(){
       
        return String.format("\nPayroll Summary for: %s %s", firstName, lastName) +
               String.format("\nHours Worked: %.2f", hoursWorked) +
               String.format("\nPay Rate: %.2f", payRate) +
               String.format("\nGross Pay: $%.2f", gross()) +
               String.format("\nDeductions:") + 
               String.format("\n\tFederal Withholding(20%%): $%.2f", fedWithholding()) +
               String.format("\n\tState Withholding (9%%): $%.2f", stateWithholding()) +
               String.format("\n\tTotal Deduction: $%.2f", totalDeductions()) +
               String.format("\nNet Pay: $%.2f", (gross() - totalDeductions()));
    }
    
    public String stringReader(String prompt){
        System.out.print(prompt + " ");
        while (true){
            try {
                return br.readLine();
            } catch (IOException e) {
               e.printStackTrace();
            }
        }
    }
    
    public double intReader(String prompt){
        System.out.print(prompt + " ");
        while (true){
            try {
                return Double.parseDouble(br.readLine());
            } catch (NumberFormatException | IOException e) {
                System.out.println("Enter a number");
            }
        }
    }

}

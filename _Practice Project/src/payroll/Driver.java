package payroll;

public class Driver {
    public static void main(String[] args) {
        
        PayrollCalculator pc = PayrollCalculator.instance();
        
        pc.payroll();
        
    }
}

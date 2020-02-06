import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Assignment2Test {
    //Tests to ensure that the BMI calculations are correct based on the calculation at this website:
    //http://extoxnet.orst.edu/faqs/dietcancer/web2/twohowto.html
    @Test
    void testBMICalculations() {
        Assignment2 tester = new Assignment2();
        assertEquals(22.7, tester.BMICalculations(5, 3, 125), "Improper calculation!");
    }

    //Tests to ensure that the BMI calculations are correct based on the following calculations:
    //Salary = $50000, percent saved = 10%, savings goal = $401000
    //Years = SavingsGoal/((Salary * PercentSaved) * 1.35) = 401000/(5000 * 1.35) = 401000/6750 = 59.407407... ~ 59
    @Test
    void testRetirementCalculations() {
        Assignment2 tester = new Assignment2();
        assertEquals(59, tester.yearsToRetirement(50000, 10, 401000), "Improper calculation!");
    }
}
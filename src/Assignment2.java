import java.util.Scanner;

public class Assignment2 {
    //main function
    public static void main(String[] args) {
        Assignment2 assignment2 = new Assignment2();
        //Scanner to take in keyboard input from the user.
        Scanner keyboard = new Scanner(System.in);
        //do while loop that ensures that the user is always prompted to choose an option until they exit.
        do {
            System.out.println("--Please choose an option from the list below:--");
            System.out.println("\t1.) Body Mass Index");
            System.out.println("\t2.) Retirement Age");
            System.out.println("\t0.) Exit");
            System.out.print("Which option would you like to choose:\t");
            //Takes the users input and ensures that it is an integer that is given as an option.
            String num = keyboard.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(num);
            } catch(Exception e) {
                System.out.println("Please ensure that your input is an integer with a value listed above.");
                continue;
            }

            if(choice == 1)
                assignment2.BMI();
            else if(choice == 2)
                assignment2.retirement();
            else if(choice == 0)
                break;
            else {
                System.out.println("Please ensure that your choice is an option listed above.");
            }
        }while(true);
    }

    //This function gathers the information
    private void BMI() {
        //Scanner to take in keyboard input from the user.
        Scanner keyboard = new Scanner(System.in);
        int feet;
        int inches;
        System.out.println("Please input your height below:");
        //This loop ensures that the feet are put in as an integer.
        do {
            System.out.print("Feet: ");
            String num = keyboard.nextLine();
            try {
                feet = Integer.parseInt(num);
                break;
            } catch(Exception e) {
                System.out.println("Please input the feet as an integer!");
            }
        } while(true);

        //This loop ensures that the inches are put in as an integer.
        do {
            System.out.print("Inches: ");
            String num = keyboard.nextLine();
            try {
                inches = Integer.parseInt(num);
                break;
            } catch(Exception e) {
                System.out.println("Please input the inches as an integer!");
            }
        } while(true);

        int pounds;
        //This loop ensures that the pounds are put in as an integer.
        do {
            System.out.print("Please input your weight in pounds: ");
            String num = keyboard.nextLine();
            try {
                pounds = Integer.parseInt(num);
                break;
            } catch(Exception e) {
                System.out.println("Please input the weight as an integer!");
            }
        } while(true);

        double BMI = BMICalculations(feet, inches, pounds);

        //This makes it easier to display the BMI category in the final output
        String BMICategory;
        if (BMI < 18.5)
            BMICategory = "underweight";
        else if(18.5 <= BMI && BMI < 25)
            BMICategory = "normal weight";
        else if(25 <= BMI && BMI < 30)
            BMICategory = "overweight";
        else
            BMICategory = "obese";

        //This prints the user's BMI based on inputs and their BMI category based on the BMI calculation.
        System.out.println("Your BMI is " + BMI + " which means that you are " + BMICategory + ".");
    }

    //Calculates the BMI based on the user's inputs
    double BMICalculations(int feet, int inches, int pounds) {
        inches += (feet * 12);

        //Convert height and weight to metric and calculate BMI
        double meters = inches * 0.025;
        double kilograms = pounds * 0.45;
        double BMI = kilograms / Math.pow(meters, 2);

        // The below calculation is used to round the BMI to the nearest tenth.
        return Math.round(BMI * 10) / 10.0;
    }

    private void retirement() {
        Scanner keyboard = new Scanner(System.in);
        int age;
        int salary;
        int percentSaved;
        int savingsGoal;

        //A loop to ensure that the age is input as an integer
        do {
            System.out.print("Enter your age as an integer: ");
            String input = keyboard.nextLine();
            try{
               age = Integer.parseInt(input);
               break;
            } catch(Exception e) {
                System.out.println("Please input an integer!");
            }
        } while(true);

        //A loop to ensure that the salary is input as an integer
        do {
            System.out.print("Enter your salary as an integer: ");
            String input = keyboard.nextLine();
            try{
                salary = Integer.parseInt(input);
                break;
            } catch(Exception e) {
                System.out.println("Please input an integer!");
            }
        } while(true);

        //A loop to ensure that the percent saved is input as an integer
        do {
            System.out.print("Enter your percentage saved as an integer: ");
            String input = keyboard.nextLine();
            try{
                percentSaved = Integer.parseInt(input);
                break;
            } catch(Exception e) {
                System.out.println("Please input an integer!");
            }
        } while(true);

        //A loop to ensure that the savings goal is input as an integer
        do {
            System.out.print("Enter your savings goal as an integer: ");
            String input = keyboard.nextLine();
            try{
                savingsGoal = Integer.parseInt(input);
                break;
            } catch(Exception e) {
                System.out.println("Please input an integer!");
            }
        } while(true);

        int yearsToRetirement = yearsToRetirement(salary, percentSaved, savingsGoal);

        if(yearsToRetirement < 100)
            System.out.println("You will be " + (age + yearsToRetirement) + "when you meet your savings goal.");
        else
            System.out.println("You will not be able to meet your retirement savings goal.");
    }

    //Calculates the years to retire as an integer.
    int yearsToRetirement(int salary, int percentSaved, int savingsGoal){
        //Converts the percentage from an integer to a decimal
        double percentage = percentSaved/100.00;
        //Gets the total amount that the person saves per year. the * 1.35 is there to show the matched 35% by the employer;
        double amountSavedPerYear = (salary*percentage) * 1.35;
        //Gets the total number of years to retirement as an integer.
        return Math.round((float)(savingsGoal/amountSavedPerYear));
    }
}

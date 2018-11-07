package Task1;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Task 1a Calculator
 */

public class Calculator {



           public static void main(String[] args)
        {
            double num1=0;
            double num2=0;
            String operation="";

       try {
           Scanner input = new Scanner(System.in);

           System.out.println("please enter the first number");
           num1 = input.nextDouble();

           System.out.println("please enter the second number");
           num2 = input.nextDouble();

           operation = input.nextLine();

           System.out.println("Please enter operation (+ or - or * or /)");
           operation = input.nextLine();

           input.close();

       }
       catch (InputMismatchException e){
           System.out.println("Not Possible input: " + e.getMessage());
           System.exit(1);


       }

            switch (operation){
                case ("+"): {
                    System.out.println("your answer is " + (num1 + num2));
                    break;
                }
                case("-"):{
                    System.out.println("your answer is " + (num1 - num2));
                    break;
                }
                case("*"):{
                    System.out.println("your answer is " + (num1 * num2));
                    break;
                }
                case("/"):{
                    try {
                        System.out.println("your answer is " + (num1 / num2));
                        break;
                    }
                    catch (ArithmeticException e){
                        System.out.println(e.getMessage());
                    }

                }
                default:{
                    System.out.println("Not possible operration");
                }
            }

    }
}



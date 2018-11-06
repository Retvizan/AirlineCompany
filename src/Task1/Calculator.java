package Task1;
import java.util.Scanner;

/**
 * Created by Andrei_Shkarubski on 10/20/2018.
 */
public class Calculator {


           public static void main(String[] args)
        {
            double num1;
            double num2;
            String operation;


            Scanner input = new Scanner(System.in);

            System.out.println("please enter the first number");
            num1 = input.nextDouble();

            System.out.println("please enter the second number");
            num2 = input.nextDouble();

            Scanner op = new Scanner(System.in);

            System.out.println("Please enter operation (+ or - or * or /)");
            operation = op.next();

            if (operation.equals("+"))
            {
                System.out.println("your answer is " + (num1 + num2));
            }
            else if  (operation.equals("-"))
            {
                System.out.println("your answer is " + (num1 - num2));
            }

            else if (operation.equals("/"))
            {
                try {
                    System.out.println("your answer is " + (num1 / num2));
                }
                catch (ArithmeticException e){
                    System.out.println(e.getMessage());
                }
            }
            else if (operation.equals("*"))
            {
                System.out.println("your answer is" + (num1 * num2));
            }
            else {
                System.out.println("Not possible operration");
            }
        }
    }




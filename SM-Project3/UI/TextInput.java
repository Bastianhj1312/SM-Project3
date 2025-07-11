package UI;

import java.util.Scanner;
public class TextInput
{
    // instance variables 

    /**
     * Constructor for objects of TextInput
     */
    public TextInput() {
        // initialise instance variables
    }
    

    //other methods
    public static int inputNumber(String question) {   
        Scanner keyboard = new Scanner(System.in);
        int number = 0;
        printQuesiton(question);
        while (!keyboard.hasNextInt()){
            System.out.println("Input needs to be a number - try again");
            keyboard.nextLine();
        }
        number = keyboard.nextInt();
        return number;
    }
    public static float inputFloatNumber(String question) {   
        Scanner keyboard = new Scanner(System.in);
        float number = 0;
        printQuesiton(question);
        while (!keyboard.hasNextFloat()){
            System.out.println("Input needs to be a number - try again");
            keyboard.nextLine();
        }
        number = keyboard.nextFloat();
        return number;
    }    
    
    public static String inputString(String question) {
        Scanner keyboard = new Scanner(System.in);
        printQuesiton(question);
        return keyboard.nextLine();
    }
    
    private static void printQuesiton(String question) {
        System.out.print(" " + question + ": ");
    }

}

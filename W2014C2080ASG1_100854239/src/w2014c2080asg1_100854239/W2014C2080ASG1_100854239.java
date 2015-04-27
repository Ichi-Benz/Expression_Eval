/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package w2014c2080asg1_100854239;

import java.util.EmptyStackException;
import java.util.Scanner;
/**
 *
 * @author Stan
 */
public class W2014C2080ASG1_100854239 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //variables that will be manipulated and used by ExpressionEvaluator
        String again = "Y", expression = "";
        float result;
        boolean state = true;
        //creates scanner variable to read user input
        Scanner input = new Scanner(System.in);
        //runs and loops program depending on state
        do{
            //handles error catching
            try{
                //runs and loops application depending on a yes or no (Y/N) decision
                do{
                    //creates variable of ExpressionEvaluator class
                    ExpressionEvaluator eval = new ExpressionEvaluator();
                    //asks user for expression
                    System.out.println("Enter a valid expression (% to break)");
                    //saves user input in variable expression to be manipulated
                    expression = input.nextLine();
                    if(expression.matches("%")){
                        state = false;
                        break;
                    }
                    //if the input is empty or has a space in start of the string this loop will ask for a proper input
                    while(expression.matches(" *")){
                        System.out.println("Input cannot be empty!\nEnter a valid expression (% to break): ");
                        expression = input.nextLine();
                    }
                    //generated fixed string which is manipulatoed by the doExpression method which will do the calculation
                    result = eval.doExpression(eval.fixString(expression));
                    //next 3 System.out.println statements print out the infix, result and a re-loop decision
                    System.out.println(eval.fixPre(eval.fixString(expression)));
                    System.out.println("Result: " + result);
                    //asks user if they want to start the application again
                    System.out.print("Enter another expression? [Y/N]? \n");
                    //checks to see if the loop is to break or restart
                    again = input.nextLine();
                    //check the input of the user for restarting or breaking the loop to see if it
                    //is empty or not as well as if it matches a specific character
                    while(again.matches(" *") || !again.matches("[nyNY]")){
                        System.out.println("Input cannot be empty and must be either Y/N!\nEnter another expression? [Y/N]? ");
                        again = input.nextLine();
                    }
                //loop will break if user input is N/n
                }while(!again.equalsIgnoreCase("N"));
            }
            //catch checks if the user had made a bad input
            //if user has bad input then message will display
            catch(Exception exc){
                System.out.println("Invalid input, your input must have an operator '+, -, *, /'.\n"
                                    + "Your input should also have operands 0...999\n"
                                    + "Your characters should be spaced out as well.\n");
            }
        //checks whether to loop or to break depending on states boolean value
        }while(state && !again.equalsIgnoreCase("N"));
    }
}

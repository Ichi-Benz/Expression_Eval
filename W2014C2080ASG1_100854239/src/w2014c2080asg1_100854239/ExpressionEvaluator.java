/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package w2014c2080asg1_100854239;
import java.util.StringTokenizer;
/**
 *
 * @author Stan
 */
public class ExpressionEvaluator {
    //declares the operator values to be used in the switch method
    private final char ADD = '+', 
                       SUBTRACT = '-', 
                       MULTIPLY = '*', 
                       DIVIDE = '/';
    //declares the stacks that will be used in this class
    private Stacked<Float> stack;
    private Stacked<String> strStack;
    private Stacked<String> exprStack;
    //creates a constructor with stack sizes
    public ExpressionEvaluator(){
        stack = new Stacked<>(20);
        strStack = new Stacked<>(20);
        exprStack = new Stacked<>(20);
    }
    //method will take users expression and calculate result
    public Float doExpression(String expr){
        //declares methods variables that will be manipulated
        Float op1, op2, result = 0f;
        String result2 = "";
        String token;
        //StringTokenizer will trim and split the input string
        StringTokenizer tokenizer = new StringTokenizer(expr);
        //loop will go through as long as the string has characters left
        while(tokenizer.hasMoreTokens()){
            token = tokenizer.nextToken();
            //checks to see the operator
            //if it is one of the above operators then it calculates the two values being stored as well
            //as the operator
            if(isOperator(token)){
                //stores values from the string to the variables as float
                op2 = (stack.pop()).floatValue();
                op1 = (stack.pop()).floatValue();
                //passes the two values and the operator to the evalOp method which will 
                //do a calculation depending on the operator token.charAt(0)
                result = evalOp(token.charAt(0), op1, op2);
                //outputs the steps for each calculation
                result2 = "(" + result2 + op2 + token + op1 + ")";
                exprStack.push(token);
                stack.push(new Float(result));
                exprStack.push(result2);
            }
            else{
                stack.push(new Float(Float.valueOf(token)));
            }
        }
        System.out.println(exprStack.pop());
        return result;
    }
    //method will output an infix expression of the prefix
    public String fixPre(String expr){
        //declares variables to be used in this method
        String result = "", exp1, exp2;
        StringTokenizer tokenizer = new StringTokenizer (expr);
        while (tokenizer.hasMoreTokens()){
            result = tokenizer.nextToken();
            //stores values into variables as string and then forms the infix expression
            //infix is stored in result and then pushed into the stack
            if (isOperator(result)){
                exp2 = exprStack.pop();
                exp1 = exprStack.pop();
                result = "(" + exp2 + result + exp1 + ")";
                exprStack.push(result);
            }
            else
                exprStack.push(result);
        }
        //prints entire infix expression
        return result;
    }
    //checks to see if given value is a proper operator
    private boolean isOperator (String token){
        return ( token.equals("+") || token.equals("-") ||
        token.equals("*") || token.equals("/") );
    }
    //takes values from doExpression and calculates them depending on the operator
    private Float evalOp (char operation, float op1, float op2){
        Float result = 0f;
        switch (operation){
            case ADD:
            result = op2 + op1;
            break;
            case SUBTRACT:
            result = op2 - op1;
            break;
            case MULTIPLY:
            result = op2 * op1;
            break;
            case DIVIDE:
            result = op2 / op1;
        }
    //returns calculated response
    return result;
    }
    //since the input string is being read backwards this method will fix the input string
    //with the string fixed doExpression as well as other methods will work properly
    public String fixString(String str){
        String[] hold = str.split(" ");
        String newString = "";
        for(int i =0; i < hold.length;i++){
            strStack.push(hold[i]);
        }
        do{
            newString += strStack.pop() + " ";
        }while(!strStack.isEmpty());
        //returns fixed string
        return newString;
    }
}

package Parser;

import Lexical.Token;
import java.util.ArrayList;
import java.util.Stack;

public class Postfix {
   
   private static int Prec(Token ch) 
    { 
        switch (ch.tokvalue) 
        { 
        case "^":  
            return 1; 
       
        case "*": 
        case "/": 
            return 2; 
       
        case "+":
        case "-":    
            return 3; 
        } 
        return -1; 
    } 

    public static ArrayList<Token> infixToPostfix(ArrayList<Token> in) 
    { 
        Stack<Token> stack = new Stack<Token>();
        ArrayList<Token> input = in;
        ArrayList<Token> result = new ArrayList<Token>(input.size());
        for (int i = 0; i<input.size(); ++i) 
        { 
            Token c = input.get(i); 
            
            if (c.type.equals("number") || c.type.equals("identifier")) 
                result.add(c);
               
            else if (c.tokvalue == "(") 
                stack.push(c); 
            
            else if (c.tokvalue == ")") 
            { 
                while (!stack.isEmpty() && stack.peek().tokvalue != "(") 
                    result.add(stack.pop());
                  
                stack.pop();
            }
            else
            { 
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek()))
                    result.add(stack.pop());
             
                stack.push(c); 
            } 
       
        } 
       
        while (!stack.isEmpty())
            result.add(stack.pop());
         
        return result; 
    }
}
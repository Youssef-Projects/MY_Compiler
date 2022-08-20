package Lexical;

/**
 *
 * @author Youssef Mamdouh Youssef | 201701453
 */
import java.util.ArrayList;

public class Token {
    public String type;
    public String tokvalue;
    public static ArrayList<Token> tokens = new ArrayList<Token>(0);
    public static String[] keyword = {"if", "for"};
    public static String[] delimeter= { "{", "}","(",")", ";" };
    public static String[] operator ={"+", "*", "-", "/", "=", "==", "<", ">"};
    
    Token (String x)
    {
        if (intialarray(x,Token.keyword))
        {
            type= "keyword";
            tokvalue= x;
            System.out.println(tokvalue +" -- "+ type);
        }
        else if (intialarray(x,Token.delimeter))
        {
            type= "delimeter";
            tokvalue= x;
            System.out.println(tokvalue +" -- "+ type);
        }
        else if (intialarray(x,Token.operator))
        {
           type="operator";
           tokvalue=x;
           System.out.println(tokvalue +" -- "+ type);
        }
        else if (digit(x))
        {
            type="number";
            tokvalue=x;
            System.out.println(tokvalue +" -- "+ type);
        }
        else if (isidentifier(x))
        {
            type="identifier";
            tokvalue=x;
            System.out.println(tokvalue +" -- "+ type);
        }
        else 
        {
            System.out.println("NotFound");
            System.exit(1);
        }
    }
      
    public boolean intialarray (String x, String[] y)
    {
        for (int i=0; i<y.length;i++)
        {
            if (x.equals(y[i]))
                return true;

        }
        return false;
    }
    public boolean digit(String Num) 
    {
        if (Num == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(Num);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    public boolean isidentifier(String x) 
    {
       char []y = x.toCharArray();
           if (y[0]!= '@')
              return false;
           else 
               for (int i=1; i<y.length;i++)
               {
                if (intialarray(Character.toString(y[i]),Token.delimeter) ||intialarray(Character.toString(y[i]),Token.operator) ||intialarray(Character.toString(y[i]),Token.keyword) )
                {
                    return false;
                }
               }
           return true;
    }

    public static void SplitTokens (ArrayList<String> code)
    {
        for(int i = 0; i < code.size(); i++){
            String[] x = code.get(i).split(" ");
            for(int j = 0; j < x.length; j++){
                if(x[j].equals(" "))
                    continue;
                Token t = new Token(x[j]);
                Token.tokens.add(t);
            }
        }
    }
}
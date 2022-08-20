    package Parser;

import java.util.ArrayList;
import Lexical.Token;
public class Assignstmnt {
    public Object left = null;
    public Object right = null;
    public String type = null;
    public String tokvalue = null;
    
    public Assignstmnt(ArrayList<Token> statement){
        if (statement.size() < 3){
            System.err.println("Error stmnt not completed");
            System.exit(0);
        
        }
        
        Token id = statement.get(0);
        this.left = new Node(id);
        Token lhs;
        statement.remove(0);
        statement.remove(0);
        if(statement.size() == 1){
            lhs = statement.get(0);
            if(lhs.tokvalue.toCharArray()[0] == '@')
                this.tokvalue = "id_id";
            else
                this.tokvalue = "id_number";
            this.right = new Node(lhs);
        }
        else {
            this.tokvalue = "id_exp";
            ArrayList<Token> exp = statement;
            if(CheckAssignStmnt(exp)){
            exp= Postfix.infixToPostfix(exp);
            this.right = new Node(exp);}
        }
    }
    public boolean CheckAssignStmnt(ArrayList<Token> exp){
        for (int i=0;i<exp.size()-1;i++){
           if(exp.get(i).type.equals("identifier")){
               if(exp.get(i+1).type.equals("identifier")){
                   System.err.println("\n Error two identifiers not allowed");
                   System.exit(0);
                   return false;
               }
           }
           if(exp.get(i).type.equals("number")){
               if(exp.get(i+1).type.equals("number")){
                   System.err.println("\n Error two numbers not allowed ");
                   System.exit(0);
                   return false;
               }
           }
           if(exp.get(i).type.equals("operator")){
               if(exp.get(i+1).type.equals("operator")){
                   System.err.println("\n Error two operators not allowed");
                   System.exit(0);
                   return false;
               }
           }
           
           if(exp.get(i).tokvalue.equals("=")){
               System.err.println("\n Error two = not allowed");
               System.exit(0);
               return false;
               
           }
        }
        return true;
    }
}
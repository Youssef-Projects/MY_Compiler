
package Parser;
import Lexical.Token;
import java.util.ArrayList;


public class IfStat {
    public Object left = null;
    public Object right = null;
    public String type = null;
    public String tokvalue = null;

    public IfStat(ArrayList<Token> Stmnt) {
        this.type = "ifstat";
        this.tokvalue = "ifstat";
        ArrayList<Token> condition = new ArrayList<Token>(0);
        ArrayList<Token> Newstmnt = new ArrayList<Token>(0);
        Stmnt.remove(0);
        if(Stmnt.get(0).tokvalue.equals("(")){
        Stmnt.remove(0);}
        else{
            System.err.println("Error you need to open bracket");
            System.exit(0);
        
        }
        
        int start = 0;
        
        for(int i = 0; i < Stmnt.size(); i ++){
            
            if(Stmnt.get(i).tokvalue.equals(")")){
                Stmnt.remove(i);
                break;
            }
            condition.add(Stmnt.get(i));
            start++;
        }
        for(int i = start; i < Stmnt.size(); i ++){
            Newstmnt.add(Stmnt.get(i));
        }
        if(CheckIf(condition)){
        this.left = new Node(condition);
        this.right = new Stmnt(Newstmnt);
        }
       
        
    }
        
        
   
    public boolean CheckIf(ArrayList<Token> condition){
        if(condition.size()<3 || condition.size()>3){
            System.err.print("Error wrong inputs ");
            System.exit(0);
            return false;
            
        }
        if(!condition.get(0).type.equals("identifier")){
            if(!condition.get(0).type.equals("number")){
            System.err.println("Error you need id or number");
            System.exit(0);
            return false;
        }}
         
        if(!condition.get(1).type.equals("operator")){
            System.err.println("Error expect operator");
            System.exit(0);
            return false;
        }
        if(condition.get(1).type.equals("operator")){
               if(condition.get(1).tokvalue.equals("-")||condition.get(1).tokvalue.equals("*")||condition.get(1).tokvalue.equals("+")||condition.get(1).tokvalue.equals("/")){
                   System.err.println("Error wrong operator\t"+"("+condition.get(1).tokvalue+")" + "not allowed");
                   System.exit(0);
                   return false;
               }
           }
        if(!condition.get(2).type.equals("identifier"))
        {
            if(!condition.get(2).type.equals("number")){
            System.err.println("Error you need id or number");
             System.exit(0);
            return false;}
        }
        
        return true;
    
}
}
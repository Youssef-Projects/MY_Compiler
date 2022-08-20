package Parser;

import Lexical.Token;
import java.util.ArrayList;

public class Cmpstmnt {
    public Object left = null;
    public Object right = null;
    String type = null;
    String tokvalue = null;

    public Cmpstmnt(ArrayList<Token> cmpstmnt, int intial) {
        ArrayList<Token> stat = new ArrayList<Token>(0);
        for(int i = intial; i < cmpstmnt.size(); i++){
            if(cmpstmnt.get(i).tokvalue.equals(";")){
                cmpstmnt.remove(i);
                break;
            }
            stat.add(cmpstmnt.get(i));
            intial ++;
            
        }
        if(cmpstmnt.size() == intial)
            this.left = new Stmnt(stat);
        else {
            this.left = new Stmnt(stat);
            this.right = new Cmpstmnt(cmpstmnt, intial);
        }
    }
}
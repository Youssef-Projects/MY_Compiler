
package Parser;

import Lexical.Token;
import java.util.ArrayList;

public class Stat {
    
    public Object middle = null;
    public String type = null;
    public String tokvalue = null;
    
    public Stat(ArrayList<Token> stat){
        if(stat.get(0).tokvalue.equals("if")){
            this.type = "stat";
            this.tokvalue = "ifstat";
            this.middle = new IfStat(stat);
        }
        else if(stat.get(0).type.equals("identifier")){
            this.type = "stat";
            this.tokvalue = "assstat";
            this.middle = new Assignstmnt(stat);
        }
        else {
            System.err.println("Synatx error!!! statement unknown");
            System.exit(0);
        }        
    }
}

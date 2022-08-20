 
package compiler;
import Lexical.Token;
import Parser.Assignstmnt;
import Parser.Cmpstmnt;
import Parser.IfStat;
import Parser.Node;
import Parser.Postfix;
import Parser.Stmnt;
import codegeneration.CodeGeneration;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.*;

public class Compiler {
    
    public static void print(Object head){
        
        if(head instanceof Cmpstmnt){
            print(((Cmpstmnt) head).left);
            if (((Cmpstmnt) head).right != null)
                print(((Cmpstmnt) head).right);
        }
        else if(head instanceof Stmnt){
            print(((Stmnt) head).middle);
        }
        else if(head instanceof Assignstmnt)
        {
            CodeGeneration.Assstat((Assignstmnt)head);
        }
        else if(head instanceof IfStat){
            
            CodeGeneration.IfStmt((IfStat)head);
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("test.txt");
        BufferedReader read = new BufferedReader(fr);
        ArrayList<String> code = new ArrayList<String>(0);
        String line;
        while ((line = read.readLine()) != null)
            code.add(line);
        Token.SplitTokens(code);

        Cmpstmnt root = new Cmpstmnt(Token.tokens, 0);
        print(root);
        for(int i = 0 ; i < CodeGeneration.W.size() ; i++)
        {
            String k = CodeGeneration.W.get(i).split("s_")[1];
            System.out.println(CodeGeneration.W.get(i)+"\tWORD\t"+k);
        }
        for(int i = 0 ; i < CodeGeneration.R.size() ; i++)
        {
            System.out.println(CodeGeneration.R.get(i)+"\tRESW\t1");
        }
    } 
}
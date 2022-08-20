package Parser;

import Lexical.Token;
import java.util.ArrayList;

public class Node {
    public Token lexeme;
    public Node left = null;
    public Node middle = null;
    public Node right = null;
    public ArrayList<Token> exp = null;

    public Node (Token lexeme){
        this.lexeme = lexeme;
    }
    public Node(ArrayList<Token> exp){
        this.exp = exp;
    }    
}
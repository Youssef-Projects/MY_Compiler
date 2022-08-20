/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codegeneration;

import Lexical.Token;
import Parser.Assignstmnt;
import Parser.Cmpstmnt;
import Parser.IfStat;
import Parser.Node;
import Parser.Postfix;
import Parser.Stmnt;
import java.util.ArrayList;
import java.lang.*;

import java.io.FileNotFoundException;
import java.io.IOException;
/**
 *
 * @author perl group
 */
public class CodeGeneration {

    public static ArrayList<String>W=new ArrayList<String>(0);
    public static ArrayList<String>R=new ArrayList<String>(0);
    public static void Assstat(Assignstmnt root)
    {
        if(root.tokvalue.equals("id_id"))
        {
            IdintIdint(root);
        }
        else if (root.tokvalue.equals("id_number"))
        {
            IdintNum(root);
        }
        else
        {
            IdintExp(root);
        }
    }
    public static void IdintIdint(Assignstmnt r)
    {
        Node left = (Node) r.left;     
        Node right = (Node) r.right;     
        if(!R.contains("s_"+left.lexeme.tokvalue))
        {
        R.add("s_"+left.lexeme.tokvalue);
        }
        if(!R.contains("s_"+left.lexeme.tokvalue))
        {
        R.add("s_"+right.lexeme.tokvalue);
        }
        System.out.println("\tLDA\ts_"+right.lexeme.tokvalue);
        System.out.println("\tSTA\ts_"+left.lexeme.tokvalue);
    }
    
    public static void IdintNum(Assignstmnt r)
    {
        Node left = (Node) r.left;     
        Node right = (Node) r.right;    
        if(!R.contains("s_"+left.lexeme.tokvalue))
        {
        R.add("s_"+left.lexeme.tokvalue);
        }
        if(!W.contains("s_"+left.lexeme.tokvalue))
        {
        W.add("s_"+right.lexeme.tokvalue);
        }
        System.out.println("\tLDA\t"+right.lexeme.tokvalue);
        System.out.println("\tSTA\ts_"+left.lexeme.tokvalue);
    }
    public static void IdintExp(Assignstmnt r)
    {
        Node left = (Node) r.left;    
        Node right = (Node) r.right;    
        if(!R.contains("s_"+left.lexeme.tokvalue))
        {
        R.add("s_"+left.lexeme.tokvalue);
        }
    }
    public static void IfStmt(IfStat r)
    {
        Node left = (Node) r.left;                      
        if(!R.contains("s_"+left.exp.get(0).tokvalue))
            R.add("s_"+left.exp.get(0).tokvalue);
        System.out.println("\tCOMP\t"+left.exp.get(2).tokvalue);
        if(left.exp.get(1).tokvalue.equals(">"))
            System.out.println("\tJLT\t");
        else if(left.exp.get(1).tokvalue.equals("<"))
            System.out.println("\tJGT\t");
        else if (left.exp.get(1).tokvalue.equals("=="))
            System.out.println("\tJEQ\t");
        Stmt((Stmnt)r.right);
    }
    public static void Stmt(Stmnt r)
    {
        if(r.tokvalue.equals("assstat"))
            Assstat((Assignstmnt)r.middle);
        else
            IfStmt((IfStat)r.middle);
    }
}

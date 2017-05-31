
import Jama.Matrix;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;




@SuppressWarnings("deprecation")
public class Main {
    public static void main(String[] args) {
    	
    	enterProg();
     }

    
    public static void enterProg(){
    	GrammLexer lexer;
        Expression exp = new Expression();
        CommonTokenStream tokens;
        GrammParser parser;
        ParseTree tree;
        TestListener listener;
        Scanner sc = new Scanner(System.in);
        ParseTreeWalker walker;
        while(true)
        {
        	System.out.println("Enter");
            lexer  = new GrammLexer(new ANTLRInputStream(sc.nextLine()));
            tokens = new CommonTokenStream(lexer);
            parser = new GrammParser(tokens);
            walker = new ParseTreeWalker();
            parser.removeErrorListeners();
            lexer.removeErrorListeners();
            tree = parser.root();
            listener = new TestListener();
            walker.walk(listener, tree);
            
            listener.exp.printResult();
          
        }
    	
    }
    
    public static TestListener enterProgTest(String str ){
    	GrammLexer lexer= new GrammLexer(new ANTLRInputStream(str));
        Expression exp = new Expression();
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GrammParser parser= new GrammParser(tokens);
        ParseTree tree;
        TestListener listener= new TestListener();
        Scanner sc = new Scanner(System.in);
        ParseTreeWalker walker = new ParseTreeWalker();
            parser.removeErrorListeners();
            lexer.removeErrorListeners();
            tree = parser.root();
            walker.walk(listener, tree); 
        return listener;  
    }
    
  
}


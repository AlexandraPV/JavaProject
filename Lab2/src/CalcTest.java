
import Jama.Matrix;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.Assert.*;

import java.util.HashMap;

public class CalcTest {
	
	
	@Test
	public void testAddMatrix(){
	  Expression expr = new  Expression();
	  double [][] arr1 = {{1,1,1},{1,1,1},{1,1,1}};
	  Matrix matr1 = new Matrix(arr1);
	  expr.matrixes.add(matr1);
	  double [][] arr2 = {{2,2,2},{2,2,2},{2,2,2}};
	  Matrix matr2 = new Matrix(arr2);
	  expr.matrixes.add(matr2);
	  expr.AddMatrix();
	  double [][] arr3 = {{3,3,3},{3,3,3},{3,3,3}};
	  
	  Matrix resMatrix = expr.matrixes.peek();
	  double [][] resArr = resMatrix.getArray();
	  //assertEquals(arr3,resArr);
	  assertArrayEquals(arr3,resArr);
	} 

	@Test
	public void testDetMatrix(){
		  Expression expr = new  Expression();
		  double [][] arr1 = {{1,1,8},{2,7,2},{7,3,3}};
		  Matrix matr1 = new Matrix(arr1);
		  expr.matrixes.add(matr1);
		  expr.DetMatrix();
		  int res = -321;
		  double resMatrix = expr.num.peek();
		  int r = (int) Math.round(resMatrix);
		  assertEquals(res,r);
	}
	
	@Test
	public void testMultVector(){
		Expression expr = new  Expression();
		  Vector vect1 = new Vector ("1,1,1");
		  expr.vectors.add(vect1);
		  Vector vect2 = new Vector ("2,2,2");
		  expr.vectors.add(vect2);
		  expr.MultVector();
		  int res = 6; 
		  double resMatrix = expr.num.peek();
		  int r = (int) Math.round(resMatrix);
		  assertEquals(res,r);
		}
	
	@Test
	public void testAddNumb(){
		Expression expr = new  Expression();
		  double num1 = 4;
		  expr.num.add(num1);
		  double num2 = 7;
		  expr.num.add(num2);
		  expr.AddNumb();
		  int res = 11; 
		  double resMatrix = expr.num.peek();
		  int r = (int) Math.round(resMatrix);
		  assertEquals(res,r);
	}
	
	@Test
	public void testInputAndOutputVectors(){
		String str = "[1,2]";
		TestListener listener = Main.enterProgTest(str ); 
            double [] ar1 = {1,2};
            double [] ar2 = listener.exp.vectors.peek().getArrayVect();
		    //Arrays.equals(ar1,ar2);
            assertArrayEquals(ar1,ar2,0.00000001);
	}
	
	@Test
	public void testInputAndOutputMatrixs(){
		String str = "[[1,2,3],[1,3,6],[5,2,6]]";
		TestListener listener = Main.enterProgTest(str ); 
            double [][] ar1 = {{1,2,3},{1,3,6},{5,2,6}};
           double [][] str2 = listener.exp.matrixes.peek().getArray();
		assertArrayEquals(ar1,str2);
	}
	
	@Test
	public void testInputAndOutputVectorsName(){
		String str = "a=[1,2]";
		TestListener listener = Main.enterProgTest(str );   
            double [] ar1 = {1,2};
            Expression exp1 = listener.hashMap.get("a");
            double [] ar2 = exp1.vectors.peek().getArrayVect();
            assertArrayEquals(ar1,ar2,0.00000001);
		   // Arrays.equals(ar1,ar2);
	}
	
	@Test
	public void testInputAndOutputMatrixsName(){
		String str = "A=[[1,2,3],[1,3,6],[5,2,6]]";
		TestListener listener = Main.enterProgTest(str );  
            double [][] ar1 = {{1,2,3},{1,3,6},{5,2,6}};
            Expression exp1 = listener.hashMap.get("A");
            double [][] ar2 = exp1.matrixes.peek().getArray();
            //Arrays.equals(ar1,ar2);
            assertArrayEquals(ar1,ar2);
	}
	
	@Test
	public void testExpression1(){
		String str = "det([[1,1,8],[2,7,2],[7,3,3]])";
		TestListener listener = Main.enterProgTest(str ); 
		int res = -321;
		double  str2 = listener.exp.num.peek();
		int r = (int) Math.round(str2);
		assertEquals(res,r);
	}
	
	@Test
	public void testExpression2(){
		String str = "det([[1,1,1],[2,2,2],[3,3,3]]+[[4,4,4],[5,5,5],[6,6,6]])";
		TestListener listener = Main.enterProgTest(str ); 
		int res = 0;
		double  str2 = listener.exp.num.peek();
		 int r = (int) Math.round(str2);
		assertEquals(res,r);
	}
	
	@Test
	public void testExpression3(){
		String str = "[1,1]*[2,2]";
		TestListener listener = Main.enterProgTest(str ); 
		int res = 4;
		double  str2 = listener.exp.num.peek();
		 int r = (int) Math.round(str2);
		assertEquals(res,r);
	}
	
	@Test
	public void testExpression4(){
		String str = "C=[[1,1,1],[1,1,1],[1,1,1]]+[[2,2,2],[2,2,2],[2,2,2]]";
		double [][] arr3 = {{3,3,3},{3,3,3},{3,3,3}};
		TestListener listener = Main.enterProgTest(str);
        Expression exp1 = listener.hashMap.get("C");
        double [][] res = exp1.matrixes.peek().getArray();
        //Arrays.equals(res, arr3);
        assertArrayEquals(res, arr3);
	}
		
	@Test
	public void testExpression5(){
		String str = "[1,1]*[2,2]+det([[1,1,1],[2,2,2],[3,3,3]]+[[4,4,4],[5,5,5],[6,6,6]])";
		TestListener listener = Main.enterProgTest(str ); 
		int res = 4;
		double  str2 = listener.exp.num.peek();
		 int r = (int) Math.round(str2);      
		assertEquals(res,r);
	}

	@Test
	public void testExpression6(){
		String str = "D=A+C";
		double [][] arr3 = {{4,5,6},{4,6,9},{8,5,9}};
		TestListener listener = Main.enterProgTest(str);
        Expression exp1 = listener.hashMap.get("D");
        double [][] res = exp1.matrixes.peek().getArray();
        //Arrays.equals(res, arr3);
        assertArrayEquals(res, arr3);
	}
}
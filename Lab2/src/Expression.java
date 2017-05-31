import java.util.Stack;

import Jama.Matrix;


public class Expression {
   public Stack<Vector> vectors = new Stack<Vector>();
   public Stack<Matrix> matrixes = new Stack<Matrix>();
   public Stack<Double> num = new Stack<Double>();
   
   public void AddMatrix(){
	   Matrix m2 = matrixes.pop();
       Matrix m1 = matrixes.pop();

       if(m1.getColumnDimension() == m2.getColumnDimension() && m1.getRowDimension() == m2.getRowDimension())
    	   matrixes.push(m1.plus(m2));
       else{
    	   System.out.println("Error size of matrix");
       }
   }
   
   public void DetMatrix(){
	   Matrix m = matrixes.pop();
	   if(m.getColumnDimension() == m.getRowDimension())
       num.push(m.det());
	   else{  
		 System.out.println("Error size of matrix");
	 }
   }
   
   public void MultVector(){
	  Vector v1 = vectors.pop();
	  Vector v2 = vectors.pop();
	  if(v1.getLenghtVector() == v2.getLenghtVector()) {
		  num.push(v1.multVector(v2));
	  }
	  else{  
			 System.out.println("Error size of vector");
			
		 } 
   }
   
   public void AddNumb(){
		  Double r1 = num.pop();
		  Double r2 = num.pop();
		  num.push(r1 + r2);
	   }
   
   public void printResult() {
	   if (!num.isEmpty()) {
		   //System.out.println("num");
		   System.out.println(num.peek());
	   } 
	   else if (!matrixes.isEmpty()) {
		   //System.out.println("matr");
		   matrixes.peek().print(3, 2);
	   }
	   else if (!vectors.isEmpty()) {
		   //System.out.println("vec");
		   vectors.peek().printVector();
	   } 
	   else {
		   System.out.println("Error");
	   }
   }
}

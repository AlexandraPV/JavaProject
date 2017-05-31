import java.util.Arrays;

public class Vector {
	
	public double[] vector;
	
	public Vector(String str){
	    String[] numbers;
	    
	    str = str.replace("[","");
	    str = str.replace("]","");
	    numbers = str.split(",");
	    
	     vector = new double[numbers.length];
		 for(int i =0; i<numbers.length; i++){
		    vector[i] = Double.parseDouble(numbers[i]);
		    //System.out.println(vector[i]);
		 }
	}
	
	public double multVector(Vector vect1){
		double res = 0;
		for(int i =0; i<vector.length; i++){
		 res += vector[i]* vect1.vector[i];
		}
		return res;
	}
	
	public int getLenghtVector(){
		return vector.length;
	}
	
	public double [] getArrayVect(){
		return vector;
	}
	
	
	public void printVector() {
		for (int i = 0; i < vector.length; i++) {
			System.out.printf("%.2f\t", vector[i]);
		}
		System.out.println();
	}

}

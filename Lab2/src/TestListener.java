import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import  Jama.Matrix;

import java.util.HashMap;


public class TestListener implements  GrammListener {
	
	public static HashMap<String,Expression> hashMap = new HashMap<String,Expression>();
	
	
	public Expression exp = new Expression();
	@Override
	public void enterEveryRule(ParserRuleContext arg0) {
		// TODO Aut-generated method stub
		
	}

	@Override
	public void exitEveryRule(ParserRuleContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitErrorNode(ErrorNode arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitTerminal(TerminalNode arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterRoot(GrammParser.RootContext ctx) {
		// TODO Auto-generated method stub
	}

	@Override
	public void exitRoot(GrammParser.RootContext ctx) {
		if(ctx.LETTER() != null){
			hashMap.put(ctx.LETTER().getText(), exp);
		}
		else if (ctx.LETTERVECTOR() != null) {
			hashMap.put(ctx.LETTERVECTOR().getText(), exp);
		}
	}

	@Override
	public void enterPlusN(GrammParser.PlusNContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitPlusN(GrammParser.PlusNContext ctx) {
		exp.AddNumb();
		
	}

	@Override
	public void enterMult(GrammParser.MultContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitMult(GrammParser.MultContext ctx) {
		exp.MultVector();
	}

	@Override
	public void enterDet(GrammParser.DetContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitDet(GrammParser.DetContext ctx) {
		exp.DetMatrix();	
	}

	@Override
	public void enterPlusM(GrammParser.PlusMContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitPlusM(GrammParser.PlusMContext ctx) {
		exp.AddMatrix();
	}

	@Override
	public void enterMatrix(GrammParser.MatrixContext ctx) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void exitMatrix(GrammParser.MatrixContext ctx) {
		if(ctx.LETTER() != null){
			Expression objM = hashMap.get(ctx.LETTER().getText());
			//objM.printResult();
			exp.matrixes.push(objM.matrixes.peek());
		
		}else {
			
		 String[] arr = ctx.getText().split("(?<=]),");
	        String[]numbers;
	        double [][] matrix = new double[arr.length][];
	        for (int i = 0; i<arr.length;i++) {
	            arr[i] = arr[i].replace("[","");
	            arr[i] = arr[i].replace("]","");
	            numbers= arr[i].split(",");
	            matrix[i] = new double[numbers.length];
	            for(int j =0; j<numbers.length;j++){
	                matrix[i][j] =Integer.parseInt(numbers[j]);
	            }
	        }
	        Matrix m = new Matrix(matrix);
	        exp.matrixes.push(m);
	       // m.print(3, 2);
		}
	}

	@Override
	public void enterVector(GrammParser.VectorContext ctx) {
			
	}

	@Override
	public void exitVector(GrammParser.VectorContext ctx) {
		if(ctx.LETTERVECTOR() != null){
			Expression objV = hashMap.get(ctx.LETTERVECTOR().getText());
			exp.vectors.push(objV.vectors.peek());
			
		}else {
			exp.vectors.push(new Vector(ctx.getText()));
		}
	}

	@Override
	public void enterExpr(GrammParser.ExprContext ctx) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void exitExpr(GrammParser.ExprContext ctx) {
		// TODO Auto-generated method stub
	}

	
}


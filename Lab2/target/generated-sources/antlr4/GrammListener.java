// Generated from Gramm.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammParser}.
 */
public interface GrammListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammParser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(GrammParser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammParser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(GrammParser.RootContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(GrammParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(GrammParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammParser#plusN}.
	 * @param ctx the parse tree
	 */
	void enterPlusN(GrammParser.PlusNContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammParser#plusN}.
	 * @param ctx the parse tree
	 */
	void exitPlusN(GrammParser.PlusNContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammParser#mult}.
	 * @param ctx the parse tree
	 */
	void enterMult(GrammParser.MultContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammParser#mult}.
	 * @param ctx the parse tree
	 */
	void exitMult(GrammParser.MultContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammParser#det}.
	 * @param ctx the parse tree
	 */
	void enterDet(GrammParser.DetContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammParser#det}.
	 * @param ctx the parse tree
	 */
	void exitDet(GrammParser.DetContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammParser#plusM}.
	 * @param ctx the parse tree
	 */
	void enterPlusM(GrammParser.PlusMContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammParser#plusM}.
	 * @param ctx the parse tree
	 */
	void exitPlusM(GrammParser.PlusMContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammParser#matrix}.
	 * @param ctx the parse tree
	 */
	void enterMatrix(GrammParser.MatrixContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammParser#matrix}.
	 * @param ctx the parse tree
	 */
	void exitMatrix(GrammParser.MatrixContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammParser#vector}.
	 * @param ctx the parse tree
	 */
	void enterVector(GrammParser.VectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammParser#vector}.
	 * @param ctx the parse tree
	 */
	void exitVector(GrammParser.VectorContext ctx);
}
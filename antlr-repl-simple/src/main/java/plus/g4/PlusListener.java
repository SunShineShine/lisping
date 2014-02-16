// Generated from Plus.g4 by ANTLR 4.1
package plus.g4;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PlusParser}.
 */
public interface PlusListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PlusParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(@NotNull PlusParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(@NotNull PlusParser.ListContext ctx);

	/**
	 * Enter a parse tree produced by {@link PlusParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(@NotNull PlusParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlusParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(@NotNull PlusParser.ExprContext ctx);
}
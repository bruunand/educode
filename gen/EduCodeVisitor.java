// Generated from /home/zen/Git/EduCode/src/EduCode.g4 by ANTLR 4.6
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link EduCodeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface EduCodeVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(EduCodeParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#methods}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethods(EduCodeParser.MethodsContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(EduCodeParser.MethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#methodc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodc(EduCodeParser.MethodcContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(EduCodeParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(EduCodeParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(EduCodeParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#stmts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmts(EduCodeParser.StmtsContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(EduCodeParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#ret}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRet(EduCodeParser.RetContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#loopstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopstmt(EduCodeParser.LoopstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#ifstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstmt(EduCodeParser.IfstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#dcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDcl(EduCodeParser.DclContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(EduCodeParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(EduCodeParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#logicexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicexpr(EduCodeParser.LogicexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#orexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrexpr(EduCodeParser.OrexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#andexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndexpr(EduCodeParser.AndexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#eqexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqexpr(EduCodeParser.EqexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#relexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelexpr(EduCodeParser.RelexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#boollit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoollit(EduCodeParser.BoollitContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#aritexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAritexpr(EduCodeParser.AritexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(EduCodeParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(EduCodeParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataType(EduCodeParser.DataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(EduCodeParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#eol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEol(EduCodeParser.EolContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdent(EduCodeParser.IdentContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#identname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentname(EduCodeParser.IdentnameContext ctx);
}
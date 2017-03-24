// Generated from /home/zen/Git/EduCode/src/EduCode.g4 by ANTLR 4.6
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link EduCodeParser}.
 */
public interface EduCodeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link EduCodeParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(EduCodeParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(EduCodeParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link EduCodeParser#methods}.
	 * @param ctx the parse tree
	 */
	void enterMethods(EduCodeParser.MethodsContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#methods}.
	 * @param ctx the parse tree
	 */
	void exitMethods(EduCodeParser.MethodsContext ctx);
	/**
	 * Enter a parse tree produced by {@link EduCodeParser#method}.
	 * @param ctx the parse tree
	 */
	void enterMethod(EduCodeParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#method}.
	 * @param ctx the parse tree
	 */
	void exitMethod(EduCodeParser.MethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link EduCodeParser#methodc}.
	 * @param ctx the parse tree
	 */
	void enterMethodc(EduCodeParser.MethodcContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#methodc}.
	 * @param ctx the parse tree
	 */
	void exitMethodc(EduCodeParser.MethodcContext ctx);
	/**
	 * Enter a parse tree produced by {@link EduCodeParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(EduCodeParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(EduCodeParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link EduCodeParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(EduCodeParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(EduCodeParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link EduCodeParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(EduCodeParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(EduCodeParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link EduCodeParser#stmts}.
	 * @param ctx the parse tree
	 */
	void enterStmts(EduCodeParser.StmtsContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#stmts}.
	 * @param ctx the parse tree
	 */
	void exitStmts(EduCodeParser.StmtsContext ctx);
	/**
	 * Enter a parse tree produced by {@link EduCodeParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(EduCodeParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(EduCodeParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link EduCodeParser#ret}.
	 * @param ctx the parse tree
	 */
	void enterRet(EduCodeParser.RetContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#ret}.
	 * @param ctx the parse tree
	 */
	void exitRet(EduCodeParser.RetContext ctx);
	/**
	 * Enter a parse tree produced by {@link EduCodeParser#loopstmt}.
	 * @param ctx the parse tree
	 */
	void enterLoopstmt(EduCodeParser.LoopstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#loopstmt}.
	 * @param ctx the parse tree
	 */
	void exitLoopstmt(EduCodeParser.LoopstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link EduCodeParser#ifstmt}.
	 * @param ctx the parse tree
	 */
	void enterIfstmt(EduCodeParser.IfstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#ifstmt}.
	 * @param ctx the parse tree
	 */
	void exitIfstmt(EduCodeParser.IfstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link EduCodeParser#dcl}.
	 * @param ctx the parse tree
	 */
	void enterDcl(EduCodeParser.DclContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#dcl}.
	 * @param ctx the parse tree
	 */
	void exitDcl(EduCodeParser.DclContext ctx);
	/**
	 * Enter a parse tree produced by {@link EduCodeParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(EduCodeParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(EduCodeParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link EduCodeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(EduCodeParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(EduCodeParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link EduCodeParser#logicexpr}.
	 * @param ctx the parse tree
	 */
	void enterLogicexpr(EduCodeParser.LogicexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#logicexpr}.
	 * @param ctx the parse tree
	 */
	void exitLogicexpr(EduCodeParser.LogicexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link EduCodeParser#orexpr}.
	 * @param ctx the parse tree
	 */
	void enterOrexpr(EduCodeParser.OrexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#orexpr}.
	 * @param ctx the parse tree
	 */
	void exitOrexpr(EduCodeParser.OrexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link EduCodeParser#andexpr}.
	 * @param ctx the parse tree
	 */
	void enterAndexpr(EduCodeParser.AndexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#andexpr}.
	 * @param ctx the parse tree
	 */
	void exitAndexpr(EduCodeParser.AndexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link EduCodeParser#eqexpr}.
	 * @param ctx the parse tree
	 */
	void enterEqexpr(EduCodeParser.EqexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#eqexpr}.
	 * @param ctx the parse tree
	 */
	void exitEqexpr(EduCodeParser.EqexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link EduCodeParser#relexpr}.
	 * @param ctx the parse tree
	 */
	void enterRelexpr(EduCodeParser.RelexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#relexpr}.
	 * @param ctx the parse tree
	 */
	void exitRelexpr(EduCodeParser.RelexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link EduCodeParser#boollit}.
	 * @param ctx the parse tree
	 */
	void enterBoollit(EduCodeParser.BoollitContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#boollit}.
	 * @param ctx the parse tree
	 */
	void exitBoollit(EduCodeParser.BoollitContext ctx);
	/**
	 * Enter a parse tree produced by {@link EduCodeParser#aritexpr}.
	 * @param ctx the parse tree
	 */
	void enterAritexpr(EduCodeParser.AritexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#aritexpr}.
	 * @param ctx the parse tree
	 */
	void exitAritexpr(EduCodeParser.AritexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link EduCodeParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(EduCodeParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(EduCodeParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link EduCodeParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(EduCodeParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(EduCodeParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link EduCodeParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterDataType(EduCodeParser.DataTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitDataType(EduCodeParser.DataTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link EduCodeParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(EduCodeParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(EduCodeParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link EduCodeParser#eol}.
	 * @param ctx the parse tree
	 */
	void enterEol(EduCodeParser.EolContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#eol}.
	 * @param ctx the parse tree
	 */
	void exitEol(EduCodeParser.EolContext ctx);
	/**
	 * Enter a parse tree produced by {@link EduCodeParser#ident}.
	 * @param ctx the parse tree
	 */
	void enterIdent(EduCodeParser.IdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#ident}.
	 * @param ctx the parse tree
	 */
	void exitIdent(EduCodeParser.IdentContext ctx);
	/**
	 * Enter a parse tree produced by {@link EduCodeParser#identname}.
	 * @param ctx the parse tree
	 */
	void enterIdentname(EduCodeParser.IdentnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#identname}.
	 * @param ctx the parse tree
	 */
	void exitIdentname(EduCodeParser.IdentnameContext ctx);
}
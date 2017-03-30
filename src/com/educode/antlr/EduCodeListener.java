// Generated from /home/zen/Git/EduCode-P4/src/EduCode.g4 by ANTLR 4.6
package com.educode.antlr;
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
	 * Enter a parse tree produced by {@link EduCodeParser#methodC}.
	 * @param ctx the parse tree
	 */
	void enterMethodC(EduCodeParser.MethodCContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#methodC}.
	 * @param ctx the parse tree
	 */
	void exitMethodC(EduCodeParser.MethodCContext ctx);
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
	 * Enter a parse tree produced by {@link EduCodeParser#loopStmt}.
	 * @param ctx the parse tree
	 */
	void enterLoopStmt(EduCodeParser.LoopStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#loopStmt}.
	 * @param ctx the parse tree
	 */
	void exitLoopStmt(EduCodeParser.LoopStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link EduCodeParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(EduCodeParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(EduCodeParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link EduCodeParser#varDcl}.
	 * @param ctx the parse tree
	 */
	void enterVarDcl(EduCodeParser.VarDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#varDcl}.
	 * @param ctx the parse tree
	 */
	void exitVarDcl(EduCodeParser.VarDclContext ctx);
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
	 * Enter a parse tree produced by {@link EduCodeParser#logicExpr}.
	 * @param ctx the parse tree
	 */
	void enterLogicExpr(EduCodeParser.LogicExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#logicExpr}.
	 * @param ctx the parse tree
	 */
	void exitLogicExpr(EduCodeParser.LogicExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link EduCodeParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(EduCodeParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(EduCodeParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link EduCodeParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(EduCodeParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(EduCodeParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link EduCodeParser#eqlExpr}.
	 * @param ctx the parse tree
	 */
	void enterEqlExpr(EduCodeParser.EqlExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#eqlExpr}.
	 * @param ctx the parse tree
	 */
	void exitEqlExpr(EduCodeParser.EqlExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link EduCodeParser#relExpr}.
	 * @param ctx the parse tree
	 */
	void enterRelExpr(EduCodeParser.RelExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#relExpr}.
	 * @param ctx the parse tree
	 */
	void exitRelExpr(EduCodeParser.RelExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link EduCodeParser#boolLit}.
	 * @param ctx the parse tree
	 */
	void enterBoolLit(EduCodeParser.BoolLitContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#boolLit}.
	 * @param ctx the parse tree
	 */
	void exitBoolLit(EduCodeParser.BoolLitContext ctx);
	/**
	 * Enter a parse tree produced by {@link EduCodeParser#arithExpr}.
	 * @param ctx the parse tree
	 */
	void enterArithExpr(EduCodeParser.ArithExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#arithExpr}.
	 * @param ctx the parse tree
	 */
	void exitArithExpr(EduCodeParser.ArithExprContext ctx);
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
	 * Enter a parse tree produced by {@link EduCodeParser#identName}.
	 * @param ctx the parse tree
	 */
	void enterIdentName(EduCodeParser.IdentNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link EduCodeParser#identName}.
	 * @param ctx the parse tree
	 */
	void exitIdentName(EduCodeParser.IdentNameContext ctx);
}
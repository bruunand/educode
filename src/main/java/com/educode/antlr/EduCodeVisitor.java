// Generated from /home/zen/Git/Reload/src/EduCode.g4 by ANTLR 4.6
package com.educode.antlr;
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
	 * Visit a parse tree produced by {@link EduCodeParser#methodC}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodC(EduCodeParser.MethodCContext ctx);
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
	 * Visit a parse tree produced by {@link EduCodeParser#loopStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopStmt(EduCodeParser.LoopStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(EduCodeParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#iterStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterStmt(EduCodeParser.IterStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#varDcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDcl(EduCodeParser.VarDclContext ctx);
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
	 * Visit a parse tree produced by {@link EduCodeParser#logicExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicExpr(EduCodeParser.LogicExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#orExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(EduCodeParser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#andExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(EduCodeParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#eqlExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqlExpr(EduCodeParser.EqlExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#relExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelExpr(EduCodeParser.RelExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#boolLit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolLit(EduCodeParser.BoolLitContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#arithExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithExpr(EduCodeParser.ArithExprContext ctx);
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
	 * Visit a parse tree produced by {@link EduCodeParser#stringLit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLit(EduCodeParser.StringLitContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#coordLit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoordLit(EduCodeParser.CoordLitContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#numberLit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberLit(EduCodeParser.NumberLitContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#eol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEol(EduCodeParser.EolContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReference(EduCodeParser.ReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdent(EduCodeParser.IdentContext ctx);
}
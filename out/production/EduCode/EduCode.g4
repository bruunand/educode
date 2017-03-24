grammar EduCode;

program  : 'PROGRAM' ident eol+ methods 'END PROGRAM'
         ;

methods  : (method eol+)*
         ;

method   : 'METHOD' ident LPAREN (params)? RPAREN ('RETURNS' dataType)? eol+ stmts 'END METHOD'
         ;

methodC  : ident LPAREN (args)? RPAREN
         ;

args     : expr(',' expr)*
         ;

params   : param(',' param)*
         ;

param    : dataType IDENT
         ;

stmts    : (stmt eol+)*
         ;

stmt     : methodC
         | assign
         | varDcl
         | ifStmt
         | loopStmt
         | ret
         ;

ret      : 'RETURN' (expr)?
         ;

loopStmt : 'REPEAT WHILE' logicExpr eol+ stmts 'END REPEAT'
         ;

ifStmt   : 'IF' logicExpr 'THEN' eol+ stmts ('ELSE IF' logicExpr 'THEN' eol+ stmts)* ('ELSE' eol+ stmts)? 'END IF'
         ;

varDcl   : dataType (ident | assign) (',' (ident | assign))*
         ;

assign   : ident '=' expr
         | ident '=' 'new' dataType LPAREN (args)? RPAREN
         ;

expr     : assign
         | logicExpr
         ;

logicExpr: orExpr
         ;

orExpr   : orExpr OROP andExpr
         | andExpr
         ;

andExpr  : andExpr ANDOP eqlExpr
         | eqlExpr
         ;

eqlExpr  : relExpr EQUALOP relExpr
         | relExpr
         ;

relExpr  : arithExpr RELOP arithExpr
         | arithExpr
         ;


boolLit  : TRUE
         | FALSE
         ;

arithExpr: term
         | arithExpr ADDOP term
         ;

term     : factor
         | term MULTOP factor
         ;

factor   : literal
         | boolLit
         | methodC // must return numliteral
         | LPAREN logicExpr RPAREN
         | ULOP factor
         ;

dataType : 'NUMBER'//Contains both ints and floats
         | 'BOOL'
         | 'COORDINATES'//Position data, (x, z, y)?
         | 'NULL'
         | 'STRING'
         | 'COLLECTION'//A collection of a type (Like a list in C#)
         | 'BLOCK'//Data for blocks placed in the world
         | 'ENTITY'//Data for an entity like animals and monsters
         | 'ITEM'//Data for an item while in inventory for example
         | 'TEXTURE'//The look of a block/entity??
         ;

literal  : ident
         | NUMLIT
         | STRLIT
         ;

eol      : NEWLINE
         ;

/* TEMP */
TRUE     : 'TRUE'
         ;

FALSE    : 'FALSE'
         ;

ADDOP    : '+'
         | '-'
         ;

MULTOP   : '/'
         | '*'
         | '%'
         ;

ANDOP    : 'AND'
         ;

OROP     : 'OR'
         ;

ULOP     : 'NOT'
         ;

RELOP    : 'GREATER THAN'
         | 'LESS THAN'
         | 'GREATER THAN OR EQUALS'
         | 'LESS THAN OR EQUALS'
         ;

EQUALOP  : 'EQUALS'
         | 'NOT EQUALS'
         ;

NEWLINE  : NewLine
         ;

ident    : identName ('[' arithExpr ']')?
         ;

identName: IDENT
         | identName '.' IDENT
         ;

/* Fragments */
fragment LowerChar: [a-z]
                  ;

fragment UpperChar: [A-Z]
                  ;

fragment Digit    : [0-9]
                  ;

fragment NewLine  : '\n'
                  ;

fragment USym     : '_'
                  ;

/* Literals */
NUMLIT   : Digit+('.' Digit*)?
         ;

COORDLIT : LPAREN Digit+ ',' Digit+',' Digit+ RPAREN
         ;

STRLIT   : USTRLIT '"'
         ;

USTRLIT  : '"' (~["\\\r\n] | '\\' (. | EOF))* // unterminated string
         ;

IDENT    : (LowerChar | UpperChar | USym) (LowerChar | UpperChar | Digit | USym)*
         ;

/* Token specification */
LPAREN   : '('
         ;

RPAREN   : ')'
         ;

/* Hidden stuff */
WHITESPACE   : [ \t\r\f]+ -> channel(HIDDEN)
             ;

LINECOMMENT  : '//' ~[\r\n]* -> channel(HIDDEN)
             ;
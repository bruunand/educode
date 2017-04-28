grammar EduCode;

program  : 'program' ident eol+ ((eventDef|method|varDcl) eol+)* 'end program'
         ;

eventDef : 'on event' eventType 'call' ident
         ;

method   : 'method' ident LPAREN (params)? RPAREN ('returns' dataType)? eol+ stmts 'end method'
         ;

methodC  : reference LPAREN (args)? RPAREN
         | methodC '.' methodC
         ;

args     : expr(',' expr)*
         ;

params   : param(',' param)*
         ;

param    : dataType ident
         ;

stmts    : (stmt eol+)*
         ;

stmt     : methodC
         | assign
         | varDcl
         | ifStmt
         | loopStmt
         | iterStmt
         | ret
         ;

ret      : 'return' (expr)?
         ;

loopStmt : 'repeat while' logicExpr eol+ stmts 'end repeat'
         ;

ifStmt   : 'if' logicExpr 'then' eol+ stmts ('else if' logicExpr 'then' eol+ stmts)* ('else' eol+ stmts)? 'end if'
         ;

iterStmt : 'foreach' dataType ident 'in' expr eol+ stmts 'end foreach'
         ;

varDcl   : dataType (ident | assign) (',' (ident | assign))*
         ;

assign   : reference '=' expr
         | reference '=' 'new' dataType LPAREN (args)? RPAREN
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
         | LPAREN dataType RPAREN factor
         ;

eventType: 'robotDeath'
         | 'robotAttacked'
         | 'entityDeath'
         | ('stringMessageReceived'|'entityMessageReceived') LPAREN numberLit RPAREN
         ;

dataType : 'number'//Contains both ints and floats
         | 'bool'
         | 'Coordinates'//Position data, (x, z, _y)?
         | 'string'
         | 'Collection' '<' dataType '>'//A collection of a type (Like a list in C#)
         | 'Block'//Data for blocks placed in the world
         | 'Entity'//Data for an entity like animals and monsters
         | 'Item'//Data for an item while in inventory for example
         | 'Texture'//The look of a block/entity??
         ;

literal  : reference
         | stringLit
         | numberLit
         | coordLit
         ;

stringLit: STRLIT
         ;

coordLit : LPAREN logicExpr ',' logicExpr ',' logicExpr RPAREN
         ;

numberLit: NUMLIT
         ;

eol      : NEWLINE
         ;

/* TEMP */
TRUE     : 'true'
         ;

FALSE    : 'false'
         ;

ADDOP    : '+'
         | '-'
         ;

MULTOP   : '/'
         | '*'
         | 'modulo'
         ;

ANDOP    : 'and'
         ;

OROP     : 'or'
         ;

ULOP     : 'not'
         ;

RELOP    : 'greater than'
         | 'less than'
         | 'greater than or equals'
         | 'less than or equals'
         ;

EQUALOP  : 'equals'
         | 'not equals'
         ;

NEWLINE  : NewLine
         ;

reference: reference '.' reference
         | reference '[' arithExpr ']'
         | ident
         ;

ident    : IDENT
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
NUMLIT   : ('-')? Digit+('.' Digit*)?
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
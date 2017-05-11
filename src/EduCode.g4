grammar EduCode;

start
    : ulist=usings? pr=program
    ;

usings
    : 'using' id+=identifier end_of_line+ ('using' id+=identifier end_of_line+)*
    ;

program  
    : 'program' id=identifier end_of_line+ ((el+=event_definition|ml+=method_declaration|vl+=variable_declaration) end_of_line+)* 'end program'
    ;

event_definition
    : 'on event' event=event_type 'call' id=identifier
    ;

method_declaration
    : 'method' id=identifier LPAREN (params=parameter_list)? RPAREN ('returns' type=data_type)? end_of_line+ body=statement_list 'end method'
    ;

argument_list
    : exprs+=expression(',' exprs+=expression)*
    ;

parameter_list
    : params+=parameter(',' params+=parameter)*
    ;

parameter
    : type=data_type id=identifier
    ;

statement_list
    : (statements+=statement end_of_line+)*
    ;

statement
    : call_statement
    | assignment_expression
    | variable_declaration
    | if_statement
    | iterative_statement
    | return_statement
    | break_statement
    | continue_statement
    ;

call_statement
    : method_call
    | access method_access
    ;

iterative_statement
    : repeat_statement
    | foreach_statement
    ;

break_statement
    : 'break'
    ;

continue_statement
    : 'continue'
    ;

return_statement
    : 'return' (expr=expression)?
    ;

repeat_statement
    : 'repeat while' predicate=logic_expression end_of_line+ bode=statement_list 'end repeat'
    ;

if_statement
    : 'if' predicate+=logic_expression 'then' end_of_line+ body+=statement_list ('else if' predicate+=logic_expression 'then' end_of_line+ body+=statement_list)* ('else' end_of_line+ elseBody=statement_list)? 'end if'
    ;

foreach_statement
    : 'foreach' type=data_type id=identifier 'in' expr=expression end_of_line+ body=statement_list 'end foreach'
    ;

variable_declaration
    : type=data_type  decl+=declarator (',' decl+=declarator)*
    ;

declarator
    : id=identifier ('=' expr=expression)?
    ;

expression
    : assignment_expression
    | logic_expression
    ;

assignment_expression
    : lhs=factor op=ASSIGNMENT_OPERATOR rhs=expression
    ;

logic_expression
    : or_expression
    ;

or_expression
    : or_expression OR_OPERATOR and_expression
    | and_expression
    ;

and_expression
    : and_expression AND_OPERATOR equality_expression
    | equality_expression
    ;

equality_expression
    : equality_expression EQUALITY_OPERATOR relative_expression
    | relative_expression
    ;

relative_expression
    : arithmetic_expression RELATIVE_OPERATOR arithmetic_expression
    | arithmetic_expression
    ;


arithmetic_expression
    : additive_expression
    ;

additive_expression
    : multiplicative_expression
    | additive_expression ADDITIVE_OPERATOR multiplicative_expression
    ;

multiplicative_expression
    : factor
    | multiplicative_expression MULTIPLICATIVE_OPERATOR factor
    ;

factor
    : literal
    | object_instantiation
    | UNARY_OPERATOR factor
    | type_cast
    | access
    ;

access
    : subfactor
    | access field_access
    | access element_access
    | access method_access
    ;

field_access
    : '.' identifier
    ;

element_access
    : '[' expression ']'
    ;

method_access
    : '.' method_call
    ;

subfactor
    : parenthesis_expression
    | identifier
    | method_call
    ;

parenthesis_expression
    : LPAREN logic_expression RPAREN
    ;

method_call
    : identifier LPAREN (argument_list)? RPAREN
    ;

type_cast
    : LPAREN data_type RPAREN factor
    ;

object_instantiation
    : 'new' data_type LPAREN (argument_list)? RPAREN
    ;

event_type
    : 'robotDeath'
    | 'robotAttacked'
    | 'entityDeath'
    | 'chatMessage'
    | ('stringMessageReceived'|'entityMessageReceived') LPAREN number_literal RPAREN
    ;

data_type
    : 'number'//Contains both ints and floats
    | 'bool'
    | 'Coordinates'//Position data, (x, z, _y)?
    | 'string'
    | 'Collection' '<' data_type '>'//A collection of a type (Like a list in C#)
    | 'Block'//Data for blocks placed in the world
    | 'Entity'//Data for an entity like animals and monsters
    | 'Item'//Data for an item while in inventory for example
    | 'Texture'//The look of a block/entity??
    ;

literal
    : bool_literal
    | string_literal
    | number_literal
    | coordinate_literal
    | null_literal
    ;

string_literal
    : STRING_LITERAL
    ;

coordinate_literal
    : LPAREN logic_expression ',' logic_expression ',' logic_expression RPAREN
    ;

number_literal
    : NUMBER_LITERAL
    ;

bool_literal
    : BOOL_LITERAL
    ;

null_literal
    : NULL_LITERAL
    ;

identifier
    : IDENTIFIER
    ;

end_of_line
    : NEWLINE
    ;



/* TEMP */
ASSIGNMENT_OPERATOR
    : '='
    | '+='
    | '-='
    | '*='
    | '/='
    ;

ADDITIVE_OPERATOR
    : '+'
    | '-'
    ;

MULTIPLICATIVE_OPERATOR
    : '/'
    | '*'
    | 'modulo'
    ;

AND_OPERATOR
    : 'and'
    ;

OR_OPERATOR
    : 'or'
    ;

UNARY_OPERATOR
    : 'not'
    | '-'
    ;

RELATIVE_OPERATOR
    : 'greater than'
    | 'less than'
    | 'greater than or equals'
    | 'less than or equals'
    ;

EQUALITY_OPERATOR
    : 'equals'
    | 'not equals'
    ;

NEWLINE
    : NewLine
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
NUMBER_LITERAL
    : ('-')? Digit+('.' Digit*)?
    ;

STRING_LITERAL
    : UNTERMINATED_STRING_LITERAL '"'
    ;

UNTERMINATED_STRING_LITERAL
    : '"' (~["\\\r\n] | '\\' (. | EOF))*
    ;

BOOL_LITERAL
    : ('true' | 'false')
    ;

NULL_LITERAL
    : 'null'
    ;


IDENTIFIER
    : (LowerChar | UpperChar | USym) (LowerChar | UpperChar | Digit | USym)*
    ;

/* Token specification */
LPAREN
    : '('
    ;

RPAREN
    : ')'
    ;

/* Hidden stuff */
WHITESPACE
    : [ \t\r\f]+ -> channel(HIDDEN)
    ;

LINECOMMENT
    : '//' ~[\r\n]* -> channel(HIDDEN)
    ;
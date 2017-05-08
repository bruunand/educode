grammar EduCode;

program
    : 'program' identifier end_of_line+ ((event_definition|method_declaration|variable_declaration) end_of_line+)* 'end program'
    ;

event_definition
    : 'on event' event_type 'call' identifier
    ;

method_declaration
    : 'method' identifier LPAREN (parameter_list)? RPAREN ('returns' data_type)? end_of_line+ statement_list 'end method'
    ;

argument_list
    : expression(',' expression)*
    ;

parameter_list
    : parameter(',' parameter)*
    ;

parameter
    : data_type identifier
    ;

statement_list
    : (statement end_of_line+)*
    ;

statement
    : method_call
    | assignment_expression
    | variable_declaration
    | if_statement
    | iterative_statement
    | return_statement
    ;

iterative_statement
    : repeat_statement
    | foreach_statement
    ;

return_statement
    : 'return' (expression)?
    ;

repeat_statement
    : 'repeat while' logic_expression end_of_line+ statement_list 'end repeat'
    ;

if_statement
    : 'if' logic_expression 'then' end_of_line+ statement_list ('else if' logic_expression 'then' end_of_line+ statement_list)* ('else' end_of_line+ statement_list)? 'end if'
    ;

foreach_statement
    : 'foreach' data_type identifier 'in' expression end_of_line+ statement_list 'end foreach'
    ;

variable_declaration
    : data_type (identifier | assignment_expression) (',' (identifier | assignment_expression))*
    ;

expression
    : assignment_expression
    | logic_expression
    ;

assignment_expression
    : factor '=' expression
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
    : relative_expression EQUALITY_OPERATOR relative_expression
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

identifier
    : IDENTIFIER
    ;

end_of_line
    : NEWLINE
    ;

/* TEMP */

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
    | '+'
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
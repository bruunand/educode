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
    : lhs=factor op=('='|'+='|'-='|'*='|'/=') rhs=expression
    ;

logic_expression
    : or=or_expression
    ;

or_expression
    : or=or_expression op='or' and=and_expression
    | and=and_expression
    ;

and_expression
    : and=and_expression op='and' eq=equality_expression
    | eq=equality_expression
    ;

equality_expression
    : eq=equality_expression op=('equals'|'not equals') rel=relative_expression
    | rel=relative_expression
    ;

relative_expression
    : ae+=arithmetic_expression op=('greater than'|'less than'|'greater than or equals'|'less than or equals') ae+=arithmetic_expression
    | ae+=arithmetic_expression
    ;

arithmetic_expression
    : add=additive_expression
    ;

additive_expression
    : mult=multiplicative_expression
    | add=additive_expression op=('+'|'-') mult=multiplicative_expression
    ;

multiplicative_expression
    : fac=factor
    | mult=multiplicative_expression op=('/'|'*'|'modulo') fac=factor
    ;

factor
    : literal
    | object_instantiation
    | ('not'|'-') factor
    | type_cast
    | access
    ;

access
    : sub=subfactor
    | rec=access acc=field_access
    | rec=access acc=element_access
    | rec=access acc=method_access
    ;

field_access
    : '.' id=identifier
    ;

element_access
    : '[' expr=logic_expression ']'
    ;

method_access
    : '.' method=method_call
    ;

subfactor
    : parenthesis_expression
    | identifier
    | method_call
    ;

parenthesis_expression
    : LPAREN expr=logic_expression RPAREN
    ;

method_call
    : id=identifier LPAREN (args=argument_list)? RPAREN
    ;

type_cast
    : LPAREN type=data_type RPAREN fac=factor
    ;

object_instantiation
    : 'new' type=data_type LPAREN (args=argument_list)? RPAREN
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
    | 'coordinates'//Position data, (x, z, _y)?
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
    : LPAREN x=logic_expression ',' y=logic_expression ',' z=logic_expression RPAREN
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
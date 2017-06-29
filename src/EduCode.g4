grammar EduCode;

start
    : (ulist=usings|end_of_line*) pr=program
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
    : exprs+=logic_expression(',' exprs+=logic_expression)*
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
    : 'return' (expr=logic_expression)?
    ;

repeat_statement
    : 'repeat while' predicate=logic_expression end_of_line+ body=statement_list 'end repeat'
    ;

if_statement
    : 'if' predicates+=logic_expression 'then' end_of_line+ bodies+=statement_list ('else if' predicates+=logic_expression 'then' end_of_line+ bodies+=statement_list)* ('else' end_of_line+ elseBody=statement_list)? 'end if'
    ;

foreach_statement
    : 'foreach' type=data_type id=identifier 'in' expr=logic_expression end_of_line+ body=statement_list 'end foreach'
    ;

variable_declaration
    : type=data_type  decls+=declarator (',' decls+=declarator)*
    ;

declarator
    : id=identifier ('=' expr=expression)?
    ;

expression
    : assignment_expression
    | logic_expression
    ;

assignment_expression
    : lhs=left_hand_side op=('='|'+='|'-='|'*='|'/=') rhs=expression
    ;

left_hand_side
    : id=identifier
    | acc=access element=element_access
    | acc=access field=field_access
    ;

logic_expression
    : or_expression
    ;

or_expression
    : left=or_expression op='or' right=and_expression
    | right=and_expression
    ;

and_expression
    : left=and_expression op='and' right=equality_expression
    | right=equality_expression
    ;

equality_expression
    : left=equality_expression op=('equals'|'not equals') right=relative_expression
    | right=relative_expression
    ;

relative_expression
    : left=arithmetic_expression op=('>'|'<'|'>='|'<=') right=arithmetic_expression
    | right=arithmetic_expression
    ;

arithmetic_expression
    : additive_expression
    ;

additive_expression
    : right=multiplicative_expression
    | left=additive_expression op=('+'|'-') right=multiplicative_expression
    ;

multiplicative_expression
    : right=factor
    | left=multiplicative_expression op=('/'|'*'|'modulo') right=factor
    ;

factor
    : literal
    | object_instantiation
    | op=('not'|'-') factor
    | type_cast
    | access
    ;

access
    : sub=subfactor
    | rec=access field_access
    | rec=access element_access
    | rec=access method_access
    ;

field_access
    : '.' id=identifier
    ;

element_access
    : '[' index=logic_expression ']'
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
    : LPAREN content=logic_expression RPAREN
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
    : type='robotDeath'
    | type='robotAttacked'
    | type='entityDeath'
    | type='chatMessage'
    | type=('stringMessageReceived'|'entityMessageReceived') LPAREN param=number_literal RPAREN
    ;

data_type
    : 'number'
    | 'bool'
    | 'coordinates'
    | 'string'
    | 'List' '<' childType=data_type '>'
    | 'Entity'
    | 'Item'
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
    : id=IDENTIFIER
    ;

end_of_line
    : NEWLINE
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
    : Digit+('.' Digit*)?
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
NEWLINE
    : NewLine
    ;
    
LPAREN
    : '('
    ;

RPAREN
    : ')'
    ;

/* Hidden stuff */

WHITESPACE
    : (' ' | '\t' | '\r')+ -> channel(HIDDEN)
    ;

LINECOMMENT
    : '//' ~[\r\n]* -> channel(HIDDEN)
    ;
grammar MyLang;

program
   	: (globalDeclaration | functionDeclaration)+
   	;

globalDeclaration
    : varDeclarationStatement
    ;

functionDeclaration
   	: 'fun' functionSignature block
	;

functionSignature
   	: Identifier '(' functionArguments? ')' ':' type
	;

functionArguments
   	: functionArg (',' functionArg)*
   	;

functionArg
   	: Identifier ':' nonVoidType
   	;

block
    : '{' statement* '}'
    ;

type
   	: nonVoidType
   	| voidType
	;

statement
    : nopStatement
    | block
    | varDeclarationStatement
    | assignmentStatement
    | ifStatement
    | ifElseStatement
    | forStatement
    | whileStatement
    | readStatement
    | writeStatement
    | returnStatement
    | functionCallStatement
    ;

assignmentStatement
    : assignment ';'
    ;

assignment
    : Identifier assignmentOP expr
    ;

ifStatement
    : 'if' '(' expr ')' block
    ;

ifElseStatement
    : 'if' '(' expr ')' thenBlock=block 'else' elseBlock=block
    ;

forStatement
    : 'for' '(' forInit? ';' forStopCondition? ';' forIteration? ')' block
    ;

forInit
    : assignment
    | varDeclaration
    ;

forStopCondition
    : expr
    ;

forIteration
    : assignment
    ;

whileStatement
    : 'while' '(' expr ')' block
    ;

readStatement
    : readCall ';'
    ;

readCall
    : name=('readInt'|'readBool') '(' ')'
    ;

writeStatement
    : name=('write'|'writeln') '(' expr ')' ';'
    ;

returnStatement
    : 'return' expr ';'
    ;

varDeclarationStatement
    : varDeclaration ';'
    ;

varDeclaration
   	: Identifier ':' nonVoidType ('=' expr)?
   	;

nopStatement
    : Nop ';'
    ;

nonVoidType
   	: 'int'
   	| 'bool'
	;

voidType
    : 'void'
    ;

expr
   	: '(' expr ')'
   	| intLiteral
   	| boolLiteral
   	| var
   	| unaryIntOp expr
   	| unaryBoolOp expr
   	| <assoc=left> left=expr divModMultOp right=expr
   	| <assoc=left> left=expr addSubOp right=expr
   	| <assoc=left> left=expr compOp right=expr
   	| <assoc=left> left=expr equalOp right=expr
   	| <assoc=left> left=expr boolAndOp right=expr
   	| <assoc=left> left=expr boolOrOp right=expr
   	| readCall
   	| functionCall
    ;

functionCallStatement
    : functionCall ';'
    ;

functionCall
    : Identifier '(' argumentList? ')'
    ;

argumentList
    : expr (',' expr)*
    ;

intLiteral
    : Z
    ;

boolLiteral
    : B
    ;

var
    : Identifier
    ;

unaryIntOp
    : '+'
    | '-'
    ;

unaryBoolOp
    : '!'
    ;


divModMultOp: '/'
            | '%'
            | '*'
            ;

addSubOp    : '+'
            | '-'
            ;

compOp      : '<'
            | '>'
            | '<='
            | '>='
            ;

equalOp     : '=='
            | '!='
            ;

boolAndOp   : '&&'
            ;

boolOrOp    : '||'
            ;

assignmentOP: '='
            | '+='
            | '-='
            | '*='
            | '/='
            | '%='
            ;

Identifier  : ID ;
Nop         : 'nop' ;

ID      : [a-zA-Z_][a-zA-Z0-9_]* ;
B       : 'true'
        | 'false'
        ;
Z       : '0'
        | [1-9][0-9]*
        ;

WS
    : [ \t\r\n\u000C]+ -> skip ;
COMMENT
    : '/*' .*? '*/' -> skip
    ;
LINE_COMMENT
    : '//' ~[\r\n]* -> skip
    ;
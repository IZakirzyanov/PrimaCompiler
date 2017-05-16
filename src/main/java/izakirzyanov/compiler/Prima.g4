grammar Prima;

program
   	: (globalVarDeclaration | functionDeclaration)+
   	;

globalVarDeclaration
    : varDeclarationStatement
    ;

functionDeclaration
   	: 'fun' functionSignature block
	;

functionSignature
   	: name=Identifier '(' functionArguments? ')' ':' type
	;

functionArguments
   	: functionArg (',' functionArg)*
   	;

functionArg
   	: name=Identifier ':' nonVoidType
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
    | whileStatement
    | writeStatement
    | returnStatement
    | functionCallStatement
    ;

assignmentStatement
    : assignment ';'
    ;

assignment
    : name=Identifier op=('='|'+='|'-='|'*='|'/='|'%='|'&='|'|=') expr
    ;

ifStatement
    : 'if' '(' condition=expr ')' thenBlock=block ('else' elseBlock=block)?
    ;

whileStatement
    : 'while' '(' condition=expr ')' body=block
    ;

readCall
    : name=('readInt'|'readBool') '(' ')'
    ;

writeStatement
    : (write='write'|writeln='writeln') '(' expr? ')' ';'
    ;

returnStatement
    : 'return' expr ';'
    ;

varDeclarationStatement
    : varDeclaration ';'
    ;

varDeclaration
   	: name=Identifier ':' nonVoidType ('=' expr)?
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
   	: '(' expr ')' # eXPRParenthesis
   	| intLiteral # eXPRLiteral
   	| boolLiteral # eXPRLiteral
   	| variableName # eXPRVarName
   	| op=('+'|'-') expr # eXPRUnary
   	| op='!' expr # eXPRUnary
   	| <assoc=left> left=expr op=('/'|'%'|'*') right=expr # eXPRBinary
   	| <assoc=left> left=expr op=('+'|'-') right=expr # eXPRBinary
   	| <assoc=left> left=expr op=('<'|'>'|'<='|'>=') right=expr # eXPRBinary
   	| <assoc=left> left=expr op=('=='|'!=') right=expr # eXPRBinary
   	| <assoc=left> left=expr op='&&' right=expr # eXPRBinary
   	| <assoc=left> left=expr op='||' right=expr # eXPRBinary
   	| readCall # eXPRReadCall
   	| functionCall # eXPRFunctionCall
    ;

functionCallStatement
    : functionCall ';'
    ;

functionCall
    : name=Identifier '(' argumentList? ')'
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

variableName
    : name=Identifier
    ;


Nop         : 'nop' ;

B       : 'true'
        | 'false'
        ;
Z       : '0'
        | [1-9][0-9]*
        ;

Identifier  : ID ;
ID      : [a-zA-Z_][a-zA-Z0-9_]* ;

WS
    : [ \t\r\n\u000C]+ -> skip ;
COMMENT
    : '/*' .*? '*/' -> skip
    ;
LINE_COMMENT
    : '//' ~[\r\n]* -> skip
    ;
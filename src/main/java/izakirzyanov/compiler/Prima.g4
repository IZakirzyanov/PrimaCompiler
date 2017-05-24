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
    | arraySetterStatement
    | assignmentStatement
    | ifStatement
    | whileStatement
    | forStatement
    | writeStatement
    | returnStatement
    | functionCallStatement
    ;

assignmentStatement
    : assignment ';'
    ;

assignment
    : name=Identifier '=' expr
    ;

arraySetterStatement
    : name=Identifier ('['indices+=expr']')+ '=' value=expr ';'
    ;

ifStatement
    : 'if' '(' condition=expr ')' thenBlock=block ('else' elseBlock=block)?
    ;

forStatement
   : 'for' '(' forInit? ';' forStopCondition=expr ';' forIteration? ')' body=block
   ;

forInit
   : assignment
   | varDeclaration
   ;

forIteration
   : assignment
   ;

whileStatement
    : 'while' '(' condition=expr ')' body=block
    ;

readCall
    : name=('readInt'|'readBool'|'readStr') '(' ')'
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
   	: 'var' name=Identifier ':' arrayType '=' arrayInitializer #arrayDeclaration
   	| 'var' name=Identifier ':' primitiveType '=' expr #primitiveDeclaration
   	;

arrayInitializer
	: primitiveType ('[' sizes+=expr ']')+
	;

nopStatement
    : Nop ';'
    ;

nonVoidType
	: primitiveType
   	| arrayType
	;

primitiveType
	: 'int'
    | 'bool'
    | 'str'
    ;

arrayType
	: primitiveType dims
	;

dims
	: ('['']')+
	;

voidType
    : 'void'
    ;

expr
   	: '(' expr ')' # eXPRParenthesis
   	| intLiteral # eXPRLiteral
   	| boolLiteral # eXPRLiteral
   	| stringLiteral # eXPRLiteral
   	| variableName # eXPRVarName
   	| arrayGetter # eXPRArrayGetter
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

arrayGetter
	: name=Identifier ('[' indices+=expr ']')+
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

stringLiteral
	: STRING
	;

variableName
    : name=Identifier
    ;


Nop     : 'nop' ;

B       : 'true'
        | 'false'
        ;
Z       : '0'
        | [1-9][0-9]*
        ;

STRING  : '"' ( '\\' [btnfr"'\\] | ~[\r\n\\"] )* '"'
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
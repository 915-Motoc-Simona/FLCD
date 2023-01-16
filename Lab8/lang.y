%{
#include <stdio.h>
#include <stdlib.h>

#define YYDEBUG 1
%}

%token ARRAY
%token OF
%token VAR
%token IF
%token WRITE
%token READINT
%token READSTRING
%token READCHAR
%token ELSE
%token WHILE
%token RETURN

%token IDENTIFIER
%token INTCONSTANT
%token STRINGCONSTANT
%token CHARCONSTANT

%token PLUS
%token MINUS
%token TIMES
%token DIV
%token MOD
%token EQ
%token BIGGER
%token BIGGEREQ
%token LESS
%token LESSEQ
%token EQQ
%token NEQ
%token AND
%token OR

%token SEMICOLON
%token OPEN_CURLY_BRACKET
%token CLOSE_CURLY_BRACKET
%token OPEN_ROUND_BRACKET
%token CLOSE_ROUND_BRACKET
%token OPEN_SQUARE_BRACKET
%token CLOSE_SQUARE_BRACKET
%token COMMA
%token INT
%token CHAR

%start program

%%

program : statementList ;
statementList : statement | statement statementList ;
statement : simpleStatement SEMICOLON | structStatement ;
simpleStatement : varDeclaration | arrayDeclaration | assignmentStatement | returnStatement | ioStatement ;
structStatement : compoundStatement | ifStatement | whileStatement ;
compoundStatement : OPEN_CURLY_BRACKET statementList CLOSE_CURLY_BRACKET ;
ifStatement : IF OPEN_ROUND_BRACKET condition CLOSE_ROUND_BRACKET compoundStatement | IF OPEN_ROUND_BRACKET condition CLOSE_ROUND_BRACKET compoundStatement ELSE compoundStatement ;
whileStatement : WHILE OPEN_ROUND_BRACKET condition CLOSE_ROUND_BRACKET compoundStatement ;
condition : expression relation expression additionalCondition ;
additionalCondition : /*Empty*/ | AND condition | OR condition ;
relation : BIGGER | BIGGEREQ | LESS | LESSEQ | EQQ | NEQ ;
expression : expression symbol_1 term | term ;
term : term symbol_2 factor | factor ;
factor: OPEN_ROUND_BRACKET expression CLOSE_ROUND_BRACKET | INTCONSTANT | STRINGCONSTANT | CHARCONSTANT | IDENTIFIER ;
symbol_1 : PLUS | MINUS ;
symbol_2: TIMES | DIV | MOD ;
expressionList : expression | expression COMMA expressionListTemp ;
expressionListTemp : /*Empty*/ | expressionList ;
varDeclaration : VAR identifierList ;
identifierList : IDENTIFIER | IDENTIFIER COMMA identifierListTemp ;
identifierListTemp : /*Empty*/ | identifierList ;
arrayDeclaration : ARRAY OPEN_SQUARE_BRACKET INTCONSTANT CLOSE_SQUARE_BRACKET identifierList OF type ;
type : INT | CHAR ;
assignmentStatement : IDENTIFIER EQ expression ;
returnStatement : RETURN expression ;
ioStatement : functionName OPEN_ROUND_BRACKET expressionList CLOSE_ROUND_BRACKET | functionName OPEN_ROUND_BRACKET CLOSE_ROUND_BRACKET ;
functionName : WRITE | READINT | READSTRING | READCHAR ;

%%
yyerror(char *s)
{
	printf("%s\n",s);
}

extern FILE *yyin;

main(int argc, char **argv)
{
	if(argc>1) yyin :  fopen(argv[1],"r");
	if(argc>2 && !strcmp(argv[2],"-d")) yydebug: 1;
	if(!yyparse()) fprintf(stderr, "\tO.K.\n");
}


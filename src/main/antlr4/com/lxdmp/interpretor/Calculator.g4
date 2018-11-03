grammar Calculator;
import CommonLexerRules; // 通用的词法规则

prog : stat+;

stat : expr NEWLINE
	|  ID '=' expr NEWLINE
	|  NEWLINE
	;

expr : expr ('*'|'/') expr 
	|  expr ('+'|'-') expr 
	|  FLOAT
	|  INT
	|  ID 
	| '(' expr ')'
	;


lexer grammar CommonLexerRules; // 通用的词法规则

ID: [a-zA-Z_][a-zA-Z_0-9]*; // 匹配标识符
INT : '-'?[0-9]+; // 匹配整数
FLOAT : '-'?[0-9]+'.'[0-9]+; // 匹配浮点数
NEWLINE : '\r'?'\n'; // 换行
WS : [ \t]+ -> skip; // 跳过空白符

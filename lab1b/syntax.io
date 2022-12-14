program = {statement}
statement = (varDeclaration | arrayDeclaration | assignmentStatament | ifStatement | whileStatement | returnStatement | ioStatement) ";"
varDeclaration = "var" identifiersList
identifiersList = identifier {"," identifier}
arrayDeclaration = "array" "[" constantIntPositive"]" identifiersList "of" type
type = "int" | "char" | "string"
assignmentStatement = identifier "=" expression
expression = intExpression | stringExpression | identifier
intExpression = constInt| intExpression ("+" | "-" | "*" | "/") intExpression 
stringExpression = constChar| constString| stringExpression + stringExpression
ifStatement = "if" "(" condition ")" "{" {statement} "}" ["else" "{" {statement} "}" ]
condition = expression relation expression
relation = "<" | "<=" | "==" | "!=" | ">=" ">"
whileStatement = "while" "(" condition ")" "{" {statement} "}"
returnStatement = "return" expression
ioStatement= "write" "(" expressionList ")" | ("readInt" | "readChar" | "readString") "(" ")"
expressionList = expression {"," expression}

grammar IfThen;
prog : conditional * ;
conditional : 'if' predicate 'then' action ;
predicate : measurement comp value ;
measurement: 'age' | 'height' | 'weight' ;
comp : '<' | '>' | '<=' | '>=' | '==' | '~=' ;
value : NON_NEGATIVE_NUMBER ;
action : 'accept' | 'reject' ;
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines

NON_NEGATIVE_NUMBER : [0-9]+ ;

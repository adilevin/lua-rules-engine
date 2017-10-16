grammar IfThen;
prog : conditional * ;
conditional : 'if' predicate 'then' action ;
predicate : measurement comp value ;
measurement: 'age' | 'height' | 'weight' ;
comp : '<' | '>' | '<=' | '>=' | '==' | '~=' ;
value : MY_NUMBER ;
action : 'accept' | 'reject' ;
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines

MY_NUMBER : '-'? [0-9]+ ;

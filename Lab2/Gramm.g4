grammar Gramm;

root : LETTER  '=' expr EOF
	  | LETTERVECTOR '=' expr EOF
      | expr EOF;

expr : '(' expr ')'
      |plusN
	  |mult
	  |'det('det')'
	  |plusM
	  |matrix
	  |vector;
	  
plusN: NUMBER '+' NUMBER;
mult:  vector '*' vector;
det: matrix
    |'('plusM')';
plusM: matrix '+' matrix;

matrix: '['vector (','vector)*']'
       | LETTER;
vector: '['NUMBER (','NUMBER)*']'
       | LETTERVECTOR;
NUMBER: [0-9]+;
LETTER: [A-Z];
LETTERVECTOR: [a-z];
WS: [ \t\n\r]+ -> skip ;
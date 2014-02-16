grammar Plus;

expr: INT
	| list
	;

list: '(' '+' expr expr ')'
	;

INT: [0-9]
	;

grammar Lisping;

file: expr*
	;

expr: atom 
	| collection
	;

atom: INT
	| STRING
	;

collection: list
	;

list: LIST_BEGIN expr* LIST_END
	;

INT: [1-9][0-9]* ;

STRING : '"' ( ~'"' | '\\' '"' )* '"' ;

LIST_BEGIN: '(' ;
LIST_END: ')' ;

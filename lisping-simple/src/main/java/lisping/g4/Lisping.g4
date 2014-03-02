grammar Lisping;

@parser::members {
	LispingInterpreter reader = new LispingInterpreter();
}

file : expr*
	;

expr : atom 
	| collection
	;

atom : 
	INT { reader.readInt($INT.text); }
	| 
	STRING { reader.readString($STRING.text); }
	;

collection
	@after { reader.completeCollection(); }
:
	list
	;

list
	@init { reader.newList(); }
	@after { reader.completeList(); }
: 
	LIST_BEGIN { System.out.println("LIST_BEGIN"); }
	expr? { reader.completeListHead(); }
	expr* 
	LIST_END { System.out.println("LIST_END"); }
	;

INT : '-'? [1-9] [0-9]* ;

STRING : '"' ( ~'"' | '\\' '"' )* '"' ;

LIST_BEGIN: '(' ;
LIST_END: ')' ;

WS : [ \t\r\n]+ -> skip ;

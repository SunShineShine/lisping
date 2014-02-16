grammar Plus;

@parser::header {
	import plus.PlusVm;
}

@parser::members {
	PlusVm vm = new PlusVm();
}

expr: INT
	{
		vm.read($INT.text);
	}
	| x = list
	;

list: LIST_BEGIN PLUS expr expr LIST_END
	{
		vm.plus();
	}
	;

INT: [0-9] ;
LIST_BEGIN: '(' ;
LIST_END: ')' ;
PLUS: '+' ;
WS: [ \t]+ -> skip ;
EOL: ( '\r' '\n' ? | '\n' ) -> skip ;

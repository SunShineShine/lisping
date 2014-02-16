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

list: '(' '+' expr expr ')'
	{
		vm.plus();
	}
	;

INT: [0-9]
	;

WS: [ \t\r\n]+ -> skip
	;

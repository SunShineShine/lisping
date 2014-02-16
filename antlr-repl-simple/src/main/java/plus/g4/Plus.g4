grammar Plus;

expr: INT
	{
		System.out.println("found expr int: " + $INT.text);
	}
	| x = list
	{
		System.out.println("found expr list: " + $x.text);
	}
	;

list: '(' '+' a = expr b = expr ')'
	{
		System.out.printf("found list: %s + %s\n", $a.text, $b.text);
	}
	;

INT: [0-9]
	;

WS: [ \t\r\n]+ -> skip
	;

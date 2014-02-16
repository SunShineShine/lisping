package plus;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import plus.g4.PlusLexer;
import plus.g4.PlusParser;

public class Plus {

	public static void main(String[] args) throws Exception {
		PlusLexer lexer = new PlusLexer(new ANTLRInputStream(System.in));
		PlusParser parser = new PlusParser(new CommonTokenStream(lexer));
		parser.expr();
	}

}

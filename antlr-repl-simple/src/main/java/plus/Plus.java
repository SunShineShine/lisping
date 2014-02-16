package plus;

import org.antlr.v4.runtime.CommonTokenFactory;
import org.antlr.v4.runtime.UnbufferedCharStream;

import plus.g4.PlusLexer;
import plus.g4.PlusParser;

public class Plus {

	public static void main(String[] args) throws Exception {
		PlusLexer lexer = new PlusLexer(new UnbufferedCharStream(System.in));
		CommonTokenFactory tokenFactory = new CommonTokenFactory(true);
		lexer.setTokenFactory(tokenFactory);
		PlusParser parser = new PlusParser(new InterpreterTokenStream(lexer));
		parser.expr();
	}

}

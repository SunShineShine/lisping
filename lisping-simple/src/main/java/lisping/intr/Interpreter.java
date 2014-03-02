package lisping.intr;

import lisping.g4.LispingLexer;
import lisping.g4.LispingParser;

import org.antlr.v4.runtime.CommonTokenFactory;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.UnbufferedCharStream;

public class Interpreter {

	public static void main(String[] args) {
		LispingLexer lexer = new LispingLexer(new UnbufferedCharStream(System.in));
		lexer.setTokenFactory(new CommonTokenFactory(true));
		LispingParser parser = new LispingParser(new CommonTokenStream(lexer));
		parser.file();
	}

}

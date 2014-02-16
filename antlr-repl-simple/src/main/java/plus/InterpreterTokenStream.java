package plus;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.UnbufferedTokenStream;

public class InterpreterTokenStream extends UnbufferedTokenStream<Token> {

	public InterpreterTokenStream(TokenSource tokenSource) {
		super(tokenSource);
	}

	@Override
	public void consume() {
		if (LA(1) == Token.EOF) {
			throw new IllegalStateException("cannot consume EOF");
		}

		// buf always has at least tokens[p==0] in this method due to ctor
		lastToken = tokens[p];   // track last token for LT(-1)

		// if we're at last token and no markers, opportunity to flush buffer
		if ( p == n-1 && numMarkers==0 ) {
			n = 0;
			p = -1; // p++ will leave this at 0
			lastTokenBufferStart = lastToken;
		}

		p++;
		currentTokenIndex++;
		// MARK: disable sync pre-read, make interpreter can execute line by line. 
//		sync(1);
	}

}

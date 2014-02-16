// Generated from Plus.g4 by ANTLR 4.1
package plus.g4;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PlusParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__2=1, T__1=2, T__0=3, INT=4, WS=5;
	public static final String[] tokenNames = {
		"<INVALID>", "')'", "'+'", "'('", "INT", "WS"
	};
	public static final int
		RULE_expr = 0, RULE_list = 1;
	public static final String[] ruleNames = {
		"expr", "list"
	};

	@Override
	public String getGrammarFileName() { return "Plus.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public PlusParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ExprContext extends ParserRuleContext {
		public Token INT;
		public ListContext x;
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public TerminalNode INT() { return getToken(PlusParser.INT, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusListener ) ((PlusListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusListener ) ((PlusListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_expr);
		try {
			setState(9);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(4); ((ExprContext)_localctx).INT = match(INT);

						System.out.println("found expr int: " + (((ExprContext)_localctx).INT!=null?((ExprContext)_localctx).INT.getText():null));
					
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 2);
				{
				setState(6); ((ExprContext)_localctx).x = list();

						System.out.println("found expr list: " + (((ExprContext)_localctx).x!=null?_input.getText(((ExprContext)_localctx).x.start,((ExprContext)_localctx).x.stop):null));
					
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListContext extends ParserRuleContext {
		public ExprContext a;
		public ExprContext b;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlusListener ) ((PlusListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlusListener ) ((PlusListener)listener).exitList(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(11); match(3);
			setState(12); match(2);
			setState(13); ((ListContext)_localctx).a = expr();
			setState(14); ((ListContext)_localctx).b = expr();
			setState(15); match(1);

					System.out.printf("found list: %s + %s\n", (((ListContext)_localctx).a!=null?_input.getText(((ListContext)_localctx).a.start,((ListContext)_localctx).a.stop):null), (((ListContext)_localctx).b!=null?_input.getText(((ListContext)_localctx).b.start,((ListContext)_localctx).b.stop):null));
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\7\25\4\2\t\2\4\3"+
		"\t\3\3\2\3\2\3\2\3\2\3\2\5\2\f\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\2\4"+
		"\2\4\2\2\23\2\13\3\2\2\2\4\r\3\2\2\2\6\7\7\6\2\2\7\f\b\2\1\2\b\t\5\4\3"+
		"\2\t\n\b\2\1\2\n\f\3\2\2\2\13\6\3\2\2\2\13\b\3\2\2\2\f\3\3\2\2\2\r\16"+
		"\7\5\2\2\16\17\7\4\2\2\17\20\5\2\2\2\20\21\5\2\2\2\21\22\7\3\2\2\22\23"+
		"\b\3\1\2\23\5\3\2\2\2\3\13";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
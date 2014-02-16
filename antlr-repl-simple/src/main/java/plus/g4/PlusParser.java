// Generated from Plus.g4 by ANTLR 4.1
package plus.g4;

	import plus.PlusVm;

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
		T__2=1, T__1=2, T__0=3, INT=4, WS=5, EOL=6;
	public static final String[] tokenNames = {
		"<INVALID>", "')'", "'+'", "'('", "INT", "WS", "EOL"
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


		PlusVm vm = new PlusVm();

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
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_expr);
		try {
			setState(7);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(4); ((ExprContext)_localctx).INT = match(INT);

						vm.read((((ExprContext)_localctx).INT!=null?((ExprContext)_localctx).INT.getText():null));
					
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 2);
				{
				setState(6); ((ExprContext)_localctx).x = list();
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
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(9); match(3);
			setState(10); match(2);
			setState(11); expr();
			setState(12); expr();
			setState(13); match(1);

					vm.plus();
				
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\b\23\4\2\t\2\4\3"+
		"\t\3\3\2\3\2\3\2\5\2\n\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\2\4\2\4\2\2"+
		"\21\2\t\3\2\2\2\4\13\3\2\2\2\6\7\7\6\2\2\7\n\b\2\1\2\b\n\5\4\3\2\t\6\3"+
		"\2\2\2\t\b\3\2\2\2\n\3\3\2\2\2\13\f\7\5\2\2\f\r\7\4\2\2\r\16\5\2\2\2\16"+
		"\17\5\2\2\2\17\20\7\3\2\2\20\21\b\3\1\2\21\5\3\2\2\2\3\t";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
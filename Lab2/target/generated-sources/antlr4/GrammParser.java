// Generated from Gramm.g4 by ANTLR 4.7
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		NUMBER=10, LETTER=11, LETTERVECTOR=12, WS=13;
	public static final int
		RULE_root = 0, RULE_expr = 1, RULE_plusN = 2, RULE_mult = 3, RULE_det = 4, 
		RULE_plusM = 5, RULE_matrix = 6, RULE_vector = 7;
	public static final String[] ruleNames = {
		"root", "expr", "plusN", "mult", "det", "plusM", "matrix", "vector"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "'('", "')'", "'det('", "'+'", "'*'", "'['", "','", "']'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "NUMBER", 
		"LETTER", "LETTERVECTOR", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Gramm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RootContext extends ParserRuleContext {
		public TerminalNode LETTER() { return getToken(GrammParser.LETTER, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode EOF() { return getToken(GrammParser.EOF, 0); }
		public TerminalNode LETTERVECTOR() { return getToken(GrammParser.LETTERVECTOR, 0); }
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammListener ) ((GrammListener)listener).enterRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammListener ) ((GrammListener)listener).exitRoot(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		try {
			setState(29);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(16);
				match(LETTER);
				setState(17);
				match(T__0);
				setState(18);
				expr();
				setState(19);
				match(EOF);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(21);
				match(LETTERVECTOR);
				setState(22);
				match(T__0);
				setState(23);
				expr();
				setState(24);
				match(EOF);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(26);
				expr();
				setState(27);
				match(EOF);
				}
				break;
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PlusNContext plusN() {
			return getRuleContext(PlusNContext.class,0);
		}
		public MultContext mult() {
			return getRuleContext(MultContext.class,0);
		}
		public DetContext det() {
			return getRuleContext(DetContext.class,0);
		}
		public PlusMContext plusM() {
			return getRuleContext(PlusMContext.class,0);
		}
		public MatrixContext matrix() {
			return getRuleContext(MatrixContext.class,0);
		}
		public VectorContext vector() {
			return getRuleContext(VectorContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammListener ) ((GrammListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammListener ) ((GrammListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expr);
		try {
			setState(44);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(31);
				match(T__1);
				setState(32);
				expr();
				setState(33);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(35);
				plusN();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(36);
				mult();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(37);
				match(T__3);
				setState(38);
				det();
				setState(39);
				match(T__2);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(41);
				plusM();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(42);
				matrix();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(43);
				vector();
				}
				break;
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

	public static class PlusNContext extends ParserRuleContext {
		public List<TerminalNode> NUMBER() { return getTokens(GrammParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(GrammParser.NUMBER, i);
		}
		public PlusNContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plusN; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammListener ) ((GrammListener)listener).enterPlusN(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammListener ) ((GrammListener)listener).exitPlusN(this);
		}
	}

	public final PlusNContext plusN() throws RecognitionException {
		PlusNContext _localctx = new PlusNContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_plusN);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(NUMBER);
			setState(47);
			match(T__4);
			setState(48);
			match(NUMBER);
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

	public static class MultContext extends ParserRuleContext {
		public List<VectorContext> vector() {
			return getRuleContexts(VectorContext.class);
		}
		public VectorContext vector(int i) {
			return getRuleContext(VectorContext.class,i);
		}
		public MultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mult; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammListener ) ((GrammListener)listener).enterMult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammListener ) ((GrammListener)listener).exitMult(this);
		}
	}

	public final MultContext mult() throws RecognitionException {
		MultContext _localctx = new MultContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_mult);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			vector();
			setState(51);
			match(T__5);
			setState(52);
			vector();
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

	public static class DetContext extends ParserRuleContext {
		public MatrixContext matrix() {
			return getRuleContext(MatrixContext.class,0);
		}
		public PlusMContext plusM() {
			return getRuleContext(PlusMContext.class,0);
		}
		public DetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_det; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammListener ) ((GrammListener)listener).enterDet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammListener ) ((GrammListener)listener).exitDet(this);
		}
	}

	public final DetContext det() throws RecognitionException {
		DetContext _localctx = new DetContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_det);
		try {
			setState(59);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
			case LETTER:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				matrix();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				match(T__1);
				setState(56);
				plusM();
				setState(57);
				match(T__2);
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

	public static class PlusMContext extends ParserRuleContext {
		public List<MatrixContext> matrix() {
			return getRuleContexts(MatrixContext.class);
		}
		public MatrixContext matrix(int i) {
			return getRuleContext(MatrixContext.class,i);
		}
		public PlusMContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plusM; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammListener ) ((GrammListener)listener).enterPlusM(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammListener ) ((GrammListener)listener).exitPlusM(this);
		}
	}

	public final PlusMContext plusM() throws RecognitionException {
		PlusMContext _localctx = new PlusMContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_plusM);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			matrix();
			setState(62);
			match(T__4);
			setState(63);
			matrix();
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

	public static class MatrixContext extends ParserRuleContext {
		public List<VectorContext> vector() {
			return getRuleContexts(VectorContext.class);
		}
		public VectorContext vector(int i) {
			return getRuleContext(VectorContext.class,i);
		}
		public TerminalNode LETTER() { return getToken(GrammParser.LETTER, 0); }
		public MatrixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matrix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammListener ) ((GrammListener)listener).enterMatrix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammListener ) ((GrammListener)listener).exitMatrix(this);
		}
	}

	public final MatrixContext matrix() throws RecognitionException {
		MatrixContext _localctx = new MatrixContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_matrix);
		int _la;
		try {
			setState(77);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				match(T__6);
				setState(66);
				vector();
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(67);
					match(T__7);
					setState(68);
					vector();
					}
					}
					setState(73);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(74);
				match(T__8);
				}
				break;
			case LETTER:
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				match(LETTER);
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

	public static class VectorContext extends ParserRuleContext {
		public List<TerminalNode> NUMBER() { return getTokens(GrammParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(GrammParser.NUMBER, i);
		}
		public TerminalNode LETTERVECTOR() { return getToken(GrammParser.LETTERVECTOR, 0); }
		public VectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammListener ) ((GrammListener)listener).enterVector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammListener ) ((GrammListener)listener).exitVector(this);
		}
	}

	public final VectorContext vector() throws RecognitionException {
		VectorContext _localctx = new VectorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_vector);
		int _la;
		try {
			setState(90);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				match(T__6);
				setState(80);
				match(NUMBER);
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(81);
					match(T__7);
					setState(82);
					match(NUMBER);
					}
					}
					setState(87);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(88);
				match(T__8);
				}
				break;
			case LETTERVECTOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				match(LETTERVECTOR);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\17_\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2 \n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\5\3/\n\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\6\5\6>\n\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\7\bH\n\b\f\b"+
		"\16\bK\13\b\3\b\3\b\3\b\5\bP\n\b\3\t\3\t\3\t\3\t\7\tV\n\t\f\t\16\tY\13"+
		"\t\3\t\3\t\5\t]\n\t\3\t\2\2\n\2\4\6\b\n\f\16\20\2\2\2c\2\37\3\2\2\2\4"+
		".\3\2\2\2\6\60\3\2\2\2\b\64\3\2\2\2\n=\3\2\2\2\f?\3\2\2\2\16O\3\2\2\2"+
		"\20\\\3\2\2\2\22\23\7\r\2\2\23\24\7\3\2\2\24\25\5\4\3\2\25\26\7\2\2\3"+
		"\26 \3\2\2\2\27\30\7\16\2\2\30\31\7\3\2\2\31\32\5\4\3\2\32\33\7\2\2\3"+
		"\33 \3\2\2\2\34\35\5\4\3\2\35\36\7\2\2\3\36 \3\2\2\2\37\22\3\2\2\2\37"+
		"\27\3\2\2\2\37\34\3\2\2\2 \3\3\2\2\2!\"\7\4\2\2\"#\5\4\3\2#$\7\5\2\2$"+
		"/\3\2\2\2%/\5\6\4\2&/\5\b\5\2\'(\7\6\2\2()\5\n\6\2)*\7\5\2\2*/\3\2\2\2"+
		"+/\5\f\7\2,/\5\16\b\2-/\5\20\t\2.!\3\2\2\2.%\3\2\2\2.&\3\2\2\2.\'\3\2"+
		"\2\2.+\3\2\2\2.,\3\2\2\2.-\3\2\2\2/\5\3\2\2\2\60\61\7\f\2\2\61\62\7\7"+
		"\2\2\62\63\7\f\2\2\63\7\3\2\2\2\64\65\5\20\t\2\65\66\7\b\2\2\66\67\5\20"+
		"\t\2\67\t\3\2\2\28>\5\16\b\29:\7\4\2\2:;\5\f\7\2;<\7\5\2\2<>\3\2\2\2="+
		"8\3\2\2\2=9\3\2\2\2>\13\3\2\2\2?@\5\16\b\2@A\7\7\2\2AB\5\16\b\2B\r\3\2"+
		"\2\2CD\7\t\2\2DI\5\20\t\2EF\7\n\2\2FH\5\20\t\2GE\3\2\2\2HK\3\2\2\2IG\3"+
		"\2\2\2IJ\3\2\2\2JL\3\2\2\2KI\3\2\2\2LM\7\13\2\2MP\3\2\2\2NP\7\r\2\2OC"+
		"\3\2\2\2ON\3\2\2\2P\17\3\2\2\2QR\7\t\2\2RW\7\f\2\2ST\7\n\2\2TV\7\f\2\2"+
		"US\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2XZ\3\2\2\2YW\3\2\2\2Z]\7\13\2"+
		"\2[]\7\16\2\2\\Q\3\2\2\2\\[\3\2\2\2]\21\3\2\2\2\t\37.=IOW\\";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
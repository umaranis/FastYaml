// Generated from YamlParser.g4 by ANTLR 4.7.2
package com.fastyaml;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class YamlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INDENT=1, DEDENT=2, NEWLINE=3, BYTES_LITERAL=4, DECIMAL_INTEGER=5, OCT_INTEGER=6, 
		HEX_INTEGER=7, BIN_INTEGER=8, FLOAT_NUMBER=9, IMAG_NUMBER=10, MINUS=11, 
		DOCUMENTSTART=12, DOCUMENTEND=13, AMPERSAND=14, STAR=15, OPEN_PAREN=16, 
		CLOSE_PAREN=17, COMMA=18, COLON=19, OPEN_BRACK=20, CLOSE_BRACK=21, OPEN_BRACE=22, 
		CLOSE_BRACE=23, LITERIAL_STR_IND=24, FOLD_STR_IND=25, DOUBLE_QUOTE=26, 
		ANCHOR=27, ALIAS=28, STRING_MY=29, SKIP1=30, UNKNOWN_CHAR=31, SKIP2=32, 
		NEWLINE_STR_LITERAL=33, NEWLINE_STR_QUOTE=34;
	public static final int
		RULE_file = 0, RULE_document = 1, RULE_list = 2, RULE_listitem = 3, RULE_mappinglist = 4, 
		RULE_key = 5, RULE_value = 6, RULE_value_scalar = 7, RULE_multiline_string = 8, 
		RULE_string_literal = 9, RULE_string_folded = 10, RULE_string_double_quoted = 11, 
		RULE_mapping = 12, RULE_flowlist = 13, RULE_flowmappinglist = 14, RULE_number = 15, 
		RULE_integer = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "document", "list", "listitem", "mappinglist", "key", "value", 
			"value_scalar", "multiline_string", "string_literal", "string_folded", 
			"string_double_quoted", "mapping", "flowlist", "flowmappinglist", "number", 
			"integer"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "'-'", 
			null, null, "'&'", "'*'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INDENT", "DEDENT", "NEWLINE", "BYTES_LITERAL", "DECIMAL_INTEGER", 
			"OCT_INTEGER", "HEX_INTEGER", "BIN_INTEGER", "FLOAT_NUMBER", "IMAG_NUMBER", 
			"MINUS", "DOCUMENTSTART", "DOCUMENTEND", "AMPERSAND", "STAR", "OPEN_PAREN", 
			"CLOSE_PAREN", "COMMA", "COLON", "OPEN_BRACK", "CLOSE_BRACK", "OPEN_BRACE", 
			"CLOSE_BRACE", "LITERIAL_STR_IND", "FOLD_STR_IND", "DOUBLE_QUOTE", "ANCHOR", 
			"ALIAS", "STRING_MY", "SKIP1", "UNKNOWN_CHAR", "SKIP2", "NEWLINE_STR_LITERAL", 
			"NEWLINE_STR_QUOTE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "YamlParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public YamlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class FileContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(YamlParser.EOF, 0); }
		public List<DocumentContext> document() {
			return getRuleContexts(DocumentContext.class);
		}
		public DocumentContext document(int i) {
			return getRuleContext(DocumentContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(YamlParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(YamlParser.NEWLINE, i);
		}
		public List<TerminalNode> DOCUMENTSTART() { return getTokens(YamlParser.DOCUMENTSTART); }
		public TerminalNode DOCUMENTSTART(int i) {
			return getToken(YamlParser.DOCUMENTSTART, i);
		}
		public List<TerminalNode> DOCUMENTEND() { return getTokens(YamlParser.DOCUMENTEND); }
		public TerminalNode DOCUMENTEND(int i) {
			return getToken(YamlParser.DOCUMENTEND, i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YamlParserListener ) ((YamlParserListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YamlParserListener ) ((YamlParserListener)listener).exitFile(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(34);
					match(NEWLINE);
					}
					} 
				}
				setState(39);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			{
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOCUMENTSTART) {
				{
				setState(40);
				match(DOCUMENTSTART);
				setState(42);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(41);
					match(NEWLINE);
					}
					break;
				}
				}
			}

			setState(46);
			document();
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOCUMENTEND) {
				{
				setState(47);
				match(DOCUMENTEND);
				setState(48);
				match(NEWLINE);
				}
			}

			setState(69);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(54);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NEWLINE) {
						{
						{
						setState(51);
						match(NEWLINE);
						}
						}
						setState(56);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					{
					setState(57);
					match(DOCUMENTSTART);
					setState(58);
					match(NEWLINE);
					}
					setState(60);
					document();
					setState(65);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==DOCUMENTEND) {
						{
						setState(61);
						match(DOCUMENTEND);
						setState(63);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
						case 1:
							{
							setState(62);
							match(NEWLINE);
							}
							break;
						}
						}
					}

					}
					} 
				}
				setState(71);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(72);
				match(NEWLINE);
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(78);
			match(EOF);
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

	public static class DocumentContext extends ParserRuleContext {
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public MappinglistContext mappinglist() {
			return getRuleContext(MappinglistContext.class,0);
		}
		public FlowlistContext flowlist() {
			return getRuleContext(FlowlistContext.class,0);
		}
		public FlowmappinglistContext flowmappinglist() {
			return getRuleContext(FlowmappinglistContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public DocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_document; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YamlParserListener ) ((YamlParserListener)listener).enterDocument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YamlParserListener ) ((YamlParserListener)listener).exitDocument(this);
		}
	}

	public final DocumentContext document() throws RecognitionException {
		DocumentContext _localctx = new DocumentContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_document);
		try {
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				list();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				mappinglist();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(82);
				flowlist();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(83);
				flowmappinglist();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(84);
				value();
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

	public static class ListContext extends ParserRuleContext {
		public List<ListitemContext> listitem() {
			return getRuleContexts(ListitemContext.class);
		}
		public ListitemContext listitem(int i) {
			return getRuleContext(ListitemContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(YamlParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(YamlParser.NEWLINE, i);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YamlParserListener ) ((YamlParserListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YamlParserListener ) ((YamlParserListener)listener).exitList(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_list);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(97); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(90);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NEWLINE) {
						{
						{
						setState(87);
						match(NEWLINE);
						}
						}
						setState(92);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(93);
					listitem();
					setState(95);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						setState(94);
						match(NEWLINE);
						}
						break;
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(99); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class ListitemContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(YamlParser.MINUS, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode INDENT() { return getToken(YamlParser.INDENT, 0); }
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public TerminalNode DEDENT() { return getToken(YamlParser.DEDENT, 0); }
		public MappinglistContext mappinglist() {
			return getRuleContext(MappinglistContext.class,0);
		}
		public FlowlistContext flowlist() {
			return getRuleContext(FlowlistContext.class,0);
		}
		public TerminalNode ANCHOR() { return getToken(YamlParser.ANCHOR, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(YamlParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(YamlParser.NEWLINE, i);
		}
		public TerminalNode ALIAS() { return getToken(YamlParser.ALIAS, 0); }
		public ListitemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listitem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YamlParserListener ) ((YamlParserListener)listener).enterListitem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YamlParserListener ) ((YamlParserListener)listener).exitListitem(this);
		}
	}

	public final ListitemContext listitem() throws RecognitionException {
		ListitemContext _localctx = new ListitemContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_listitem);
		int _la;
		try {
			setState(131);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				match(MINUS);
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ANCHOR) {
					{
					setState(102);
					match(ANCHOR);
					}
				}

				setState(125);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(105);
					value();
					}
					break;
				case 2:
					{
					setState(107); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(106);
						match(NEWLINE);
						}
						}
						setState(109); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					setState(111);
					match(INDENT);
					setState(112);
					list();
					setState(113);
					match(DEDENT);
					}
					break;
				case 3:
					{
					setState(116); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(115);
						match(NEWLINE);
						}
						}
						setState(118); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					setState(120);
					match(INDENT);
					setState(121);
					mappinglist();
					setState(122);
					match(DEDENT);
					}
					break;
				case 4:
					{
					setState(124);
					flowlist();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				match(MINUS);
				setState(128);
				match(ALIAS);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(129);
				match(MINUS);
				setState(130);
				match(NEWLINE);
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

	public static class MappinglistContext extends ParserRuleContext {
		public List<MappingContext> mapping() {
			return getRuleContexts(MappingContext.class);
		}
		public MappingContext mapping(int i) {
			return getRuleContext(MappingContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(YamlParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(YamlParser.NEWLINE, i);
		}
		public MappinglistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mappinglist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YamlParserListener ) ((YamlParserListener)listener).enterMappinglist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YamlParserListener ) ((YamlParserListener)listener).exitMappinglist(this);
		}
	}

	public final MappinglistContext mappinglist() throws RecognitionException {
		MappinglistContext _localctx = new MappinglistContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_mappinglist);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(143); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(136);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NEWLINE) {
						{
						{
						setState(133);
						match(NEWLINE);
						}
						}
						setState(138);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(139);
					mapping();
					setState(141);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						setState(140);
						match(NEWLINE);
						}
						break;
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(145); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class KeyContext extends ParserRuleContext {
		public TerminalNode STRING_MY() { return getToken(YamlParser.STRING_MY, 0); }
		public KeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_key; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YamlParserListener ) ((YamlParserListener)listener).enterKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YamlParserListener ) ((YamlParserListener)listener).exitKey(this);
		}
	}

	public final KeyContext key() throws RecognitionException {
		KeyContext _localctx = new KeyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_key);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(STRING_MY);
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

	public static class ValueContext extends ParserRuleContext {
		public Value_scalarContext value_scalar() {
			return getRuleContext(Value_scalarContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(YamlParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(YamlParser.NEWLINE, i);
		}
		public TerminalNode INDENT() { return getToken(YamlParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(YamlParser.DEDENT, 0); }
		public Multiline_stringContext multiline_string() {
			return getRuleContext(Multiline_stringContext.class,0);
		}
		public String_literalContext string_literal() {
			return getRuleContext(String_literalContext.class,0);
		}
		public String_foldedContext string_folded() {
			return getRuleContext(String_foldedContext.class,0);
		}
		public String_double_quotedContext string_double_quoted() {
			return getRuleContext(String_double_quotedContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YamlParserListener ) ((YamlParserListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YamlParserListener ) ((YamlParserListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_value);
		try {
			setState(160);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(149);
				value_scalar();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				match(NEWLINE);
				setState(151);
				match(INDENT);
				setState(152);
				value_scalar();
				setState(153);
				match(NEWLINE);
				setState(154);
				match(DEDENT);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(156);
				multiline_string();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(157);
				string_literal();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(158);
				string_folded();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(159);
				string_double_quoted();
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

	public static class Value_scalarContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TerminalNode STRING_MY() { return getToken(YamlParser.STRING_MY, 0); }
		public Value_scalarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_scalar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YamlParserListener ) ((YamlParserListener)listener).enterValue_scalar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YamlParserListener ) ((YamlParserListener)listener).exitValue_scalar(this);
		}
	}

	public final Value_scalarContext value_scalar() throws RecognitionException {
		Value_scalarContext _localctx = new Value_scalarContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_value_scalar);
		try {
			setState(164);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DECIMAL_INTEGER:
			case OCT_INTEGER:
			case HEX_INTEGER:
			case BIN_INTEGER:
			case FLOAT_NUMBER:
			case IMAG_NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				number();
				}
				break;
			case STRING_MY:
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				match(STRING_MY);
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

	public static class Multiline_stringContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(YamlParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(YamlParser.NEWLINE, i);
		}
		public TerminalNode INDENT() { return getToken(YamlParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(YamlParser.DEDENT, 0); }
		public List<Value_scalarContext> value_scalar() {
			return getRuleContexts(Value_scalarContext.class);
		}
		public Value_scalarContext value_scalar(int i) {
			return getRuleContext(Value_scalarContext.class,i);
		}
		public List<Multiline_stringContext> multiline_string() {
			return getRuleContexts(Multiline_stringContext.class);
		}
		public Multiline_stringContext multiline_string(int i) {
			return getRuleContext(Multiline_stringContext.class,i);
		}
		public Multiline_stringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiline_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YamlParserListener ) ((YamlParserListener)listener).enterMultiline_string(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YamlParserListener ) ((YamlParserListener)listener).exitMultiline_string(this);
		}
	}

	public final Multiline_stringContext multiline_string() throws RecognitionException {
		Multiline_stringContext _localctx = new Multiline_stringContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_multiline_string);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DECIMAL_INTEGER) | (1L << OCT_INTEGER) | (1L << HEX_INTEGER) | (1L << BIN_INTEGER) | (1L << FLOAT_NUMBER) | (1L << IMAG_NUMBER) | (1L << STRING_MY))) != 0)) {
				{
				setState(166);
				value_scalar();
				}
			}

			setState(169);
			match(NEWLINE);
			setState(170);
			match(INDENT);
			setState(180); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(180);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
					case 1:
						{
						setState(171);
						value_scalar();
						setState(176);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(172);
								match(NEWLINE);
								setState(173);
								value_scalar();
								}
								} 
							}
							setState(178);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
						}
						}
						break;
					case 2:
						{
						setState(179);
						multiline_string();
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(182); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(184);
				match(NEWLINE);
				}
			}

			setState(187);
			match(DEDENT);
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

	public static class String_literalContext extends ParserRuleContext {
		public TerminalNode LITERIAL_STR_IND() { return getToken(YamlParser.LITERIAL_STR_IND, 0); }
		public List<TerminalNode> STRING_MY() { return getTokens(YamlParser.STRING_MY); }
		public TerminalNode STRING_MY(int i) {
			return getToken(YamlParser.STRING_MY, i);
		}
		public List<TerminalNode> NEWLINE_STR_LITERAL() { return getTokens(YamlParser.NEWLINE_STR_LITERAL); }
		public TerminalNode NEWLINE_STR_LITERAL(int i) {
			return getToken(YamlParser.NEWLINE_STR_LITERAL, i);
		}
		public String_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YamlParserListener ) ((YamlParserListener)listener).enterString_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YamlParserListener ) ((YamlParserListener)listener).exitString_literal(this);
		}
	}

	public final String_literalContext string_literal() throws RecognitionException {
		String_literalContext _localctx = new String_literalContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_string_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			match(LITERIAL_STR_IND);
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE_STR_LITERAL) {
				{
				{
				setState(191); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(190);
					match(NEWLINE_STR_LITERAL);
					}
					}
					setState(193); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE_STR_LITERAL );
				setState(195);
				match(STRING_MY);
				}
				}
				setState(200);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class String_foldedContext extends ParserRuleContext {
		public TerminalNode FOLD_STR_IND() { return getToken(YamlParser.FOLD_STR_IND, 0); }
		public List<TerminalNode> STRING_MY() { return getTokens(YamlParser.STRING_MY); }
		public TerminalNode STRING_MY(int i) {
			return getToken(YamlParser.STRING_MY, i);
		}
		public List<TerminalNode> NEWLINE_STR_LITERAL() { return getTokens(YamlParser.NEWLINE_STR_LITERAL); }
		public TerminalNode NEWLINE_STR_LITERAL(int i) {
			return getToken(YamlParser.NEWLINE_STR_LITERAL, i);
		}
		public String_foldedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_folded; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YamlParserListener ) ((YamlParserListener)listener).enterString_folded(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YamlParserListener ) ((YamlParserListener)listener).exitString_folded(this);
		}
	}

	public final String_foldedContext string_folded() throws RecognitionException {
		String_foldedContext _localctx = new String_foldedContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_string_folded);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			match(FOLD_STR_IND);
			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE_STR_LITERAL) {
				{
				{
				setState(203); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(202);
					match(NEWLINE_STR_LITERAL);
					}
					}
					setState(205); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE_STR_LITERAL );
				setState(207);
				match(STRING_MY);
				}
				}
				setState(212);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class String_double_quotedContext extends ParserRuleContext {
		public List<TerminalNode> DOUBLE_QUOTE() { return getTokens(YamlParser.DOUBLE_QUOTE); }
		public TerminalNode DOUBLE_QUOTE(int i) {
			return getToken(YamlParser.DOUBLE_QUOTE, i);
		}
		public List<TerminalNode> STRING_MY() { return getTokens(YamlParser.STRING_MY); }
		public TerminalNode STRING_MY(int i) {
			return getToken(YamlParser.STRING_MY, i);
		}
		public List<TerminalNode> NEWLINE_STR_QUOTE() { return getTokens(YamlParser.NEWLINE_STR_QUOTE); }
		public TerminalNode NEWLINE_STR_QUOTE(int i) {
			return getToken(YamlParser.NEWLINE_STR_QUOTE, i);
		}
		public String_double_quotedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_double_quoted; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YamlParserListener ) ((YamlParserListener)listener).enterString_double_quoted(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YamlParserListener ) ((YamlParserListener)listener).exitString_double_quoted(this);
		}
	}

	public final String_double_quotedContext string_double_quoted() throws RecognitionException {
		String_double_quotedContext _localctx = new String_double_quotedContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_string_double_quoted);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(DOUBLE_QUOTE);
			setState(214);
			match(STRING_MY);
			setState(223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE_STR_QUOTE) {
				{
				{
				setState(216); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(215);
					match(NEWLINE_STR_QUOTE);
					}
					}
					setState(218); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE_STR_QUOTE );
				setState(220);
				match(STRING_MY);
				}
				}
				setState(225);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(226);
			match(DOUBLE_QUOTE);
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

	public static class MappingContext extends ParserRuleContext {
		public KeyContext key() {
			return getRuleContext(KeyContext.class,0);
		}
		public TerminalNode COLON() { return getToken(YamlParser.COLON, 0); }
		public TerminalNode INDENT() { return getToken(YamlParser.INDENT, 0); }
		public MappinglistContext mappinglist() {
			return getRuleContext(MappinglistContext.class,0);
		}
		public TerminalNode DEDENT() { return getToken(YamlParser.DEDENT, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(YamlParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(YamlParser.NEWLINE, i);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public FlowmappinglistContext flowmappinglist() {
			return getRuleContext(FlowmappinglistContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public MappingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapping; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YamlParserListener ) ((YamlParserListener)listener).enterMapping(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YamlParserListener ) ((YamlParserListener)listener).exitMapping(this);
		}
	}

	public final MappingContext mapping() throws RecognitionException {
		MappingContext _localctx = new MappingContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_mapping);
		int _la;
		try {
			setState(259);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(228);
				key();
				setState(229);
				match(COLON);
				setState(231); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(230);
					match(NEWLINE);
					}
					}
					setState(233); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(235);
				match(INDENT);
				setState(236);
				mappinglist();
				setState(237);
				match(DEDENT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(239);
				key();
				setState(240);
				match(COLON);
				setState(242); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(241);
					match(NEWLINE);
					}
					}
					setState(244); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(246);
				match(INDENT);
				setState(247);
				list();
				setState(248);
				match(DEDENT);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(250);
				key();
				setState(251);
				match(COLON);
				setState(252);
				flowmappinglist();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(254);
				key();
				setState(255);
				match(COLON);
				setState(257);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
				case 1:
					{
					setState(256);
					value();
					}
					break;
				}
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

	public static class FlowlistContext extends ParserRuleContext {
		public TerminalNode OPEN_BRACK() { return getToken(YamlParser.OPEN_BRACK, 0); }
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public TerminalNode CLOSE_BRACK() { return getToken(YamlParser.CLOSE_BRACK, 0); }
		public List<TerminalNode> COMMA() { return getTokens(YamlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(YamlParser.COMMA, i);
		}
		public FlowlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flowlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YamlParserListener ) ((YamlParserListener)listener).enterFlowlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YamlParserListener ) ((YamlParserListener)listener).exitFlowlist(this);
		}
	}

	public final FlowlistContext flowlist() throws RecognitionException {
		FlowlistContext _localctx = new FlowlistContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_flowlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			match(OPEN_BRACK);
			setState(262);
			value();
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(263);
				match(COMMA);
				setState(264);
				value();
				}
				}
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(270);
			match(CLOSE_BRACK);
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

	public static class FlowmappinglistContext extends ParserRuleContext {
		public TerminalNode OPEN_BRACE() { return getToken(YamlParser.OPEN_BRACE, 0); }
		public List<MappingContext> mapping() {
			return getRuleContexts(MappingContext.class);
		}
		public MappingContext mapping(int i) {
			return getRuleContext(MappingContext.class,i);
		}
		public TerminalNode CLOSE_BRACE() { return getToken(YamlParser.CLOSE_BRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(YamlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(YamlParser.COMMA, i);
		}
		public FlowmappinglistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flowmappinglist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YamlParserListener ) ((YamlParserListener)listener).enterFlowmappinglist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YamlParserListener ) ((YamlParserListener)listener).exitFlowmappinglist(this);
		}
	}

	public final FlowmappinglistContext flowmappinglist() throws RecognitionException {
		FlowmappinglistContext _localctx = new FlowmappinglistContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_flowmappinglist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			match(OPEN_BRACE);
			setState(273);
			mapping();
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(274);
				match(COMMA);
				setState(275);
				mapping();
				}
				}
				setState(280);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(281);
			match(CLOSE_BRACE);
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

	public static class NumberContext extends ParserRuleContext {
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public TerminalNode FLOAT_NUMBER() { return getToken(YamlParser.FLOAT_NUMBER, 0); }
		public TerminalNode IMAG_NUMBER() { return getToken(YamlParser.IMAG_NUMBER, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YamlParserListener ) ((YamlParserListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YamlParserListener ) ((YamlParserListener)listener).exitNumber(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_number);
		try {
			setState(286);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DECIMAL_INTEGER:
			case OCT_INTEGER:
			case HEX_INTEGER:
			case BIN_INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(283);
				integer();
				}
				break;
			case FLOAT_NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(284);
				match(FLOAT_NUMBER);
				}
				break;
			case IMAG_NUMBER:
				enterOuterAlt(_localctx, 3);
				{
				setState(285);
				match(IMAG_NUMBER);
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

	public static class IntegerContext extends ParserRuleContext {
		public TerminalNode DECIMAL_INTEGER() { return getToken(YamlParser.DECIMAL_INTEGER, 0); }
		public TerminalNode OCT_INTEGER() { return getToken(YamlParser.OCT_INTEGER, 0); }
		public TerminalNode HEX_INTEGER() { return getToken(YamlParser.HEX_INTEGER, 0); }
		public TerminalNode BIN_INTEGER() { return getToken(YamlParser.BIN_INTEGER, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YamlParserListener ) ((YamlParserListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YamlParserListener ) ((YamlParserListener)listener).exitInteger(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DECIMAL_INTEGER) | (1L << OCT_INTEGER) | (1L << HEX_INTEGER) | (1L << BIN_INTEGER))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3$\u0125\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\7\2&\n\2\f\2\16\2)\13\2\3\2\3\2\5\2-\n\2\5\2/\n\2\3\2\3\2\3\2\5\2"+
		"\64\n\2\3\2\7\2\67\n\2\f\2\16\2:\13\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2B\n\2"+
		"\5\2D\n\2\7\2F\n\2\f\2\16\2I\13\2\3\2\7\2L\n\2\f\2\16\2O\13\2\3\2\3\2"+
		"\3\3\3\3\3\3\3\3\3\3\5\3X\n\3\3\4\7\4[\n\4\f\4\16\4^\13\4\3\4\3\4\5\4"+
		"b\n\4\6\4d\n\4\r\4\16\4e\3\5\3\5\5\5j\n\5\3\5\3\5\6\5n\n\5\r\5\16\5o\3"+
		"\5\3\5\3\5\3\5\3\5\6\5w\n\5\r\5\16\5x\3\5\3\5\3\5\3\5\3\5\5\5\u0080\n"+
		"\5\3\5\3\5\3\5\3\5\5\5\u0086\n\5\3\6\7\6\u0089\n\6\f\6\16\6\u008c\13\6"+
		"\3\6\3\6\5\6\u0090\n\6\6\6\u0092\n\6\r\6\16\6\u0093\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00a3\n\b\3\t\3\t\5\t\u00a7\n\t"+
		"\3\n\5\n\u00aa\n\n\3\n\3\n\3\n\3\n\3\n\7\n\u00b1\n\n\f\n\16\n\u00b4\13"+
		"\n\3\n\6\n\u00b7\n\n\r\n\16\n\u00b8\3\n\5\n\u00bc\n\n\3\n\3\n\3\13\3\13"+
		"\6\13\u00c2\n\13\r\13\16\13\u00c3\3\13\7\13\u00c7\n\13\f\13\16\13\u00ca"+
		"\13\13\3\f\3\f\6\f\u00ce\n\f\r\f\16\f\u00cf\3\f\7\f\u00d3\n\f\f\f\16\f"+
		"\u00d6\13\f\3\r\3\r\3\r\6\r\u00db\n\r\r\r\16\r\u00dc\3\r\7\r\u00e0\n\r"+
		"\f\r\16\r\u00e3\13\r\3\r\3\r\3\16\3\16\3\16\6\16\u00ea\n\16\r\16\16\16"+
		"\u00eb\3\16\3\16\3\16\3\16\3\16\3\16\3\16\6\16\u00f5\n\16\r\16\16\16\u00f6"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0104\n\16"+
		"\5\16\u0106\n\16\3\17\3\17\3\17\3\17\7\17\u010c\n\17\f\17\16\17\u010f"+
		"\13\17\3\17\3\17\3\20\3\20\3\20\3\20\7\20\u0117\n\20\f\20\16\20\u011a"+
		"\13\20\3\20\3\20\3\21\3\21\3\21\5\21\u0121\n\21\3\22\3\22\3\22\2\2\23"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2\3\3\2\7\n\2\u0149\2\'\3\2"+
		"\2\2\4W\3\2\2\2\6c\3\2\2\2\b\u0085\3\2\2\2\n\u0091\3\2\2\2\f\u0095\3\2"+
		"\2\2\16\u00a2\3\2\2\2\20\u00a6\3\2\2\2\22\u00a9\3\2\2\2\24\u00bf\3\2\2"+
		"\2\26\u00cb\3\2\2\2\30\u00d7\3\2\2\2\32\u0105\3\2\2\2\34\u0107\3\2\2\2"+
		"\36\u0112\3\2\2\2 \u0120\3\2\2\2\"\u0122\3\2\2\2$&\7\5\2\2%$\3\2\2\2&"+
		")\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(.\3\2\2\2)\'\3\2\2\2*,\7\16\2\2+-\7\5"+
		"\2\2,+\3\2\2\2,-\3\2\2\2-/\3\2\2\2.*\3\2\2\2./\3\2\2\2/\60\3\2\2\2\60"+
		"\63\5\4\3\2\61\62\7\17\2\2\62\64\7\5\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64"+
		"G\3\2\2\2\65\67\7\5\2\2\66\65\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2"+
		"\29;\3\2\2\2:8\3\2\2\2;<\7\16\2\2<=\7\5\2\2=>\3\2\2\2>C\5\4\3\2?A\7\17"+
		"\2\2@B\7\5\2\2A@\3\2\2\2AB\3\2\2\2BD\3\2\2\2C?\3\2\2\2CD\3\2\2\2DF\3\2"+
		"\2\2E8\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2HM\3\2\2\2IG\3\2\2\2JL\7\5"+
		"\2\2KJ\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2NP\3\2\2\2OM\3\2\2\2PQ\7\2"+
		"\2\3Q\3\3\2\2\2RX\5\6\4\2SX\5\n\6\2TX\5\34\17\2UX\5\36\20\2VX\5\16\b\2"+
		"WR\3\2\2\2WS\3\2\2\2WT\3\2\2\2WU\3\2\2\2WV\3\2\2\2X\5\3\2\2\2Y[\7\5\2"+
		"\2ZY\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]_\3\2\2\2^\\\3\2\2\2_a\5"+
		"\b\5\2`b\7\5\2\2a`\3\2\2\2ab\3\2\2\2bd\3\2\2\2c\\\3\2\2\2de\3\2\2\2ec"+
		"\3\2\2\2ef\3\2\2\2f\7\3\2\2\2gi\7\r\2\2hj\7\35\2\2ih\3\2\2\2ij\3\2\2\2"+
		"j\177\3\2\2\2k\u0080\5\16\b\2ln\7\5\2\2ml\3\2\2\2no\3\2\2\2om\3\2\2\2"+
		"op\3\2\2\2pq\3\2\2\2qr\7\3\2\2rs\5\6\4\2st\7\4\2\2t\u0080\3\2\2\2uw\7"+
		"\5\2\2vu\3\2\2\2wx\3\2\2\2xv\3\2\2\2xy\3\2\2\2yz\3\2\2\2z{\7\3\2\2{|\5"+
		"\n\6\2|}\7\4\2\2}\u0080\3\2\2\2~\u0080\5\34\17\2\177k\3\2\2\2\177m\3\2"+
		"\2\2\177v\3\2\2\2\177~\3\2\2\2\u0080\u0086\3\2\2\2\u0081\u0082\7\r\2\2"+
		"\u0082\u0086\7\36\2\2\u0083\u0084\7\r\2\2\u0084\u0086\7\5\2\2\u0085g\3"+
		"\2\2\2\u0085\u0081\3\2\2\2\u0085\u0083\3\2\2\2\u0086\t\3\2\2\2\u0087\u0089"+
		"\7\5\2\2\u0088\u0087\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008a"+
		"\u008b\3\2\2\2\u008b\u008d\3\2\2\2\u008c\u008a\3\2\2\2\u008d\u008f\5\32"+
		"\16\2\u008e\u0090\7\5\2\2\u008f\u008e\3\2\2\2\u008f\u0090\3\2\2\2\u0090"+
		"\u0092\3\2\2\2\u0091\u008a\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0091\3\2"+
		"\2\2\u0093\u0094\3\2\2\2\u0094\13\3\2\2\2\u0095\u0096\7\37\2\2\u0096\r"+
		"\3\2\2\2\u0097\u00a3\5\20\t\2\u0098\u0099\7\5\2\2\u0099\u009a\7\3\2\2"+
		"\u009a\u009b\5\20\t\2\u009b\u009c\7\5\2\2\u009c\u009d\7\4\2\2\u009d\u00a3"+
		"\3\2\2\2\u009e\u00a3\5\22\n\2\u009f\u00a3\5\24\13\2\u00a0\u00a3\5\26\f"+
		"\2\u00a1\u00a3\5\30\r\2\u00a2\u0097\3\2\2\2\u00a2\u0098\3\2\2\2\u00a2"+
		"\u009e\3\2\2\2\u00a2\u009f\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a1\3\2"+
		"\2\2\u00a3\17\3\2\2\2\u00a4\u00a7\5 \21\2\u00a5\u00a7\7\37\2\2\u00a6\u00a4"+
		"\3\2\2\2\u00a6\u00a5\3\2\2\2\u00a7\21\3\2\2\2\u00a8\u00aa\5\20\t\2\u00a9"+
		"\u00a8\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\7\5"+
		"\2\2\u00ac\u00b6\7\3\2\2\u00ad\u00b2\5\20\t\2\u00ae\u00af\7\5\2\2\u00af"+
		"\u00b1\5\20\t\2\u00b0\u00ae\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3"+
		"\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b7\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5"+
		"\u00b7\5\22\n\2\u00b6\u00ad\3\2\2\2\u00b6\u00b5\3\2\2\2\u00b7\u00b8\3"+
		"\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00bb\3\2\2\2\u00ba"+
		"\u00bc\7\5\2\2\u00bb\u00ba\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00bd\3\2"+
		"\2\2\u00bd\u00be\7\4\2\2\u00be\23\3\2\2\2\u00bf\u00c8\7\32\2\2\u00c0\u00c2"+
		"\7#\2\2\u00c1\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3"+
		"\u00c4\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c7\7\37\2\2\u00c6\u00c1\3"+
		"\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9"+
		"\25\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00d4\7\33\2\2\u00cc\u00ce\7#\2"+
		"\2\u00cd\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0"+
		"\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d3\7\37\2\2\u00d2\u00cd\3\2\2\2"+
		"\u00d3\u00d6\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\27"+
		"\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00d8\7\34\2\2\u00d8\u00e1\7\37\2\2"+
		"\u00d9\u00db\7$\2\2\u00da\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00da"+
		"\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00e0\7\37\2\2"+
		"\u00df\u00da\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2"+
		"\3\2\2\2\u00e2\u00e4\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00e5\7\34\2\2"+
		"\u00e5\31\3\2\2\2\u00e6\u00e7\5\f\7\2\u00e7\u00e9\7\25\2\2\u00e8\u00ea"+
		"\7\5\2\2\u00e9\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb"+
		"\u00ec\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ee\7\3\2\2\u00ee\u00ef\5\n"+
		"\6\2\u00ef\u00f0\7\4\2\2\u00f0\u0106\3\2\2\2\u00f1\u00f2\5\f\7\2\u00f2"+
		"\u00f4\7\25\2\2\u00f3\u00f5\7\5\2\2\u00f4\u00f3\3\2\2\2\u00f5\u00f6\3"+
		"\2\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8"+
		"\u00f9\7\3\2\2\u00f9\u00fa\5\6\4\2\u00fa\u00fb\7\4\2\2\u00fb\u0106\3\2"+
		"\2\2\u00fc\u00fd\5\f\7\2\u00fd\u00fe\7\25\2\2\u00fe\u00ff\5\36\20\2\u00ff"+
		"\u0106\3\2\2\2\u0100\u0101\5\f\7\2\u0101\u0103\7\25\2\2\u0102\u0104\5"+
		"\16\b\2\u0103\u0102\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0106\3\2\2\2\u0105"+
		"\u00e6\3\2\2\2\u0105\u00f1\3\2\2\2\u0105\u00fc\3\2\2\2\u0105\u0100\3\2"+
		"\2\2\u0106\33\3\2\2\2\u0107\u0108\7\26\2\2\u0108\u010d\5\16\b\2\u0109"+
		"\u010a\7\24\2\2\u010a\u010c\5\16\b\2\u010b\u0109\3\2\2\2\u010c\u010f\3"+
		"\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u0110\3\2\2\2\u010f"+
		"\u010d\3\2\2\2\u0110\u0111\7\27\2\2\u0111\35\3\2\2\2\u0112\u0113\7\30"+
		"\2\2\u0113\u0118\5\32\16\2\u0114\u0115\7\24\2\2\u0115\u0117\5\32\16\2"+
		"\u0116\u0114\3\2\2\2\u0117\u011a\3\2\2\2\u0118\u0116\3\2\2\2\u0118\u0119"+
		"\3\2\2\2\u0119\u011b\3\2\2\2\u011a\u0118\3\2\2\2\u011b\u011c\7\31\2\2"+
		"\u011c\37\3\2\2\2\u011d\u0121\5\"\22\2\u011e\u0121\7\13\2\2\u011f\u0121"+
		"\7\f\2\2\u0120\u011d\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u011f\3\2\2\2\u0121"+
		"!\3\2\2\2\u0122\u0123\t\2\2\2\u0123#\3\2\2\2+\',.\638ACGMW\\aeiox\177"+
		"\u0085\u008a\u008f\u0093\u00a2\u00a6\u00a9\u00b2\u00b6\u00b8\u00bb\u00c3"+
		"\u00c8\u00cf\u00d4\u00dc\u00e1\u00eb\u00f6\u0103\u0105\u010d\u0118\u0120";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
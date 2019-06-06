// Generated from YamlLexer.g4 by ANTLR 4.7.2
package com.fastyaml;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class YamlLexer extends Lexer {
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
		FLOW=1, LITERAL_STRING=2, DOUBLE_QUOTE_STR=3;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "FLOW", "LITERAL_STRING", "DOUBLE_QUOTE_STR"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"NEWLINE", "BYTES_LITERAL", "DECIMAL_INTEGER", "OCT_INTEGER", "HEX_INTEGER", 
			"BIN_INTEGER", "FLOAT_NUMBER", "IMAG_NUMBER", "MINUS", "DOCUMENTSTART", 
			"DOCUMENTEND", "AMPERSAND", "STAR", "OPEN_PAREN", "CLOSE_PAREN", "COMMA", 
			"COLON", "OPEN_BRACK", "CLOSE_BRACK", "OPEN_BRACE", "CLOSE_BRACE", "LITERIAL_STR_IND", 
			"FOLD_STR_IND", "DOUBLE_QUOTE", "ANCHOR", "ALIAS", "NAME", "STRING_MY", 
			"STRING_MY_START", "SKIP1", "UNKNOWN_CHAR", "NON_ZERO_DIGIT", "DIGIT", 
			"OCT_DIGIT", "HEX_DIGIT", "BIN_DIGIT", "POINT_FLOAT", "EXPONENT_FLOAT", 
			"INT_PART", "FRACTION", "EXPONENT", "SHORT_BYTES", "LONG_BYTES", "LONG_BYTES_ITEM", 
			"SHORT_BYTES_CHAR_NO_SINGLE_QUOTE", "SHORT_BYTES_CHAR_NO_DOUBLE_QUOTE", 
			"LONG_BYTES_CHAR", "BYTES_ESCAPE_SEQ", "SPACES", "COMMENT", "LINE_JOINING", 
			"DECIMAL_INTEGER2", "OCT_INTEGER2", "HEX_INTEGER2", "BIN_INTEGER2", "FLOAT_NUMBER2", 
			"IMAG_NUMBER2", "STRING_MY_2", "STRING_MY_START_2", "COMMA2", "COLON2", 
			"SKIP2", "CLOSE_BRACK2", "CLOSE_BRACE2", "NEWLINE_STR_LITERAL", "STRING_MY_3", 
			"STRING_MY_4", "NEWLINE_STR_QUOTE", "DOUBLE_QUOTE2"
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



	  /**
	   * A queue where extra tokens are pushed on (see the NEWLINE lexer rule for instance).
	   * Tokens are returned from the queue first. Once the queue is empty, lexer goes back to input stream for producing tokens.
	   */
	  private java.util.LinkedList<Token> tokens = new java.util.LinkedList<>();

	  // The stack that keeps track of the indentation level.
	  private java.util.Stack<Integer> indents = new java.util.Stack<>();

	  // The amount of opened braces, brackets and parenthesis.
	  private int opened = 0;

	  // The most recently produced token.
	  private Token lastToken = null;

	  /**
	   * Add a token to the queue. Tokens are returned from the queue first, before new tokens are extracted from input stream.
	   */
	  public void schedule(Token t) {
	    tokens.offer(t);
	  }

	  @Override
	  public Token nextToken() {

	      if (tokens.isEmpty()) {
	          Token next = super.nextToken();

	          if (next.getType() == EOF) {
	              processEOF_NextToken();
	              next = tokens.poll();
	          } else if(next.getType() == NEWLINE) {
	              processNEWLINE_NextToken();
	              next = tokens.poll();
	          }

	          if (lastToken != null && lastToken.getType() == MINUS) {
	              switch(next.getType()) {
	                  case MINUS:
	                    next = commonToken(YamlParser.NEWLINE, "\n");
	                    createAndScheduleIndent(this._tokenStartCharPositionInLine);
	                    schedule(commonToken(YamlParser.MINUS, "-"));
	                  break;
	                  case STRING_MY:
	                    int indent = this._tokenStartCharPositionInLine;
	                    Token afterNext = super.nextToken();
	                    if(afterNext.getType() == COLON) {
	                        createAndScheduleIndent(indent); 					//2 - after next (INDENT)
	                        schedule(next);										//3 - last (string)
	                        next = commonToken(YamlParser.NEWLINE, "\n");  //1 - next (NEWLINE)
	                    }

	                    if (afterNext.getType() == EOF) {
	                        processEOF_NextToken();
	                    } else if(afterNext.getType() == NEWLINE) {
	                        processNEWLINE_NextToken();
	                    }
	                    else {
	                        schedule(afterNext);
	                    }
	                    break;
	              }
	          }

	          this.lastToken = next;
	      } else {
	          this.lastToken = tokens.poll();
	      }

	      return this.lastToken;
	  }

	  private void processEOF_NextToken() {
	      schedule(commonToken(YamlParser.NEWLINE, "\n"));

	      if (!this.indents.isEmpty()) {

	          // Now emit as much DEDENT tokens as needed.
	          while (!indents.isEmpty()) {
	              this.schedule(createDedent());
	              indents.pop();
	          }
	      }

	      // Put the EOF back on the token stream.
	      this.schedule(commonToken(YamlParser.EOF, "<EOF>"));
	  }

	  private void processNEWLINE_NextToken() {
	      //String newLine = getText().replaceAll("[^\r\n]+", "");
	      String spaces = getText().replaceAll("[\r\n]+", "");

	      schedule(commonToken(NEWLINE, "\n"));

	      int indent = getIndentationCount(spaces);
	      int previous = indents.isEmpty() ? 0 : indents.peek();

	      if (indent == previous) {
	          // skip indents of the same size as the present indent-size
	          //skip();
	      }
	      else if (indent > previous) {
	          indents.push(indent);
	          schedule(commonToken(YamlParser.INDENT, spaces));
	      }
	      else {
	          // Possibly emit more than 1 DEDENT token.
	          while(!indents.isEmpty() && indents.peek() > indent) {
	              this.schedule(createDedent());
	              indents.pop();
	          }
	      }

	  }

	  private Token createDedent() {
	    CommonToken dedent = commonToken(YamlParser.DEDENT, "");
	    dedent.setLine(this.lastToken.getLine());
	    return dedent;
	  }

	  private CommonToken commonToken(int type, String text) {
	    int stop = this.getCharIndex() - 1;
	    int start = text.isEmpty() ? stop : stop - text.length() + 1;
	    return new CommonToken(this._tokenFactorySourcePair, type, DEFAULT_TOKEN_CHANNEL, start, stop);
	  }

	  /**
	   * Create a Indent token if given indentation level is greater and schedule it in 'tokens' queue.
	   * @param indent indentation level
	   */
	  private void createAndScheduleIndent(int indent) {
	      int previous = indents.isEmpty() ? 0 : indents.peek();
	      if (indent > previous) {
	          indents.push(indent);
	          schedule(commonToken(YamlParser.INDENT, "-"));
	      }
	  }

	  // Calculates the indentation of the provided spaces, taking the
	  // following rules into account:
	  //
	  // "Tabs are replaced (from left to right) by one to eight spaces
	  //  such that the total number of characters up to and including
	  //  the replacement is a multiple of eight [...]"
	  //
	  //  -- https://docs.python.org/3.1/reference/lexical_analysis.html#indentation
	  static int getIndentationCount(String spaces) {

	    int count = 0;

	    for (char ch : spaces.toCharArray()) {
	      switch (ch) {
	        case '\t':
	          count += 8 - (count % 8);
	          break;
	        default:
	          // A normal space char.
	          count++;
	      }
	    }

	    return count;
	  }

	  boolean atStartOfInput() {
	    return super.getCharPositionInLine() == 0 && super.getLine() == 1;
	  }

	  /**
	   * Indentation of a string literal. '-1' means the value is not set.
	   */
	  private int string_literal_start = -1;



	public YamlLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "YamlLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 0:
			NEWLINE_action((RuleContext)_localctx, actionIndex);
			break;
		case 13:
			OPEN_PAREN_action((RuleContext)_localctx, actionIndex);
			break;
		case 14:
			CLOSE_PAREN_action((RuleContext)_localctx, actionIndex);
			break;
		case 17:
			OPEN_BRACK_action((RuleContext)_localctx, actionIndex);
			break;
		case 18:
			CLOSE_BRACK_action((RuleContext)_localctx, actionIndex);
			break;
		case 19:
			OPEN_BRACE_action((RuleContext)_localctx, actionIndex);
			break;
		case 20:
			CLOSE_BRACE_action((RuleContext)_localctx, actionIndex);
			break;
		case 21:
			LITERIAL_STR_IND_action((RuleContext)_localctx, actionIndex);
			break;
		case 22:
			FOLD_STR_IND_action((RuleContext)_localctx, actionIndex);
			break;
		case 64:
			NEWLINE_STR_LITERAL_action((RuleContext)_localctx, actionIndex);
			break;
		case 65:
			STRING_MY_3_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void NEWLINE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:

			     int next = _input.LA(1);
			     if (opened > 0 || next == '\r' || next == '\n' || next == '#') {
			         // If we're inside a list or on a blank line, ignore all indents,
			         // dedents and line breaks.
			         skip();
			     }
			   
			break;
		}
	}
	private void OPEN_PAREN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			opened++;
			break;
		}
	}
	private void CLOSE_PAREN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			opened--;
			break;
		}
	}
	private void OPEN_BRACK_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			opened++;
			break;
		}
	}
	private void CLOSE_BRACK_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:
			opened--;
			break;
		}
	}
	private void OPEN_BRACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:
			opened++;
			break;
		}
	}
	private void CLOSE_BRACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6:
			opened--;
			break;
		}
	}
	private void LITERIAL_STR_IND_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7:
			string_literal_start=-1;
			break;
		}
	}
	private void FOLD_STR_IND_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 8:
			string_literal_start=-1;
			break;
		}
	}
	private void NEWLINE_STR_LITERAL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 9:

			     int next = _input.LA(1);
			     if(!(opened > 0 || next == '\r' || next == '\n' || next == '#')) {
			       int indent = indents.isEmpty() ? 0 : indents.peek();
			       int space_count = getIndentationCount(getText().replaceAll("[\r\n]+", ""));
			       if(space_count <= indent) {
			         popMode();
			         setType(NEWLINE);
			       }
			       else if (string_literal_start == -1) {
			         string_literal_start = space_count;
			       }
			     }
			   
			break;
		}
	}
	private void STRING_MY_3_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 10:

			     int extraSpace = _tokenStartCharPositionInLine - string_literal_start;
			     if(extraSpace > 0) {
			       StringBuilder builder = new StringBuilder();
			       for (int i = 0; i < extraSpace; i++) {
			         builder.append(' ');
			       }
			       builder.append(getText());
			       setText(builder.toString());
			     }
			   
			break;
		}
	}
	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0:
			return NEWLINE_sempred((RuleContext)_localctx, predIndex);
		case 9:
			return DOCUMENTSTART_sempred((RuleContext)_localctx, predIndex);
		case 10:
			return DOCUMENTEND_sempred((RuleContext)_localctx, predIndex);
		case 28:
			return STRING_MY_START_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean NEWLINE_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return atStartOfInput();
		}
		return true;
	}
	private boolean DOCUMENTSTART_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return  super.getCharPositionInLine() == 0 ;
		}
		return true;
	}
	private boolean DOCUMENTEND_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return  super.getCharPositionInLine() == 0 ;
		}
		return true;
	}
	private boolean STRING_MY_START_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return _input.LA(3) != 45;
		case 4:
			return super.getCharPositionInLine() != 0;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2$\u0268\b\1\b\1\b"+
		"\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t"+
		"\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21"+
		"\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30"+
		"\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37"+
		"\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)"+
		"\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63"+
		"\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;"+
		"\4<\t<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\3\2"+
		"\3\2\3\2\5\2\u0094\n\2\3\2\3\2\5\2\u0098\n\2\3\2\5\2\u009b\n\2\5\2\u009d"+
		"\n\2\3\2\3\2\3\3\3\3\5\3\u00a3\n\3\3\3\3\3\5\3\u00a7\n\3\3\4\3\4\7\4\u00ab"+
		"\n\4\f\4\16\4\u00ae\13\4\3\4\6\4\u00b1\n\4\r\4\16\4\u00b2\5\4\u00b5\n"+
		"\4\3\5\3\5\3\5\6\5\u00ba\n\5\r\5\16\5\u00bb\3\6\3\6\3\6\6\6\u00c1\n\6"+
		"\r\6\16\6\u00c2\3\7\3\7\3\7\6\7\u00c8\n\7\r\7\16\7\u00c9\3\b\3\b\5\b\u00ce"+
		"\n\b\3\t\3\t\5\t\u00d2\n\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3"+
		"\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21"+
		"\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30"+
		"\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\6\34\u0115"+
		"\n\34\r\34\16\34\u0116\3\35\3\35\3\35\3\35\3\35\6\35\u011e\n\35\r\35\16"+
		"\35\u011f\3\35\7\35\u0123\n\35\f\35\16\35\u0126\13\35\3\36\3\36\3\36\3"+
		"\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u0134\n\36\3\37\3\37"+
		"\3\37\5\37\u0139\n\37\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%"+
		"\3&\5&\u014a\n&\3&\3&\3&\3&\5&\u0150\n&\3\'\3\'\5\'\u0154\n\'\3\'\3\'"+
		"\3(\6(\u0159\n(\r(\16(\u015a\3)\3)\6)\u015f\n)\r)\16)\u0160\3*\3*\5*\u0165"+
		"\n*\3*\6*\u0168\n*\r*\16*\u0169\3+\3+\3+\7+\u016f\n+\f+\16+\u0172\13+"+
		"\3+\3+\3+\3+\7+\u0178\n+\f+\16+\u017b\13+\3+\5+\u017e\n+\3,\3,\3,\3,\3"+
		",\7,\u0185\n,\f,\16,\u0188\13,\3,\3,\3,\3,\3,\3,\3,\3,\7,\u0192\n,\f,"+
		"\16,\u0195\13,\3,\3,\3,\5,\u019a\n,\3-\3-\5-\u019e\n-\3.\5.\u01a1\n.\3"+
		"/\5/\u01a4\n/\3\60\5\60\u01a7\n\60\3\61\3\61\3\61\3\62\6\62\u01ad\n\62"+
		"\r\62\16\62\u01ae\3\63\3\63\7\63\u01b3\n\63\f\63\16\63\u01b6\13\63\3\64"+
		"\3\64\5\64\u01ba\n\64\3\64\5\64\u01bd\n\64\3\64\3\64\5\64\u01c1\n\64\3"+
		"\65\3\65\7\65\u01c5\n\65\f\65\16\65\u01c8\13\65\3\65\6\65\u01cb\n\65\r"+
		"\65\16\65\u01cc\5\65\u01cf\n\65\3\65\3\65\3\66\3\66\3\66\6\66\u01d6\n"+
		"\66\r\66\16\66\u01d7\3\66\3\66\3\67\3\67\3\67\6\67\u01df\n\67\r\67\16"+
		"\67\u01e0\3\67\3\67\38\38\38\68\u01e8\n8\r8\168\u01e9\38\38\39\39\59\u01f0"+
		"\n9\39\39\3:\3:\5:\u01f6\n:\3:\3:\3:\3:\3;\3;\3;\3;\3;\6;\u0201\n;\r;"+
		"\16;\u0202\3;\7;\u0206\n;\f;\16;\u0209\13;\3;\3;\3<\3<\3<\3<\3<\5<\u0212"+
		"\n<\3=\3=\3=\3=\3>\3>\3>\3>\3?\3?\3?\3?\5?\u0220\n?\3?\3?\5?\u0224\n?"+
		"\5?\u0226\n?\3?\3?\3@\3@\3@\3@\3@\3A\3A\3A\3A\3A\3B\5B\u0235\nB\3B\3B"+
		"\5B\u0239\nB\3B\7B\u023c\nB\fB\16B\u023f\13B\3B\3B\3C\7C\u0244\nC\fC\16"+
		"C\u0247\13C\3C\3C\3C\3C\3D\3D\3D\7D\u0250\nD\fD\16D\u0253\13D\3D\3D\3"+
		"E\5E\u0258\nE\3E\3E\5E\u025c\nE\3E\7E\u025f\nE\fE\16E\u0262\13E\3F\3F"+
		"\3F\3F\3F\4\u0186\u0193\2G\6\5\b\6\n\7\f\b\16\t\20\n\22\13\24\f\26\r\30"+
		"\16\32\17\34\20\36\21 \22\"\23$\24&\25(\26*\27,\30.\31\60\32\62\33\64"+
		"\34\66\358\36:\2<\37>\2@ B!D\2F\2H\2J\2L\2N\2P\2R\2T\2V\2X\2Z\2\\\2^\2"+
		"`\2b\2d\2f\2h\2j\2l\2n\2p\2r\2t\2v\2x\2z\2|\2~\2\u0080\"\u0082\2\u0084"+
		"\2\u0086#\u0088\2\u008a\2\u008c$\u008e\2\6\2\3\4\5\36\4\2DDdd\4\2TTtt"+
		"\4\2QQqq\4\2ZZzz\4\2LLll\5\2\62;C\\c|\7\2\f\f\17\17\"\"$$<<\5\2\f\f\17"+
		"\17\"\"\7\2\f\f\17\17\"\"%%<<\f\2\f\f\17\17\"\"$%((,,//<<]]}~\6\2\f\f"+
		"\17\17\"\"//\3\2\63;\3\2\62;\3\2\629\5\2\62;CHch\3\2\62\63\4\2GGgg\4\2"+
		"--//\7\2\2\13\r\16\20(*]_\u0081\7\2\2\13\r\16\20#%]_\u0081\4\2\2]_\u0081"+
		"\3\2\2\u0081\4\2\13\13\"\"\4\2\f\f\17\17\f\2\f\f\17\17\"\"$$..<<]]__}"+
		"}\177\177\f\2\f\f\17\17\"\"%%..<<]]__}}\177\177\f\2\f\f\17\17\"\"$%./"+
		"<<]]__}}\177\177\6\2\f\f\17\17$$^^\2\u0297\2\6\3\2\2\2\2\b\3\2\2\2\2\n"+
		"\3\2\2\2\2\f\3\2\2\2\2\16\3\2\2\2\2\20\3\2\2\2\2\22\3\2\2\2\2\24\3\2\2"+
		"\2\2\26\3\2\2\2\2\30\3\2\2\2\2\32\3\2\2\2\2\34\3\2\2\2\2\36\3\2\2\2\2"+
		" \3\2\2\2\2\"\3\2\2\2\2$\3\2\2\2\2&\3\2\2\2\2(\3\2\2\2\2*\3\2\2\2\2,\3"+
		"\2\2\2\2.\3\2\2\2\2\60\3\2\2\2\2\62\3\2\2\2\2\64\3\2\2\2\2\66\3\2\2\2"+
		"\28\3\2\2\2\2<\3\2\2\2\2@\3\2\2\2\2B\3\2\2\2\3l\3\2\2\2\3n\3\2\2\2\3p"+
		"\3\2\2\2\3r\3\2\2\2\3t\3\2\2\2\3v\3\2\2\2\3x\3\2\2\2\3|\3\2\2\2\3~\3\2"+
		"\2\2\3\u0080\3\2\2\2\3\u0082\3\2\2\2\3\u0084\3\2\2\2\4\u0086\3\2\2\2\4"+
		"\u0088\3\2\2\2\5\u008a\3\2\2\2\5\u008c\3\2\2\2\5\u008e\3\2\2\2\6\u009c"+
		"\3\2\2\2\b\u00a0\3\2\2\2\n\u00b4\3\2\2\2\f\u00b6\3\2\2\2\16\u00bd\3\2"+
		"\2\2\20\u00c4\3\2\2\2\22\u00cd\3\2\2\2\24\u00d1\3\2\2\2\26\u00d5\3\2\2"+
		"\2\30\u00d7\3\2\2\2\32\u00dc\3\2\2\2\34\u00e1\3\2\2\2\36\u00e3\3\2\2\2"+
		" \u00e5\3\2\2\2\"\u00e8\3\2\2\2$\u00eb\3\2\2\2&\u00ed\3\2\2\2(\u00ef\3"+
		"\2\2\2*\u00f4\3\2\2\2,\u00f7\3\2\2\2.\u00fc\3\2\2\2\60\u00ff\3\2\2\2\62"+
		"\u0104\3\2\2\2\64\u0109\3\2\2\2\66\u010d\3\2\2\28\u0110\3\2\2\2:\u0114"+
		"\3\2\2\2<\u0118\3\2\2\2>\u0133\3\2\2\2@\u0138\3\2\2\2B\u013c\3\2\2\2D"+
		"\u013e\3\2\2\2F\u0140\3\2\2\2H\u0142\3\2\2\2J\u0144\3\2\2\2L\u0146\3\2"+
		"\2\2N\u014f\3\2\2\2P\u0153\3\2\2\2R\u0158\3\2\2\2T\u015c\3\2\2\2V\u0162"+
		"\3\2\2\2X\u017d\3\2\2\2Z\u0199\3\2\2\2\\\u019d\3\2\2\2^\u01a0\3\2\2\2"+
		"`\u01a3\3\2\2\2b\u01a6\3\2\2\2d\u01a8\3\2\2\2f\u01ac\3\2\2\2h\u01b0\3"+
		"\2\2\2j\u01b7\3\2\2\2l\u01ce\3\2\2\2n\u01d2\3\2\2\2p\u01db\3\2\2\2r\u01e4"+
		"\3\2\2\2t\u01ef\3\2\2\2v\u01f5\3\2\2\2x\u01fb\3\2\2\2z\u0211\3\2\2\2|"+
		"\u0213\3\2\2\2~\u0217\3\2\2\2\u0080\u0225\3\2\2\2\u0082\u0229\3\2\2\2"+
		"\u0084\u022e\3\2\2\2\u0086\u0238\3\2\2\2\u0088\u0245\3\2\2\2\u008a\u0251"+
		"\3\2\2\2\u008c\u025b\3\2\2\2\u008e\u0263\3\2\2\2\u0090\u0091\6\2\2\2\u0091"+
		"\u009d\5f\62\2\u0092\u0094\7\17\2\2\u0093\u0092\3\2\2\2\u0093\u0094\3"+
		"\2\2\2\u0094\u0095\3\2\2\2\u0095\u0098\7\f\2\2\u0096\u0098\7\17\2\2\u0097"+
		"\u0093\3\2\2\2\u0097\u0096\3\2\2\2\u0098\u009a\3\2\2\2\u0099\u009b\5f"+
		"\62\2\u009a\u0099\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009d\3\2\2\2\u009c"+
		"\u0090\3\2\2\2\u009c\u0097\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f\b\2"+
		"\2\2\u009f\7\3\2\2\2\u00a0\u00a2\t\2\2\2\u00a1\u00a3\t\3\2\2\u00a2\u00a1"+
		"\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a7\5X+\2\u00a5"+
		"\u00a7\5Z,\2\u00a6\u00a4\3\2\2\2\u00a6\u00a5\3\2\2\2\u00a7\t\3\2\2\2\u00a8"+
		"\u00ac\5D!\2\u00a9\u00ab\5F\"\2\u00aa\u00a9\3\2\2\2\u00ab\u00ae\3\2\2"+
		"\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00b5\3\2\2\2\u00ae\u00ac"+
		"\3\2\2\2\u00af\u00b1\7\62\2\2\u00b0\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2"+
		"\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b5\3\2\2\2\u00b4\u00a8"+
		"\3\2\2\2\u00b4\u00b0\3\2\2\2\u00b5\13\3\2\2\2\u00b6\u00b7\7\62\2\2\u00b7"+
		"\u00b9\t\4\2\2\u00b8\u00ba\5H#\2\u00b9\u00b8\3\2\2\2\u00ba\u00bb\3\2\2"+
		"\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\r\3\2\2\2\u00bd\u00be"+
		"\7\62\2\2\u00be\u00c0\t\5\2\2\u00bf\u00c1\5J$\2\u00c0\u00bf\3\2\2\2\u00c1"+
		"\u00c2\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\17\3\2\2"+
		"\2\u00c4\u00c5\7\62\2\2\u00c5\u00c7\t\2\2\2\u00c6\u00c8\5L%\2\u00c7\u00c6"+
		"\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca"+
		"\21\3\2\2\2\u00cb\u00ce\5N&\2\u00cc\u00ce\5P\'\2\u00cd\u00cb\3\2\2\2\u00cd"+
		"\u00cc\3\2\2\2\u00ce\23\3\2\2\2\u00cf\u00d2\5\22\b\2\u00d0\u00d2\5R(\2"+
		"\u00d1\u00cf\3\2\2\2\u00d1\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4"+
		"\t\6\2\2\u00d4\25\3\2\2\2\u00d5\u00d6\7/\2\2\u00d6\27\3\2\2\2\u00d7\u00d8"+
		"\6\13\3\2\u00d8\u00d9\7/\2\2\u00d9\u00da\7/\2\2\u00da\u00db\7/\2\2\u00db"+
		"\31\3\2\2\2\u00dc\u00dd\6\f\4\2\u00dd\u00de\7\60\2\2\u00de\u00df\7\60"+
		"\2\2\u00df\u00e0\7\60\2\2\u00e0\33\3\2\2\2\u00e1\u00e2\7(\2\2\u00e2\35"+
		"\3\2\2\2\u00e3\u00e4\7,\2\2\u00e4\37\3\2\2\2\u00e5\u00e6\7*\2\2\u00e6"+
		"\u00e7\b\17\3\2\u00e7!\3\2\2\2\u00e8\u00e9\7+\2\2\u00e9\u00ea\b\20\4\2"+
		"\u00ea#\3\2\2\2\u00eb\u00ec\7.\2\2\u00ec%\3\2\2\2\u00ed\u00ee\7<\2\2\u00ee"+
		"\'\3\2\2\2\u00ef\u00f0\7]\2\2\u00f0\u00f1\b\23\5\2\u00f1\u00f2\3\2\2\2"+
		"\u00f2\u00f3\b\23\6\2\u00f3)\3\2\2\2\u00f4\u00f5\7_\2\2\u00f5\u00f6\b"+
		"\24\7\2\u00f6+\3\2\2\2\u00f7\u00f8\7}\2\2\u00f8\u00f9\b\25\b\2\u00f9\u00fa"+
		"\3\2\2\2\u00fa\u00fb\b\25\6\2\u00fb-\3\2\2\2\u00fc\u00fd\7\177\2\2\u00fd"+
		"\u00fe\b\26\t\2\u00fe/\3\2\2\2\u00ff\u0100\7~\2\2\u0100\u0101\b\27\n\2"+
		"\u0101\u0102\3\2\2\2\u0102\u0103\b\27\13\2\u0103\61\3\2\2\2\u0104\u0105"+
		"\7@\2\2\u0105\u0106\b\30\f\2\u0106\u0107\3\2\2\2\u0107\u0108\b\30\13\2"+
		"\u0108\63\3\2\2\2\u0109\u010a\7$\2\2\u010a\u010b\3\2\2\2\u010b\u010c\b"+
		"\31\r\2\u010c\65\3\2\2\2\u010d\u010e\5\34\r\2\u010e\u010f\5:\34\2\u010f"+
		"\67\3\2\2\2\u0110\u0111\5\36\16\2\u0111\u0112\5:\34\2\u01129\3\2\2\2\u0113"+
		"\u0115\t\7\2\2\u0114\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0114\3\2"+
		"\2\2\u0116\u0117\3\2\2\2\u0117;\3\2\2\2\u0118\u0124\5>\36\2\u0119\u0123"+
		"\n\b\2\2\u011a\u011b\7<\2\2\u011b\u0123\n\t\2\2\u011c\u011e\7\"\2\2\u011d"+
		"\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u011d\3\2\2\2\u011f\u0120\3\2"+
		"\2\2\u0120\u0121\3\2\2\2\u0121\u0123\n\n\2\2\u0122\u0119\3\2\2\2\u0122"+
		"\u011a\3\2\2\2\u0122\u011d\3\2\2\2\u0123\u0126\3\2\2\2\u0124\u0122\3\2"+
		"\2\2\u0124\u0125\3\2\2\2\u0125=\3\2\2\2\u0126\u0124\3\2\2\2\u0127\u0134"+
		"\n\13\2\2\u0128\u0129\7<\2\2\u0129\u0134\n\t\2\2\u012a\u012b\7/\2\2\u012b"+
		"\u0134\n\f\2\2\u012c\u012d\6\36\5\2\u012d\u012e\7/\2\2\u012e\u0134\7/"+
		"\2\2\u012f\u0130\6\36\6\2\u0130\u0131\7/\2\2\u0131\u0132\7/\2\2\u0132"+
		"\u0134\7/\2\2\u0133\u0127\3\2\2\2\u0133\u0128\3\2\2\2\u0133\u012a\3\2"+
		"\2\2\u0133\u012c\3\2\2\2\u0133\u012f\3\2\2\2\u0134?\3\2\2\2\u0135\u0139"+
		"\5f\62\2\u0136\u0139\5h\63\2\u0137\u0139\5j\64\2\u0138\u0135\3\2\2\2\u0138"+
		"\u0136\3\2\2\2\u0138\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013b\b\37"+
		"\16\2\u013bA\3\2\2\2\u013c\u013d\13\2\2\2\u013dC\3\2\2\2\u013e\u013f\t"+
		"\r\2\2\u013fE\3\2\2\2\u0140\u0141\t\16\2\2\u0141G\3\2\2\2\u0142\u0143"+
		"\t\17\2\2\u0143I\3\2\2\2\u0144\u0145\t\20\2\2\u0145K\3\2\2\2\u0146\u0147"+
		"\t\21\2\2\u0147M\3\2\2\2\u0148\u014a\5R(\2\u0149\u0148\3\2\2\2\u0149\u014a"+
		"\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u0150\5T)\2\u014c\u014d\5R(\2\u014d"+
		"\u014e\7\60\2\2\u014e\u0150\3\2\2\2\u014f\u0149\3\2\2\2\u014f\u014c\3"+
		"\2\2\2\u0150O\3\2\2\2\u0151\u0154\5R(\2\u0152\u0154\5N&\2\u0153\u0151"+
		"\3\2\2\2\u0153\u0152\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0156\5V*\2\u0156"+
		"Q\3\2\2\2\u0157\u0159\5F\"\2\u0158\u0157\3\2\2\2\u0159\u015a\3\2\2\2\u015a"+
		"\u0158\3\2\2\2\u015a\u015b\3\2\2\2\u015bS\3\2\2\2\u015c\u015e\7\60\2\2"+
		"\u015d\u015f\5F\"\2\u015e\u015d\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u015e"+
		"\3\2\2\2\u0160\u0161\3\2\2\2\u0161U\3\2\2\2\u0162\u0164\t\22\2\2\u0163"+
		"\u0165\t\23\2\2\u0164\u0163\3\2\2\2\u0164\u0165\3\2\2\2\u0165\u0167\3"+
		"\2\2\2\u0166\u0168\5F\"\2\u0167\u0166\3\2\2\2\u0168\u0169\3\2\2\2\u0169"+
		"\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016aW\3\2\2\2\u016b\u0170\7)\2\2\u016c"+
		"\u016f\5^.\2\u016d\u016f\5d\61\2\u016e\u016c\3\2\2\2\u016e\u016d\3\2\2"+
		"\2\u016f\u0172\3\2\2\2\u0170\u016e\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u0173"+
		"\3\2\2\2\u0172\u0170\3\2\2\2\u0173\u017e\7)\2\2\u0174\u0179\7$\2\2\u0175"+
		"\u0178\5`/\2\u0176\u0178\5d\61\2\u0177\u0175\3\2\2\2\u0177\u0176\3\2\2"+
		"\2\u0178\u017b\3\2\2\2\u0179\u0177\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u017c"+
		"\3\2\2\2\u017b\u0179\3\2\2\2\u017c\u017e\7$\2\2\u017d\u016b\3\2\2\2\u017d"+
		"\u0174\3\2\2\2\u017eY\3\2\2\2\u017f\u0180\7)\2\2\u0180\u0181\7)\2\2\u0181"+
		"\u0182\7)\2\2\u0182\u0186\3\2\2\2\u0183\u0185\5\\-\2\u0184\u0183\3\2\2"+
		"\2\u0185\u0188\3\2\2\2\u0186\u0187\3\2\2\2\u0186\u0184\3\2\2\2\u0187\u0189"+
		"\3\2\2\2\u0188\u0186\3\2\2\2\u0189\u018a\7)\2\2\u018a\u018b\7)\2\2\u018b"+
		"\u019a\7)\2\2\u018c\u018d\7$\2\2\u018d\u018e\7$\2\2\u018e\u018f\7$\2\2"+
		"\u018f\u0193\3\2\2\2\u0190\u0192\5\\-\2\u0191\u0190\3\2\2\2\u0192\u0195"+
		"\3\2\2\2\u0193\u0194\3\2\2\2\u0193\u0191\3\2\2\2\u0194\u0196\3\2\2\2\u0195"+
		"\u0193\3\2\2\2\u0196\u0197\7$\2\2\u0197\u0198\7$\2\2\u0198\u019a\7$\2"+
		"\2\u0199\u017f\3\2\2\2\u0199\u018c\3\2\2\2\u019a[\3\2\2\2\u019b\u019e"+
		"\5b\60\2\u019c\u019e\5d\61\2\u019d\u019b\3\2\2\2\u019d\u019c\3\2\2\2\u019e"+
		"]\3\2\2\2\u019f\u01a1\t\24\2\2\u01a0\u019f\3\2\2\2\u01a1_\3\2\2\2\u01a2"+
		"\u01a4\t\25\2\2\u01a3\u01a2\3\2\2\2\u01a4a\3\2\2\2\u01a5\u01a7\t\26\2"+
		"\2\u01a6\u01a5\3\2\2\2\u01a7c\3\2\2\2\u01a8\u01a9\7^\2\2\u01a9\u01aa\t"+
		"\27\2\2\u01aae\3\2\2\2\u01ab\u01ad\t\30\2\2\u01ac\u01ab\3\2\2\2\u01ad"+
		"\u01ae\3\2\2\2\u01ae\u01ac\3\2\2\2\u01ae\u01af\3\2\2\2\u01afg\3\2\2\2"+
		"\u01b0\u01b4\7%\2\2\u01b1\u01b3\n\31\2\2\u01b2\u01b1\3\2\2\2\u01b3\u01b6"+
		"\3\2\2\2\u01b4\u01b2\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b5i\3\2\2\2\u01b6"+
		"\u01b4\3\2\2\2\u01b7\u01b9\7^\2\2\u01b8\u01ba\5f\62\2\u01b9\u01b8\3\2"+
		"\2\2\u01b9\u01ba\3\2\2\2\u01ba\u01c0\3\2\2\2\u01bb\u01bd\7\17\2\2\u01bc"+
		"\u01bb\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd\u01be\3\2\2\2\u01be\u01c1\7\f"+
		"\2\2\u01bf\u01c1\7\17\2\2\u01c0\u01bc\3\2\2\2\u01c0\u01bf\3\2\2\2\u01c1"+
		"k\3\2\2\2\u01c2\u01c6\5D!\2\u01c3\u01c5\5F\"\2\u01c4\u01c3\3\2\2\2\u01c5"+
		"\u01c8\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7\u01cf\3\2"+
		"\2\2\u01c8\u01c6\3\2\2\2\u01c9\u01cb\7\62\2\2\u01ca\u01c9\3\2\2\2\u01cb"+
		"\u01cc\3\2\2\2\u01cc\u01ca\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01cf\3\2"+
		"\2\2\u01ce\u01c2\3\2\2\2\u01ce\u01ca\3\2\2\2\u01cf\u01d0\3\2\2\2\u01d0"+
		"\u01d1\b\65\17\2\u01d1m\3\2\2\2\u01d2\u01d3\7\62\2\2\u01d3\u01d5\t\4\2"+
		"\2\u01d4\u01d6\5H#\2\u01d5\u01d4\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7\u01d5"+
		"\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9\u01da\b\66\20\2"+
		"\u01dao\3\2\2\2\u01db\u01dc\7\62\2\2\u01dc\u01de\t\5\2\2\u01dd\u01df\5"+
		"J$\2\u01de\u01dd\3\2\2\2\u01df\u01e0\3\2\2\2\u01e0\u01de\3\2\2\2\u01e0"+
		"\u01e1\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2\u01e3\b\67\21\2\u01e3q\3\2\2"+
		"\2\u01e4\u01e5\7\62\2\2\u01e5\u01e7\t\2\2\2\u01e6\u01e8\5L%\2\u01e7\u01e6"+
		"\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9\u01e7\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea"+
		"\u01eb\3\2\2\2\u01eb\u01ec\b8\22\2\u01ecs\3\2\2\2\u01ed\u01f0\5N&\2\u01ee"+
		"\u01f0\5P\'\2\u01ef\u01ed\3\2\2\2\u01ef\u01ee\3\2\2\2\u01f0\u01f1\3\2"+
		"\2\2\u01f1\u01f2\b9\23\2\u01f2u\3\2\2\2\u01f3\u01f6\5\22\b\2\u01f4\u01f6"+
		"\5R(\2\u01f5\u01f3\3\2\2\2\u01f5\u01f4\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7"+
		"\u01f8\t\6\2\2\u01f8\u01f9\3\2\2\2\u01f9\u01fa\b:\24\2\u01faw\3\2\2\2"+
		"\u01fb\u0207\5z<\2\u01fc\u0206\n\32\2\2\u01fd\u01fe\7<\2\2\u01fe\u0206"+
		"\n\t\2\2\u01ff\u0201\7\"\2\2\u0200\u01ff\3\2\2\2\u0201\u0202\3\2\2\2\u0202"+
		"\u0200\3\2\2\2\u0202\u0203\3\2\2\2\u0203\u0204\3\2\2\2\u0204\u0206\n\33"+
		"\2\2\u0205\u01fc\3\2\2\2\u0205\u01fd\3\2\2\2\u0205\u0200\3\2\2\2\u0206"+
		"\u0209\3\2\2\2\u0207\u0205\3\2\2\2\u0207\u0208\3\2\2\2\u0208\u020a\3\2"+
		"\2\2\u0209\u0207\3\2\2\2\u020a\u020b\b;\25\2\u020by\3\2\2\2\u020c\u0212"+
		"\n\34\2\2\u020d\u020e\7<\2\2\u020e\u0212\n\t\2\2\u020f\u0210\7/\2\2\u0210"+
		"\u0212\n\t\2\2\u0211\u020c\3\2\2\2\u0211\u020d\3\2\2\2\u0211\u020f\3\2"+
		"\2\2\u0212{\3\2\2\2\u0213\u0214\7.\2\2\u0214\u0215\3\2\2\2\u0215\u0216"+
		"\b=\26\2\u0216}\3\2\2\2\u0217\u0218\7<\2\2\u0218\u0219\3\2\2\2\u0219\u021a"+
		"\b>\27\2\u021a\177\3\2\2\2\u021b\u0226\5f\62\2\u021c\u0226\5h\63\2\u021d"+
		"\u0226\5j\64\2\u021e\u0220\7\17\2\2\u021f\u021e\3\2\2\2\u021f\u0220\3"+
		"\2\2\2\u0220\u0221\3\2\2\2\u0221\u0224\7\f\2\2\u0222\u0224\7\17\2\2\u0223"+
		"\u021f\3\2\2\2\u0223\u0222\3\2\2\2\u0224\u0226\3\2\2\2\u0225\u021b\3\2"+
		"\2\2\u0225\u021c\3\2\2\2\u0225\u021d\3\2\2\2\u0225\u0223\3\2\2\2\u0226"+
		"\u0227\3\2\2\2\u0227\u0228\b?\16\2\u0228\u0081\3\2\2\2\u0229\u022a\7_"+
		"\2\2\u022a\u022b\3\2\2\2\u022b\u022c\b@\30\2\u022c\u022d\b@\31\2\u022d"+
		"\u0083\3\2\2\2\u022e\u022f\7\177\2\2\u022f\u0230\3\2\2\2\u0230\u0231\b"+
		"A\32\2\u0231\u0232\bA\31\2\u0232\u0085\3\2\2\2\u0233\u0235\7\17\2\2\u0234"+
		"\u0233\3\2\2\2\u0234\u0235\3\2\2\2\u0235\u0236\3\2\2\2\u0236\u0239\7\f"+
		"\2\2\u0237\u0239\7\17\2\2\u0238\u0234\3\2\2\2\u0238\u0237\3\2\2\2\u0239"+
		"\u023d\3\2\2\2\u023a\u023c\t\30\2\2\u023b\u023a\3\2\2\2\u023c\u023f\3"+
		"\2\2\2\u023d\u023b\3\2\2\2\u023d\u023e\3\2\2\2\u023e\u0240\3\2\2\2\u023f"+
		"\u023d\3\2\2\2\u0240\u0241\bB\33\2\u0241\u0087\3\2\2\2\u0242\u0244\n\31"+
		"\2\2\u0243\u0242\3\2\2\2\u0244\u0247\3\2\2\2\u0245\u0243\3\2\2\2\u0245"+
		"\u0246\3\2\2\2\u0246\u0248\3\2\2\2\u0247\u0245\3\2\2\2\u0248\u0249\bC"+
		"\34\2\u0249\u024a\3\2\2\2\u024a\u024b\bC\25\2\u024b\u0089\3\2\2\2\u024c"+
		"\u0250\n\35\2\2\u024d\u024e\7^\2\2\u024e\u0250\7^\2\2\u024f\u024c\3\2"+
		"\2\2\u024f\u024d\3\2\2\2\u0250\u0253\3\2\2\2\u0251\u024f\3\2\2\2\u0251"+
		"\u0252\3\2\2\2\u0252\u0254\3\2\2\2\u0253\u0251\3\2\2\2\u0254\u0255\bD"+
		"\25\2\u0255\u008b\3\2\2\2\u0256\u0258\7\17\2\2\u0257\u0256\3\2\2\2\u0257"+
		"\u0258\3\2\2\2\u0258\u0259\3\2\2\2\u0259\u025c\7\f\2\2\u025a\u025c\7\17"+
		"\2\2\u025b\u0257\3\2\2\2\u025b\u025a\3\2\2\2\u025c\u0260\3\2\2\2\u025d"+
		"\u025f\t\30\2\2\u025e\u025d\3\2\2\2\u025f\u0262\3\2\2\2\u0260\u025e\3"+
		"\2\2\2\u0260\u0261\3\2\2\2\u0261\u008d\3\2\2\2\u0262\u0260\3\2\2\2\u0263"+
		"\u0264\7$\2\2\u0264\u0265\3\2\2\2\u0265\u0266\bF\35\2\u0266\u0267\bF\31"+
		"\2\u0267\u008f\3\2\2\2J\2\3\4\5\u0093\u0097\u009a\u009c\u00a2\u00a6\u00ac"+
		"\u00b2\u00b4\u00bb\u00c2\u00c9\u00cd\u00d1\u0116\u011f\u0122\u0124\u0133"+
		"\u0138\u0149\u014f\u0153\u015a\u0160\u0164\u0169\u016e\u0170\u0177\u0179"+
		"\u017d\u0186\u0193\u0199\u019d\u01a0\u01a3\u01a6\u01ae\u01b4\u01b9\u01bc"+
		"\u01c0\u01c6\u01cc\u01ce\u01d7\u01e0\u01e9\u01ef\u01f5\u0202\u0205\u0207"+
		"\u0211\u021f\u0223\u0225\u0234\u0238\u023d\u0245\u024f\u0251\u0257\u025b"+
		"\u0260\36\3\2\2\3\17\3\3\20\4\3\23\5\7\3\2\3\24\6\3\25\7\3\26\b\3\27\t"+
		"\7\4\2\3\30\n\7\5\2\b\2\2\t\7\2\t\b\2\t\t\2\t\n\2\t\13\2\t\f\2\t\37\2"+
		"\t\24\2\t\25\2\t\27\2\6\2\2\t\31\2\3B\13\3C\f\t\34\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
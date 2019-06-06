// Generated from YamlParser.g4 by ANTLR 4.7.2
package com.fastyaml;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link YamlParser}.
 */
public interface YamlParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link YamlParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(YamlParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link YamlParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(YamlParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link YamlParser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocument(YamlParser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link YamlParser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocument(YamlParser.DocumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link YamlParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(YamlParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link YamlParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(YamlParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link YamlParser#listitem}.
	 * @param ctx the parse tree
	 */
	void enterListitem(YamlParser.ListitemContext ctx);
	/**
	 * Exit a parse tree produced by {@link YamlParser#listitem}.
	 * @param ctx the parse tree
	 */
	void exitListitem(YamlParser.ListitemContext ctx);
	/**
	 * Enter a parse tree produced by {@link YamlParser#mappinglist}.
	 * @param ctx the parse tree
	 */
	void enterMappinglist(YamlParser.MappinglistContext ctx);
	/**
	 * Exit a parse tree produced by {@link YamlParser#mappinglist}.
	 * @param ctx the parse tree
	 */
	void exitMappinglist(YamlParser.MappinglistContext ctx);
	/**
	 * Enter a parse tree produced by {@link YamlParser#key}.
	 * @param ctx the parse tree
	 */
	void enterKey(YamlParser.KeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link YamlParser#key}.
	 * @param ctx the parse tree
	 */
	void exitKey(YamlParser.KeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link YamlParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(YamlParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link YamlParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(YamlParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link YamlParser#value_scalar}.
	 * @param ctx the parse tree
	 */
	void enterValue_scalar(YamlParser.Value_scalarContext ctx);
	/**
	 * Exit a parse tree produced by {@link YamlParser#value_scalar}.
	 * @param ctx the parse tree
	 */
	void exitValue_scalar(YamlParser.Value_scalarContext ctx);
	/**
	 * Enter a parse tree produced by {@link YamlParser#multiline_string}.
	 * @param ctx the parse tree
	 */
	void enterMultiline_string(YamlParser.Multiline_stringContext ctx);
	/**
	 * Exit a parse tree produced by {@link YamlParser#multiline_string}.
	 * @param ctx the parse tree
	 */
	void exitMultiline_string(YamlParser.Multiline_stringContext ctx);
	/**
	 * Enter a parse tree produced by {@link YamlParser#string_literal}.
	 * @param ctx the parse tree
	 */
	void enterString_literal(YamlParser.String_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link YamlParser#string_literal}.
	 * @param ctx the parse tree
	 */
	void exitString_literal(YamlParser.String_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link YamlParser#string_folded}.
	 * @param ctx the parse tree
	 */
	void enterString_folded(YamlParser.String_foldedContext ctx);
	/**
	 * Exit a parse tree produced by {@link YamlParser#string_folded}.
	 * @param ctx the parse tree
	 */
	void exitString_folded(YamlParser.String_foldedContext ctx);
	/**
	 * Enter a parse tree produced by {@link YamlParser#string_double_quoted}.
	 * @param ctx the parse tree
	 */
	void enterString_double_quoted(YamlParser.String_double_quotedContext ctx);
	/**
	 * Exit a parse tree produced by {@link YamlParser#string_double_quoted}.
	 * @param ctx the parse tree
	 */
	void exitString_double_quoted(YamlParser.String_double_quotedContext ctx);
	/**
	 * Enter a parse tree produced by {@link YamlParser#mapping}.
	 * @param ctx the parse tree
	 */
	void enterMapping(YamlParser.MappingContext ctx);
	/**
	 * Exit a parse tree produced by {@link YamlParser#mapping}.
	 * @param ctx the parse tree
	 */
	void exitMapping(YamlParser.MappingContext ctx);
	/**
	 * Enter a parse tree produced by {@link YamlParser#flowlist}.
	 * @param ctx the parse tree
	 */
	void enterFlowlist(YamlParser.FlowlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link YamlParser#flowlist}.
	 * @param ctx the parse tree
	 */
	void exitFlowlist(YamlParser.FlowlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link YamlParser#flowmappinglist}.
	 * @param ctx the parse tree
	 */
	void enterFlowmappinglist(YamlParser.FlowmappinglistContext ctx);
	/**
	 * Exit a parse tree produced by {@link YamlParser#flowmappinglist}.
	 * @param ctx the parse tree
	 */
	void exitFlowmappinglist(YamlParser.FlowmappinglistContext ctx);
	/**
	 * Enter a parse tree produced by {@link YamlParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(YamlParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link YamlParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(YamlParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link YamlParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(YamlParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link YamlParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(YamlParser.IntegerContext ctx);
}
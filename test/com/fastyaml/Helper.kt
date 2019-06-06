package com.fastyaml

import com.fastyaml.ThrowingErrorListener
import com.fastyaml.YamlLexer
import com.fastyaml.YamlParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

/**
 * Created by Syed Umar Anis on 7/19/2017.
 */

fun getYamlParser(input: String) : YamlParser {
    val lexer = YamlLexer(CharStreams.fromString(input)); val tokens = CommonTokenStream(lexer); val parser = YamlParser(tokens)
    lexer.removeErrorListeners(); lexer.addErrorListener(ThrowingErrorListener.INSTANCE)
    parser.removeErrorListeners(); parser.addErrorListener(ThrowingErrorListener.INSTANCE)
    return parser
}
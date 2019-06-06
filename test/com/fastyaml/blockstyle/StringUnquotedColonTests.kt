package com.fastyaml.blockstyle

import com.fastyaml.YamlLexer
import com.fastyaml.YamlParser
import com.fastyaml.ast
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.junit.Assert.*
import org.junit.Test

/**
 * Created by Syed Umar Anis on 7/19/2017.
 */
class StringUnquotedColonTests {

    @Test
    fun startWithColon() {
        val input = "- :value"

        val lexer = YamlLexer(CharStreams.fromString(input)); val tokens = CommonTokenStream(lexer); val parser = YamlParser(tokens)

        val m = parser.file().ast()
        if(m is List<*>) {
            assertEquals(1, m.count())
            assertEquals(":value", m[0])
        }
        else
            fail()
    }

    @Test
    fun endsWithColon() {
        val input = "- value:"

        val lexer = YamlLexer(CharStreams.fromString(input)); val tokens = CommonTokenStream(lexer); val parser = YamlParser(tokens)

        val m = parser.file().ast()
        assertEquals(listOf(mapOf("value" to null)), m)
    }

    @Test
    fun colonInTheMiddle() {
        val input = "- val:ue"

        val lexer = YamlLexer(CharStreams.fromString(input)); val tokens = CommonTokenStream(lexer); val parser = YamlParser(tokens)

        val m = parser.file().ast()
        if(m is List<*>) {
            assertEquals(1, m.count())
            assertEquals("val:ue", m[0])
        }
        else
            fail()
    }

    @Test
    fun colonInTheMiddleWithSpace_Allowed() {
        val input = "- val : ue"

        val lexer = YamlLexer(CharStreams.fromString(input)); val tokens = CommonTokenStream(lexer); val parser = YamlParser(tokens)

        val m = parser.file().ast()
        if(m is List<*>) {
            assertEquals(1, m.count())
            assertEquals(mapOf("val" to "ue"), m[0])
        }
        else
            fail()
    }
}

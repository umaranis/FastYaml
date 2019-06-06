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
class StringUnquotedTests {

    @Test
    fun multipleWords() {
        val input = "- hello world"

        val lexer = YamlLexer(CharStreams.fromString(input)); val tokens = CommonTokenStream(lexer); val parser = YamlParser(tokens)

        val m = parser.file().ast()
        if(m is List<*>) {
            assertEquals(1, m.count())
            assertEquals("hello world", m[0])
        }
        else
            fail()
    }

    @Test
    fun multipleWords2() {
        val input = "- hello world 2"

        val lexer = YamlLexer(CharStreams.fromString(input)); val tokens = CommonTokenStream(lexer); val parser = YamlParser(tokens)

        val m = parser.file().ast()
        if(m is List<*>) {
            assertEquals(1, m.count())
            assertEquals("hello world 2", m[0])
        }
        else
            fail()
    }

    @Test
    fun multipleSpaces() {
        val input = "- hello    world 2"

        val lexer = YamlLexer(CharStreams.fromString(input)); val tokens = CommonTokenStream(lexer); val parser = YamlParser(tokens)

        val m = parser.file().ast()
        if(m is List<*>) {
            assertEquals(1, m.count())
            assertEquals("hello    world 2", m[0])
        }
        else
            fail()
    }

    @Test
    fun multipleSpacesInStart() {
        val input = "-      hello    world 2"

        val lexer = YamlLexer(CharStreams.fromString(input)); val tokens = CommonTokenStream(lexer); val parser = YamlParser(tokens)

        val m = parser.file().ast()
        if(m is List<*>) {
            assertEquals(1, m.count())
            assertEquals("hello    world 2", m[0])
        }
        else
            fail()
    }

    @Test
    fun multipleSpacesInEnd() {
        val input = "- hello    world 2     "

        val lexer = YamlLexer(CharStreams.fromString(input)); val tokens = CommonTokenStream(lexer); val parser = YamlParser(tokens)

        val m = parser.file().ast()
        if(m is List<*>) {
            assertEquals(1, m.count())
            assertEquals("hello    world 2", m[0])
        }
        else
            fail()
    }

}

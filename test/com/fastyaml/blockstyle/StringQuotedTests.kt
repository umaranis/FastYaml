package com.fastyaml.blockstyle

import com.fastyaml.YamlLexer
import com.fastyaml.YamlParser
import com.fastyaml.ast
import com.fastyaml.getYamlParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.junit.Assert
import org.junit.Test

/**
 * Created by Syed Umar Anis on 7/19/2017.
 */
class StringQuotedTests {

    @Test
    fun quotedString() {
        val input = """unicode: "Sosa did fine.""""

        val lexer = YamlLexer(CharStreams.fromString(input)); val tokens = CommonTokenStream(lexer); val parser = YamlParser(tokens)

        val m = parser.file().ast()
        if(m is Map<*,*>) {
            Assert.assertEquals(1, m.count())
            Assert.assertEquals("Sosa did fine.", m["unicode"])
        }
        else
            Assert.fail()
    }

    @Test
    fun quotedString_AmongUnquoted() {
        val input =
"""key1: Sosa did fine.
key2: "Sosa did fine."
key3: Sosa did fine.
"""

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if(m is Map<*,*>) {
            Assert.assertEquals(3, m.count())
            Assert.assertEquals(mapOf("key1" to "Sosa did fine.", "key2" to "Sosa did fine.", "key3" to "Sosa did fine."), m)
        }
        else
            Assert.fail()
    }

    @Test
    fun quotedString_MultiLine() {
        val input =
"""unicode: "Sosa
 did fine.""""

        val lexer = YamlLexer(CharStreams.fromString(input)); val tokens = CommonTokenStream(lexer); val parser = YamlParser(tokens)

        val m = parser.file().ast()
        if(m is Map<*,*>) {
            Assert.assertEquals(1, m.count())
            Assert.assertEquals("Sosa did fine.", m["unicode"])
        }
        else
            Assert.fail()
    }

    @Test
    fun quotedString_MultiLine_Newlines() {
        val input =
"""unicode: "Sosa


 did fine.""""

        val lexer = YamlLexer(CharStreams.fromString(input)); val tokens = CommonTokenStream(lexer); val parser = YamlParser(tokens)

        val m = parser.file().ast()
        if(m is Map<*,*>) {
            Assert.assertEquals(1, m.count())
            Assert.assertEquals("Sosa\n\ndid fine.", m["unicode"])
        }
        else
            Assert.fail()
    }

    //TODO: running below test hangs the process, fix it
    /*@Test
    fun unicode() {
        val input = """unicode: "Sosa did fine.\u263A"""

        val lexer = YamlLexer(CharStreams.fromString(input)); val tokens = CommonTokenStream(lexer); val parser = YamlParser(tokens)

        val m = parser.file().ast()
        if(m is Map<*,*>) {
            Assert.assertEquals(1, m.count())
            Assert.assertEquals("hello world", m["unicode"])
        }
        else
            Assert.fail()
    }*/

}
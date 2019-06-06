package com.fastyaml.blockstyle

import com.fastyaml.*
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.junit.Assert.*
import org.junit.Test

/**
 * Created by Syed Umar Anis on 7/19/2017.
 */
class StringUnquotedDashTests {

    @Test
    fun startWithDash() {
        val input = "- -value"

        val lexer = YamlLexer(CharStreams.fromString(input)); val tokens = CommonTokenStream(lexer); val parser = YamlParser(tokens)

        val m = parser.file().ast()
        if(m is List<*>) {
            assertEquals(1, m.count())
            assertEquals("-value", m[0])
        }
        else
            fail()
    }

    @Test
    fun startWithDashSpace_NotAllowed() {
        val input = "- - value"

        val parser = getYamlParser(input)

        val m = parser.file().ast() //throws exception
        if(m is List<*>) {
            assertEquals(1, m.count())
            assertEquals(listOf("value"), m[0])
        }
        else
            fail()
    }

    @Test
    fun endsWithDash() {
        val input = "- value-"

        val lexer = YamlLexer(CharStreams.fromString(input)); val tokens = CommonTokenStream(lexer); val parser = YamlParser(tokens)

        val m = parser.file().ast()
        if(m is List<*>) {
            assertEquals(1, m.count())
            assertEquals("value-", m[0])
        }
        else
            fail()
    }

    @Test
    fun dashInTheMiddle() {
        val input = "- val-ue"

        val lexer = YamlLexer(CharStreams.fromString(input)); val tokens = CommonTokenStream(lexer); val parser = YamlParser(tokens)

        val m = parser.file().ast()
        if(m is List<*>) {
            assertEquals(1, m.count())
            assertEquals("val-ue", m[0])
        }
        else
            fail()
    }

    @Test
    fun dashInTheMiddleWithSpace() {
        val input = "- val - ue"

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if(m is List<*>) {
            assertEquals(1, m.count())
            assertEquals("val - ue", m[0])
        }
        else
            fail()
    }

    @Test
    fun doubleDashAtStart() {
        val input = "- --value"

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if(m is List<*>) {
            assertEquals(1, m.count())
            assertEquals("--value", m[0])
        }
        else
            fail()
    }

    @Test
    fun tripleDashAtStart() {
        val input = "- ---value"

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if(m is List<*>) {
            assertEquals(1, m.count())
            assertEquals("---value", m[0])
        }
        else
            fail()
    }

    @Test
    fun fourDashAtStart() {
        val input = "- ----value"

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if(m is List<*>) {
            assertEquals(1, m.count())
            assertEquals("----value", m[0])
        }
        else
            fail()
    }

    @Test
    fun doubleDashAsValue() {
        val input = "- --"

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if(m is List<*>) {
            assertEquals(1, m.count())
            assertEquals("--", m[0])
        }
        else
            fail()
    }

    @Test
    fun tripleDashAsValue() {
        val input = "- ---"

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if(m is List<*>) {
            assertEquals(1, m.count())
            assertEquals("---", m[0])
        }
        else
            fail()
    }

    @Test
    fun fourDashAsValue() {
        val input = "- ----"

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if(m is List<*>) {
            assertEquals(1, m.count())
            assertEquals("----", m[0])
        }
        else
            fail()
    }
}

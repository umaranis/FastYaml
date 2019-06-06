package com.fastyaml.blockstyle

import com.fastyaml.YamlLexer
import com.fastyaml.YamlParser
import com.fastyaml.ast
import com.fastyaml.getYamlParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.junit.Assert.*
import org.junit.Test

/**
 * Created by Syed Umar Anis on 6/5/2017.
 */
class SimpleListTests {

    @Test
    fun OneItem() {
        val input =
                """- one"""

        val lexer = YamlLexer(CharStreams.fromString(input)); val tokens = CommonTokenStream(lexer); val parser = YamlParser(tokens)

        val c = parser.file().ast()
        if(c is List<*>) {
            assertEquals(1, c.count())
            assertEquals("one", c[0])
        }
        else
            fail()
    }

    @Test
    fun ListTest1() {
        val input =
"""- po
- pr
- rfq"""

        val lexer = YamlLexer(CharStreams.fromString(input)); val tokens = CommonTokenStream(lexer); val parser = YamlParser(tokens)

        val c = parser.file().ast()
        if(c is List<*>) {
            assertEquals(3, c.count())
            assertEquals("po", c[0])
        }
        else
            fail()
    }

    @Test
    fun ListTest_BeginWithNewline() {
        val input = "\n" +
                    "- po\n" +
                    "- pr\n" +
                    "- rfq"

        val lexer = YamlLexer(CharStreams.fromString(input)); val tokens = CommonTokenStream(lexer); val parser = YamlParser(tokens)

        val c = parser.file().ast()
        if(c is List<*>) {
            assertEquals(3, c.count())
            assertEquals("po", c[0])
        }
        else
            fail()
    }

    @Test
    fun ListTest_EndWithNewline() {
        val input = "\n" +
                "- po\n" +
                "- pr\n" +
                "- rfq\n"

        val lexer = YamlLexer(CharStreams.fromString(input)); val tokens = CommonTokenStream(lexer); val parser = YamlParser(tokens)

        val c = parser.file().ast()
        if(c is List<*>) {
            assertEquals(3, c.count())
            assertEquals("po", c[0])
        }
        else
            fail()
    }

    @Test
    fun ListTest_NewlineInBetween() {
        val input = "\n" +
                "- po\n\n" +
                "- pr\n" +
                "- rfq\n"

        val lexer = YamlLexer(CharStreams.fromString(input)); val tokens = CommonTokenStream(lexer); val parser = YamlParser(tokens)

        val c = parser.file().ast()
        if(c is List<*>) {
            assertEquals(3, c.count())
            assertEquals("po", c[0])
        }
        else
            fail()
    }

    @Test
    fun ListTest_3NewlineInBetween() {
        val input = "\n" +
                "- po\n\n\n\n" +
                "- pr\n" +
                "- rfq\n"

        val lexer = YamlLexer(CharStreams.fromString(input)); val tokens = CommonTokenStream(lexer); val parser = YamlParser(tokens)

        val c = parser.file().ast()
        if(c is List<*>) {
            assertEquals(3, c.count())
            assertEquals("po", c[0])
        }
        else
            fail()
    }

    @Test
    fun listOfNumbers() {
        val input =
"""- 1
- 2
- 3"""

        val parser = getYamlParser(input)

        val c = parser.file().ast()
        if(c is List<*>) {
            assertEquals(3, c.count())
            assertEquals(1, c[0])
        }
        else
            fail()
    }

    @Test
    fun listWithNulls() {
        val input =
"""- 1
-
- 3"""

        val parser = getYamlParser(input)

        val c = parser.file().ast()
        if(c is List<*>) {
            assertEquals(3, c.count())
            assertEquals(listOf(1, null, 3), c)
        }
        else
            fail()
    }

    @Test
    fun listWithNullAtTheEnd() {
        val input =
"""- 1
-
-
"""

        val parser = getYamlParser(input)

        val c = parser.file().ast()
        if(c is List<*>) {
            assertEquals(3, c.count())
            assertEquals(listOf(1, null, null), c)
        }
        else
            fail()
    }

    @Test
    fun listWithNullAtTheEndWithoutNewline() {
        val input =
"""- 1
-
-"""

        val parser = getYamlParser(input)

        val c = parser.file().ast()
        if(c is List<*>) {
            assertEquals(3, c.count())
            assertEquals(listOf(1, null, null), c)
        }
        else
            fail()
    }
}

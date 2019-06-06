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
class StringUnquotedMultilineTests {

    @Test
    fun valueOnNextLine() {
        val input =
"""-
  world"""

        val lexer = YamlLexer(CharStreams.fromString(input)); val tokens = CommonTokenStream(lexer); val parser = YamlParser(tokens)

        val m = parser.file().ast()
        if(m is List<*>) {
            assertEquals(1, m.count())
            assertEquals("world", m[0])
        }
        else
            fail()
    }


    @Test
    fun valueOnNextLinePlusSpace() {
        val input =
"""-
  world"""

        val lexer = YamlLexer(CharStreams.fromString(input)); val tokens = CommonTokenStream(lexer); val parser = YamlParser(tokens)

        val m = parser.file().ast()
        if(m is List<*>) {
            assertEquals(1, m.count())
            assertEquals("world", m[0])
        }
        else
            fail()
    }


    @Test
    fun valueAfterManyNewLines() {
        val input =
"""-



  world"""

        val lexer = YamlLexer(CharStreams.fromString(input)); val tokens = CommonTokenStream(lexer); val parser = YamlParser(tokens)

        val m = parser.file().ast()
        if(m is List<*>) {
            assertEquals(1, m.count())
            assertEquals("world", m[0])
        }
        else
            fail()
    }

    @Test
    fun twoLines() {
        val input =
"""- hello
   world"""

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
    fun fiveLines() {
        val input =
"""- YAML
  Ain't
  Markup
  Language

  """

        val lexer = YamlLexer(CharStreams.fromString(input)); val tokens = CommonTokenStream(lexer); val parser = YamlParser(tokens)

        val m = parser.file().ast()
        if(m is List<*>) {
            assertEquals(1, m.count())
            assertEquals("YAML Ain't Markup Language", m[0])
        }
        else
            fail()
    }


    @Test
    fun stringsWithIndentsInside() {
        val input =
"""- YAML
    Ain't
      Markup
        Language

  """

        val lexer = YamlLexer(CharStreams.fromString(input)); val tokens = CommonTokenStream(lexer); val parser = YamlParser(tokens)

        val m = parser.file().ast()
        if(m is List<*>) {
            assertEquals(1, m.count())
            assertEquals("YAML Ain't Markup Language", m[0])
        }
        else
            fail()
    }


    @Test
    fun stringsWithIndentsDedentsInside() {
        val input =
"""- YAML
    is
       a
    human
      friendly
        data
    serialization
    standard
    for all
     programming
       languages.

  """

        val lexer = YamlLexer(CharStreams.fromString(input)); val tokens = CommonTokenStream(lexer); val parser = YamlParser(tokens)

        val m = parser.file().ast()
        if(m is List<*>) {
            assertEquals(1, m.count())
            assertEquals("YAML is a human friendly data serialization standard for all programming languages.", m[0])
        }
        else
            fail()
    }


    /**
     * Might confuse indent generation
     */
    @Test
    fun emptyLineWithSpaces() {
        val input =
"""- yaml: hello

   world
  """

        val lexer = YamlLexer(CharStreams.fromString(input)); val tokens = CommonTokenStream(lexer); val parser = YamlParser(tokens)

        val m = parser.file().ast()
        if(m is List<*>) {
            assertEquals(1, m.count())
            assertEquals(mapOf("yaml" to "hello world"), m[0])
        }
        else
            fail()
    }

}

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
class StringLiteralTests {

    @Test
    fun literalStyle() {
        val input =
"""- |
  hello world"""


        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if(m is List<*>) {
            Assert.assertEquals(1, m.count())
            Assert.assertEquals("hello world", m[0])
        }
        else
            Assert.fail()
    }

    @Test
    fun mapping() {
        val input =
"""- |
 key: value"""


        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if(m is List<*>) {
            Assert.assertEquals(1, m.count())
            Assert.assertEquals("key: value", m[0])
        }
        else
            Assert.fail()
    }

    @Test
    fun multiline() {
        val input =
"""- |
 line 1
  line 2
   line 3
 line 4"""


        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if(m is List<*>) {
            Assert.assertEquals(1, m.count())
            Assert.assertEquals("line 1\n line 2\n  line 3\nline 4", m[0])
        }
        else
            Assert.fail()
    }

    @Test
    fun emptyLines() {
        val input =
"""- |

 line 1


  line 2

   line 3


 line 4"""


        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if(m is List<*>) {
            Assert.assertEquals(1, m.count())
            Assert.assertEquals("\nline 1\n\n\n line 2\n\n  line 3\n\n\nline 4", m[0])
        }
        else
            Assert.fail()
    }

    @Test
    fun emptyLines_WithSpaces() {
        val input ="- |\n line 1\n \n  line 2\n\n       line 3\n\n \n line 4"

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if(m is List<*>) {
            Assert.assertEquals(1, m.count())
            Assert.assertEquals("line 1\n\n line 2\n\n      line 3\n\n\nline 4", m[0])
        }
        else
            Assert.fail()
    }

    @Test
    fun twoListItems() {
        val input =
"""- |
 line 1
  line 2
   line 3
 line 4
- |
 second item
 2 lines"""


        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if(m is List<*>) {
            Assert.assertEquals(2, m.count())
            Assert.assertEquals("line 1\n line 2\n  line 3\nline 4", m[0])
        }
        else
            Assert.fail()
    }

    @Test
    fun twoMappings() {
        val input =
"""key1: |
 line 1
  line 2
   line 3
 line 4
key2: |
 second item
 2 lines"""


        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if(m is Map<*,*>) {
            Assert.assertEquals(2, m.count())
            Assert.assertEquals("line 1\n line 2\n  line 3\nline 4", m["key1"])
            Assert.assertEquals("second item\n2 lines", m["key2"])
        }
        else
            Assert.fail()
    }

    @Test
    fun dedentAfterString() {
        val input =
"""
key1:
  key2:
    key3: |
      line 1
        line 2
          line 3
      line 4
key4: |
 second item
 2 lines"""


        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if(m is Map<*,*>) {
            Assert.assertEquals(2, m.count())
            Assert.assertEquals(mapOf("key2" to mapOf("key3" to "line 1\n  line 2\n    line 3\nline 4")), m["key1"])
            Assert.assertEquals("second item\n2 lines", m["key4"])
        }
        else
            Assert.fail()
    }

}
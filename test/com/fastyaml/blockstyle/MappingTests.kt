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
 * Created by Syed Umar Anis on 6/14/2017.
 */
class MappingTests {

    @Test
    fun mapping() {
        val input = "key : value"

        val lexer = YamlLexer(CharStreams.fromString(input)); val tokens = CommonTokenStream(lexer); val parser = YamlParser(tokens)

        val m = parser.file().ast()
        if(m is Map<*,*>) {
            assertEquals(1, m.count())
            assertEquals("value", m["key"])
        }
        else
            fail()
    }

    @Test
    fun mapping_singleChar() {
        val input = "k : v"

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if(m is Map<*,*>) {
            assertEquals(1, m.count())
            assertEquals("v", m["k"])
        }
        else
            fail()
    }

    @Test
    fun mapping_keyWithNoSpace() {
        val input = "key: value"

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if(m is Map<*,*>) {
            assertEquals(1, m.count())
            assertEquals("value", m["key"])
        }
        else
            fail()
    }

    @Test
    fun mapping_noSpace() {
        val input = "key:value" //not valid as space is required after colon

        val lexer = YamlLexer(CharStreams.fromString(input)); val tokens = CommonTokenStream(lexer); val parser = YamlParser(tokens)

        val m = parser.file().ast()
        if(m is String) {
            assertEquals("key:value", m)
        }
        else {
            fail()
        }
    }

    @Test
    fun mapping_noSpaceList() {
        val input = "- key:value"

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if(m is List<*>) {
            assertEquals(1, m.count())
            assertEquals("key:value", m[0])
        }
        else
            fail()
    }

    @Test
    fun mapping_noSpaceListSingleChar() {
        val input = "- k:v"

        val lexer = YamlLexer(CharStreams.fromString(input)); val tokens = CommonTokenStream(lexer); val parser = YamlParser(tokens)

        val m = parser.file().ast()
        if(m is List<*>) {
            assertEquals(1, m.count())
            assertEquals("k:v", m[0])
        }
        else
            fail()
    }

    @Test
    fun mapping_noSpaceListSingleCharKey() {
        val input = "- k:value"

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if(m is List<*>) {
            assertEquals(1, m.count())
            assertEquals("k:value", m[0])
        }
        else
            fail()
    }

    @Test
    fun mapping_noSpaceListSingleCharValue() {
        val input = "- key:v"

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if(m is List<*>) {
            assertEquals(1, m.count())
            assertEquals("key:v", m[0])
        }
        else
            fail()
    }

    @Test
    fun mappingList() {
        val input =
"""key1: value1
key2 : value2"""

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if(m is Map<*,*>) {
            assertEquals(2, m.count())
            assertEquals(m, mapOf("key1" to "value1", "key2" to "value2"))
        }
        else
            fail()
    }

    @Test
    fun mappingListWithNewLineStart() {
        val input =
"""
key1: value1
key2 : value2"""

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if(m is Map<*,*>) {
            assertEquals(2, m.count())
            assertEquals(m, mapOf("key1" to "value1", "key2" to "value2"))
        }
        else
            fail()
    }

    @Test
    fun mappingListWithNewLineEnd() {
        val input =
"""key1: value1
key2 : value2
"""

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if(m is Map<*,*>) {
            assertEquals(2, m.count())
            assertEquals(m, mapOf("key1" to "value1", "key2" to "value2"))
        }
        else
            fail()
    }

    @Test
    fun mappingListWithNewLineMiddle() {
        val input =
"""key1: value1

key2 : value2"""

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if(m is Map<*,*>) {
            assertEquals(2, m.count())
            assertEquals(m, mapOf("key1" to "value1", "key2" to "value2"))
        }
        else
            fail()
    }

    @Test
    fun mappingListWithNewLines() {
        val input =
"""

key1: value1


key2 : value2

"""

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if(m is Map<*,*>) {
            assertEquals(2, m.count())
            assertEquals(m, mapOf("key1" to "value1", "key2" to "value2"))
        }
        else
            fail()
    }

}
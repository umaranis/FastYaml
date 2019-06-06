package com.fastyaml.blockstyle

import com.fastyaml.ast
import com.fastyaml.getYamlParser
import org.junit.Assert
import org.junit.Test

/**
 * Created by Syed Umar Anis on 6/5/2017.
 */
class ScalarDocumentTests {

    @Test
    fun StringScalar() {
        var input =
"""---
Hello World
"""

        val parser = getYamlParser(input)

        val c = parser.file().ast()
        if(c is String) {
            Assert.assertEquals("Hello World", c)
        }
        else
            Assert.fail()
    }

    @Test
    fun StringMultilineScalar1() {
        var input =
"""---
Hello
World
"""

        val parser = getYamlParser(input)

        val c = parser.file().ast()
        if(c is String) {
            Assert.assertEquals("Hello World", c)
        }
        else
            Assert.fail()
    }

    @Test
    fun StringMultilineScalar2() {
        var input =
"""---
Hello
 World
"""

        val parser = getYamlParser(input)

        val c = parser.file().ast()
        if(c is String) {
            Assert.assertEquals("Hello World", c)
        }
        else
            Assert.fail()
    }

    @Test
    fun StringMultilineScalar3() {
        var input =
"""---
 Hello
 World
"""

        val parser = getYamlParser(input)

        val c = parser.file().ast()
        if(c is String) {
            Assert.assertEquals("Hello World", c)
        }
        else
            Assert.fail()
    }

    @Test
    fun ValueOnDocumentStartLine() {
        var input =
"""--- Hello
 World
"""

        val parser = getYamlParser(input)

        val c = parser.file().ast()
        if(c is String) {
            Assert.assertEquals("Hello World", c)
        }
        else
            Assert.fail()
    }

    @Test
    fun DocumentStartIndicatorAsValue() {
        var input =
"""- ---"""

        val parser = getYamlParser(input)

        val c = parser.file().ast()
        if(c is List<*>) {
            Assert.assertEquals(listOf("---"), c)
        }
        else
            Assert.fail()
    }

    @Test
    fun DocumentEndIndicatorAsValue() {
        var input =
                """- ..."""

        val parser = getYamlParser(input)

        val c = parser.file().ast()
        if(c is List<*>) {
            Assert.assertEquals(listOf("..."), c)
        }
        else
            Assert.fail()
    }

}


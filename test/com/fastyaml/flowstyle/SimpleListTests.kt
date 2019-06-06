package com.fastyaml.flowstyle

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
    fun ListTest1() {
        val input =
"""[name, hr, avg  ]"""

        val parser = getYamlParser(input)

        val c = parser.file().ast()
        if(c is List<*>) {
            assertEquals(3, c.count())
            assertEquals(listOf("name","hr","avg"), c)
        }
        else
            fail()
    }

}

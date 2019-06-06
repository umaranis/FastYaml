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
class MappingInsideListTests {

    @Test
    fun oneMapping() {
        val input =
"""-
  key: value"""

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if(m is List<*>) {
            assertEquals(1, m.count())
            assertEquals(listOf(mapOf("key" to "value")), m)
        }
        else
            fail()
    }

    @Test
    fun oneMappingSameLine() {
        val input = "- key: value"

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if(m is List<*>) {
            assertEquals(1, m.count())
            assertEquals(listOf(mapOf("key" to "value")), m)
        }
        else
            fail()
    }

}
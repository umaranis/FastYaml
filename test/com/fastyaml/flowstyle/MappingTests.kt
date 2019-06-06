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
 * Created by Syed Umar Anis on 6/14/2017.
 */
class MappingTests {

    @Test
    fun mapping() {
        val input = "{hr: 65, avg: 0.278}"

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if(m is Map<*,*>) {
            assertEquals(2, m.count())
            assertEquals(mapOf("hr" to 65, "avg" to 0.278), m)
        }
        else
            fail()
    }

    @Test
    fun mappingInsideBlock() {
        val input = "Mark McGwire: {hr: 65, avg: 0.278}"

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if(m is Map<*,*>) {
            assertEquals(1, m.count())
            assertEquals(mapOf("Mark McGwire" to mapOf("hr" to 65, "avg" to 0.278)), m)
        }
        else
            fail()
    }
}
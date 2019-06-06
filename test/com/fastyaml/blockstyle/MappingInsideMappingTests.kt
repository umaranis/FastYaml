package com.fastyaml.blockstyle

import com.fastyaml.ast
import com.fastyaml.getYamlParser
import org.junit.Assert
import org.junit.Test

/**
 * Created by Syed Umar Anis on 6/14/2017.
 */
class MappingInsideMappingTests {

    @Test
    fun oneMapping() {
        val input =
"""
key1:
  key1.1:
    key1.1.1: value1
key2: this is second value"""

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if(m is Map<*,*>) {
            Assert.assertEquals(2, m.count())
            Assert.assertEquals(mapOf("key1" to mapOf("key1.1" to mapOf("key1.1.1" to "value1")), "key2" to "this is second value" ), m)
        }
        else
            Assert.fail()
    }

}
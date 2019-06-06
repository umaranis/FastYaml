package com.fastyaml.blockstyle

import com.fastyaml.ast
import com.fastyaml.getYamlParser
import org.junit.Assert
import org.junit.Test

/**
 * Created by Syed Umar Anis on 6/5/2017.
 */
class DataTypeTests {

    @Test
    fun Integer() {
        var input =
"""points: 6"""

        val parser = getYamlParser(input)

        val c = parser.file().ast()
        if(c is Map<*,*>) {
            Assert.assertEquals(mapOf("points" to 6), c)
            Assert.assertTrue(c["points"] is Integer)
        }
        else
            Assert.fail()
    }


    @Test
    fun Integer_Newline() {
        var input =
"""points:
 6"""

        val parser = getYamlParser(input)

        val c = parser.file().ast()
        if(c is Map<*,*>) {
            Assert.assertEquals(mapOf("points" to 6), c)
            Assert.assertTrue(c["points"] is Integer)
        }
        else
            Assert.fail()
    }

    @Test
    fun Integer_Newline2() {
        var input =
"""points:
 6
max: 10"""

        val parser = getYamlParser(input)

        val c = parser.file().ast()
        if(c is Map<*,*>) {
            Assert.assertEquals(mapOf("points" to 6, "max" to 10), c)
            Assert.assertTrue(c["points"] is Integer)
        }
        else
            Assert.fail()
    }

}
package com.fastyaml.blockstyle

import com.fastyaml.ast
import com.fastyaml.getYamlParser
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Test

/**
 * Created by Syed Umar Anis on 6/5/2017.
 */
class ComplexListTests {

    @Test
    fun ListWithinList() {
        var input =
"""- po
- pr
-
  - pr1
  - pr2
- rfq"""

        val parser = getYamlParser(input)

        val c = parser.file().ast()
        if(c is List<*>) {
            assertEquals(4, c.count())
            assertEquals("po", c[0])
            assertEquals("pr2", (c[2] as List<*>)[1])
        }
        else
            fail()
    }

    @Test
    fun ListWithinList2() {
        var input =
"""- po
- pr
-
  - pr1
  - pr2
  -
    - hi1
    - hi2
- rfq"""

        val parser = getYamlParser(input)

        val c = parser.file().ast()
        if(c is List<*>) {
            assertEquals(4, c.count())
            assertEquals("po", c[0])
            assertEquals("pr2", (c[2] as List<*>)[1])
            assertEquals("hi1", ((c[2] as List<*>)[2] as List<*>)[0])
        }
        else
            fail()
    }

    @Test
    fun ListWithinList3() {
        var input =
"""- po
- pr
-
  - pr1
  - pr2
  -
    - hi1
    - hi2
    -
      - li1"""

        val parser = getYamlParser(input)

        val c = parser.file().ast()
        if(c is List<*>) {
            assertEquals(3, c.count())
            assertEquals("po", c[0])
            assertEquals("pr2", (c[2] as List<*>)[1])
            assertEquals("hi1", ((c[2] as List<*>)[2] as List<*>)[0])
            assertEquals("li1", (((c[2] as List<*>)[2] as List<*>)[2] as List<*>)[0])
        }
        else
            fail()
    }

    @Test
    fun ListWithinListWithNewline() {
        var input =
"""- po
- pr
-



  - pr1
  - pr2
- rfq"""

        val parser = getYamlParser(input)

        val c = parser.file().ast()
        if(c is List<*>) {
            assertEquals(4, c.count())
            assertEquals("po", c[0])
            assertEquals("pr2", (c[2] as List<*>)[1])
        }
        else
            fail()
    }

    @Test
    fun DedentThreeLevelsDown() {
        var input =
"""-
  -
    -
      - very deep
- shallow"""

        val parser = getYamlParser(input)

        val c = parser.file().ast()
        if(c is List<*>) {
            assertEquals(2, c.count())
            assertEquals(listOf(listOf(listOf(listOf("very deep"))), "shallow"), c)
        }
        else
            fail()
    }

    @Test
    fun TwoListsOnOneLine() {
        var input =
"""- - list inside list"""

        val parser = getYamlParser(input)

        val c = parser.file().ast()
        if(c is List<*>) {
            assertEquals(1, c.count())
            assertEquals(listOf(listOf("list inside list")), c)
        }
        else
            fail()
    }

    @Test
    fun FiveListsOnOneLine() {
        var input =
                """- - - - - list inside list"""

        val parser = getYamlParser(input)

        val c = parser.file().ast()
        if(c is List<*>) {
            assertEquals(1, c.count())
            assertEquals(listOf(listOf(listOf(listOf(listOf("list inside list"))))), c)
        }
        else
            fail()
    }



}

package com.fastyaml

import com.fastyaml.ast
import com.fastyaml.getYamlParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Test

/**
 * Tests for examples from Yaml Specification 2.1
 * Created by Syed Umar Anis on 7/20/2017.
 */
class SpecTests {

    @Test
    fun  e2_1_SequenceOfScalars() {
        val input =
"""- Mark McGwire
- Sammy Sosa
- Ken Griffey"""

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if (m is List<*>) {
            assertEquals(m, listOf("Mark McGwire", "Sammy Sosa", "Ken Griffey"))
            assertEquals(3, m.count())
        } else
            fail()
    }

    @Test
    fun e2_2_MappingScalarsToScalars() {
        val input =
"""hr:  65    # Home runs
avg: 0.278 # Batting average
rbi: 147   # Runs Batted In"""

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if (m is Map<*,*>) {
            assertEquals(mapOf("hr" to 65, "avg" to 0.278, "rbi" to 147), m)
            assertEquals(3, m.count())
        } else
            fail()
    }

    @Test
    fun  e2_3_MappingScalarsToSequences() {
        val input =
"""american:
  - Boston Red Sox
  - Detroit Tigers
  - New York Yankees
national:
  - New York Mets
  - Chicago Cubs
  - Atlanta Braves"""

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if (m is Map<*,*>) {
            assertEquals(mapOf("american" to listOf("Boston Red Sox", "Detroit Tigers", "New York Yankees"), "national" to listOf("New York Mets", "Chicago Cubs", "Atlanta Braves")), m)
            assertEquals(2, m.count())
        } else
            fail()
    }

    @Test
    fun  e2_4_SequenceOfMappings() {
        val input =
"""-
  name: Mark McGwire
  hr:   65
  avg:  0.278
-
  name: Sammy Sosa
  hr:   63
  avg:  0.288"""

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if (m is List<*>) {
            assertEquals(listOf(mapOf("name" to "Mark McGwire", "hr" to 65, "avg" to 0.278), mapOf("name" to "Sammy Sosa", "hr" to 63, "avg" to 0.288)), m)
            assertEquals(2, m.count())
        } else
            fail()
    }

    @Test
    fun  e2_5_SequenceOfSequences() {
        val input =
"""- [name        , hr, avg  ]
- [Mark McGwire, 65, 0.278]
- [Sammy Sosa  , 63, 0.288]"""

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if (m is List<*>) {
            assertEquals(listOf(
                    listOf("name", "hr", "avg"),
                    listOf("Mark McGwire", 65, 0.278),
                    listOf("Sammy Sosa", 63, 0.288)
                    ), m)
            assertEquals(3, m.count())
        } else
            fail()
    }

    @Test
    fun  e2_6_MappingOfMappings() {
        val input =
"""Mark McGwire: {hr: 65, avg: 0.278}
Sammy Sosa: {
    hr: 63,
    avg: 0.288
  }"""

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if (m is Map<*,*>) {
            assertEquals(mapOf(
                    "Mark McGwire" to mapOf("hr" to 65, "avg" to 0.278),
                    "Sammy Sosa" to mapOf("hr" to 63, "avg" to 0.288)
            ), m)
            assertEquals(2, m.count())
        } else
            fail()
    }

    @Test
    fun  e2_7_TwoDocumentsInAStream_EachWithALeadingComment() {
        val input =
"""# Ranking of 1998 home runs
---
- Mark McGwire
- Sammy Sosa
- Ken Griffey

# Team ranking
---
- Chicago Cubs
- St Louis Cardinals"""

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if (m is List<*>) {
            assertEquals(listOf(
                    listOf("Mark McGwire", "Sammy Sosa", "Ken Griffey"),
                    listOf("Chicago Cubs", "St Louis Cardinals"))
                    , m)
            assertEquals(2, m.count())
        } else
            fail()
    }

    @Test
    fun  e2_8_PlayByPlayFeedFromAGame() {
        val input =
"""---
time: 20:03:20
player: Sammy Sosa
action: strike (miss)
...
---
time: 20:03:47
player: Sammy Sosa
action: grand slam
..."""

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if (m is List<*>) {
            assertEquals(listOf(
                    mapOf("time" to "20:03:20", "player" to "Sammy Sosa", "action" to "strike (miss)"),
                    mapOf("time" to "20:03:47", "player" to "Sammy Sosa", "action" to "grand slam"))
                    , m)
            assertEquals(2, m.count())
        } else
            fail()
    }

    @Test
    fun  e2_9_SingleDocumentWithTwoComments() {
        val input =
"""---
hr: # 1998 hr ranking
  - Mark McGwire
  - Sammy Sosa
rbi:
  # 1998 rbi ranking
  - Sammy Sosa
  - Ken Griffey"""

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if (m is Map<*,*>) {
            assertEquals(mapOf(
                    "hr" to listOf("Mark McGwire", "Sammy Sosa"),
                    "rbi" to listOf("Sammy Sosa", "Ken Griffey"))
                    , m)
            assertEquals(2, m.count())
        } else
            fail()
    }

    @Test
    fun  e2_10_NodeAppearsTwiceInThisDocument() {
        val input =
"""---
hr:
  - Mark McGwire
  # Following node labeled SS
  - &SS Sammy Sosa
rbi:
  - *SS # Subsequent occurrence
  - Ken Griffey"""

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if (m is Map<*,*>) {
            assertEquals(mapOf(
                    "hr" to listOf("Mark McGwire", "Sammy Sosa"),
                    "rbi" to listOf("Sammy Sosa", "Ken Griffey"))
                    , m)
            assertEquals(2, m.count())
        } else
            fail()
    }

    @Test
    fun  e2_11_MappingBetweenSequences() {
        val input =
"""? - Detroit Tigers
  - Chicago cubs
:
  - 2001-07-23

? [ New York Yankees,
    Atlanta Braves ]
: [ 2001-07-02, 2001-08-12,
    2001-08-14 ]"""

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if (m is Map<*,*>) {
            assertEquals(mapOf(
                    "hr" to listOf("Mark McGwire", "Sammy Sosa"),
                    "rbi" to listOf("Sammy Sosa", "Ken Griffey"))
                    , m)
            assertEquals(2, m.count())
        } else
            fail()
    }


    @Test
    fun  e2_12_CompactNestedMapping() {
        val input =
"""---
# Products purchased
- item    : Super Hoop
  quantity: 1
- item    : Basketball
  quantity: 4
- item    : Big Shoes
  quantity: 1"""

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if (m is List<*>) {
            assertEquals(listOf(
                    mapOf("item" to "Super Hoop", "quantity" to 1),
                    mapOf("item" to "Basketball", "quantity" to 4),
                    mapOf("item" to "Big Shoes", "quantity" to 1))
                    , m)
            assertEquals(3, m.count())
        } else
            fail()
    }


    @Test
    fun  e2_13_InLiteralsNewlinesArePreserved() {
        val input =
"""# ASCII Art
--- |
  \//||\/||
  // ||  ||__
"""

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if (m is String) {
            assertEquals("""\//||\/||
// ||  ||__"""
                    , m)
        } else
            fail()
    }

    @Test
    fun  e2_14_FoldedScalars() {
        val input =
"""--- >
  Mark McGwire's
  year was crippled
  by a knee injury."""

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if (m is String) {
            assertEquals("""Mark McGwire's year was crippled by a knee injury.""", m)
        } else
            fail()
    }

    @Test
    fun  e2_15_FoldedNewlinesPreservedForIndentedAndBlankLines() {
        val input =
""">
 Sammy Sosa completed another
 fine season with great stats.

   63 Home Runs
   0.288 Batting Average

 What a year!
"""

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if (m is String) {
            assertEquals(
"""Sammy Sosa completed another fine season with great stats.

  63 Home Runs
  0.288 Batting Average
What a year!""", m)
        } else
            fail()
    }

    @Test
    fun  e2_16_IndentationDeterminesScope() {
        val input =
"""name: Mark McGwire
accomplishment: >
  Mark set a major league
  home run record in 1998.
stats: |
  65 Home Runs
  0.278 Batting Average"""

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if (m is Map<*,*>) {
            assertEquals(mapOf("name" to "Mark McGwire",
                    "accomplishment" to "Mark set a major league home run record in 1998.",
                    "stats" to """65 Home Runs
0.278 Batting Average"""), m)
        } else
            fail()
    }

    @Test
    fun  e2_17_QuotedScalars() {
        val input =
"""unicode: "Sosa did fine.\u263A"
control: "\b1998\t1999\t2000\n"
hex esc: "\x0d\x0a is \r\n"

single: '"Howdy!" he cried.'
quoted: ' # Not a ''comment''.'
tie-fighter: '|\-*-/|'"""

        val parser = getYamlParser(input)

        val m = parser.file().ast()
        if (m is Map<*,*>) {
            assertEquals(mapOf("name" to "Mark McGwire",
                    "accomplishment" to "Mark set a major league home run record in 1998.",
                    "stats" to """65 Home Runs
0.278 Batting Average"""), m)
        } else
            fail()
    }

}


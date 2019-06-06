package com.fastyaml

import org.antlr.v4.runtime.tree.TerminalNode

/**
 * Created by Syed Umar Anis on 6/4/2017.
 */

fun YamlParser.FileContext.ast() : Any {
    val anchors : MutableMap<String, Any?> = mutableMapOf()
    val documents = this.document()
    if(documents.size > 1) {
        val l: MutableList<Any> = mutableListOf()
        this.document().forEach {
            l.add(it.ast(anchors))
        }
        return l
    }
    else
    {
        return documents[0].ast(anchors)
    }
}

fun YamlParser.DocumentContext.ast(anchors: MutableMap<String, Any?>) : Any {
    return when {
        this.list() != null -> this.list().ast(anchors)
        this.mappinglist() != null -> this.mappinglist().ast(anchors)
        this.flowlist() != null -> flowlist().ast(anchors)
        this.flowmappinglist() != null -> flowmappinglist().ast(anchors)
        this.value() != null -> value().ast(anchors)
        else -> throw Exception("Abstract Syntax Tree: List or Mapping not found in the document.")
    }
}

fun YamlParser.ListContext.ast(anchors: MutableMap<String, Any?>) : MutableList<Any?> {
    val l : MutableList<Any?> = mutableListOf()
    this.listitem().forEach {
        l.add(it.ast(anchors))
    }
    return l
}

fun YamlParser.ListitemContext.ast(anchors: MutableMap<String, Any?>) : Any? {
    val listItem : Any? = when {
        value() != null -> value().ast(anchors)
        list() != null -> list().ast(anchors)
        mappinglist() != null -> mappinglist().ast(anchors)
        flowlist() != null -> flowlist().ast(anchors)
        ALIAS() != null -> anchors[ALIAS().text.substring(1)]
        else -> null
    }
    if (ANCHOR() != null) anchors[ANCHOR().text.substring(1)] = listItem
    return listItem
}

fun  YamlParser.FlowlistContext.ast(anchors: MutableMap<String, Any?>): Any {
    val l : MutableList<Any> = mutableListOf()
    this.value().forEach { l.add(it.ast(anchors)) }
    return l
}

fun YamlParser.MappinglistContext.ast(anchors: MutableMap<String, Any?>) : MutableMap<Any, Any?> {
    val m : MutableMap<Any, Any?> = mutableMapOf()
    this.mapping().forEach {
        m[it.key().ast(anchors)] = when {
            it.value() != null -> it.value().ast(anchors)
            it.list() != null -> it.list().ast(anchors)
            it.flowmappinglist() != null -> it.flowmappinglist().ast(anchors)
            it.mappinglist() != null -> it.mappinglist().ast(anchors)
            else -> null
        }
    }
    return m
}

fun  YamlParser.FlowmappinglistContext.ast(anchors: MutableMap<String, Any?>): Any {
    val m : MutableMap<Any, Any> = mutableMapOf()
    this.mapping().forEach {
        m[it.key().ast(anchors)] = when {
            it.value() != null -> it.value().ast(anchors)
            else -> it.list().ast(anchors)
        }
    }
    return m
}

fun YamlParser.KeyContext.ast(anchors: MutableMap<String, Any?>) : Any {
    return STRING_MY().toString()
}

fun YamlParser.ValueContext.ast(anchors: MutableMap<String, Any?>) : Any {
    return when {
        this.value_scalar() != null -> value_scalar().ast(anchors)
        this.multiline_string() != null -> this.multiline_string().ast(anchors)
        this.string_literal() != null -> string_literal().ast(anchors)
        this.string_folded() != null -> string_folded().ast(anchors)
        else -> this.string_double_quoted().ast(anchors)
    }
}

fun YamlParser.Value_scalarContext.ast(anchors: MutableMap<String, Any?>) : Any {
    return when {
        STRING_MY() != null -> STRING_MY().toString()
        else -> number().ast(anchors)
    }
}

fun YamlParser.Multiline_stringContext.ast(anchors: MutableMap<String, Any?>) : String {
    val str = StringBuilder()
    this.children.forEach {
        when (it) {
            is YamlParser.Multiline_stringContext -> {
                if(!str.isEmpty()) str.append(" ")
                str.append(it.ast(anchors))
            }
            is YamlParser.Value_scalarContext -> {
                if(!str.isEmpty()) str.append(" ")
                str.append(it.ast(anchors).toString())
            }
        }
    }
    return str.toString()
}

fun YamlParser.String_literalContext.ast(anchors: MutableMap<String, Any?>): Any {
    val str = StringBuilder()
    var i = 2
    while(i < childCount) {
        var node = this.getChild(i) as TerminalNode
        when(node.symbol.type) {
            YamlLexer.NEWLINE_STR_LITERAL -> str.append("\n")
            YamlLexer.STRING_MY -> str.append(node.text)
        }
        i++
    }
    return str.toString()
}

fun YamlParser.String_foldedContext.ast(anchors: MutableMap<String, Any?>): Any {
    val str = StringBuilder()
    var i = 2
    while(i < childCount) {
        var node = this.getChild(i) as TerminalNode
        when(node.symbol.type) {
            YamlLexer.NEWLINE_STR_LITERAL -> {
                if((getChild(i - 1) as TerminalNode).symbol.type == YamlLexer.NEWLINE_STR_LITERAL)
                    str.append("\n")
            }
            YamlLexer.STRING_MY -> {
                if(node.text.startsWith(' '))   str.append("\n")
                if(str.isNotEmpty() && str[str.length - 1] != '\n')  str.append(" ")
                str.append(node.text)
            }
        }
        i++
    }
    return str.toString()
}

fun YamlParser.String_double_quotedContext.ast(anchors: MutableMap<String, Any?>): Any {
    val str = StringBuilder()
    var i = 1
    while(i < childCount) {
        var node = this.getChild(i) as TerminalNode
        when(node.symbol.type) {
            YamlLexer.NEWLINE_STR_QUOTE -> {
                if((getChild(i - 1) as TerminalNode).symbol.type == YamlLexer.NEWLINE_STR_QUOTE)
                    str.append("\n")
            }
            YamlLexer.STRING_MY -> {
                if(str.isNotEmpty() && str[str.length - 1] != '\n')  str.append(" ")
                str.append(node.text)
            }
        }
        i++
    }
    return str.toString()
}

fun YamlParser.NumberContext.ast(anchors: MutableMap<String, Any?>) : Any {
    return when {
        integer() != null -> integer().getChild(0).text.toInt() //TODO: implement for binary, hex & oct
        FLOAT_NUMBER() != null -> FLOAT_NUMBER().text.toDouble()
        else -> "" //TODO: implement for imagery number
    }
}
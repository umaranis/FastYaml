
parser grammar YamlParser;

options {   tokenVocab = YamlLexer; }

// The Yaml Language Reference: http://www.yaml.org/spec/1.2/spec.html

/*
 * my parser rules
 */

file
 : NEWLINE*
 (
   (DOCUMENTSTART NEWLINE?)? document (DOCUMENTEND NEWLINE)? (NEWLINE* (DOCUMENTSTART NEWLINE) document (DOCUMENTEND NEWLINE?)?)*
 )
 NEWLINE* EOF
 ;

document
 : list | mappinglist | flowlist | flowmappinglist | value
 ;

list
 : (NEWLINE* listitem NEWLINE?)+
 ;

listitem
 : MINUS ANCHOR? (
        value |
        NEWLINE+ INDENT list DEDENT |
        NEWLINE+ INDENT mappinglist DEDENT |
        flowlist
        )
 | MINUS ALIAS
 | MINUS NEWLINE //null value
 ;

mappinglist
 : (NEWLINE* mapping NEWLINE?)+
 ;

key
 : STRING_MY
 ;

value
 : value_scalar | NEWLINE INDENT value_scalar NEWLINE DEDENT | multiline_string | string_literal | string_folded | string_double_quoted
 ;

value_scalar
 : number | STRING_MY
 ;

multiline_string
 : value_scalar? NEWLINE INDENT ( value_scalar (NEWLINE value_scalar)* | multiline_string)+ NEWLINE? DEDENT
 ;

string_literal
 : LITERIAL_STR_IND (NEWLINE_STR_LITERAL+ STRING_MY)*
 ;

string_folded
 : FOLD_STR_IND (NEWLINE_STR_LITERAL+ STRING_MY)*
 ;

string_double_quoted
 : DOUBLE_QUOTE STRING_MY (NEWLINE_STR_QUOTE+ STRING_MY)* DOUBLE_QUOTE
 ;

mapping
 : key COLON NEWLINE+ INDENT mappinglist DEDENT
 | key COLON NEWLINE+ INDENT list DEDENT
 | key COLON flowmappinglist
 | key COLON value?
 ;

/*
 * flow rules
 */

flowlist
 : OPEN_BRACK value (COMMA value)* CLOSE_BRACK
 ;

flowmappinglist
 : OPEN_BRACE mapping (COMMA mapping)* CLOSE_BRACE
 ;

/*
 * parser rules
 */

number
 : integer
 | FLOAT_NUMBER
 | IMAG_NUMBER
 ;

/// integer        ::=  decimalinteger | octinteger | hexinteger | bininteger
integer
 : DECIMAL_INTEGER
 | OCT_INTEGER
 | HEX_INTEGER
 | BIN_INTEGER
 ;
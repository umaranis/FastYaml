package com.fastyaml;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class LexerTokenPrinter {

    public static void main(String[] args) throws IOException {
        ANTLRInputStream input =
                new ANTLRInputStream(
                        new FileInputStream("D:\\Umar\\IntelijSpace\\FastYaml\\src\\test1.yaml"));

        YamlLexer lexer = new YamlLexer(input);

        List<? extends Token> lt = lexer.getAllTokens(); //this will take all tokens out of lexer, parser will not work afterwards
        for(Token t : lt) {
            System.out.println(lexer.VOCABULARY.getDisplayName(t.getType()));
        }

    }

}
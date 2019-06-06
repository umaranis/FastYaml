package com.fastyaml;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class YamlMain {

    public static void main(String[] args) throws IOException {
        ANTLRInputStream input =
                new ANTLRInputStream(
                        new FileInputStream("D:\\Umar\\IntelijSpace\\FastYaml\\src\\test1.yaml"));

        YamlLexer lexer = new YamlLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        YamlParser parser = new YamlParser(tokens);

        YamlParser.FileContext c = parser.file();
        return;
    }

}
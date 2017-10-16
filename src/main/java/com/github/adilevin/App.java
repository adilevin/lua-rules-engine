package com.github.adilevin;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        InputStream in = App.class.getResourceAsStream("/rule-files/1.rules");
        CharStream charStream = CharStreams.fromStream(in);
        IfThenLexer lexer = new IfThenLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        IfThenParser parser = new IfThenParser(tokens);
        IfThenParser.ProgContext progContext = parser.prog();
        ParseTreeWalker walker = new ParseTreeWalker();
        SimpleListener listener = new SimpleListener();
        walker.walk(listener, progContext);
        IntermediateModel intermediateModel = listener.getIntermediateModel();

        try {
            Translator translator = new Translator();
            String luaCode = translator.generateLUA(intermediateModel);
            PrintWriter writer = new PrintWriter("rules.lua");
            writer.print(luaCode);
            writer.close();
            System.out.println( luaCode );
        } catch (Exception e) {
            System.out.println("Failed: " + e);
        }
    }
}

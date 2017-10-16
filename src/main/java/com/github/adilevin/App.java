package com.github.adilevin;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CharStream charStream = CharStreams.fromString(
                "if age < 5 then accept\n if height >= 10 then reject");
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
            System.out.println( luaCode );
        } catch (Exception e) {
            System.out.println("Failed: " + e);
        }
    }
}

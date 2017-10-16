package com.github.adilevin;

import lombok.AllArgsConstructor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.io.InputStream;

public class IntermediateModelBuilder {

  static IntermediateModel buildIntermediateModelFromRulesText(InputStream rulesText) throws IOException {
    CommonTokenStream tokens = tokenize(rulesText);
    IfThenParser.ProgContext progContext = parse(tokens);
    return walkParseTree(progContext);
  }

  private static IntermediateModel walkParseTree(IfThenParser.ProgContext progContext) {
    IntermediateModel model = new IntermediateModel();
    Listener listener = new Listener(model);
    ParseTreeWalker walker = new ParseTreeWalker();
    walker.walk(listener, progContext);
    return model;
  }

  private static IfThenParser.ProgContext parse(CommonTokenStream tokens) {
    IfThenParser parser = new IfThenParser(tokens);
    return parser.prog();
  }

  private static CommonTokenStream tokenize(InputStream rulesText) throws IOException {
    CharStream charStream = CharStreams.fromStream(rulesText);
    IfThenLexer lexer = new IfThenLexer(charStream);
    return new CommonTokenStream(lexer);
  }

  @AllArgsConstructor
  private static class Listener extends IfThenBaseListener {

    private IntermediateModel model;

    @Override
    public void enterConditional(IfThenParser.ConditionalContext ctx) {
      IntermediateModel.Conditional cond = new IntermediateModel.Conditional(
              ctx.predicate().getText(), ctx.action().getText());
      model.conditionals.add(cond);
    }

  }
}

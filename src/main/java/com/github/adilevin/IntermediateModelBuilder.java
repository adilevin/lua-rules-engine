package com.github.adilevin;

import lombok.AllArgsConstructor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.io.InputStream;

import static java.util.stream.Collectors.toList;

public class IntermediateModelBuilder {

  static IntermediateModel buildIntermediateModelFromRulesText(InputStream rulesText) throws IOException {
    CommonTokenStream tokens = tokenize(rulesText);
    IfThenParser.ProgContext progContext = parse(tokens);
    return walkParseTree(progContext);
  }

  private static IntermediateModel walkParseTree(IfThenParser.ProgContext progContext) {
    RulesVisitor rulesVisitor = new RulesVisitor();
    return progContext.accept(rulesVisitor);
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

  private static class RulesVisitor extends IfThenBaseVisitor<IntermediateModel> {

    @Override public IntermediateModel visitProg(IfThenParser.ProgContext ctx) {
      IntermediateModel model = new IntermediateModel();
      CondVisitor condVisitor = new CondVisitor();
      ctx.conditional()
              .stream()
              .map(condCtx -> condCtx.accept(condVisitor))
              .forEach((condModel)->{model.conditionals.add(condModel);});
      return model;
    }
  }

  private static class CondVisitor extends IfThenBaseVisitor<IntermediateModel.Conditional> {

    @Override public IntermediateModel.Conditional visitConditional(IfThenParser.ConditionalContext ctx) {
      PredicateVisitor predicateVisitor = new PredicateVisitor();
      IntermediateModel.Predicate predicate = ctx.predicate().accept(predicateVisitor);
      return new IntermediateModel.Conditional(predicate, ctx.action().getText());
    }
  }

  private static class PredicateVisitor extends IfThenBaseVisitor<IntermediateModel.Predicate> {

    @Override public IntermediateModel.Predicate visitPredicate(IfThenParser.PredicateContext ctx) {
      return new IntermediateModel.Predicate(
              ctx.measurement().getText(),
              ctx.comp().getText(),
              ctx.value().getText());
    }
  }
}

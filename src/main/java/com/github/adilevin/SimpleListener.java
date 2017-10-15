package com.github.adilevin;

/**
 * Created by alevin on 10/15/2017.
 */
public class SimpleListener extends IfThenBaseListener {

  private IntermediateModel model = new IntermediateModel();

  IntermediateModel getIntermediateModel() {
    return model;
  }

  @Override public void enterProg(IfThenParser.ProgContext ctx) {
    System.out.println("enterProg");
  }

  @Override public void exitProg(IfThenParser.ProgContext ctx) {
    System.out.println("exitProg");
  }

  @Override public void enterConditional(IfThenParser.ConditionalContext ctx) {
    System.out.println("enterConditional");
    IntermediateModel.Conditional cond = new IntermediateModel.Conditional();
    cond.predicate = ctx.predicate().getText();
    cond.action = ctx.action().getText();
    model.conditionals.add(cond);
  }

}

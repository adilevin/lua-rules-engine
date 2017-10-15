package com.github.adilevin;

import static com.github.adilevin.IntermediateModel.*;

/**
 * Created by alevin on 10/15/2017.
 */
public class SimpleListener extends IfThenBaseListener {

  private IntermediateModel model = new IntermediateModel();

  IntermediateModel getIntermediateModel() {
    return model;
  }

  @Override
  public void enterProg(IfThenParser.ProgContext ctx) {
    System.out.println("enterProg");
  }

  @Override
  public void exitProg(IfThenParser.ProgContext ctx) {
    System.out.println("exitProg");
  }

  @Override
  public void enterConditional(IfThenParser.ConditionalContext ctx) {
    System.out.println("enterConditional");

    model.conditionals.add(new Conditional() {{
      predicate = ctx.predicate().getText();
      action = ctx.action().getText();
    }});
  }

}

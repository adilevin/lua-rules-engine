package com.github.adilevin;

import org.stringtemplate.v4.ST;

/**
 * Created by alevin on 10/15/2017.
 */
public class Translator {

  private String conditionalTemplate = "Check that <cond.predicate>, and if it's true then <cond.action>\n";

  public String generateLUA(IntermediateModel model) {
    String out = "";
    for(IntermediateModel.Conditional cond : model.conditionals ) {
      ST template = new ST(conditionalTemplate);
      template.add("cond", cond);
      out += template.render();
    }
    return out;
  }

}

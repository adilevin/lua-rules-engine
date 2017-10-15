package com.github.adilevin;

/**
 * Created by alevin on 10/15/2017.
 */
public class Translator {

  public String generateLUA(IntermediateModel model) {
    String out = "";
    for(IntermediateModel.Conditional cond : model.conditionals ) {
      out += "IF " + cond.predicate + " THEN " + cond.action + "!\n";
    }
    return out;
  }

}

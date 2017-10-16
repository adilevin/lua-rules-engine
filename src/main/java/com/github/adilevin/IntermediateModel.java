package com.github.adilevin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alevin on 10/15/2017.
 */
public class IntermediateModel {

  static class Conditional {
    public Conditional(String predicate, String action) {
      this.predicate = predicate;
      this.action = action;
    }
    public String getPredicate() { return predicate; }
    public String getAction() { return action; }
    private String predicate;
    private String action;
  }

  public List<Conditional> conditionals = new ArrayList<>();

}

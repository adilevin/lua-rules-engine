package com.github.adilevin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alevin on 10/15/2017.
 */
public class IntermediateModel {

  static class Conditional {
    public String predicate;
    public String action;
  }

  public List<Conditional> conditionals = new ArrayList<>();

}

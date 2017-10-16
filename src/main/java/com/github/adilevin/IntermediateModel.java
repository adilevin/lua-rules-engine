package com.github.adilevin;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

// In order for Freemarker templates object mapper to work, this needs to be a
// public class with getters such as in the JavaBeans spec (getXX() or isXX()).
// Lombok's @Getter helps with this.
@Getter
public class IntermediateModel {

  @Getter
  @AllArgsConstructor
  static public class Conditional {
    private Predicate predicate;
    private String action;
  }

  @Getter
  @AllArgsConstructor
  static public class Predicate {
    private String measurement;
    private String comparator;
    private String value;
  }

  public List<Conditional> conditionals = new ArrayList<>();

}

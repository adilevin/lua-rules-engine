package com.github.adilevin;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alevin on 10/15/2017.
 */

// In order for Freemarker templates object mapper to work, this needs to be a
// public class with getters such as in the JavaBeans spec (getXX() or isXX()).
// Lombok's @Getter helps with this.
@Getter
public class IntermediateModel {

  @Getter
  @AllArgsConstructor
  static public class Conditional {
    private String predicate;
    private String action;
  }

  public List<Conditional> conditionals = new ArrayList<>();

}

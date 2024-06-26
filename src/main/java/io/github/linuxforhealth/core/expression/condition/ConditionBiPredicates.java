/*
 * (C) Copyright IBM Corp. 2020, 2021
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package io.github.linuxforhealth.core.expression.condition;

import java.util.function.BiPredicate;
import org.apache.commons.lang3.StringUtils;

/**
 * This is a static class that defines different types of Rule predicates and their operations.
 * 
 * @author pbhallam@us.ibm.com
 *
 */

public class ConditionBiPredicates {

  public static final BiPredicate<Integer, Integer> GREATER_THAN = (x, y) -> x > y;
  public static final BiPredicate<Integer, Integer> EQUAL_TO = (x, y) -> x.equals(y);
  public static final BiPredicate<Integer, Integer> NOT_EQUAL_TO = (x, y) -> !x.equals(y);
  public static final BiPredicate<Integer, Integer> LESS_THAN = (x, y) -> x < y;
  public static final BiPredicate<Integer, Integer> GREATER_THAN_OR_EQUAL_TO = (x, y) -> x >= y;
  public static final BiPredicate<Integer, Integer> LESS_THAN_OR_EQUAL_TO = (x, y) -> x <= y;

  public static final BiPredicate<String, String> EQUALS_IC = StringUtils::equalsIgnoreCase;
  public static final BiPredicate<String, String> NOT_EQUALS = EQUALS_IC.negate();

  public static final BiPredicate<String, String> STARTS_WITH = StringUtils::startsWithIgnoreCase;
  public static final BiPredicate<String, String> NOT_STARTS_WITH = STARTS_WITH.negate();

  public static final BiPredicate<String, String> ENDS_WITH = StringUtils::endsWithIgnoreCase;
  public static final BiPredicate<String, String> NOT_ENDS_WITH = ENDS_WITH.negate();

  public static final BiPredicate<String, String> CONTAINS = StringUtils::containsIgnoreCase;
  public static final BiPredicate<String, String> NOT_CONTAINS = CONTAINS.negate();

  private ConditionBiPredicates() {}

}

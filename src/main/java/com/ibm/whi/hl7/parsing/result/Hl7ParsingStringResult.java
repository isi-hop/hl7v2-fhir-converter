package com.ibm.whi.hl7.parsing.result;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.python.google.common.collect.Lists;

/**
 * Represents the String value of result of parsing HL7 message.
 * 
 *
 * @author {user}
 */
public class Hl7ParsingStringResult implements ParsingResult<String> {


  private String textValue;

  public Hl7ParsingStringResult(String textValue) {
    this.textValue = textValue;
  }




  public boolean isEmpty() {
    return StringUtils.isBlank(this.textValue);
  }

  @Override
  public String getValue() {
    return textValue;
  }

  @Override
  public List<String> getValues() {
    return Lists.newArrayList(textValue);
  }

}

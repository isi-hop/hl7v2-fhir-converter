package com.ibm.whi.hl7.expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.ibm.whi.core.expression.GenericResult;
import com.ibm.whi.core.message.InputData;
import com.ibm.whi.core.resource.ResourceResult;
import com.ibm.whi.core.resource.ResourceValue;
import com.ibm.whi.hl7.resource.HL7DataBasedResourceModel;
import com.ibm.whi.hl7.resource.ResourceModelReader;

/**
 * Represent a expression that represents resolving a json template
 * 
 *
 * @author {user}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResourceExpression extends AbstractExpression {


  private static final Logger LOGGER = LoggerFactory.getLogger(ResourceExpression.class);

  private HL7DataBasedResourceModel data;
  private String resourceToGenerate;



  /**
   * 
   * @param type
   * @param resourceToGenerate
   * @param hl7spec
   * @param defaultValue
   * @param required
   * @param variables
   * @param referencesResources
   */
  @JsonCreator
  public ResourceExpression(@JsonProperty("type") String type,
      @JsonProperty("resource") String resourceToGenerate, @JsonProperty("hl7spec") String hl7spec,
      @JsonProperty("default") Object defaultValue, @JsonProperty("required") boolean required,
      @JsonProperty("var") Map<String, String> variables,
      @JsonProperty("condition") String condition) {
    super(type, defaultValue, required, hl7spec, variables, condition);

    Preconditions.checkArgument(StringUtils.isNotBlank(resourceToGenerate),
        "reference cannot be blank");
    if (resourceToGenerate.endsWith("*")) {
      this.setMultiple();
      resourceToGenerate = StringUtils.removeEnd(resourceToGenerate, "*");
    }
    this.resourceToGenerate = StringUtils.strip(resourceToGenerate);
    this.data = (HL7DataBasedResourceModel) ResourceModelReader.getInstance()
        .generateResourceModel(this.resourceToGenerate);
    Preconditions.checkState(this.data != null, "Resource reference model cannot be null");


  }


  public ResourceExpression(@JsonProperty("type") String type,
      @JsonProperty("resource") String resourceToGenerate,
      @JsonProperty("hl7spec") String hl7spec) {
    this(type, resourceToGenerate, hl7spec, null, false, null, null);
  }



  public HL7DataBasedResourceModel getData() {
    return data;
  }



  @Override
  public GenericResult evaluateExpression(InputData dataSource,
      Map<String, GenericResult> contextValues, GenericResult hl7SpecValues) {
    Preconditions.checkArgument(dataSource != null, "dataSource cannot be null");
    Preconditions.checkArgument(contextValues != null, "contextValues cannot be null");
    LOGGER.info("Evaluating expression {}", this.resourceToGenerate);
    GenericResult evaluationResult = null;
    if (this.isMultiple() && hl7SpecValues != null) {
      List<?> dataValues = (List<?>) hl7SpecValues.getValue();
      List<GenericResult> baseValues = new ArrayList<>();

      dataValues.removeIf(Objects::isNull);
      dataValues.forEach(d -> baseValues.add(new GenericResult(d)));
      ResourceResult result = this.data.evaluateMultiple(dataSource,
          ImmutableMap.copyOf(contextValues), baseValues, this.getVariables());
      if (result != null) {
        List<ResourceValue> resolvedvalues = result.getResources();
        LOGGER.info("Evaluated expression {}, returning {} ", this.resourceToGenerate,
            resolvedvalues);
        if (resolvedvalues != null && !resolvedvalues.isEmpty()) {
          List<Map<String, Object>> values = new ArrayList<>();
          resolvedvalues.forEach(v -> values.add(v.getResource()));
          evaluationResult = new GenericResult(values, result.getAdditionalResources());
        }
      }
    } else {
      GenericResult baseValue = new GenericResult(getSingleValue(hl7SpecValues));

      ResourceResult result =
          this.data.evaluateSingle(dataSource, ImmutableMap.copyOf(contextValues), baseValue);
      if (result != null && result.getResources() != null && !result.getResources().isEmpty()) {
        List<ResourceValue> resolvedvalues = result.getResources();

        LOGGER.info("Evaluated expression {}, returning {} ", this.resourceToGenerate,
            resolvedvalues);
        if (resolvedvalues != null && !resolvedvalues.isEmpty()) {
          evaluationResult =
              new GenericResult(resolvedvalues.get(0).getResource(),
                  result.getAdditionalResources());
        }
      }
    }

    return evaluationResult;

  }



  public String getReference() {
    return resourceToGenerate;
  }



}
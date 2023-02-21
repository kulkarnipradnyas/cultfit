package com.myCode.pradnya.server.cult.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Error response details element
 */
@Schema(description = "Error response details element")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-21T01:43:17.874374+05:30[Asia/Kolkata]")


public class ErrorResponseDetailsElement   {
  @JsonProperty("title")
  private String title = null;

  @JsonProperty("source")
  private String source = null;

  @JsonProperty("message")
  private String message = null;

  @JsonProperty("messageTemplate")
  private String messageTemplate = null;

  @JsonProperty("messagePlaceholders")
  @Valid
  private Map<String, Object> messagePlaceholders = null;

  public ErrorResponseDetailsElement title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Error message title
   * @return title
   **/
  @Schema(example = "Not accessible", description = "Error message title")
  
    public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public ErrorResponseDetailsElement source(String source) {
    this.source = source;
    return this;
  }

  /**
   * Reference to JSON path or Property Reference
   * @return source
   **/
  @Schema(example = "resourceId", description = "Reference to JSON path or Property Reference")
  
    public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public ErrorResponseDetailsElement message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Localized message string that describes the issue with the cited source.  Corrective action for the caller should be provided if appropriate and known.
   * @return message
   **/
  @Schema(example = "String is not accessible is not accessible", description = "Localized message string that describes the issue with the cited source.  Corrective action for the caller should be provided if appropriate and known.")
  
    public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ErrorResponseDetailsElement messageTemplate(String messageTemplate) {
    this.messageTemplate = messageTemplate;
    return this;
  }

  /**
   * The template to display the message
   * @return messageTemplate
   **/
  @Schema(example = "validation.constraint.between", description = "The template to display the message")
  
    public String getMessageTemplate() {
    return messageTemplate;
  }

  public void setMessageTemplate(String messageTemplate) {
    this.messageTemplate = messageTemplate;
  }

  public ErrorResponseDetailsElement messagePlaceholders(Map<String, Object> messagePlaceholders) {
    this.messagePlaceholders = messagePlaceholders;
    return this;
  }

  public ErrorResponseDetailsElement putMessagePlaceholdersItem(String key, Object messagePlaceholdersItem) {
    if (this.messagePlaceholders == null) {
      this.messagePlaceholders = new HashMap<>();
    }
    this.messagePlaceholders.put(key, messagePlaceholdersItem);
    return this;
  }

  /**
   * Get messagePlaceholders
   * @return messagePlaceholders
   **/
  @Schema(example = "{\"field\":\"size\",\"min\":3,\"max\":64}", description = "")
  
    public Map<String, Object> getMessagePlaceholders() {
    return messagePlaceholders;
  }

  public void setMessagePlaceholders(Map<String, Object> messagePlaceholders) {
    this.messagePlaceholders = messagePlaceholders;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorResponseDetailsElement errorResponseDetailsElement = (ErrorResponseDetailsElement) o;
    return Objects.equals(this.title, errorResponseDetailsElement.title) &&
        Objects.equals(this.source, errorResponseDetailsElement.source) &&
        Objects.equals(this.message, errorResponseDetailsElement.message) &&
        Objects.equals(this.messageTemplate, errorResponseDetailsElement.messageTemplate) &&
        Objects.equals(this.messagePlaceholders, errorResponseDetailsElement.messagePlaceholders);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, source, message, messageTemplate, messagePlaceholders);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorResponseDetailsElement {\n");
    
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    messageTemplate: ").append(toIndentedString(messageTemplate)).append("\n");
    sb.append("    messagePlaceholders: ").append(toIndentedString(messagePlaceholders)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

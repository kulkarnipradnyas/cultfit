package com.myCode.pradnya.server.cult.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.myCode.pradnya.server.cult.model.ErrorResponseDetailsElement;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * The error data for any specific failure response.  This message format is used whenever the cult Service reports a failure to the caller.  The error codes allocated to this API definition are in the range of &#x60;E311001&#x60; to &#x60;E311999&#x60;.
 */
@Schema(description = "The error data for any specific failure response.  This message format is used whenever the cult Service reports a failure to the caller.  The error codes allocated to this API definition are in the range of `E311001` to `E311999`.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-03-03T02:32:44.003435+05:30[Asia/Kolkata]")


public class ErrorResponse   {
  @JsonProperty("title")
  private String title = null;

  @JsonProperty("status")
  private Integer status = null;

  @JsonProperty("code")
  private String code = null;

  @JsonProperty("cause")
  private String cause = null;

  @JsonProperty("action")
  private String action = null;

  @JsonProperty("correlationId")
  private String correlationId = null;

  @JsonProperty("details")
  @Valid
  private List<ErrorResponseDetailsElement> details = null;

  public ErrorResponse title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Error title
   * @return title
   **/
  @Schema(example = "Input data validation failed", required = true, description = "Error title")
      @NotNull

    public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public ErrorResponse status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * HTTP status code
   * @return status
   **/
  @Schema(required = true, description = "HTTP status code")
      @NotNull

    public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public ErrorResponse code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Error code.
   * @return code
   **/
  @Schema(example = "E311001", required = true, description = "Error code.")
      @NotNull

    public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public ErrorResponse cause(String cause) {
    this.cause = cause;
    return this;
  }

  /**
   * The cause of the error
   * @return cause
   **/
  @Schema(example = "The input data in question does not meet validation rules", required = true, description = "The cause of the error")
      @NotNull

    public String getCause() {
    return cause;
  }

  public void setCause(String cause) {
    this.cause = cause;
  }

  public ErrorResponse action(String action) {
    this.action = action;
    return this;
  }

  /**
   * Actionable instructions for the API consumer
   * @return action
   **/
  @Schema(example = "Correct input data and retry request", required = true, description = "Actionable instructions for the API consumer")
      @NotNull

    public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public ErrorResponse correlationId(String correlationId) {
    this.correlationId = correlationId;
    return this;
  }

  /**
   * Auto-generated ID, which uniquely identifies the request, available in the response.  When contacting support with an inquiry regarding a specific request, provide the value of this header which will help troubleshooting the issue.  If not present, one will be generated.
   * @return correlationId
   **/
  @Schema(example = "f9bc3746-79e5-4ae5-ba87-30a6f3b9faa2", required = true, description = "Auto-generated ID, which uniquely identifies the request, available in the response.  When contacting support with an inquiry regarding a specific request, provide the value of this header which will help troubleshooting the issue.  If not present, one will be generated.")
      @NotNull

    public String getCorrelationId() {
    return correlationId;
  }

  public void setCorrelationId(String correlationId) {
    this.correlationId = correlationId;
  }

  public ErrorResponse details(List<ErrorResponseDetailsElement> details) {
    this.details = details;
    return this;
  }

  public ErrorResponse addDetailsItem(ErrorResponseDetailsElement detailsItem) {
    if (this.details == null) {
      this.details = new ArrayList<>();
    }
    this.details.add(detailsItem);
    return this;
  }

  /**
   * Collection of error details
   * @return details
   **/
  @Schema(description = "Collection of error details")
      @Valid
    public List<ErrorResponseDetailsElement> getDetails() {
    return details;
  }

  public void setDetails(List<ErrorResponseDetailsElement> details) {
    this.details = details;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorResponse errorResponse = (ErrorResponse) o;
    return Objects.equals(this.title, errorResponse.title) &&
        Objects.equals(this.status, errorResponse.status) &&
        Objects.equals(this.code, errorResponse.code) &&
        Objects.equals(this.cause, errorResponse.cause) &&
        Objects.equals(this.action, errorResponse.action) &&
        Objects.equals(this.correlationId, errorResponse.correlationId) &&
        Objects.equals(this.details, errorResponse.details);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, status, code, cause, action, correlationId, details);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorResponse {\n");
    
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    cause: ").append(toIndentedString(cause)).append("\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    correlationId: ").append(toIndentedString(correlationId)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
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

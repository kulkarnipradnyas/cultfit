package com.myCode.pradnya.server.cult.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * The error data for any specific failure response.  This message format is used whenever the gateway reports an error
 */
@Schema(description = "The error data for any specific failure response.  This message format is used whenever the gateway reports an error")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-03-03T02:32:44.003435+05:30[Asia/Kolkata]")


public class ExternalErrorResponse   {
  @JsonProperty("error")
  private String error = null;

  @JsonProperty("error_description")
  private String errorDescription = null;

  public ExternalErrorResponse error(String error) {
    this.error = error;
    return this;
  }

  /**
   * Error title
   * @return error
   **/
  @Schema(example = "Input data failed validation", required = true, description = "Error title")
      @NotNull

    public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public ExternalErrorResponse errorDescription(String errorDescription) {
    this.errorDescription = errorDescription;
    return this;
  }

  /**
   * Descriptive error message.
   * @return errorDescription
   **/
  @Schema(example = "Requested resource not found", required = true, description = "Descriptive error message.")
      @NotNull

    public String getErrorDescription() {
    return errorDescription;
  }

  public void setErrorDescription(String errorDescription) {
    this.errorDescription = errorDescription;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExternalErrorResponse externalErrorResponse = (ExternalErrorResponse) o;
    return Objects.equals(this.error, externalErrorResponse.error) &&
        Objects.equals(this.errorDescription, externalErrorResponse.errorDescription);
  }

  @Override
  public int hashCode() {
    return Objects.hash(error, errorDescription);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExternalErrorResponse {\n");
    
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    errorDescription: ").append(toIndentedString(errorDescription)).append("\n");
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

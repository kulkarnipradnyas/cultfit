package com.myCode.pradnya.server.cult.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Version of a specific data set
 */
@Schema(description = "Version of a specific data set")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-22T00:41:41.111094+05:30[Asia/Kolkata]")


public class DataVersion   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("version")
  private String version = null;

  public DataVersion name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Identifies a data set, e.g. a HRN, or a service specific identifier
   * @return name
   **/
  @Schema(required = true, description = "Identifies a data set, e.g. a HRN, or a service specific identifier")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DataVersion version(String version) {
    this.version = version;
    return this;
  }

  /**
   * The current version of this data set
   * @return version
   **/
  @Schema(required = true, description = "The current version of this data set")
      @NotNull

    public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataVersion dataVersion = (DataVersion) o;
    return Objects.equals(this.name, dataVersion.name) &&
        Objects.equals(this.version, dataVersion.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, version);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataVersion {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
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

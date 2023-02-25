package com.myCode.pradnya.server.cult.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.myCode.pradnya.server.cult.model.DataVersion;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * The version info of the service
 */
@Schema(description = "The version info of the service")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-25T18:16:18.488114+05:30[Asia/Kolkata]")


public class VersionInfo   {
  @JsonProperty("apiVersion")
  private String apiVersion = null;

  @JsonProperty("serviceVersion")
  private String serviceVersion = null;

  @JsonProperty("dataVersions")
  @Valid
  private List<DataVersion> dataVersions = null;

  public VersionInfo apiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return this;
  }

  /**
   * The api version
   * @return apiVersion
   **/
  @Schema(example = "1.0.0", required = true, description = "The api version")
      @NotNull

    public String getApiVersion() {
    return apiVersion;
  }

  public void setApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
  }

  public VersionInfo serviceVersion(String serviceVersion) {
    this.serviceVersion = serviceVersion;
    return this;
  }

  /**
   * The service version
   * @return serviceVersion
   **/
  @Schema(example = "1.0.0", required = true, description = "The service version")
      @NotNull

    public String getServiceVersion() {
    return serviceVersion;
  }

  public void setServiceVersion(String serviceVersion) {
    this.serviceVersion = serviceVersion;
  }

  public VersionInfo dataVersions(List<DataVersion> dataVersions) {
    this.dataVersions = dataVersions;
    return this;
  }

  public VersionInfo addDataVersionsItem(DataVersion dataVersionsItem) {
    if (this.dataVersions == null) {
      this.dataVersions = new ArrayList<>();
    }
    this.dataVersions.add(dataVersionsItem);
    return this;
  }

  /**
   * Returns the versions of data sets used by the service
   * @return dataVersions
   **/
  @Schema(description = "Returns the versions of data sets used by the service")
      @Valid
    public List<DataVersion> getDataVersions() {
    return dataVersions;
  }

  public void setDataVersions(List<DataVersion> dataVersions) {
    this.dataVersions = dataVersions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VersionInfo versionInfo = (VersionInfo) o;
    return Objects.equals(this.apiVersion, versionInfo.apiVersion) &&
        Objects.equals(this.serviceVersion, versionInfo.serviceVersion) &&
        Objects.equals(this.dataVersions, versionInfo.dataVersions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(apiVersion, serviceVersion, dataVersions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VersionInfo {\n");
    
    sb.append("    apiVersion: ").append(toIndentedString(apiVersion)).append("\n");
    sb.append("    serviceVersion: ").append(toIndentedString(serviceVersion)).append("\n");
    sb.append("    dataVersions: ").append(toIndentedString(dataVersions)).append("\n");
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

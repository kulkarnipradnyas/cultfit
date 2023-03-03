package com.myCode.pradnya.server.cult.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AuthVerifyOtpBody
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-03-03T02:32:44.003435+05:30[Asia/Kolkata]")


public class AuthVerifyOtpBody   {
  @JsonProperty("otp")
  private String otp = null;

  public AuthVerifyOtpBody otp(String otp) {
    this.otp = otp;
    return this;
  }

  /**
   * Get otp
   * @return otp
   **/
  @Schema(description = "")
  
    public String getOtp() {
    return otp;
  }

  public void setOtp(String otp) {
    this.otp = otp;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthVerifyOtpBody authVerifyOtpBody = (AuthVerifyOtpBody) o;
    return Objects.equals(this.otp, authVerifyOtpBody.otp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(otp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthVerifyOtpBody {\n");
    
    sb.append("    otp: ").append(toIndentedString(otp)).append("\n");
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

package com.myCode.pradnya.server.cult.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * User information
 */
@Schema(description = "User information")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-25T18:16:18.488114+05:30[Asia/Kolkata]")


public class User   {
  @JsonProperty("userName")
  private String userName = null;

  @JsonProperty("password")
  private String password = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("phoneNumber")
  private String phoneNumber = null;

  @JsonProperty("workEmailId")
  private String workEmailId = null;

  @JsonProperty("roles")
  @Valid
  private List<String> roles = null;

  @JsonProperty("securityQuestion")
  private Object securityQuestion = null;

  public User userName(String userName) {
    this.userName = userName;
    return this;
  }

  /**
   * Get userName
   * @return userName
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public User password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public User email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
   **/
  @Schema(description = "")
  
    public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public User phoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

  /**
   * Get phoneNumber
   * @return phoneNumber
   **/
  @Schema(description = "")
  
    public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public User workEmailId(String workEmailId) {
    this.workEmailId = workEmailId;
    return this;
  }

  /**
   * Get workEmailId
   * @return workEmailId
   **/
  @Schema(description = "")
  
    public String getWorkEmailId() {
    return workEmailId;
  }

  public void setWorkEmailId(String workEmailId) {
    this.workEmailId = workEmailId;
  }

  public User roles(List<String> roles) {
    this.roles = roles;
    return this;
  }

  public User addRolesItem(String rolesItem) {
    if (this.roles == null) {
      this.roles = new ArrayList<>();
    }
    this.roles.add(rolesItem);
    return this;
  }

  /**
   * Get roles
   * @return roles
   **/
  @Schema(example = "[\"admin\",\"vendor\",\"user\"]", description = "")
  
    public List<String> getRoles() {
    return roles;
  }

  public void setRoles(List<String> roles) {
    this.roles = roles;
  }

  public User securityQuestion(Object securityQuestion) {
    this.securityQuestion = securityQuestion;
    return this;
  }

  /**
   * Get securityQuestion
   * @return securityQuestion
   **/
  @Schema(description = "")
  
    public Object getSecurityQuestion() {
    return securityQuestion;
  }

  public void setSecurityQuestion(Object securityQuestion) {
    this.securityQuestion = securityQuestion;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.userName, user.userName) &&
        Objects.equals(this.password, user.password) &&
        Objects.equals(this.email, user.email) &&
        Objects.equals(this.phoneNumber, user.phoneNumber) &&
        Objects.equals(this.workEmailId, user.workEmailId) &&
        Objects.equals(this.roles, user.roles) &&
        Objects.equals(this.securityQuestion, user.securityQuestion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userName, password, email, phoneNumber, workEmailId, roles, securityQuestion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    workEmailId: ").append(toIndentedString(workEmailId)).append("\n");
    sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
    sb.append("    securityQuestion: ").append(toIndentedString(securityQuestion)).append("\n");
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

/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.34).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.myCode.pradnya.server.cult.api;

import com.myCode.pradnya.server.cult.model.AuthSendOtpBody;
import com.myCode.pradnya.server.cult.model.AuthSignInBody;
import com.myCode.pradnya.server.cult.model.AuthVerifyOtpBody;
import com.myCode.pradnya.server.cult.model.ErrorResponse;
import com.myCode.pradnya.server.cult.model.ExternalErrorResponse;
import com.myCode.pradnya.server.cult.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-03-03T02:32:44.003435+05:30[Asia/Kolkata]")
@Validated
public interface AuthApi {

    Logger log = LoggerFactory.getLogger(AuthApi.class);

    default Optional<ObjectMapper> getObjectMapper(){
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest(){
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @Operation(summary = "Example endpoint", description = "", security = {
        @SecurityRequirement(name = "sessionAuth")    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK") })
    @RequestMapping(value = "/auth/example",
        method = RequestMethod.GET)
    default ResponseEntity<Void> authExampleGet() {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default AuthApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Sends an OTP to the specified phone number", description = "", security = {
        @SecurityRequirement(name = "sessionAuth")    }, tags={ "Cult Auth" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = ""),
        
        @ApiResponse(responseCode = "401", description = "The request requires user authentication", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExternalErrorResponse.class))),
        
        @ApiResponse(responseCode = "403", description = "The request cannot be fulfilled", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExternalErrorResponse.class))),
        
        @ApiResponse(responseCode = "500", description = "The server encountered an unexpected condition that prevented it from fulfilling the request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
        
        @ApiResponse(responseCode = "502", description = "The server received an invalid response from the upstream server", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
        
        @ApiResponse(responseCode = "503", description = "The server is not ready to handle the request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
        
        @ApiResponse(responseCode = "504", description = "The server did not get a response in time", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
        
        @ApiResponse(responseCode = "5XX", description = "API response in case of errors.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))) })
    @RequestMapping(value = "/auth/sendOtp",
        produces = "application/json", 
        consumes = "application/json",
        method = RequestMethod.POST)
    default ResponseEntity<Void> sendOtp(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody AuthSendOtpBody body, @Parameter(in = ParameterIn.HEADER, description = "Auto-generated ID, which uniquely identifies the request, available in the response.  When contacting support with an inquiry regarding a specific request, provide the value of this header which will help troubleshooting the issue.  If not present, one will be generated." ,schema=@Schema()) @RequestHeader(value="X-Correlation-ID", required=false) String xCorrelationID, @Parameter(in = ParameterIn.HEADER, description = "User-provided token that can be used to trace a request or a group of requests sent to the service.  If not present, one will be generated." ,schema=@Schema()) @RequestHeader(value="X-Request-ID", required=false) String xRequestID) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default AuthApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "User SignIn", description = "", security = {
        @SecurityRequirement(name = "sessionAuth")    }, tags={ "Cult Auth" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = ""),
        
        @ApiResponse(responseCode = "401", description = "The request requires user authentication", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExternalErrorResponse.class))),
        
        @ApiResponse(responseCode = "403", description = "The request cannot be fulfilled", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExternalErrorResponse.class))),
        
        @ApiResponse(responseCode = "500", description = "The server encountered an unexpected condition that prevented it from fulfilling the request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
        
        @ApiResponse(responseCode = "502", description = "The server received an invalid response from the upstream server", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
        
        @ApiResponse(responseCode = "503", description = "The server is not ready to handle the request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
        
        @ApiResponse(responseCode = "504", description = "The server did not get a response in time", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
        
        @ApiResponse(responseCode = "5XX", description = "API response in case of errors.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))) })
    @RequestMapping(value = "/auth/signIn",
        produces = "application/json", 
        consumes = "application/json",
        method = RequestMethod.POST)
    default ResponseEntity<Void> signIn(@Parameter(in = ParameterIn.DEFAULT, description = "SignIn User", required=true, schema=@Schema()) @Valid @RequestBody AuthSignInBody body, @Parameter(in = ParameterIn.HEADER, description = "Auto-generated ID, which uniquely identifies the request, available in the response.  When contacting support with an inquiry regarding a specific request, provide the value of this header which will help troubleshooting the issue.  If not present, one will be generated." ,schema=@Schema()) @RequestHeader(value="X-Correlation-ID", required=false) String xCorrelationID, @Parameter(in = ParameterIn.HEADER, description = "User-provided token that can be used to trace a request or a group of requests sent to the service.  If not present, one will be generated." ,schema=@Schema()) @RequestHeader(value="X-Request-ID", required=false) String xRequestID) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default AuthApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Create User Signup", description = "", security = {
        @SecurityRequirement(name = "sessionAuth")    }, tags={ "Cult Auth" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = ""),
        
        @ApiResponse(responseCode = "401", description = "The request requires user authentication", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExternalErrorResponse.class))),
        
        @ApiResponse(responseCode = "403", description = "The request cannot be fulfilled", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExternalErrorResponse.class))),
        
        @ApiResponse(responseCode = "500", description = "The server encountered an unexpected condition that prevented it from fulfilling the request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
        
        @ApiResponse(responseCode = "502", description = "The server received an invalid response from the upstream server", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
        
        @ApiResponse(responseCode = "503", description = "The server is not ready to handle the request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
        
        @ApiResponse(responseCode = "504", description = "The server did not get a response in time", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
        
        @ApiResponse(responseCode = "5XX", description = "API response in case of errors.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))) })
    @RequestMapping(value = "/auth/signup",
        produces = "application/json", 
        consumes = "application/json",
        method = RequestMethod.POST)
    default ResponseEntity<Void> signupUser(@Parameter(in = ParameterIn.DEFAULT, description = "Create User", required=true, schema=@Schema()) @Valid @RequestBody User body) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default AuthApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Verify OTP", description = "", security = {
        @SecurityRequirement(name = "sessionAuth")    }, tags={ "Cult Auth" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = ""),
        
        @ApiResponse(responseCode = "401", description = "The request requires user authentication", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExternalErrorResponse.class))),
        
        @ApiResponse(responseCode = "403", description = "The request cannot be fulfilled", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExternalErrorResponse.class))),
        
        @ApiResponse(responseCode = "500", description = "The server encountered an unexpected condition that prevented it from fulfilling the request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
        
        @ApiResponse(responseCode = "502", description = "The server received an invalid response from the upstream server", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
        
        @ApiResponse(responseCode = "503", description = "The server is not ready to handle the request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
        
        @ApiResponse(responseCode = "504", description = "The server did not get a response in time", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
        
        @ApiResponse(responseCode = "5XX", description = "API response in case of errors.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))) })
    @RequestMapping(value = "/auth/verifyOtp",
        produces = "application/json", 
        consumes = "application/json",
        method = RequestMethod.POST)
    default ResponseEntity<Void> verifyOtp(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody AuthVerifyOtpBody body, @Parameter(in = ParameterIn.HEADER, description = "Auto-generated ID, which uniquely identifies the request, available in the response.  When contacting support with an inquiry regarding a specific request, provide the value of this header which will help troubleshooting the issue.  If not present, one will be generated." ,schema=@Schema()) @RequestHeader(value="X-Correlation-ID", required=false) String xCorrelationID, @Parameter(in = ParameterIn.HEADER, description = "User-provided token that can be used to trace a request or a group of requests sent to the service.  If not present, one will be generated." ,schema=@Schema()) @RequestHeader(value="X-Request-ID", required=false) String xRequestID) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default AuthApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}


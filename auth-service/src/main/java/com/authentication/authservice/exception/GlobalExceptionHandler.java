package com.authentication.authservice.exception;

import com.authentication.authservice.configuration.MessagesConfiguration;
import com.authentication.authservice.utils.ObjectMapperUtil;
import com.myCode.pradnya.server.cult.model.ErrorResponse;
import com.myCode.pradnya.server.cult.model.ErrorResponseDetailsElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    private static final String SPACE = " ";
    private static final String INVALID = "Invalid";
    private static final String START = "{";
    private static final String END = "}.";
    private static final String VALUE = "value";
    private static final String X_CORRELATION_ID = "X-Correlation-ID";
   @ExceptionHandler(value = InterruptedException.class)
    @ResponseStatus(code= HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleInterruptedException(InterruptedException exception){
       logger.error("Handle interrupted exception", exception);
       ErrorResponse response= MessagesConfiguration.getConfig().getErrorResponse(ErrorCodes.E311062.name());
       response.setCause(String.join(SPACE, response.getCause(), exception.getMessage()));
       response.setCorrelationId(MDC.get(X_CORRELATION_ID));
       return response;
   }
    @ExceptionHandler(value = ExecutionException.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleExecutionException(ExecutionException exception) {
        logger.error("Handle execution exception", exception);
        ErrorResponse response = MessagesConfiguration.getConfig().getErrorResponse(ErrorCodes.E311062.name());
        response.setCause(String.join(SPACE, response.getCause(), exception.getMessage()));
        response.setCorrelationId(MDC.get(X_CORRELATION_ID));
        return response;
    }
    @ExceptionHandler(value = CultServiceException.class)
    public ResponseEntity<ErrorResponse> handleFlowServiceException(CultServiceException exception) {
        logger.warn("Handle flow service exception", exception);
        ErrorResponse errorResponse = exception.getErrorResponse();
        errorResponse.setCorrelationId(MDC.get(X_CORRELATION_ID));
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(errorResponse.getStatus()));
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(Exception exception, WebRequest request) {
        logger.error("Handle exception", exception);
        ErrorResponse response = MessagesConfiguration.getConfig().getErrorResponse(ErrorCodes.E311062.name());
        response.setCause(String.join(SPACE, response.getCause(), exception.getMessage()));
        response.setCorrelationId(MDC.get(X_CORRELATION_ID));
        return response;
    }
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED)
    public ErrorResponse handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
        logger.error("Handle http request method not supported exception", exception);
        ErrorResponse response = MessagesConfiguration.getConfig().getErrorResponse(ErrorCodes.E311023.name());
        response.setCause(String.join(SPACE, response.getCause(), exception.getMessage()));
        return response;
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        logger.error("Handle method argument not valid exception", exception);
        ErrorResponse response = MessagesConfiguration.getConfig().getErrorResponse(ErrorCodes.E311001.name());
        List<ErrorResponseDetailsElement> details = new ArrayList<>();
        exception.getBindingResult().getFieldErrors().forEach(error -> {
            ErrorResponseDetailsElement errorResponseDetailsElement = new ErrorResponseDetailsElement();
            errorResponseDetailsElement.setTitle(String.join(SPACE, INVALID, String.valueOf(error.getField()), VALUE, START, String.valueOf(error.getRejectedValue()), END));
            errorResponseDetailsElement.setSource(String.valueOf(error.getField()));
            errorResponseDetailsElement.setMessage(String.valueOf(error.getDefaultMessage()));
            details.add(errorResponseDetailsElement);
        });
        response.setDetails(details);
        response.setCorrelationId(MDC.get(X_CORRELATION_ID));
        return response;
    }
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorResponse handleHttpMessageNotReadableException(HttpMessageNotReadableException exception, WebRequest request) {
        logger.error("Handle http message not readable exception", exception);
        Throwable mostSpecificCause = exception.getMostSpecificCause();
        ErrorResponse response = MessagesConfiguration.getConfig().getErrorResponse(ErrorCodes.E311011.name());
        response.setCause(String.join(SPACE, response.getCause(), mostSpecificCause.getMessage()));
        response.setCorrelationId(MDC.get(X_CORRELATION_ID));
        return response;
    }
    @ExceptionHandler(value = RuntimeException.class)
//    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorResponse handleRuntimeException(RuntimeException exception, WebRequest request) {
        logger.warn("Handle runtime exception", exception);
        ErrorResponse response = MessagesConfiguration.getConfig().getErrorResponse(ErrorCodes.E311011.name());
        response.setCause(String.join(SPACE, response.getCause(), exception.getMessage()));
        response.setCorrelationId(MDC.get(X_CORRELATION_ID));
        return response;
    }
    @ExceptionHandler(value = CannotCreateTransactionException.class)
    @ResponseStatus(code = HttpStatus.SERVICE_UNAVAILABLE)
    public ErrorResponse handleCannotCreateTransactionException(CannotCreateTransactionException exception, WebRequest request) {
        logger.error("Handle cannot create transaction exception", exception);
        ErrorResponse response = MessagesConfiguration.getConfig().getErrorResponse(ErrorCodes.E311050.name());
        response.setCause(String.join(SPACE, response.getCause(), exception.getMessage()));
        response.setCorrelationId(MDC.get(X_CORRELATION_ID));
        return response;
    }
    @ExceptionHandler(value = HttpClientErrorException.Unauthorized.class)
    public ResponseEntity<ErrorResponse> handleHttpClientErrorExceptionUnauthorized(HttpClientErrorException.Unauthorized exception, WebRequest request) {
        ObjectMapperUtil objectMapperUtil = new ObjectMapperUtil();
        String json = objectMapperUtil.writeValueAsString(exception);
        logger.error("Handle http client error exception unauthorized {}", json, exception);
        ErrorResponse response = MessagesConfiguration.getConfig().getErrorResponse(ErrorCodes.E311058.name());
        response.setCause(String.join(SPACE, response.getCause(), exception.getMessage()));
        response.setCorrelationId(MDC.get(X_CORRELATION_ID));
        response.setStatus(exception.getStatusCode().value());
        return new ResponseEntity<>(response, HttpStatus.valueOf(exception.getStatusCode().value()));
    }
    @ExceptionHandler(value = RestClientException.class)
    @ResponseStatus(code = HttpStatus.SERVICE_UNAVAILABLE)
    public ErrorResponse handleRestClientException(RestClientException exception) {
        logger.error("Handle http rest client error exception {}", exception.getMessage(), exception);
        ErrorResponse response = MessagesConfiguration.getConfig().getErrorResponse(ErrorCodes.E311034.name());
        response.setCause(String.join(SPACE, response.getCause(), exception.getMessage()));
        response.setCorrelationId(MDC.get(X_CORRELATION_ID));
        return response;
    }
}

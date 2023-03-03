package com.authentication.authservice.exception;

import com.authentication.authservice.configuration.MessagesConfiguration;
import com.authentication.authservice.utils.ObjectMapperUtil;
import com.myCode.pradnya.server.cult.model.ErrorResponse;
import com.myCode.pradnya.server.cult.model.ErrorResponseDetailsElement;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * This user defined exception is used to map different exceptions to provide better information to user.
 */
public class CultServiceException extends RuntimeException {

    private transient ErrorResponse errorResponse;

    /**
     * Convenience builder method.
     *
     * @param errorCode The error code being thrown.
     * @param data      A variable length list of message elements.
     * @return The resulting FlowServiceException object built from the given arguments.
     */
    public static CultServiceException build(ErrorCodes errorCode, String... data) {
        return new CultServiceException(errorCode, data);
    }

    /**
     * Convenience builder method.
     *
     * @param errorCode The error code being thrown.
     * @param cause     The Throwable that is the source of the error the message used in the returned exception.
     * @return The resulting FlowServiceException object built from the given arguments.
     */
    public static CultServiceException build(ErrorCodes errorCode, Throwable cause) {
        return new CultServiceException(errorCode, cause, cause.getMessage());
    }


    /**
     * Convenience builder method.
     *
     * @param errorCode The error code being thrown.
     * @param cause     The Throwable that is the source of the error.
     * @param data      A variable length list of message elements.
     * @return The resulting FlowServiceException object built from the given arguments.
     */
    public static CultServiceException build(ErrorCodes errorCode, Throwable cause, String... data) {
        return new CultServiceException(errorCode, cause, data);
    }

    public static CultServiceException buildNotSupportedError(String whatIsNotSupported) {
        return build(ErrorCodes.E311000, whatIsNotSupported);
    }


    /**
     * Constructor to build FlowServiceException using error response object.
     *
     * @param errorResponse ErrorResponse object to build Exception.
     */
    public CultServiceException(ErrorResponse errorResponse) {
        super(errorResponse.getCause());
        this.errorResponse = errorResponse;
    }

    /**
     * The flow service exception constructor with error code and messages.
     *
     * @param errorCode error code.
     * @param values    error messages.
     */
    public CultServiceException(ErrorCodes errorCode, String... values) {

        super(errorCode.toString());

        ErrorResponse errorMessageResponse = MessagesConfiguration.getConfig().getErrorResponse(errorCode.name());

        StringBuilder stringBuilder = new StringBuilder("");

        if (values != null && values.length > 0) {
            for (String value : values) {
                if (value != null && !value.isEmpty() && !value.isBlank()) {
                    stringBuilder.append(" ");
                    stringBuilder.append(value);
                }
            }
        }

        String causeString = String.join("", errorMessageResponse.getCause(), stringBuilder.toString());

        if (causeString != null && !causeString.isEmpty() && !causeString.isBlank()) {
            causeString = causeString.trim();
        }

        errorMessageResponse.setCause(causeString);

        this.errorResponse = errorMessageResponse;
    }

    /**
     * The flow service exception constructor with error code and messages.
     *
     * @param errorCode error code.
     * @param cause     cause.
     * @param values    error messages.
     */
    public CultServiceException(ErrorCodes errorCode, Throwable cause, String... values) {

        super(
                errorCode.toString() + " " +
                        (values != null
                                ? Arrays.stream(values).reduce(StringUtils.EMPTY, (s1, s2) -> s1 + " " + s2)
                                : ""),
                cause);

        ErrorResponse errorMessageResponse = MessagesConfiguration.getConfig().getErrorResponse(errorCode.name());

        StringBuilder stringBuilder = new StringBuilder("");

        if (values != null && values.length > 0) {
            for (String value : values) {
                if (value != null && !value.isEmpty() && !value.isBlank()) {
                    stringBuilder.append(" ");
                    stringBuilder.append(value);
                }
            }
        }

        String causeString = String.join("", errorMessageResponse.getCause(), stringBuilder.toString());

        if (causeString != null && !causeString.isEmpty() && !causeString.isBlank()) {
            causeString = causeString.trim();
        }

        errorMessageResponse.setCause(causeString);

        this.errorResponse = errorMessageResponse;
    }

    public CultServiceException(ErrorCodes errorCode, Exception exception, String cause) {

        super(cause, exception);

        ErrorResponse errorResponse = MessagesConfiguration.getConfig().getErrorResponse(errorCode.name());

        if (cause != null && !cause.isEmpty() && !cause.isBlank()) {
            cause = errorResponse.getCause() + " " + cause.trim();
            cause = cause.trim();
            errorResponse.setCause(cause);
        }

        if (exception instanceof CultServiceException) {

            CultServiceException flowServiceException = (CultServiceException) exception;
            errorResponse = flowServiceException.getErrorResponse();

        } else if (exception instanceof HttpClientErrorException) {

            HttpClientErrorException httpClientErrorException = (HttpClientErrorException) exception;

            ObjectMapperUtil objectMapperUtil = new ObjectMapperUtil();
            String json = objectMapperUtil.writeValueAsString(httpClientErrorException);

            ErrorResponseDetailsElement errorResponseDetailsElement = new ErrorResponseDetailsElement();
            errorResponseDetailsElement.setTitle(httpClientErrorException.getStatusText());
            errorResponseDetailsElement.setMessage(json);

            List<ErrorResponseDetailsElement> details = new ArrayList<>();
            details.add(errorResponseDetailsElement);
            errorResponse.setDetails(details);

        } else if (exception instanceof HttpServerErrorException) {

            HttpServerErrorException httpServerErrorException = (HttpServerErrorException) exception;

            ObjectMapperUtil objectMapperUtil = new ObjectMapperUtil();
            String json = objectMapperUtil.writeValueAsString(httpServerErrorException);

            ErrorResponseDetailsElement errorResponseDetailsElement = new ErrorResponseDetailsElement();
            errorResponseDetailsElement.setTitle(httpServerErrorException.getStatusText());
            errorResponseDetailsElement.setMessage(json);

            List<ErrorResponseDetailsElement> details = new ArrayList<>();
            details.add(errorResponseDetailsElement);
            errorResponse.setDetails(details);

        } else if (exception instanceof ExecutionException) {

            ExecutionException executionException = (ExecutionException) exception;

            Throwable throwable = executionException.getCause();

            if (throwable instanceof CultServiceException) {

                CultServiceException flowServiceException = (CultServiceException) throwable;

                errorResponse = flowServiceException.getErrorResponse();

            } else if (throwable instanceof HttpClientErrorException) {

                HttpClientErrorException httpClientErrorException = (HttpClientErrorException) throwable;

                ObjectMapperUtil objectMapperUtil = new ObjectMapperUtil();
                String json = objectMapperUtil.writeValueAsString(httpClientErrorException);

                ErrorResponseDetailsElement errorResponseDetailsElement = new ErrorResponseDetailsElement();
                errorResponseDetailsElement.setTitle(httpClientErrorException.getStatusText());
                errorResponseDetailsElement.setMessage(json);

                List<ErrorResponseDetailsElement> details = new ArrayList<>();
                details.add(errorResponseDetailsElement);
                errorResponse.setDetails(details);

            } else if (throwable instanceof HttpServerErrorException) {

                HttpServerErrorException httpServerErrorException = (HttpServerErrorException) throwable;

                ObjectMapperUtil objectMapperUtil = new ObjectMapperUtil();
                String json = objectMapperUtil.writeValueAsString(httpServerErrorException);

                ErrorResponseDetailsElement errorResponseDetailsElement = new ErrorResponseDetailsElement();
                errorResponseDetailsElement.setTitle(httpServerErrorException.getStatusText());
                errorResponseDetailsElement.setMessage(json);

                List<ErrorResponseDetailsElement> details = new ArrayList<>();
                details.add(errorResponseDetailsElement);
                errorResponse.setDetails(details);

            } else {

                ErrorResponseDetailsElement errorResponseDetailsElement = new ErrorResponseDetailsElement();
                errorResponseDetailsElement.setTitle(cause);
                errorResponseDetailsElement.setMessage(exception.getMessage());

                List<ErrorResponseDetailsElement> details = new ArrayList<>();
                details.add(errorResponseDetailsElement);
                errorResponse.setDetails(details);
            }

        } else {

            ErrorResponseDetailsElement errorResponseDetailsElement = new ErrorResponseDetailsElement();
            errorResponseDetailsElement.setTitle(cause);
            errorResponseDetailsElement.setMessage(exception.getMessage());

            List<ErrorResponseDetailsElement> details = new ArrayList<>();
            details.add(errorResponseDetailsElement);
            errorResponse.setDetails(details);
        }

        this.errorResponse = errorResponse;
    }

    public CultServiceException(ErrorCodes errorCodes, HttpClientErrorException exception, String cause) {

        super(cause, exception);

        ErrorResponse errorResponse = MessagesConfiguration.getConfig().getErrorResponse(errorCodes.name());

        if (cause != null && !cause.isEmpty() && !cause.isBlank()) {
            cause = errorResponse.getCause() + " " + cause.trim();
            cause = cause.trim();
            errorResponse.setCause(cause);
        }

        List<ErrorResponseDetailsElement> details = new ArrayList<>();

        ObjectMapperUtil objectMapperUtil = new ObjectMapperUtil();
        String json = objectMapperUtil.writeValueAsString(exception);

        ErrorResponseDetailsElement errorResponseDetailsElement = new ErrorResponseDetailsElement();
        errorResponseDetailsElement.setTitle(exception.getStatusText());
        errorResponseDetailsElement.setMessage(json);
        details.add(errorResponseDetailsElement);

        errorResponse.setDetails(details);

        this.errorResponse = errorResponse;
    }

    public CultServiceException(ErrorCodes errorCodes, HttpServerErrorException exception, String cause) {

        super(cause, exception);

        ErrorResponse errorResponse = MessagesConfiguration.getConfig().getErrorResponse(errorCodes.name());

        if (cause != null && !cause.isEmpty() && !cause.isBlank()) {
            cause = errorResponse.getCause() + " " + cause.trim();
            cause = cause.trim();
            errorResponse.setCause(cause);
        }

        List<ErrorResponseDetailsElement> details = new ArrayList<>();

        ObjectMapperUtil objectMapperUtil = new ObjectMapperUtil();
        String json = objectMapperUtil.writeValueAsString(exception);

        ErrorResponseDetailsElement errorResponseDetailsElement = new ErrorResponseDetailsElement();
        errorResponseDetailsElement.setTitle(exception.getStatusText());
        errorResponseDetailsElement.setMessage(json);
        details.add(errorResponseDetailsElement);

        errorResponse.setDetails(details);

        this.errorResponse = errorResponse;
    }

    public CultServiceException(ErrorCodes errorCodes, RestClientException exception, String cause) {

        super(cause, exception);

        ErrorResponse errorResponse = MessagesConfiguration.getConfig().getErrorResponse(errorCodes.name());

        if (cause != null && !cause.isEmpty() && !cause.isBlank()) {
            cause = errorResponse.getCause() + " " + cause.trim();
            cause = cause.trim();
            errorResponse.setCause(cause);
        }

        List<ErrorResponseDetailsElement> details = new ArrayList<>();

        ErrorResponseDetailsElement errorResponseDetailsElement = new ErrorResponseDetailsElement();
        errorResponseDetailsElement.setMessage(exception.getMessage());
        details.add(errorResponseDetailsElement);

        errorResponse.setDetails(details);

        this.errorResponse = errorResponse;
    }

    /**
     * The flow service exception constructor with error code details and messages.
     *
     * @param errorCode    error code.
     * @param errorDetails error details.
     * @param values       values.
     */
    public CultServiceException(ErrorCodes errorCode, List<ErrorResponseDetailsElement> errorDetails, String... values) {

        super(errorCode.toString());

        ErrorResponse errorMessageResponse = MessagesConfiguration.getConfig().getErrorResponse(errorCode.name());

        StringBuilder stringBuilder = new StringBuilder("");

        if (values != null && values.length > 0) {
            for (String value : values) {
                if (value != null && !value.isEmpty() && !value.isBlank()) {
                    stringBuilder.append(" ");
                    stringBuilder.append(value);
                }
            }
        }

        String causeString = String.join("", errorMessageResponse.getCause(), stringBuilder.toString());

        if (causeString != null && !causeString.isEmpty() && !causeString.isBlank()) {
            causeString = causeString.trim();
        }

        errorMessageResponse.setCause(causeString);

        if (!CollectionUtils.isEmpty(errorDetails)) {
            errorMessageResponse.setDetails(errorDetails);
        }

        this.errorResponse = errorMessageResponse;
    }

    /**
     * The default flow service constructor.
     */
    public CultServiceException() {
        super();
        this.errorResponse = new ErrorResponse();
        this.errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
    }

    /**
     * The flow service exception constructor with message,cause,enableSuppression and writableStackTrace.
     *
     * @param message            message.
     * @param cause              cause.
     * @param enableSuppression  enableSuppression.
     * @param writableStackTrace writableStackTrace.
     */
    public CultServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorResponse = new ErrorResponse();
        this.errorResponse.setCause(message);
        this.errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
    }

    /**
     * The flow service exception constructor with message and cause.
     *
     * @param message message.
     * @param cause   cause.
     */
    public CultServiceException(String message, Throwable cause) {
        super(message, cause);
        this.errorResponse = new ErrorResponse();
        this.errorResponse.setCause(message);
        this.errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
    }

    /**
     * The flow service exception constructor with message.
     *
     * @param message message.
     */
    public CultServiceException(String message) {
        super(message);
        this.errorResponse = new ErrorResponse();
        this.errorResponse.setCause(message);
        this.errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
    }

    /**
     * The flow service exception constructor with  cause.
     *
     * @param cause cause.
     */
    public CultServiceException(Throwable cause) {
        super(cause);
        this.errorResponse = new ErrorResponse();
        this.errorResponse.setCause(cause.getMessage());
        this.errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
    }


    /**
     * This method will return error response.
     *
     * @return errorResponse.
     */
    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

}

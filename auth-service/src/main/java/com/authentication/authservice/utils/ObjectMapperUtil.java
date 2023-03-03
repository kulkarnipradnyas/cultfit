package com.authentication.authservice.utils;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

public class ObjectMapperUtil {

    private static final Logger logger = LoggerFactory.getLogger(ObjectMapperUtil.class);

    public ObjectMapperUtil() {
    }

    public ObjectMapper getObjectMapper() {

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        objectMapper.enable(JsonParser.Feature.ALLOW_COMMENTS);

        objectMapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);

        objectMapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);

        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        objectMapper.disable(SerializationFeature.INDENT_OUTPUT);

        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.disable(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE);
        objectMapper.disable(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES);
        objectMapper.disable(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS);
        objectMapper.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);

        JavaTimeModule javaTimeModule = new JavaTimeModule();
        objectMapper.registerModule(javaTimeModule);

        return objectMapper;
    }

    public JsonNode readValue(Object object) throws JsonProcessingException {

        ObjectMapperUtil objectMapperUtil = new ObjectMapperUtil();

        return objectMapperUtil.readValue(object, JsonNode.class);
    }

    public <T> T readValue(String content, Class<T> valueType) throws JsonProcessingException {

        ObjectMapper objectMapper = getObjectMapper();

        return objectMapper.readValue(content, valueType);
    }

    public <T> T readValue(Object value, Class<T> valueType) throws JsonProcessingException {

        ObjectMapper objectMapper = getObjectMapper();

        String content = objectMapper.writeValueAsString(value);

        return objectMapper.readValue(content, valueType);
    }

    public String writeValueAsString(Object value) throws JsonProcessingException {

        ObjectMapper objectMapper = getObjectMapper();

        return objectMapper.writeValueAsString(value);
    }

    public String writeValueAsString(HttpClientErrorException exception) {

        try {

            byte[] bytes = exception.getResponseBodyAsByteArray();
            if (bytes == null || bytes.length == 0) {

                String responseBody = exception.getResponseBodyAsString();
                if (responseBody == null || responseBody.isEmpty() || responseBody.isBlank()) {

                    String message = exception.getMessage();
                    if (message == null || message.isEmpty() || message.isBlank()) {
                        return exception.getStatusText();
                    }
                    return message;
                }
                return responseBody;
            }

            ObjectMapper objectMapper = getObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(bytes);
            return objectMapper.writeValueAsString(jsonNode);

        } catch (Exception ex) {

            logger.error("Unable to write value as string", ex);

            String responseBody = exception.getResponseBodyAsString();
            if (responseBody == null || responseBody.isEmpty() || responseBody.isBlank()) {

                String message = exception.getMessage();
                if (message == null || message.isEmpty() || message.isBlank()) {
                    return exception.getStatusText();
                }
                return message;
            }
            return responseBody;
        }

    }

    public String writeValueAsString(HttpServerErrorException exception) {

        try {

            byte[] bytes = exception.getResponseBodyAsByteArray();
            if (bytes == null || bytes.length == 0) {

                String responseBody = exception.getResponseBodyAsString();
                if (responseBody == null || responseBody.isEmpty() || responseBody.isBlank()) {

                    String message = exception.getMessage();
                    if (message == null || message.isEmpty() || message.isBlank()) {
                        return exception.getStatusText();
                    }
                    return message;
                }
                return responseBody;
            }

            ObjectMapper objectMapper = getObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(bytes);
            return objectMapper.writeValueAsString(jsonNode);

        } catch (Exception ex) {

            logger.error("Unable to write value as string", ex);

            String responseBody = exception.getResponseBodyAsString();
            if (responseBody == null || responseBody.isEmpty() || responseBody.isBlank()) {

                String message = exception.getMessage();
                if (message == null || message.isEmpty() || message.isBlank()) {
                    return exception.getStatusText();
                }
                return message;
            }
            return responseBody;
        }

    }

}

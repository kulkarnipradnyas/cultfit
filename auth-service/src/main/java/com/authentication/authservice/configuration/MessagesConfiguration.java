package com.authentication.authservice.configuration;

import com.authentication.authservice.service.impl.AuthServiceImpl;
import com.myCode.pradnya.server.cult.model.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class MessagesConfiguration {
    private static final Logger log = LoggerFactory.getLogger(MessagesConfiguration.class);
    private static final String TITLE = "title";
    private static final String STATUS = "status";
    private static final String CAUSE = "cause";
    private static final String ACTION = "action";
    private static final String DOT = ".";
    private static final String MESSAGES_FILE_NAME = "messages.properties";
    private static final MessagesConfiguration singletonInstance = new MessagesConfiguration();

    private final Properties properties;
    private MessagesConfiguration(){
        try(InputStream input= AuthServiceImpl.class.getClassLoader().getResourceAsStream(MESSAGES_FILE_NAME)){
            properties = new Properties();
            properties.load(input);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static  MessagesConfiguration getConfig(){
        return  singletonInstance;
    }
    private String getMessage(String key){
        return this.properties.getProperty(key);
    }
    public ErrorResponse getErrorResponse(String codeKey) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTitle(this.properties.getProperty(String.join(DOT,codeKey,TITLE)));
        try{
            errorResponse.setStatus(Integer.valueOf(this.properties.getProperty(String.join(DOT, codeKey, STATUS).trim())));
        }catch (Exception e){
            errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            log.warn("Error occurred while reading status {} {}", codeKey, e);
        }
        errorResponse.setCause(this.properties.getProperty(String.join(DOT, codeKey, CAUSE)));
        errorResponse.setAction(this.properties.getProperty(String.join(DOT, codeKey, ACTION)));
        errorResponse.setCode(codeKey);
        return errorResponse;
    }
}

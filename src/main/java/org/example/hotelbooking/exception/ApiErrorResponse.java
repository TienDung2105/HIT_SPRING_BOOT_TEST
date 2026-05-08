package org.example.hotelbooking.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.Instant;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiErrorResponse(
        String logMessage,
        String userMessage,
        String devMessage,
        List<FieldValidationError> errors,
        String devInfo,
        Instant timestamp
) {

    public static ApiErrorResponse of(String logMessage, String userMessage, String devMessage) {
        return new ApiErrorResponse(logMessage, userMessage, devMessage, null, null, Instant.now());
    }

    public static ApiErrorResponse withErrors(
            String logMessage,
            String userMessage,
            String devMessage,
            List<FieldValidationError> errors
    ) {
        return new ApiErrorResponse(logMessage, userMessage, devMessage, errors, null, Instant.now());
    }

    public static ApiErrorResponse withDevInfo(
            String logMessage,
            String userMessage,
            String devMessage,
            String devInfo
    ) {
        return new ApiErrorResponse(logMessage, userMessage, devMessage, null, devInfo, Instant.now());
    }
}

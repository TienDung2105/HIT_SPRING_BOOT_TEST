package org.example.hotelbooking.exception;

public record FieldValidationError(
        String field,
        String message
) {
}

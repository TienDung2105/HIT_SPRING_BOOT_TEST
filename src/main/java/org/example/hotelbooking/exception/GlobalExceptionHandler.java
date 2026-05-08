package org.example.hotelbooking.exception;

import jakarta.validation.ConstraintViolationException;
import org.example.hotelbooking.constant.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException exception) {
        List<FieldValidationError> errors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(this::toFieldValidationError)
                .toList();

        ApiErrorResponse body = ApiErrorResponse.withErrors(
                ErrorMessage.INVALID_REQUEST_BODY_LOG,
                ErrorMessage.INVALID_REQUEST_USER,
                ErrorMessage.VALIDATION_BODY_DEV,
                errors
        );
        return ResponseEntity.badRequest().body(body);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiErrorResponse> handleConstraintViolation(ConstraintViolationException exception) {
        List<FieldValidationError> errors = exception.getConstraintViolations()
                .stream()
                .map(violation -> new FieldValidationError(
                        violation.getPropertyPath().toString(),
                        violation.getMessage()
                ))
                .toList();

        ApiErrorResponse body = ApiErrorResponse.withErrors(
                ErrorMessage.INVALID_REQUEST_PARAMETERS_LOG,
                ErrorMessage.INVALID_REQUEST_USER,
                ErrorMessage.VALIDATION_PARAMETERS_DEV,
                errors
        );
        return ResponseEntity.badRequest().body(body);
    }

    @ExceptionHandler({
            BadRequestException.class,
            MissingServletRequestParameterException.class,
            MethodArgumentTypeMismatchException.class
    })
    public ResponseEntity<ApiErrorResponse> handleBadRequest(Exception exception) {
        ApiErrorResponse body = ApiErrorResponse.of(
                ErrorMessage.INVALID_REQUEST_PARAMETERS_LOG,
                ErrorMessage.INVALID_REQUEST_USER,
                exception.getMessage()
        );
        return ResponseEntity.badRequest().body(body);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleResourceNotFound(ResourceNotFoundException exception) {
        ApiErrorResponse body = ApiErrorResponse.withDevInfo(
                exception.getMessage(),
                ErrorMessage.RESOURCE_NOT_FOUND_USER,
                exception.getMessage(),
                exception.getResourceName() + " id=" + exception.getResourceId()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ApiErrorResponse> handleConflict(ConflictException exception) {
        ApiErrorResponse body = ApiErrorResponse.of(
                exception.getMessage(),
                ErrorMessage.CONFLICT_USER,
                exception.getMessage()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleInternalError(Exception exception) {
        ApiErrorResponse body = ApiErrorResponse.withDevInfo(
                ErrorMessage.INTERNAL_ERROR_LOG,
                ErrorMessage.INTERNAL_ERROR_USER,
                exception.getMessage(),
                exception.getClass().getName()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }

    private FieldValidationError toFieldValidationError(FieldError error) {
        return new FieldValidationError(error.getField(), error.getDefaultMessage());
    }
}

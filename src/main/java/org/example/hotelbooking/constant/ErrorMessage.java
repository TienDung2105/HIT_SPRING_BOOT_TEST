package org.example.hotelbooking.constant;

public final class ErrorMessage {

    private ErrorMessage() {
    }

    // TO DO


    public static final String INVALID_REQUEST_BODY_LOG = "Invalid request body.";
    public static final String INVALID_REQUEST_PARAMETERS_LOG = "Invalid request parameters.";
    public static final String INVALID_REQUEST_USER = "Loi, vui long kiem tra lai thong tin da nhap.";
    public static final String VALIDATION_BODY_DEV = "Validation failed for request body";
    public static final String VALIDATION_PARAMETERS_DEV = "Validation failed for request parameters";
    public static final String RESOURCE_NOT_FOUND_FORMAT = "%s with ID %s not found.";
    public static final String RESOURCE_NOT_FOUND_USER = "Khong tim thay tai nguyen.";
    public static final String CONFLICT_USER = "Khong the thuc hien thao tac do xung dot du lieu.";
    public static final String INTERNAL_ERROR_LOG = "Internal Error.";
    public static final String INTERNAL_ERROR_USER = "Da xay ra loi noi bo.";
}

package org.example.hotelbooking.exception;

import org.example.hotelbooking.constant.ErrorMessage;

public class ResourceNotFoundException extends RuntimeException {

    private final String resourceName;
    private final String resourceId;

    public ResourceNotFoundException(String resourceName, String resourceId) {
        super(ErrorMessage.RESOURCE_NOT_FOUND_FORMAT.formatted(resourceName, resourceId));
        this.resourceName = resourceName;
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getResourceId() {
        return resourceId;
    }
}

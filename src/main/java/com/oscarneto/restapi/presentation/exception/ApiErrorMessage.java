package com.oscarneto.restapi.presentation.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ApiErrorMessage {
    UNKNOWN("Unknown error. Please, try again or contact the system administrator."),
    NOT_FOUND("Resource not found."),
    BAD_REQUEST("One or more fields are invalid or missing. Please, make sure you are sending the data according the API standards and try again."),
    FORBIDDEN("User without privileges to execute action."),
    UNAUTHORIZED("Unauthorized user."),
    ARGUMENT_MISMATCH("Param value %s is invalid."),
    DUPLICATE_KEY("Resource key already exists.");

    private final String message;

    public String getMessage(Object... args) {
        return String.format(this.message, args);
    }
}

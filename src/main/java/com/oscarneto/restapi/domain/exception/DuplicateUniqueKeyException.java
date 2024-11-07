package com.oscarneto.restapi.domain.exception;

public class DuplicateUniqueKeyException extends RuntimeException {

    public DuplicateUniqueKeyException(Class clazz, String key, String value) {
        super(String.format("%s with %s %s already exists.", clazz.getSimpleName(), key, value));
    }
}

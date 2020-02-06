package com.taskTopjava.util.exception;

public class NotFoundException extends ApplicationException {
    public static final String NOT_FOUND_EXCEPTION = "Not found";

    public NotFoundException(String msgCode) {
        super(ErrorType.DATA_NOT_FOUND, msgCode);
    }
}

package com.taskTopjava.util.exception;

public class ErrorInfo {
    private final String url;
    private final ErrorType type;
    private final String typeMessage;
    private final String[] details;

    public ErrorInfo(String url, ErrorType type, String typeMessage, String[] details) {
        this.details = details;
        this.type = type;
        this.typeMessage = typeMessage;
        this.url = url;
    }
}

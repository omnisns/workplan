package com.abc.exception;

/**
 * Created by Reen on 2018/12/18.
 */
public class SyncheaException extends RuntimeException{

    public SyncheaException() {
        super();
    }

    public SyncheaException(String message) {
        super(message);
    }

    public SyncheaException(String message, Throwable cause) {
        super(message, cause);
    }

    public SyncheaException(Throwable cause) {
        super(cause);
    }

    public SyncheaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package com.fjut.oj.exception;


/**
 * @Author: wyx
 * @Despriction:
 * @Date:Created in 14:59 2019/7/7
 * @Modify By:
 */
public class AuthExpireException extends RuntimeException {
    public AuthExpireException() {
        super();
    }

    public AuthExpireException(String message) {
        super(message);
    }

    public AuthExpireException(String message, Throwable cause) {

        super(message, cause);
    }

    public AuthExpireException(Throwable cause) {
        super(cause);
    }

    protected AuthExpireException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

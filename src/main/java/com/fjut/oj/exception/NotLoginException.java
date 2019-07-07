package com.fjut.oj.exception;

/**
 * TODO: 自定义业务异常类，暂时未使用
 * @Author: axiang
 * @Despriction:
 * @Date:Created in 8:52 2019/6/21
 * @Modify By:
 */
public class NotLoginException extends RuntimeException {

    public NotLoginException() {
        super();
    }

    public NotLoginException(String message) {
        super(message);
    }

    public NotLoginException(String message, Throwable cause) {

        super(message, cause);
    }

    public NotLoginException(Throwable cause) {
        super(cause);
    }

    protected NotLoginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package com.fjut.oj.exception;

/**
 * TODO: 自定义业务异常类，暂时未使用
 * @Author: axiang
 * @Despriction:
 * @Date:Created in 8:52 2019/6/21
 * @Modify By:
 */
public class BusinessException extends RuntimeException {
    private int code;



    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {

        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    protected BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

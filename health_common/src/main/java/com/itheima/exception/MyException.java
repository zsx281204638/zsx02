package com.itheima.exception;

public class MyException extends RuntimeException{
    /**
     * 构建 就要传入提示信息
     * @param message
     */
    public MyException(String message){
        super(message);
    }
}

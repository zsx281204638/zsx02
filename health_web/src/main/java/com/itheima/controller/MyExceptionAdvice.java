package com.itheima.controller;

import com.itheima.entity.Result;
import com.itheima.exception.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



/**
 * 统一异常处理
 *  使用@ExceptionHandler来捕获异常
 *  *  MyExceptionAdvice 必须要被包扫描到
 *  *  异常是由小到大来匹配捕获
 */
@RestControllerAdvice
public class MyExceptionAdvice {

    /**
     * 日志记录对象
     * MyExceptionAdvice 记录这个类
     * 记录日志的api, 记录日志文件。
     * info:    记录流程性的过程
     * debug:   记录关键数据， 订单的id, userToken, redisKey，看通知知道用户当运行状况
     * error:   记录异常信息
     *
     * 记录到数据库：
     *  记录关键数据的变更，银行转帐 ，A 有多个钱，B帐号有多钱，A -> 500，A转后余额： B转后余额
     *  将来有记录可查
     */
    private static final Logger log = LoggerFactory.getLogger(MyExceptionAdvice.class);
    /**
     * 捕获MyException类型的异常
     * 用这个方法来处理
     */
    @ExceptionHandler(MyException.class)
    public Result handleMyException(MyException e){
        log.info("进入了自定义异常处理，用户行为不规范");
        // 返回给ajax 提示信息
            return new Result(false,e.getMessage());
    }

    /**
     * 捕获Exception类型的异常
     * 用这个方法来处理
     */
    @ExceptionHandler(Exception.class)
    public Result handleMyException(Exception e){
        // e.printStackTrace();
        log.error("发生未知异常了",e);
        // 返回给ajax 提示信息
        return new Result(false,"发送未知异常，请联系管理员");
    }
}

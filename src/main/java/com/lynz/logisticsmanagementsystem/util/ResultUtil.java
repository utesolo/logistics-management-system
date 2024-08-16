package com.lynz.logisticsmanagementsystem.util;

public class ResultUtil {

    /*
    * 成功且带数据
    * */
    public static Result<Object> success(Object object){
        Result<Object> result = new Result<>();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMsg(ResultCode.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }

    public static Result<Object> successRoot(){
        return success(null);
    }

    public static Result<Object> online(Object object){
        Result<Object> result = new Result<Object>();
        result.setCode(ResultCode.ONLINE.getCode());
        result.setMsg(ResultCode.ONLINE.getMsg());
        result.setData(object);
        return result;
    }

    public static Result<Object> offline(Object object){
        Result<Object> result = new Result<Object>();
        result.setCode(ResultCode.OFFLINE.getCode());
        result.setMsg(ResultCode.OFFLINE.getMsg());
        result.setData(object);
        return result;
    }

    public static Result<Object> error(Object object){
        Result<Object> result = new Result<Object>();
        result.setCode(ResultCode.ERROR.getCode());
        result.setMsg(ResultCode.ERROR.getMsg());
        result.setData(object);
        return result;
    }
}

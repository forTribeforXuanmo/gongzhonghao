package com.zyiot.common.base;

import com.zyiot.common.enums.SysEnums;

import java.io.Serializable;

/**
 * Created by Administrator on 2017-7-13.
 */
public class BaseResponse implements Serializable {
    /**
     * 返回给前台的提示信息
     */
    private String Msg;
    /**
     * 错误吗
     */
    private String code;
    /**
     * 要返回的对象
     */
    private Object object = null;

    public BaseResponse() {

    }

    public BaseResponse(String msg, String code) {
        Msg = msg;
        this.code = code;
    }

    public BaseResponse(String msg, String code, Object object) {
        Msg = msg;
        this.code = code;
        this.object = object;
    }

    public BaseResponse success() {
        setMsg("成功");
        setCode(SysEnums.RESPONSE_SUCCESS.getCode());
        return this;
    }

    public BaseResponse error() {
        setMsg("失败");
        setCode(SysEnums.RESPONSE_FAIL.getCode());
        return this;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}

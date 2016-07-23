package com.zju.hpec.controller.view;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * Author: hzduhao
 * Date: 2016/7/13
 * Time: 11:46
 * 返回给客户端的视图层对象 ，封装了服务端相应状态、消息以及数据
 */
public class ResponseView implements Serializable{

   
	private static final long serialVersionUID = 2014075165994742194L;

    public static final int OK = 0;
    /**
     * 异常 ：弹窗显示message的内容
     */
    public final static int EXCEPTION_WINDOW_SHOW = -2;
    /**
     * 异常 ： toast显示message的内容
     */
    public final static int EXCEPTION_TOAST_SHOW = -2;

    public final static String DEFAULT_MESSAGE = "ok";

	private int code;
    private String message = DEFAULT_MESSAGE;
    private Object result;

    public ResponseView(){
        this.code = OK;
        this.message = DEFAULT_MESSAGE;
    }

    public ResponseView(int code,String message){
        this.code = code;
        this.message = message;
    }

    public ResponseView(int code,String message,Object result){
        this(code,message);
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}

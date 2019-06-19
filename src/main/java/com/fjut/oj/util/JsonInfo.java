package com.fjut.oj.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wyx
 * @Despriction: 对Json数据的封装。建议将JsonMsg全部替换为该封装
 * @Date:Created in 11:47 2019/6/17
 * @Modify By:
 */
public class JsonInfo {
    private int code;
    private String msg;
    private List<Object> datas = new ArrayList<>();


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Object> getDatas() {
        return datas;
    }

    public void setDatas(List<Object> datas) {
        this.datas = datas;
    }

    public void setSuccess() {
        code = 100;
        msg = "操作成功！";
    }

    public void setFail() {
        code = 200;
        msg = "操作失败！";
    }

    public void cleanDatas(){
        this.datas.clear();
    }

    public void addInfo(Object object) {
        datas.add(object);
    }


}

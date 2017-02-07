package com.paul.zmm_personal;

import java.io.Serializable;

/**
 * 
 * 结果
 *
 * @author chenyunyun hzchenyunyun1@corp.netease.com
 * @since 2016年7月18日
 */
public class ResultInfo implements Serializable {

    private static final long serialVersionUID = -4164294590989946020L;

    private int retcode;

    private String retdesc = "";

    private Object result;

    public ResultInfo() {

    }

    public ResultInfo(int retcode, String retdesc) {

        this.retcode = retcode;
        this.retdesc = retdesc;
    }

    public int getRetcode() {

        return this.retcode;
    }

    public void setRetcode(int retcode) {

        this.retcode = retcode;
    }

    public String getRetdesc() {

        return this.retdesc;
    }

    public void setRetdesc(String retdesc) {

        this.retdesc = retdesc;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}

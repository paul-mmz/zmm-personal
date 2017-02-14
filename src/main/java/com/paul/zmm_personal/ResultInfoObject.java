package com.paul.zmm_personal;

import java.io.Serializable;

public class ResultInfoObject<T> extends ResultInfo implements Serializable {

    private static final long serialVersionUID = -9206418273661084658L;

    private T object = null;

    public ResultInfoObject() {

    }

    public ResultInfoObject(int retcode, String retdesc) {

        super(retcode, retdesc);
    }

    public ResultInfoObject(int retcode, String retdesc, T object) {

        super(retcode, retdesc);
        this.object = object;
    }

    public T getObject() {

        return this.object;
    }

    public void setObject(T object) {

        this.object = object;
    }

    
}

package com.can.mz.bean;

import com.can.mz.build.UnProguardable;

import java.io.Serializable;

public class ForumResponseResult implements Serializable, UnProguardable {

    /**
     * status : 1
     */

    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

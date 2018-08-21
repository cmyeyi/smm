package com.can.mz.bean;

import com.can.mz.build.UnProguardable;

import java.io.Serializable;

public class ForumNotification implements Serializable, UnProguardable {

    /**
     * is_notice : 0
     */

    private int is_notice;

    public int getIs_notice() {
        return is_notice;
    }

    public void setIs_notice(int is_notice) {
        this.is_notice = is_notice;
    }
}

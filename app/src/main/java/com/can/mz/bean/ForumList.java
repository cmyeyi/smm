package com.can.mz.bean;

import com.can.mz.build.UnProguardable;

import java.io.Serializable;
import java.util.List;

public class ForumList implements Serializable, UnProguardable {
    /**
     * status : 1
     * forum_list : [{"is_praise":0,"is_new_comment":0,"new_comment_count":0,"forum_id":10,"release_user_id":0,"release_aid":"1514345205079","release_user_name":"Pengguna-5079","title":"还钱","text":"借钱","view_count":14,"praise_count":3,"this_comment_count":1,"create_time":"2017-12-27 11:12:59"}]
     */

    private int status;
    private List<ForumItemBean> forum_list;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<ForumItemBean> getForum_list() {
        return forum_list;
    }

    public void setForum_list(List<ForumItemBean> forum_list) {
        this.forum_list = forum_list;
    }

}
